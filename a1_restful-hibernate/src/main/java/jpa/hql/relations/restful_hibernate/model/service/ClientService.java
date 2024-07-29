package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import jpa.hql.relations.restful_hibernate.model.entity.AddressT1;
import jpa.hql.relations.restful_hibernate.model.entity.Client;

public interface ClientService {

    List<Client>listOfClient();
    Optional<Client> findById(Long id);
    Client saveClient(Client client);
    Optional<Client> updateClient(Long id, Client client);
    Optional<Client> deleteById(Long id);
    String delAddressClient(Long id, AddressT1 addressT1);
}

