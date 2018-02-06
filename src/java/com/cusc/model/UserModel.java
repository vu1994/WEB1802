/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author cuscsoft
 */
@Entity
@Table(name = "user")
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private long userID;
    
    @Column(name = "user_screenname")
    private String userScreenname;
    
    @Column(name = "user_password")
    private String userPassword;
    
    @Column(name = "nv_id")
    private String nvID;
    
    @Column(name = "nv_ten")
    private String nvTen;
    
    @Column (name = "user_role")
    private int userRole;

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserScreenname() {
        return userScreenname;
    }

    public void setUserScreenname(String userScreenname) {
        this.userScreenname = userScreenname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getNvID() {
        return nvID;
    }

    public void setNvID(String nvID) {
        this.nvID = nvID;
    }

    public String getNvTen() {
        return nvTen;
    }

    public void setNvTen(String nvTen) {
        this.nvTen = nvTen;
    }
}
