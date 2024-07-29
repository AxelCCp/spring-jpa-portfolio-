package jpa.hql.relations.restful_hibernate.model.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jpa.hql.relations.restful_hibernate.model.entity.Client;

public interface ClientDao extends CrudRepository<Client, Long> {

    @Query("select c from Client c left join fetch c.addresses_t1 left join fetch c.bankAccounts left join fetch c.emailsAccounts left join fetch c.equiposRegistrados where c.id=?1")
    Optional<Client> findOne(Long id);

}
