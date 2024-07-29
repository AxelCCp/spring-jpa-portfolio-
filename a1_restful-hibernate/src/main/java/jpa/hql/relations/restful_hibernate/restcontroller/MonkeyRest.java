package jpa.hql.relations.restful_hibernate.restcontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.hql.relations.restful_hibernate.model.dto.MonkeyBananaDto;
import jpa.hql.relations.restful_hibernate.model.entity.Monkey;
import jpa.hql.relations.restful_hibernate.model.service.MonkeyService;

@RestController
@RequestMapping("/monkey")
public class MonkeyRest {

    @GetMapping("/list")
    public ResponseEntity<?>monkeyList() {
        return ResponseEntity.ok().body(this.monkeyService.monkeyList());
    }

    @PostMapping("/create")
    public ResponseEntity<?>createMonkey(@RequestBody MonkeyBananaDto monkeyBanana) {

        Optional<Monkey>opMonkey = monkeyService.saveMonkey(monkeyBanana);
        if(opMonkey.isPresent()){
            return ResponseEntity.ok().body(opMonkey.orElseThrow());
        }

        return ResponseEntity.badRequest().body("Error .... . . . ."); 
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteMonkey(@PathVariable Long id) {
        Optional<Monkey> opMonkey = this.monkeyService.deleteMonkey(id);
        if(opMonkey.isPresent()){
            Map<String, Object> response = new HashMap<>();
            response.put("response", "Registro eliminado con exito ... ");
            response.put("monkey_deleted", opMonkey.orElseThrow());
            return ResponseEntity.ok().body(response);
        }
        return ResponseEntity.badRequest().body("Error al eliminar el monkey.. . . ");
    }


    @Autowired
    private MonkeyService monkeyService;

}
