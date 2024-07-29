package jpa.hql.relations.restful_hibernate.restcontroller;

import java.util.List;
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

import jpa.hql.relations.restful_hibernate.model.entity.Engine;
import jpa.hql.relations.restful_hibernate.model.service.EngineService;

@RestController
@RequestMapping("/engine")
public class EngineController {

    @GetMapping("/list")
    public ResponseEntity<?>getEngineList() {
        return ResponseEntity.status(HttpStatus.OK).body(this.engineService.getEngineList());
    }

    @GetMapping("/list-brand/{brand}")
    public ResponseEntity<?>getEngineListByBrand(@PathVariable(name="brand") String brand) {

        Optional<List<Engine>> opList= this.engineService.getEngineListByBrand(brand);
        if(opList.isPresent()){
            List<Engine> listEngine = opList.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(listEngine);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<?>createEngine(@RequestBody Engine engine) {
        return ResponseEntity.ok().body(this.engineService.save(engine));
    } 

    @PutMapping("/update-by-id/{id}")
    public ResponseEntity<?>updateEngineById(@PathVariable(name="id")Long id, @RequestBody Engine engine) {
        Optional<Engine>opEngine = this.engineService.updateById(id, engine);
        if(opEngine.isPresent()){
            return ResponseEntity.ok().body(opEngine.orElseThrow());
        }
        return ResponseEntity.badRequest().build();
    }


    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id) {
        Optional<Engine>opEngine = this.engineService.getEngineById(id);
        if(opEngine.isPresent()){
            this.engineService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(opEngine.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @Autowired
    private EngineService engineService;

}
