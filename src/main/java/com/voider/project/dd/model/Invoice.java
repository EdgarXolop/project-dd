package com.voider.project.dd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "INVOICE")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdInvoice")
	private Integer idInvoice;
	@Column(name = "Serie")
	private String serie;
	@Column(name = "IdCurrency")
	private Integer idCurrency; 
	@Column(name = "ExchangeRate")
	private Double exchangeRate; 
	@Column(name = "InvoiceDate")
	private Date invoiceDate;
	@Column(name="IdUser")
    private Integer idUser;
	@Column(name = "Total")
	private Double total;
	@Column(name = "DeletedAt",insertable=false)
	private Date deletedAt;


	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCurrency", insertable=false, updatable=false)
	private Currency currency;

	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.REFRESH)
	@JoinColumn(name="idInvoice",insertable=false,updatable=false)
	private List<InvoiceDetail> details = new ArrayList<>();
	
	public Invoice() {}

	public Integer getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Integer idInvoice) {
		this.idInvoice = idInvoice;
    }
    
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

	public Integer getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Integer idCurrency) {
		this.idCurrency = idCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public List<InvoiceDetail> getDetails() {
		return details;
	}
	
	public void setDetails(List<InvoiceDetail> details) {
		this.details = details;
	}
	
}