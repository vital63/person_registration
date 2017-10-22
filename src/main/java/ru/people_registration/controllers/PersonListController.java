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

@ManagedBean(eager = false)
@SessionScoped
public class PersonListController implements Serializable{

    private Person newPerson;
    private Address inputAddress;
    
    private UIComponent component;

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
    
    public PersonListController() {
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

    public Person getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(Person newPerson) {
        this.newPerson = newPerson;
    }
    
    public List<Person> getAllPersonList(){
        return DataHelper.getInstance().getAllPersons();
    }

    public Address getInputAddress() {
        return inputAddress;
    }

    public void setInputAddress(Address inputAddress) {
        this.inputAddress = inputAddress;
    }
}
