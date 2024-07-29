package jpa.hql.relations.restful_hibernate.model.dao;

import org.springframework.data.repository.CrudRepository;

import jpa.hql.relations.restful_hibernate.model.entity.Patient;

public interface PatientDao extends CrudRepository<Patient, Long>{

    
}
