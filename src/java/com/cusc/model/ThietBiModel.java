/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author npvu
 */
@Entity
@Table(name = "ThietBi")
public class ThietBiModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    @Column(name = "thietbi_ngaynhap")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date thietBiNgayNhap;
    
    @Column(name = "thietbi_ngaycap")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date thietBiNgayCap;
    
    @Column(name = "thietbi_capcho")
    private int capChoNhanVienID;
    
    @Column(name = "thietbi_nguoicap")
    private int thietBiNguoiCap;
    
    @Column(name = "thietbi_trangthai_capphat")
    private int thietBiTrangThaiCapPhat;
    
    @Column(name = "thietbi_ngaythuhoi")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date thietBiNgayThuHoi;
    
    public ThietBiModel(){
        
    }
    
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

    public Date getThietBiNgayNhap() {
        return thietBiNgayNhap;
    }

    public void setThietBiNgayNhap(Date thietBiNgayNhap) {
        this.thietBiNgayNhap = thietBiNgayNhap;
    }

    public Date getThietBiNgayCap() {
        return thietBiNgayCap;
    }

    public void setThietBiNgayCap(Date thietBiNgayCap) {
        this.thietBiNgayCap = thietBiNgayCap;
    }

    public int getCapChoNhanVienID() {
        return capChoNhanVienID;
    }

    public void setCapChoNhanVienID(int capChoNhanVienID) {
        this.capChoNhanVienID = capChoNhanVienID;
    }

    public int getThietBiNguoiCap() {
        return thietBiNguoiCap;
    }

    public void setThietBiNguoiCap(int thietBiNguoiCap) {
        this.thietBiNguoiCap = thietBiNguoiCap;
    }

    public Date getThietBiNgayThuHoi() {
        return thietBiNgayThuHoi;
    }

    public void setThietBiNgayThuHoi(Date thietBiNgayThuHoi) {
        this.thietBiNgayThuHoi = thietBiNgayThuHoi;
    }

    public int getThietBiTrangThaiCapPhat() {
        return thietBiTrangThaiCapPhat;
    }

    public void setThietBiTrangThaiCapPhat(int thietBiTrangThaiCapPhat) {
        this.thietBiTrangThaiCapPhat = thietBiTrangThaiCapPhat;
    }

}
