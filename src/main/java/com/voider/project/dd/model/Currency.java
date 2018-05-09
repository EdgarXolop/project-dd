package com.voider.project.dd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdCurrency")
	private Integer idCurrency;
	@Column(name = "Name")
	private String name;
	@Column(name = "Abbrevation")
	private String abbrevation;
	@Column(name = "IdUser")
	private Integer idUser;
	@Column(name="DeletedAt")
	private Date deletedAt;
	
	public Currency() {}

	public Integer getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Integer idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbrevation() {
		return abbrevation;
	}

	public void setAbbrevation(String abbrevation) {
		this.abbrevation = abbrevation;
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