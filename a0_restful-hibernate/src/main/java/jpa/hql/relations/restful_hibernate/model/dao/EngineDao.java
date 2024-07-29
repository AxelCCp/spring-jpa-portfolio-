package jpa.hql.relations.restful_hibernate.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jpa.hql.relations.restful_hibernate.model.entity.Engine;

@Repository
public interface EngineDao extends CrudRepository<Engine, Long> {

    @Query("select e from Engine e")
    List<Engine> getEngineList (); 

    @Query("select e from Engine e where e.brand=?1")
    Optional<List<Engine>> getEngineListByBrand(String brand);



}
