package ru.people_registration.db;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import ru.people_registration.beans.Address;
import ru.people_registration.beans.Person;
import ru.people_registration.beans.Street;

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
}
