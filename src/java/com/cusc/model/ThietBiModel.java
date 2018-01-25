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
    @Table(name = "ThietBi")
public class ThietBiModel implements Serializable {

    @Id
    @Column(name = "thietbi_id", unique = true, nullable = false)
    private Long thietBiID;
    
    @Column(name = "thietbi_ten")
    private String thietBiTen;
    
    @Column(name = "danhmuc_thietbi_id")
    private String dmThietBiID;
    
    @Column(name = "danhmuc_thietbi_ten")
    private String dmThietBiTen;
    
    @Column(name = "tinhtrang_id")
    private String tinhTrangID;
    
    @Column(name = "tinhtrang_ten")
    private String tinhTrangTen;
    
    // --- Getter Setter
    public Long getThietBiID() {
        return thietBiID;
    }

    public void setThietBiID(Long thietBiID) {
        this.thietBiID = thietBiID;
    }

    public String getThietBiTen() {
        return thietBiTen;
    }

    public void setThietBiTen(String thietBiTen) {
        this.thietBiTen = thietBiTen;
    }

    public String getDmThietBiID() {
        return dmThietBiID;
    }

    public void setDmThietBiID(String dmThietBiID) {
        this.dmThietBiID = dmThietBiID;
    }

    public String getTinhTrangID() {
        return tinhTrangID;
    }

    public void setTinhTrangID(String tinhTrangID) {
        this.tinhTrangID = tinhTrangID;
    }

    public String getDmThietBiTen() {
        return dmThietBiTen;
    }

    public void setDmThietBiTen(String dmThietBiTen) {
        this.dmThietBiTen = dmThietBiTen;
    }

    public String getTinhTrangTen() {
        return tinhTrangTen;
    }

    public void setTinhTrangTen(String tinhTrangTen) {
        this.tinhTrangTen = tinhTrangTen;
    }

}
