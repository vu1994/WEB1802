/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author thyen
 */
@Entity
@Table(name = "phongban")
public class PhongBanModel implements Serializable {

    @Id
    @Column(name = "pb_id", unique = true, nullable = false)
    private long phongbanID;
    
    @Column(name = "pb_ten")
    private String phongbanTen;

    public PhongBanModel() {
    }
   
    public long getPhongbanID() {
        return phongbanID;
    }

    public void setPhongbanID(long phongbanID) {
        this.phongbanID = phongbanID;
    }

    public String getPhongbanTen() {
        return phongbanTen;
    }

    public void setPhongbanTen(String phongbanTen) {
        this.phongbanTen = phongbanTen;
    }
    
}
