package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.hql.relations.restful_hibernate.model.dao.ClientDao;
import jpa.hql.relations.restful_hibernate.model.entity.AddressT1;
import jpa.hql.relations.restful_hibernate.model.entity.Client;

@Service
public class ClientServiceImpl implements ClientService{

    @Override
    @Transactional(readOnly = true)
    public List<Client> listOfClient() {
        return (List<Client>) this.clientDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id) {
       return this.clientDao.findOne(id);
    }

    @Override
    @Transactional
    public Client saveClient(Client client) {
        return this.clientDao.save(client);
    }

    @Override
    @Transactional
    public Optional<Client> updateClient(Long id, Client client) {
        Optional<Client>opClient = this.clientDao.findById(id);
        if(opClient.isPresent()){

            Client client_db = opClient.orElseThrow();

            client_db.setName(client.getName());
            client_db.setLastname(client.getLastname());
            client_db.setFormaPago(client.getFormaPago());
            
           /*  client_db.setAddresses_t1(client.getAddresses_t1());
            client_db.setBankAccounts(client.getBankAccounts());
            client_db.setEmailsAccounts(client.getEmailsAccounts());
            client_db.setEquiposRegistrados(client.getEquiposRegistrados()); */
            
            return Optional.of(this.clientDao.save(client_db));
        }
        return opClient;
    }

    @Override
    @Transactional
    public Optional<Client> deleteById(Long id) {
        Optional<Client>opClient = this.clientDao.findById(id);
        opClient.ifPresent(c -> this.clientDao.deleteById(c.getId()));
        return opClient;
    }

    @Override
    @Transactional
    public String delAddressClient(Long id, AddressT1 addressT1) {
        Optional<Client>opClient = this.clientDao.findById(id);
        opClient.ifPresent(c -> c.getAddresses_t1().remove(addressT1));
        return "address deleted";
    }

    @Autowired
    private ClientDao clientDao;


}
