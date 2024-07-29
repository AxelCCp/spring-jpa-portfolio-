package jpa.hql.relations.restful_hibernate.restcontroller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.hql.relations.restful_hibernate.model.entity.MedicalOrder;
import jpa.hql.relations.restful_hibernate.model.entity.Patient;
import jpa.hql.relations.restful_hibernate.model.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientRest {

    @GetMapping("/list")
    public ResponseEntity<?>getPatientList() {
        return ResponseEntity.ok().body(this.patientService.patientList());
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.patientService.getPatientById(id));
    }
    
    @PostMapping("/create")
    public ResponseEntity<?>createPatient(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.patientService.createPatient(patient));
    }

    @PostMapping("/add-med-orders/{id}")
    public ResponseEntity<?>addMedicalOrders(@PathVariable Long id, @RequestBody List<MedicalOrder> medicalOrder) {
        Optional<Patient>opPatient = this.patientService.getPatientById(id);
        if(opPatient.isPresent()){
            this.patientService.addMedicalOrders(id, medicalOrder);
            return ResponseEntity.ok().body(this.patientService.getPatientById(id).orElseThrow());
        } 
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el paciente con id " + id + ".");
    }


    @DeleteMapping("/del-med-orders/{idPatient}/{idMedOrder}")
    public ResponseEntity<?>addMedicalOrders(@PathVariable(name="idPatient") Long idPatient, @PathVariable(name="idMedOrder") Long idMedOrder) {
        Optional<Patient>opPatient = this.patientService.getPatientById(idPatient);
        if(opPatient.isPresent()){
            Patient patient = opPatient.orElseThrow();
            MedicalOrder medicalOrder;
            Set<MedicalOrder> medicalOrders = patient.getMedical_orders();
            for(MedicalOrder mo : medicalOrders){
                if(mo.getId_order()==idMedOrder){
                    medicalOrder = mo;
                    patient.delMedicalOrder(medicalOrder);
                    this.patientService.updatePatientByID(idPatient, patient);
                    break;
                }
            }
            return ResponseEntity.ok().body(this.patientService.getPatientById(idPatient).orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el paciente con id " + idPatient + ".");
    }



    @Autowired
    private PatientService patientService;

}
