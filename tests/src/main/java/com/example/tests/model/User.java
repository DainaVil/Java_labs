package com.example.tests.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="user")
@Table
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="group_id")
    private Long groupID;

    @Column(name="role_id")
    private Long roleID;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;
    
    @Column(name="middle_name")
    private String middleName;

    @Column(name="login")
    private String login;

    @Column(name="password_hash")
    private String passwordHash;

    public User() {
    }

    public User(Long id, Long group_id, Long role_id, String first_name, String last_name, String middle_name, String login, String password_hash) {
        this.id = id;
        this.groupID = group_id;
        this.roleID = role_id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.middleName = middle_name;
        this.login = login;
        this.passwordHash = password_hash;
    }

    public Long getID() {
        return id;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long group_id) {
        this.groupID = group_id;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long role_id) {
        this.roleID = role_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middle_name) {
        this.middleName = middle_name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String password_hash) {
        this.passwordHash = password_hash;
    }
}

