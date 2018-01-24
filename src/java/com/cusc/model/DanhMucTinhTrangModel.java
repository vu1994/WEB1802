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
@Table(name = "tinhtrang")
public class DanhMucTinhTrangModel implements Serializable {

    @Id
    @Column(name = "tinhtrang_id", unique = true, nullable = false)
    private Long tinhTrangID;
    
    @Column(name = "tinhtrang_ten")
    private String tinhTrangTen;
    
    @Column(name = "tinhtrang_noidung")
    private String tinhTrangNoiDung;
    
    // --- Getter Setter

    public Long getTinhTrangID() {
        return tinhTrangID;
    }

    public void setTinhTrangID(Long tinhTrangID) {
        this.tinhTrangID = tinhTrangID;
    }

    public String getTinhTrangTen() {
        return tinhTrangTen;
    }

    public void setTinhTrangTen(String tinhTrangTen) {
        this.tinhTrangTen = tinhTrangTen;
    }

    public String getTinhTrangNoiDung() {
        return tinhTrangNoiDung;
    }

    public void setTinhTrangNoiDung(String tinhTrangNoiDung) {
        this.tinhTrangNoiDung = tinhTrangNoiDung;
    }

}
