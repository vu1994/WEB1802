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
 * @author npvu
 */
@Entity
    @Table(name = "ThietBi")
public class ThietBiModel implements Serializable {

    @Id
    @Column(name = "thietbi_id", unique = true, nullable = false)
    private Long thietBiID;
    
    @Column(name = "thietbi_ten")
    private String theitBiTen;

    public String getTheitBiTen() {
        return theitBiTen;
    }

    public void setTheitBiTen(String theitBiTen) {
        this.theitBiTen = theitBiTen;
    }
    
    // --- Getter Setter
    public Long getThietBiID() {
        return thietBiID;
    }

    public void setThietBiID(Long thietBiID) {
        this.thietBiID = thietBiID;
    }

}
