package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import jpa.hql.relations.restful_hibernate.model.entity.Bank;

public interface BankService {

    List<Bank>getBankList();
    Optional<Bank>getBankByIdBank(Long idBank);
    Bank createBank(Bank bank);
    Optional<Bank>updateBankData(Long idBank, Bank bank);
    Optional<Bank>deleteBankById(Long idBank);

}
