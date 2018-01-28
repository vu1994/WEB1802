/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.QuanLyThietBiDataProvider;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    QuanLyThietBiDataProvider thietBiDp = new QuanLyThietBiDataProvider();
    private List<Map> listThietBi = new ArrayList<>();
    private int selectedNhomThietBi;
    private int selectedTinhTrang;
    private Date selectedNgayNhap;
    private int selectedNhanVien;
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
        listThietBi = thietBiDp.getListThietBi();
    }
    
    public void preActionThemThietBi(){
        Calendar currentDate = Calendar.getInstance();
        selectedNgayNhap = currentDate.getTime();
        viewMode = 1;
    }
    
    public void actionThemThietBi(){
        
    }
    
    public void showFormCapPhat(){
        System.out.println("npvu: "+selectedCapPhat);
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

    public int getSelectedNhomThietBi() {
        return selectedNhomThietBi;
    }

    public void setSelectedNhomThietBi(int selectedNhomThietBi) {
        this.selectedNhomThietBi = selectedNhomThietBi;
    }

    public int getSelectedTinhTrang() {
        return selectedTinhTrang;
    }

    public void setSelectedTinhTrang(int selectedTinhTrang) {
        this.selectedTinhTrang = selectedTinhTrang;
    }

    public int getSelectedNhanVien() {
        return selectedNhanVien;
    }

    public void setSelectedNhanVien(int selectedNhanVien) {
        this.selectedNhanVien = selectedNhanVien;
    }

    public Date getSelectedNgayNhap() {
        return selectedNgayNhap;
    }

    public void setSelectedNgayNhap(Date selectedNgayNhap) {
        this.selectedNgayNhap = selectedNgayNhap;
    }

    public boolean isSelectedCapPhat() {
        return selectedCapPhat;
    }

    public void setSelectedCapPhat(boolean selectedCapPhat) {
        this.selectedCapPhat = selectedCapPhat;
    }
    
}
