package ru.people_registration.db;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import ru.people_registration.beans.Address;
import ru.people_registration.beans.Person;
import ru.people_registration.beans.Street;
import ru.people_registration.data_filters.PersonFilter;

public class DataHelper {
    
    private SessionFactory sessionFactory = null;
    
    private DataHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public static DataHelper getInstance() {
        return DataHelperHolder.INSTANCE;
    }
    
    private static class DataHelperHolder {
        private static final DataHelper INSTANCE = new DataHelper();
    }
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public List<Street> getAllStreets() {
        return getSession().createCriteria(Street.class).list();
    }
    
    public void addPerson(Person person){
        getSession().save(person);
    }
    
    public Address getAddress(int number, Street street){
        String hql = "from Address where number = :number and street.id = :street_id";
        List<Address> list = getSession().createQuery(hql).setParameter("number", number)
                .setParameter("street_id", street.getId()).list();
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<Person> getAllPersons(){
        return getSession().createCriteria(Person.class).list();
    }
    
    public List<Person> getFilteredPersons(PersonFilter personFilter){
        Criteria criteria = getSession().createCriteria(Person.class).createAlias("address", "ad");
        
        if (personFilter.getSurname() != null)
            criteria.add(Restrictions.ilike("surname", personFilter.getSurname(), MatchMode.ANYWHERE));
        
        if (personFilter.getName() != null)
            criteria.add(Restrictions.ilike("name", personFilter.getName(), MatchMode.ANYWHERE));
        
        if (personFilter.getDateBirthdayMin() != null)
            criteria.add(Restrictions.ge("dateBirthday", personFilter.getDateBirthdayMin()));
        
        if (personFilter.getDateBirthdayMax() != null)
            criteria.add(Restrictions.le("dateBirthday", personFilter.getDateBirthdayMax()));
        
        if (personFilter.getSex() != null)
            criteria.add(Restrictions.eq("sex", personFilter.getSex()));
        
        if (personFilter.getStreet() != null)
            criteria.add(Restrictions.eq("ad.street", personFilter.getStreet()));
        
        if (personFilter.getBuildingNum()!= null)
            criteria.add(Restrictions.eq("ad.number", personFilter.getBuildingNum()));
        
        return criteria.list();
    }
}
