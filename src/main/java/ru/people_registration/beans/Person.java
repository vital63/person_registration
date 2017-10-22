package ru.people_registration.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="person", schema="public")
public class Person  implements java.io.Serializable {

    private int id;
    private Address address;
    private String surname;
    private String name;
    private String patronymic;
    private boolean sex;
    private Date dateBirthday;

    public Person() {
    }

    public Person(int id, Address address, String surname, String name, String patronymic, boolean sex, Date dateBirthday) {
       this.id = id;
       this.address = address;
       this.surname = surname;
       this.name = name;
       this.patronymic = patronymic;
       this.sex = sex;
       this.dateBirthday = dateBirthday;
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id", nullable=false)
    @Cascade(CascadeType.ALL)
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name="surname", nullable=false, length=30)
    public String getSurname() {
        return this.surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    @Column(name="name", nullable=false, length=30)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="patronymic", nullable=false, length=30)
    public String getPatronymic() {
        return this.patronymic;
    }
    
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    
    @Column(name="sex", nullable=false)
    public boolean isSex() {
        return this.sex;
    }
    
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_birthday", nullable=false, length=13)
    public Date getDateBirthday() {
        return this.dateBirthday;
    }
    
    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", address=" + address + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic + ", sex=" + sex + ", dateBirthday=" + dateBirthday + '}';
    }
    
    
}


