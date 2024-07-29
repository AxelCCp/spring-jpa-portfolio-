package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.hql.relations.restful_hibernate.model.dao.EngineDao;
import jpa.hql.relations.restful_hibernate.model.entity.Engine;

@Service
public class EngineServiceImpl implements EngineService {

    @Override
    @Transactional(readOnly = true)
    public List<Engine> getEngineList() {
       return this.engineDao.getEngineList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Engine>> getEngineListByBrand(String brand) {
       return this.engineDao.getEngineListByBrand(brand);
    }

    @Override
    @Transactional
    public Optional<Engine> getEngineById(Long id) {
       return this.engineDao.findById(id);
    }

    @Override
    @Transactional
    public Engine save(Engine engine) {
       return this.engineDao.save(engine);
    }

    @Override
    @Transactional
    public Optional<Engine> updateById(Long id, Engine engine) {
       Optional<Engine> opEn = this.engineDao.findById(id);
       if(opEn.isPresent()){
            Engine engineDb = opEn.orElseThrow();
            engineDb.setBrand(engine.getBrand());
            engineDb.setEngineCode(engine.getEngineCode());
            engineDb.setYearProduction(engine.getYearProduction());
            return Optional.of(this.engineDao.save(engineDb));
       }
       return opEn;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.engineDao.deleteById(id);
    }

    @Autowired
    private EngineDao engineDao;

    
}
