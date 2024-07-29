package jpa.hql.relations.restful_hibernate.model.service;

import java.util.List;
import java.util.Optional;

import jpa.hql.relations.restful_hibernate.model.entity.InvoiceT1;

public interface InvoiceT1Service {

    List<InvoiceT1>getListInvoicesT1();

    Optional<InvoiceT1>getInvoiceT1ById(Long id);

    InvoiceT1 createInvoiceT1(InvoiceT1 invoiceT1);
    
    Optional<InvoiceT1>updateInvoiceT1ById(Long id, InvoiceT1 invoiceT1);

    Optional<InvoiceT1>deleteInvoiceT1ById(Long id);

}
