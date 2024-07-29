package jpa.hql.relations.restful_hibernate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.hql.relations.restful_hibernate.model.dao.AntDao;
import jpa.hql.relations.restful_hibernate.model.entity.Ant;

@RestController
@RequestMapping("/ant")
public class AntController {

    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok().body(this.antDao.findAll());
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody List<Ant> ants) {
        Iterable<Ant> antsDB = this.antDao.saveAll(ants);
        return ResponseEntity.ok().body(antsDB);
    }

    @Autowired
    private AntDao antDao;

}
