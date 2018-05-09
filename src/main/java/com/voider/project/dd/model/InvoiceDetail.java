package com.voider.project.dd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE_DETAIL")
public class InvoiceDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdInvoiceDetail")
    private Integer idInvoiceDetail;
	@Column(name="IdInvoice")
    private Integer idInvoice;
	@Column(name="ProductCode")
    private String productCode;
	@Column(name="Quantity")
    private int quantity;
	@Column(name="Description")
    private String description;
	@Column(name="Value")
    private Float value;
	@Column(name="IdUser")
    private Integer idUser;
	@Column(name = "DeletedAt")
	private Date deletedAt;
	
	public InvoiceDetail() {}

	public Integer getIdInvoiceDetail() {
		return idInvoiceDetail;
	}

	public void setIdInvoiceDetail(Integer idInvoiceDetail) {
		this.idInvoiceDetail = idInvoiceDetail;
	}

	public Integer getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(Integer idInvoice) {
		this.idInvoice = idInvoice;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
}
