package ru.people_registration.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="street", schema="public")
public class Street  implements java.io.Serializable {

    private int id;
    private String name;
    private Set<Address> addresses = new HashSet<Address>(0);

    public Street() {
    }
	
    public Street(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Street(int id, String name, Set<Address> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }
   
    @Id 
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="name", nullable=false, length=30)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="street")
    public Set<Address> getAddresses() {
        return this.addresses;
    }
    
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}


