package com.voider.project.dd.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

import com.voider.project.dd.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

    @Query("select i from Invoice i where i.idInvoice = ?1 and i.deletedAt is null ")
    public Invoice get(Integer idInvoice);

    @Query("SELECT i FROM Invoice i where (i.invoiceDate between ?1 and ?2) and i.deletedAt is null order by i.invoiceDate asc")
    public List<Invoice> listInvoiceByDateRange(Date dateFrom, Date dateTo);
    
}
