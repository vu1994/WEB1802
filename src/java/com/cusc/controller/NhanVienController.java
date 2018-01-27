/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.NhanVienProvider;
import com.cusc.model.DanhMucThietBiModel;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author thyen
 */
@ManagedBean(name="DanhMucNhanVienController")
@RequestScoped
public class NhanVienController {
    private NhanVienProvider nvProvider = new NhanVienProvider();
    private List<Map> listDmNhanVien;
   
    
    public NhanVienController(){
        this.actionGetListDmNhanVien();
    }
    
    public void actionGetListDmNhanVien(){
        listDmNhanVien = nvProvider.getListNhanVien();
    }

    public List<Map> getListDmNhanVien() {
        return listDmNhanVien;
    }

    public void setListDmNhanVien(List<Map> listDmNhanVien) {
        this.listDmNhanVien = listDmNhanVien;
    }
    
    
}
