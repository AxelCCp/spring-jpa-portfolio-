package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.hql.relations.restful_hibernate.model.dao.PatientDao;
import jpa.hql.relations.restful_hibernate.model.entity.Client;
import jpa.hql.relations.restful_hibernate.model.entity.MedicalOrder;
import jpa.hql.relations.restful_hibernate.model.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService{

    @Override
    @Transactional(readOnly = true)
    public List<Patient> patientList() {
        return (List<Patient>) this.patientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Patient> getPatientById(Long id) {
        return this.patientDao.findById(id);
    }

    @Override
    @Transactional
    public Patient createPatient(Patient patient) {
        return this.patientDao.save(patient);
    }

    @Override
    @Transactional
    public Optional<Patient> addMedicalOrders(Long id, List<MedicalOrder> medicalOrders) {
       Optional<Patient>opPatient = this.patientDao.findById(id);
       if(opPatient.isPresent()) {
            Patient patient = opPatient.orElseThrow();
            patient.addMedicalOrders(medicalOrders);
            return Optional.of(this.patientDao.save(patient));
       }
       return opPatient;
    }

    @Override
    @Transactional
    public Optional<Patient> updatePatientByID(Long id, Patient patient) {
        return Optional.of(this.patientDao.save(patient));
    }

    @Override
    @Transactional
    public Optional<Client> deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }


    @Autowired
    private PatientDao patientDao;

}
