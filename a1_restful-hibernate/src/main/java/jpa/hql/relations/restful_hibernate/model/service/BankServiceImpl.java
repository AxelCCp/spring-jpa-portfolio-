package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.hql.relations.restful_hibernate.model.dao.BankDao;
import jpa.hql.relations.restful_hibernate.model.entity.Bank;

@Service
public class BankServiceImpl implements BankService{

    @Override
    public List<Bank> getBankList() {
       return (List<Bank>)this.bankDao.findAll();
    }

    @Override
    public Optional<Bank> getBankByIdBank(Long idBank) {
        return this.bankDao.findById(idBank);
    }

    @Override
    public Bank createBank( Bank bank) {
        return this.bankDao.save(bank);
    }

    @Override
    public Optional<Bank> updateBankData(Long idBank, Bank bank) {
        Optional<Bank>opbank = this.bankDao.findById(idBank);
        if(opbank.isPresent()){
            Bank bank_db = opbank.orElseThrow();
            bank_db.setName(bank.getName());
            return Optional.of(this.bankDao.save(bank_db));
        }
        return opbank;
    }

    @Override
    public Optional<Bank> deleteBankById(Long idBank) {
        Optional<Bank>opbank = this.bankDao.findById(idBank);
        opbank.ifPresent(b ->  this.bankDao.deleteById(idBank));
        return opbank;
    }


    @Autowired
    private BankDao bankDao;

}
