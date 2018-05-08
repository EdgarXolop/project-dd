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
@Table(name="USER")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdUser")
    private Integer idUser;
    @Column(name="Name")
    private String name;
    @Column(name="Password")
    private String password;
    @Column(name="Email")
    private String email;
    @Column(name="Phone")
    private String phone;
    @Column(name="User")
    private String user;
    @Column(name="IdRole")
    private Integer idRole;
    @Column(name="DeletedAt")
    private Date deletedAt;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="idRole", insertable=false, updatable=false)
    private Role role;

    public User(){}

    public Integer getIdUser() {
        return idUser;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getPhone() {
        return phone;
    }
    public String getUser() {
        return user;
    }
    public Integer getIdRole() {
        return idRole;
    }
    public Date getDeletedAt() {
        return deletedAt;
    }
    public Role getRole() {
        return role;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", name=" + name + ", email=" + email + ", phone=" + phone + ", user=" + user + ", deletedAt=" + deletedAt + '}';
    }

}