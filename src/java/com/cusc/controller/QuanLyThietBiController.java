/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.QuanLyThietBiDataProvider;
import com.cusc.model.ThietBiModel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SunnyNguyen
 */
@ManagedBean (name="QuanLyThietBiController")
@ViewScoped
public class QuanLyThietBiController {
    QuanLyThietBiDataProvider tbProvider = new QuanLyThietBiDataProvider();
    private List<Map> listThietBi = new ArrayList<>();
    private ThietBiModel objThietBi = new ThietBiModel();
    private boolean selectedCapPhat = false;
    private int viewMode = 0;
    /**
     * Creates a new instance of QuanLyThietBiController
     */
    public QuanLyThietBiController() {
        listThietBi.clear();
        this.actionGetListThietBi();
    }
    
    public void actionGetListThietBi(){
        listThietBi = tbProvider.getListThietBi();
    }
    
    public void preActionThemThietBi(){
        Calendar currentDate = Calendar.getInstance();
        objThietBi.setThietBiNgayNhap(currentDate.getTime());
        viewMode = 1;
    }
    
    public void actionThemThietBi(){
        if(tbProvider.addThietBi(objThietBi)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        this.actionGetListThietBi();
        viewMode = 0;
    }
    
    public void showFormCapPhat(){
        selectedCapPhat = !selectedCapPhat;
    }
    
    public void actionTroVe(){
        viewMode = 0;
    }
            
            
    // Getter & Setter
    
    public int getViewMode() {
        return viewMode;
    }

    public void setViewMode(int viewMode) {
        this.viewMode = viewMode;
    }

    public List<Map> getListThietBi() {
        return listThietBi;
    }

    public void setListThietBi(List<Map> listThietBi) {
        this.listThietBi = listThietBi;
    }

    public boolean isSelectedCapPhat() {
        return selectedCapPhat;
    }

    public void setSelectedCapPhat(boolean selectedCapPhat) {
        this.selectedCapPhat = selectedCapPhat;
    }

    public ThietBiModel getObjThietBi() {
        return objThietBi;
    }

    public void setObjThietBi(ThietBiModel objThietBi) {
        this.objThietBi = objThietBi;
    }
    
}
