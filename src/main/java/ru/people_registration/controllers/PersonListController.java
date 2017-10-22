package ru.people_registration.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import ru.people_registration.beans.Address;
import ru.people_registration.beans.Person;
import ru.people_registration.db.DataHelper;
import ru.people_registration.data_filters.PersonFilter;

@ManagedBean(eager = false)
@SessionScoped
public class PersonListController implements Serializable{

    private Person newPerson;
    private Address inputAddress;
    private PersonFilter personFilter;
    private boolean needFilter = false;
    private List<Person> currentList;
    
    private UIComponent component;

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
    
    public PersonListController() {
        personFilter = new PersonFilter();
    }
    
    public String saveNewPerson(){
        Address existAddress = DataHelper.getInstance().getAddress(inputAddress.getNumber(), inputAddress.getStreet());
        if(existAddress != null){
            inputAddress = existAddress;
        }
        newPerson.setAddress(inputAddress);
        DataHelper.getInstance().addPerson(newPerson);
        
        FacesContext.getCurrentInstance().addMessage(component.getClientId(), new FacesMessage("Данные добавлены"));
        return "index?faces-redirect=true";
    }
    
    public String switchAddMode(){
        newPerson = new Person();
        inputAddress = new Address();
        return "add_person?faces-redirect=true";
    }

    public void updateCurrentList() {
        if(needFilter)
            currentList = DataHelper.getInstance().getFilteredPersons(personFilter);
        else
            currentList = DataHelper.getInstance().getAllPersons();
    }

    public Person getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(Person newPerson) {
        this.newPerson = newPerson;
    }

    public Address getInputAddress() {
        return inputAddress;
    }

    public void setInputAddress(Address inputAddress) {
        this.inputAddress = inputAddress;
    }

    public PersonFilter getPersonFilter() {
        return personFilter;
    }

    public void setPersonFilter(PersonFilter personFilter) {
        this.personFilter = personFilter;
    }

    public boolean isNeedFilter() {
        return needFilter;
    }

    public void setNeedFilter(boolean needFilter) {
        this.needFilter = needFilter;
    }

    public List<Person> getCurrentList() {
        if (currentList == null)
            currentList = DataHelper.getInstance().getAllPersons();
        
        return currentList;
    }
    
    public void setCurrentList(List<Person> currentList) {
        this.currentList = currentList;
    }
}
