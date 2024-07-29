package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import jpa.hql.relations.restful_hibernate.model.entity.Client;
import jpa.hql.relations.restful_hibernate.model.entity.MedicalOrder;
import jpa.hql.relations.restful_hibernate.model.entity.Patient;

public interface PatientService {

    List<Patient>patientList();
    Optional<Patient>getPatientById(Long id);
    Patient createPatient(Patient patient);
    Optional<Patient> addMedicalOrders(Long id, List<MedicalOrder>medicalOrders);
    Optional<Patient>updatePatientByID(Long id, Patient patient);
    Optional<Client> deleteById(Long id);

}
