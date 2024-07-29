package jpa.hql.relations.restful_hibernate.model.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="medical_order")
public class MedicalOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_order;

    //bidireccional
    @JsonIgnore
    @JoinColumn(name="patient_id") //MedicalOrder es dueña de la relacion.
    @ManyToOne
    private Patient patient;

    private String doctor;
    private String description;
    private LocalDate date;

    public Long getId_order() {
        return id_order;
    }
    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }
    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    

}
