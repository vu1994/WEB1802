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
import javax.persistence.Table;

/**
 *
 * @author npvu
 */
@Entity
@Table(name = "danhmuc_thietbi")
public class DanhMucThietBiModel implements Serializable {

    @Id
    @Column(name = "danhmuc_thietbi_id")
    private long dmThietBiID;
    
    @Column(name = "danhmuc_thietbi_ten")
    private String dmThietBiTen;
    
    public DanhMucThietBiModel(){
        
    }
    
    // --- Getter Setter

    public long getDmThietBiID() {
        return dmThietBiID;
    }

    public void setDmThietBiID(long dmThietBiID) {
        this.dmThietBiID = dmThietBiID;
    }

    public String getDmThietBiTen() {
        return dmThietBiTen;
    }

    public void setDmThietBiTen(String dmThietBiTen) {
        this.dmThietBiTen = dmThietBiTen;
    }
    

}
