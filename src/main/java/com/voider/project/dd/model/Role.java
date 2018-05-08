package com.voider.project.dd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENT")
public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdRole")
    private Integer idRole;
    @Column(name="Name")
    private String name;
	@Column(name="DeletedAt")
	private Date deletedAt;

    public Integer getIdRole() {
        return idRole;
    }
    public String getName() {
        return name;
    }
    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}