package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import jpa.hql.relations.restful_hibernate.model.entity.Engine;

public interface EngineService {

    List<Engine> getEngineList();
    
    Optional<List<Engine>> getEngineListByBrand(String brand);

    Optional<Engine> getEngineById(Long id);

    Engine save(Engine engine);

    Optional<Engine> updateById(Long id, Engine engine);

    void deleteById(Long id);

}
