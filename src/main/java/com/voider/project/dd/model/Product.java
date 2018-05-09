package com.voider.project.dd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdProduct")
    private Integer idProduct;
	@Column(name="ProductCode")
    private String productCode;
	@Column(name="Description")
    private String description;
	@Column(name="IdCoin")
    private Integer idCoin;
	@Column(name="Price")
    private Double price;
	@Column(name="IdUser")
    private Integer idUser;
	@Column(name="DeletedAt")
    private Date deletedAt;
	
	public Product() {}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdCoin() {
		return idCoin;
	}

	public void setIdCoin(Integer idCoin) {
		this.idCoin = idCoin;
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