package jpa.hql.relations.restful_hibernate.model.dao;

import org.springframework.data.repository.CrudRepository;

import jpa.hql.relations.restful_hibernate.model.entity.Banana;

public interface BananaDao extends CrudRepository<Banana, Long>{}
