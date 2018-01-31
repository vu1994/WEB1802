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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author thyen
 */
@Entity
@Table(name = "nhanvien")
public class NhanVienModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "nv_id", unique = true, nullable = false)
    private long nhanvienID;
    
    @Column(name = "nv_ten")
    private String nhanvienTen;
    
    @Column(name = "nv_diachi")
    private String nhanvienDiaChi;
    
    @Column(name = "nv_email")
    private String nhanvienEmail;
    
    @Column(name = "nv_sdt")
    private String nhanvienSdt;
    
    @Column(name = "nv_gioitinh")
    private Boolean nhanvienGioitinh=true;

    @Override
    public String toString() {
        return "NhanVienModel{" + "nhanvienID=" + nhanvienID + ","
                + " nhanvienTen=" + nhanvienTen + ", nhanvienDiaChi=" + 
                nhanvienDiaChi + ", nhanvienEmail=" + nhanvienEmail + ","
                + " nhanvienSdt=" + nhanvienSdt + ", nhanvienGioitinh=" +
                nhanvienGioitinh + ", nhanvienNgaysinh=" + nhanvienNgaysinh + ", "
                + "nhanvienPhongban=" + nhanvienPhongban + '}';
    }
    
    @Column(name = "nv_ngaysinh")
    private Date nhanvienNgaysinh;
    
    @Column(name = "pb_id")
    private int nhanvienPhongban;

    public NhanVienModel() {
    }

    
    
    public long getNhanvienID() {
        return nhanvienID;
    }

    public void setNhanvienID(long nhanvienID) {
        this.nhanvienID = nhanvienID;
    }

    public String getNhanvienTen() {
        return nhanvienTen;
    }

    public void setNhanvienTen(String nhanvienTen) {
        this.nhanvienTen = nhanvienTen;
    }

    public String getNhanvienDiaChi() {
        return nhanvienDiaChi;
    }

    public void setNhanvienDiaChi(String nhanvienDiaChi) {
        this.nhanvienDiaChi = nhanvienDiaChi;
    }

    public String getNhanvienEmail() {
        return nhanvienEmail;
    }

    public void setNhanvienEmail(String nhanvienEmail) {
        this.nhanvienEmail = nhanvienEmail;
    }

    public String getNhanvienSdt() {
        return nhanvienSdt;
    }

    public void setNhanvienSdt(String nhanvienSdt) {
        this.nhanvienSdt = nhanvienSdt;
    }

    public Boolean getNhanvienGioitinh() {
        return nhanvienGioitinh;
    }

    public void setNhanvienGioitinh(Boolean nhanvienGioitinh) {
        this.nhanvienGioitinh = nhanvienGioitinh;
    }

    public Date getNhanvienNgaysinh() {
        return nhanvienNgaysinh;
    }

    public void setNhanvienNgaysinh(Date nhanvienNgaysinh) {
        this.nhanvienNgaysinh = nhanvienNgaysinh;
    }

    public int getNhanvienPhongban() {
        return nhanvienPhongban;
    }

    public void setNhanvienPhongban(int nhanvienPhongban) {
        this.nhanvienPhongban = nhanvienPhongban;
    }
    
    
}
