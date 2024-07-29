package jpa.hql.relations.restful_hibernate.restcontroller;

import java.util.List;
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

import jpa.hql.relations.restful_hibernate.model.dao.ProductionStageDao;
import jpa.hql.relations.restful_hibernate.model.dao.WorkerDao;
import jpa.hql.relations.restful_hibernate.model.entity.ProductionStage;
import jpa.hql.relations.restful_hibernate.model.entity.Worker;

@RestController
@RequestMapping("/worker")
public class WorkerRest {


    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok().body(this.workerDao.findAll());
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody List<Worker> workers) {
        Iterable<Worker> antsDB = this.workerDao.saveAll(workers);
        return ResponseEntity.ok().body(antsDB);
    }

    @DeleteMapping("del-stage/{idWorker}/{idStage}")
    public ResponseEntity<?>deleteStageOfWorker(@PathVariable Long idWorker, @PathVariable Long idStage) {
        Optional<Worker> opWorker = this.workerDao.findById(idWorker);
        if(opWorker.isPresent()){
            Optional<ProductionStage> opStage = this.productionStageDao.findById(idStage);
            if(opStage.isPresent()){
                Worker workerDB = opWorker.orElseThrow();
                workerDB.getProductionStages().remove(opStage.get());
                return ResponseEntity.ok().body(Optional.of(this.workerDao.save(workerDB)));
            }
        }
        return ResponseEntity.badRequest().body("No se encontró registro de worker");
    }

    @Autowired
    private WorkerDao workerDao;
    @Autowired
    private ProductionStageDao productionStageDao;

}
