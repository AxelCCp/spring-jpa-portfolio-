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

import jpa.hql.relations.restful_hibernate.model.entity.AddressT1;
import jpa.hql.relations.restful_hibernate.model.entity.Client;
import jpa.hql.relations.restful_hibernate.model.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientRest {

    @GetMapping("/list")
    public ResponseEntity<?> getListOfClient() {
        return ResponseEntity.ok().body(this.clientService.listOfClient());
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.clientService.findById(id));
    }


    @PostMapping("/create")
    public ResponseEntity<?>createClient(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.saveClient(client));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateClient(@PathVariable Long id, @RequestBody Client client) {
        Optional<Client>opClient = this.clientService.findById(id);
        
        if(opClient.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.updateClient(id, client));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Objeto no encontrado!");
    }


    @DeleteMapping("del-address/{id}")
    public ResponseEntity<?>deleteAddress(@PathVariable Long id, @RequestBody AddressT1 addressT1) {
        Optional<Client>opClient = this.clientService.findById(id);
        if(opClient.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.delAddressClient(id, addressT1));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Objeto no encontrado!");
    }


    @Autowired
    private ClientService clientService;
}
