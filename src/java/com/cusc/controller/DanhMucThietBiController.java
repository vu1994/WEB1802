/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.DanhMucThietBiDataProvider;
import com.cusc.model.DanhMucThietBiModel;
import com.cusc.util.WindowUitls;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author npvu
 */
@ManagedBean(name="DanhMucThietBiController")
@ViewScoped
public class DanhMucThietBiController {
    private DanhMucThietBiDataProvider dmThietBiDp = new DanhMucThietBiDataProvider();
    private List<Map> listDmThietBi;
    private DanhMucThietBiModel objDmThietBi = new DanhMucThietBiModel();
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
        objDmThietBi.setDmThietBiID(Long.parseLong(mapDmThietBi.get("danhmuc_thietbi_id").toString()));
        objDmThietBi.setDmThietBiTen(mapDmThietBi.get("danhmuc_thietbi_ten").toString());
        viewMode = 2;
    }
    
    public void preActionThemThietBi(){
        strEditTen = "";
        viewMode = 1;
    }
    
    public void actionThemThietBi() throws IOException{
        DanhMucThietBiModel dmThietBi = new DanhMucThietBiModel();
        dmThietBi.setDmThietBiTen(strEditTen);
        if(dmThietBiDp.addDmThietBi(dmThietBi)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        WindowUitls.reload();
    }
    
    public void actionEditTenThietBi(){
        if(dmThietBiDp.updateDmThietBi(objDmThietBi)){
            System.out.println("true" +objDmThietBi.getDmThietBiID());
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

    public DanhMucThietBiModel getObjDmThietBi() {
        return objDmThietBi;
    }

    public void setObjDmThietBi(DanhMucThietBiModel objDmThietBi) {
        this.objDmThietBi = objDmThietBi;
    }

}
