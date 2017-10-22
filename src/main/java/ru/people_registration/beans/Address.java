package ru.people_registration.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="address", schema="public")
public class Address  implements java.io.Serializable {

    private int id;
    private Street street;
    private int number;
    private Set<Person> persons = new HashSet<Person>(0);

    public Address() {
    }
	
    public Address(int id, Street street, int number) {
        this.id = id;
        this.street = street;
        this.number = number;
    }

    public Address(int id, Street street, int number, Set<Person> persons) {
       this.id = id;
       this.street = street;
       this.number = number;
       this.persons = persons;
    }
   
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="street_id", nullable=false)
    public Street getStreet() {
        return this.street;
    }
    
    public void setStreet(Street street) {
        this.street = street;
    }
    
    @Column(name="number", nullable=false)
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    public Set<Person> getPersons() {
        return this.persons;
    }
    
    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", number=" + number + '}';
    }
}


