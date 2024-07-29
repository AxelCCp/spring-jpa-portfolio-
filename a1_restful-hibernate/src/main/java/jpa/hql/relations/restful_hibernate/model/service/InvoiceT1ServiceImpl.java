package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpa.hql.relations.restful_hibernate.model.dao.InvoiceT1Dao;
import jpa.hql.relations.restful_hibernate.model.entity.InvoiceT1;

@Service
public class InvoiceT1ServiceImpl implements InvoiceT1Service{

    @Override
    @Transactional(readOnly = true)
    public List<InvoiceT1> getListInvoicesT1() {
        return (List<InvoiceT1>) this.invoiceT1Dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InvoiceT1> getInvoiceT1ById(Long id) {
        return this.invoiceT1Dao.findById(id);
    }

    @Override
    @Transactional
    public InvoiceT1 createInvoiceT1(InvoiceT1 invoiceT1) {
       return this.invoiceT1Dao.save(invoiceT1);
    }

    @Override
    @Transactional
    public Optional<InvoiceT1> updateInvoiceT1ById(Long id, InvoiceT1 invoiceT1) {
        Optional<InvoiceT1> opInvoice = this.getInvoiceT1ById(id);
        if(opInvoice.isPresent()){
            InvoiceT1 invoiceT1_db = opInvoice.orElseThrow();
            invoiceT1_db.setDescription(invoiceT1.getDescription());
            invoiceT1_db.setClient(invoiceT1.getClient());
            invoiceT1_db.setTotal(invoiceT1.getTotal());
            return Optional.of(this.invoiceT1Dao.save(invoiceT1_db));
        }
        return opInvoice;
    }

    @Override
    @Transactional
    public Optional<InvoiceT1> deleteInvoiceT1ById(Long id) {
        Optional<InvoiceT1> opInvoice = this.getInvoiceT1ById(id);
        opInvoice.ifPresent(i -> this.invoiceT1Dao.deleteById(i.getId()));
        return opInvoice;
    }

    @Autowired
    private InvoiceT1Dao invoiceT1Dao;

}


