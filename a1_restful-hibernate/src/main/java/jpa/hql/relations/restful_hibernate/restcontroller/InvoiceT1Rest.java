package jpa.hql.relations.restful_hibernate.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.hql.relations.restful_hibernate.model.entity.InvoiceT1;
import jpa.hql.relations.restful_hibernate.model.service.InvoiceT1Service;

@RestController
@RequestMapping("/invoiceT1")
public class InvoiceT1Rest {


    @GetMapping("/list")
    public ResponseEntity<?>getListInvoicesT1() {
        return ResponseEntity.ok().body(this.invoiceT1Service.getListInvoicesT1());
    }


    @GetMapping("/by-Id/{id}")
    public ResponseEntity<?>getInvoiceT1ById(@PathVariable Long id) {
        Optional<InvoiceT1> opInvoice =  this.invoiceT1Service.getInvoiceT1ById(id);
        if(opInvoice.isPresent()){
            return ResponseEntity.ok().body(this.invoiceT1Service.getInvoiceT1ById(id).orElseThrow());
        }
        return ResponseEntity.notFound().build();   
    }

    @PostMapping("/create")
    public ResponseEntity<?>createInvoiceT1(@RequestBody InvoiceT1 invoiceT1) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.invoiceT1Service.createInvoiceT1(invoiceT1));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateInvoiceT1(@PathVariable Long id, @RequestBody InvoiceT1 invoiceT1) {
        Optional<InvoiceT1> opInvoice =  this.invoiceT1Service.getInvoiceT1ById(id);
        if(opInvoice.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(this.updateInvoiceT1(id, invoiceT1));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Objeto no encontrado!");
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id) {
        Optional<InvoiceT1> opInvoice =  this.invoiceT1Service.deleteInvoiceT1ById(id);
        if(opInvoice.isPresent()){
            return ResponseEntity.ok(opInvoice.orElseThrow());    
        }
        return ResponseEntity.notFound().build();
    }


    @Autowired
    private InvoiceT1Service invoiceT1Service;

}
