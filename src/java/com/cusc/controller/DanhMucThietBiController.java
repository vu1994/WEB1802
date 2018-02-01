/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.DanhMucThietBiDataProvider;
import com.cusc.model.DanhMucThietBiModel;
import com.cusc.util.WindowUtils;
import java.io.IOException;
import java.io.Serializable;
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
public class DanhMucThietBiController implements Serializable {
    private DanhMucThietBiDataProvider dmThietBiDp = new DanhMucThietBiDataProvider();
    private List<Map> listDmThietBi;
    private DanhMucThietBiModel objDmThietBi = new DanhMucThietBiModel();
    private int viewMode = 0;
    private boolean editMode;
    private long longEditID;
    
    public DanhMucThietBiController(){
        this.actionGetListDmThietBi();
    }
    
    public void actionGetListDmThietBi(){
        listDmThietBi = dmThietBiDp.getListDmThietBi();
    }
    
    public void preActionEditTenThietBi(Map mapDmThietBi){
        objDmThietBi = new DanhMucThietBiModel();
        objDmThietBi.setDmThietBiID(Long.parseLong(mapDmThietBi.get("danhmuc_thietbi_id").toString()));
        objDmThietBi.setDmThietBiTen(mapDmThietBi.get("danhmuc_thietbi_ten").toString());
        editMode = true;
    }
    
    public void preActionThemThietBi(){
        objDmThietBi = new DanhMucThietBiModel();
        editMode = false;
    }
    
    public void actionThemThietBi() throws IOException{
        if(dmThietBiDp.updateDmThietBi(objDmThietBi)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        WindowUtils.reload();
    }
    
    public void actionEditTenThietBi() throws IOException{
        if(dmThietBiDp.updateDmThietBi(objDmThietBi)){
            System.out.println("true" +objDmThietBi.getDmThietBiID());
        } else {
            System.out.println("false");
        }
        WindowUtils.reload();
    }
    
    public void actionXoaDmThietBi(int dmThietBiID){
        if(dmThietBiDp.delDmThietBi(dmThietBiID)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        listDmThietBi = dmThietBiDp.getListDmThietBi();
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

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

}
