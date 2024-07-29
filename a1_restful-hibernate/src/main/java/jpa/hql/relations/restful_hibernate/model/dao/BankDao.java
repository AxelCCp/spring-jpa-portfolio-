package jpa.hql.relations.restful_hibernate.model.dao;

import org.springframework.data.repository.CrudRepository;

import jpa.hql.relations.restful_hibernate.model.entity.Bank;

public interface BankDao extends CrudRepository<Bank, Long>{}
