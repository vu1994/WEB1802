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
    private long longEditID;
    
    public DanhMucThietBiController(){
        this.actionGetListDmThietBi();
    }
    
    public void actionGetListDmThietBi(){
        listDmThietBi = dmThietBiDp.getListDmThietBi();
    }
    
    public void preActionEditTenThietBi(Map mapDmThietBi){
        longEditID = Long.parseLong(mapDmThietBi.get("danhmuc_thietbi_id").toString());
        strEditTen = mapDmThietBi.get("danhmuc_thietbi_ten").toString();
        viewMode = 2;
    }
    
    public void preActionThemThietBi(){
        viewMode = 1;
    }
    
    public void actionThemThietBi(){
        DanhMucThietBiModel dmThietBi = new DanhMucThietBiModel();
        dmThietBi.setDmThietBiTen(strEditTen);
        if(dmThietBiDp.addDmThietBi(dmThietBi)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        listDmThietBi = dmThietBiDp.getListDmThietBi();
        viewMode = 0;
    }
    
    public void actionEditTenThietBi(long ID){
        DanhMucThietBiModel dmThietBiModel = new DanhMucThietBiModel();
        System.out.println("true " +ID + " - "+longEditID);
        dmThietBiModel.setDmThietBiID(ID);
        dmThietBiModel.setDmThietBiTen(strEditTen);
        if(dmThietBiDp.updateDmThietBi(dmThietBiModel)){
            System.out.println("true" +dmThietBiModel.getDmThietBiID());
        } else {
            System.out.println("false");
        }
        listDmThietBi = dmThietBiDp.getListDmThietBi();
        viewMode = 0;
    }
    
    public void actionXoaDmThietBi(int dmThietBiID){
        if(dmThietBiDp.delDmThietBi(dmThietBiID)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        listDmThietBi = dmThietBiDp.getListDmThietBi();
        viewMode = 0;
    }
    
    public void actionTroVe(){
        viewMode = 0;
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

    public long getLongEditID() {
        return longEditID;
    }

    public void setLongEditID(long longEditID) {
        this.longEditID = longEditID;
    }

}
