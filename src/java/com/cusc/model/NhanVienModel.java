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
@Table(name = "nhanvien")
public class NhanVienModel implements Serializable {

    @Id
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
    private int nhanvienGioitinh;
    
    @Column(name = "nv_ngaysinh")
    private String nhanvienNgaysinh;
    
    @Column(name = "pb_id")
    private String nhanvienPhongban;

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

    public int getNhanvienGioitinh() {
        return nhanvienGioitinh;
    }

    public void setNhanvienGioitinh(int nhanvienGioitinh) {
        this.nhanvienGioitinh = nhanvienGioitinh;
    }

    public String getNhanvienNgaysinh() {
        return nhanvienNgaysinh;
    }

    public void setNhanvienNgaysinh(String nhanvienNgaysinh) {
        this.nhanvienNgaysinh = nhanvienNgaysinh;
    }

    public String getNhanvienPhongban() {
        return nhanvienPhongban;
    }

    public void setNhanvienPhongban(String nhanvienPhongban) {
        this.nhanvienPhongban = nhanvienPhongban;
    }
    
    
}
