package jpa.hql.relations.restful_hibernate.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="patients" )
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;

    //bidireccional
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="patient")
    private Set<MedicalOrder> medical_orders;
    
    //unidireccional
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true) 
    private Set<MedicalHistory> medical_history;


    public void addMedicalOrders(List<MedicalOrder>medicalOrdersParam) {
        medicalOrdersParam.forEach(mo -> {
            this.medical_orders.add(mo);
            mo.setPatient(this);
        });
    }


    public void delMedicalOrder(MedicalOrder mo) {
        this.getMedical_orders().remove(mo);
        mo.setPatient(null);
    }

    public Patient() {
        this.medical_orders = new HashSet<>();
        this.medical_history = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<MedicalOrder> getMedical_orders() {
        return medical_orders;
    }

    public void setMedical_orders(Set<MedicalOrder> medical_orders) {
        this.medical_orders = medical_orders;
    }

    public Set<MedicalHistory> getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(Set<MedicalHistory> medical_history) {
        this.medical_history = medical_history;
    } 

    

}
