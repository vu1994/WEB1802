/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.NhanVienProvider;
import com.cusc.model.NhanVienModel;
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
    private int selectedPhongBan;
    private NhanVienModel objNhanVien = new NhanVienModel();

    public NhanVienProvider getNvProvider() {
        return nvProvider;
    }

    public void setNvProvider(NhanVienProvider nvProvider) {
        this.nvProvider = nvProvider;
    }

    public NhanVienModel getObjNhanVien() {
        return objNhanVien;
    }

    public void setObjNhanVien(NhanVienModel objNhanVien) {
        this.objNhanVien = objNhanVien;
    }
   
    
    public NhanVienController(){
        this.actionGetListDmNhanVien();
    }
    
    public void actionGetListDmNhanVien(){
        listDmNhanVien = nvProvider.getListNhanVien();
    }
    
    public void actionChangePhongBan(){
        if(selectedPhongBan == 0){
            this.actionGetListDmNhanVien();
        }else{
            listDmNhanVien = nvProvider.getListNhanVienTheoPhongBan(selectedPhongBan);
        } 
    }
    
    public List<Map> getListDmNhanVien() {
        return listDmNhanVien;
    }

    public void setListDmNhanVien(List<Map> listDmNhanVien) {
        this.listDmNhanVien = listDmNhanVien;
    }

    public int getSelectedPhongBan() {
        return selectedPhongBan;
    }

    public void setSelectedPhongBan(int selectedPhongBan) {
        this.selectedPhongBan = selectedPhongBan;
    }
    
    
}
