package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.hql.relations.restful_hibernate.model.dao.MonkeyDao;
import jpa.hql.relations.restful_hibernate.model.dto.MonkeyBananaDto;
import jpa.hql.relations.restful_hibernate.model.entity.Banana;
import jpa.hql.relations.restful_hibernate.model.entity.Monkey;

@Service
public class MonkeyServiceImpl implements MonkeyService{

    @Override
    @Transactional(readOnly = true)
    public List<Monkey> monkeyList() {
        return (List<Monkey>) this.monkeyDao.findAll();
    }

    @Override
    @Transactional
    public Optional<Monkey> saveMonkey(MonkeyBananaDto monkeyBanana) {
       Monkey myMonkey = monkeyBanana.getMonkey();
       Banana myBanana = monkeyBanana.getBanana();
       myMonkey.setBanana(myBanana);
       return Optional.of(this.monkeyDao.save(myMonkey));
    }

    @Override
    @Transactional
    public Optional<Monkey> deleteMonkey(Long id) {
        Optional<Monkey> opMonkey = this.monkeyDao.findById(id);
        if(opMonkey.isPresent()){
            this.monkeyDao.deleteById(id);
            return opMonkey;
        }
        return opMonkey;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Monkey> getByMonkeyId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByMonkeyId'");
    }

    @Autowired
    private MonkeyDao monkeyDao;

}
