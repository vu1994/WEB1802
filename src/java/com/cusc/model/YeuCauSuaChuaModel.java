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

/**
 *
 * @author cuscsoft
 */
@Entity
@Table(name = "yeucau_suachua")
public class YeuCauSuaChuaModel implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "yeucau_id", unique = true, nullable = false)
    private long yeucauID;
    
    @Column(name = "yeucau_nv_id")
    private Integer yeucauNvID;
    
    @Column(name = "yeucau_tb_id")
    private Integer yeucauTbID;
    
    @Column(name = "yeucau_ngayyeucau")
    private Date yeucauNgayYeuCau;
    
    @Column(name = "yeucau_tinhtranghong")
    private String yeucauTinhTrangHong;
    
    @Column(name = "yeucau_tinhtrangsc")
    private Integer yeucauTinhTrangSC;
    
    public long getYeucauID() {
        return yeucauID;
    }

    public void setYeucauID(long yeucauID) {
        this.yeucauID = yeucauID;
    }

    public Integer getYeucauNvID() {
        return yeucauNvID;
    }

    public void setYeucauNvID(Integer yeucauNvID) {
        this.yeucauNvID = yeucauNvID;
    }

    public Integer getYeucauTbID() {
        return yeucauTbID;
    }

    public void setYeucauTbID(Integer yeucauTbID) {
        this.yeucauTbID = yeucauTbID;
    }

    public Date getYeucauNgayYeuCau() {
        return yeucauNgayYeuCau;
    }

    public void setYeucauNgayYeuCau(Date yeucauNgayYeuCau) {
        this.yeucauNgayYeuCau = yeucauNgayYeuCau;
    }

    public String getYeucauTinhTrangHong() {
        return yeucauTinhTrangHong;
    }

    public void setYeucauTinhTrangHong(String yeucauTinhTrangHong) {
        this.yeucauTinhTrangHong = yeucauTinhTrangHong;
    }

    public Integer getYeucauTinhTrangSC() {
        return yeucauTinhTrangSC;
    }

    public void setYeucauTinhTrangSC(Integer yeucauTinhTrangSC) {
        this.yeucauTinhTrangSC = yeucauTinhTrangSC;
    }

    
}
