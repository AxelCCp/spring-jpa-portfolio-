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

import jpa.hql.relations.restful_hibernate.model.entity.Bank;
import jpa.hql.relations.restful_hibernate.model.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankRest {

    @GetMapping("/list")
    public ResponseEntity<?>getBankList() {
        return ResponseEntity.ok().body(this.bankService.getBankList());
    }
    
    @GetMapping("/by-id/{id}")
    public ResponseEntity<?> getBankByIdBank(@PathVariable Long id) {
        Optional<Bank> opBank = this.bankService.getBankByIdBank(id);
        if(opBank.isPresent()){
            return ResponseEntity.ok().body(opBank.orElseThrow());
        }
        return ResponseEntity.notFound().build(); 
    }

    @PostMapping("/create")
    public ResponseEntity<?>createBank(@RequestBody Bank bank) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bankService.createBank(bank));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateBank(@PathVariable Long id, @RequestBody Bank bank) {
        Optional<Bank> opBank = this.bankService.getBankByIdBank(id);
        if(opBank.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(this.bankService.updateBankData(id, bank));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Objeto no encontrado!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id) {
        Optional<Bank> opBank = this.bankService.deleteBankById(id);
        if(opBank.isPresent()){
            return ResponseEntity.ok(opBank.orElseThrow());   
        }
        return ResponseEntity.notFound().build();
    }



    @Autowired
    private BankService bankService;
}
