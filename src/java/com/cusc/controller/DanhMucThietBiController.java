/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.DanhMucThietBiDataProvider;
import com.cusc.model.DanhMucThietBiModel;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author npvu
 */
@ManagedBean(name="DanhMucThietBiController")
@RequestScoped
public class DanhMucThietBiController {
    private DanhMucThietBiDataProvider dmThietBiDp = new DanhMucThietBiDataProvider();
    private List<Map> listDmThietBi;
    private int viewMode = 0;
    private String strEditTen;
    
    public DanhMucThietBiController(){
        this.actionGetListDmThietBi();
    }
    
    public void actionGetListDmThietBi(){
        listDmThietBi = dmThietBiDp.getListDmThietBi();
    }
    
    public void preActionEditTenThietBi(Map mapDmThietBi){
        strEditTen = mapDmThietBi.get("danhmuc_thietbi_ten").toString();
        mapDmThietBi.put("editTen", true);
    }
    
    public void preActionThemThietBi(){
       viewMode = 1;
    }
    
    public void actionTroVe(){
        viewMode = 0;
    }
    
    public void actionThemThietBi(){
        System.out.println("ndsadsa dsad asdsa das ");
        DanhMucThietBiModel dmThietBi = new DanhMucThietBiModel();
        dmThietBi.setDmThietBiTen(strEditTen);
        if(dmThietBiDp.updateDmThietBi(dmThietBi)){
            
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        listDmThietBi = dmThietBiDp.getListDmThietBi();
        viewMode = 0;
    }
    
    public void actionEditTenThietBi(Map mapDmThietBi){
        
    }
    
    // Getter & Setter

    public List<Map> getListDmThietBi() {
        return listDmThietBi;
    }

    public void setListDmThietBi(List<Map> listDmThietBi) {
        this.listDmThietBi = listDmThietBi;
    }

    public int getViewMode() {
        return viewMode;
    }

    public void setViewMode(int viewMode) {
        this.viewMode = viewMode;
    }

    public String getStrEditTen() {
        return strEditTen;
    }

    public void setStrEditTen(String strEditTen) {
        this.strEditTen = strEditTen;
    }

    public DanhMucThietBiDataProvider getDmThietBiDp() {
        return dmThietBiDp;
    }

    public void setDmThietBiDp(DanhMucThietBiDataProvider dmThietBiDp) {
        this.dmThietBiDp = dmThietBiDp;
    }
}
