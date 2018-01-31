/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.QuanLyThietBiDataProvider;
import com.cusc.model.ThietBiModel;
import com.cusc.util.WindowUtils;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
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
public class QuanLyThietBiController implements Serializable {
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
        viewMode = 0;
    }
    
    public void actionGetListThietBi(){
        listThietBi = tbProvider.getListThietBi();
    }
    
    public void preActionThemThietBi(){
        Calendar currentDate = Calendar.getInstance();
        objThietBi = new ThietBiModel();
        objThietBi.setThietBiNgayNhap(currentDate.getTime());
    }
    
    public void preActionEditThietBi(Map mapThietBi){
        objThietBi = new ThietBiModel();
        objThietBi.setThietBiID(Long.parseLong(mapThietBi.get("thietbi_id").toString()));
        objThietBi.setThietBiTen(mapThietBi.get("thietbi_ten").toString());
        objThietBi.setDmThietBiID(Integer.parseInt(mapThietBi.get("danhmuc_thietbi_id").toString()));
        objThietBi.setTinhTrangID(Integer.parseInt(mapThietBi.get("tinhtrang_id").toString()));
        try{
            objThietBi.setCapChoNhanVienID(Integer.parseInt(mapThietBi.get("thietbi_capcho").toString()));
        }catch(NullPointerException e){
            objThietBi.setCapChoNhanVienID(0);
        }
        
        try{
            objThietBi.setThietBiNguoiCap(Integer.parseInt(mapThietBi.get("thietbi_nguoicap").toString()));
        }catch(NullPointerException e){
            objThietBi.setThietBiNguoiCap(0);
        }
        
        try{
            objThietBi.setThietBiNgayNhap(Date.valueOf(mapThietBi.get("thietbi_ngaynhap").toString()));
        }catch(NullPointerException e){
            objThietBi.setThietBiNgayNhap(null);
        }
        
        try{
            objThietBi.setThietBiNgayCap(Date.valueOf(mapThietBi.get("thietbi_ngaycap").toString()));
        }catch(NullPointerException e){
            objThietBi.setThietBiNgayCap(null);
        }
        try{
            objThietBi.setThietBiTrangThaiCapPhat(mapThietBi.get("thietbi_trangthai_capphat").toString());
        }catch(NullPointerException e){
            objThietBi.setThietBiTrangThaiCapPhat(null);
        }
        
        try{
            objThietBi.setThietBiNgayThuHoi(Date.valueOf(mapThietBi.get("thietbi_ngaythuhoi").toString()));
        }catch(NullPointerException e){
            objThietBi.setThietBiNgayThuHoi(null);
        }
    }
    
    public void preActionCapPhat(Map mapThietBi){
        objThietBi = new ThietBiModel();
        objThietBi.setThietBiID(Long.parseLong(mapThietBi.get("thietbi_id").toString()));
        objThietBi.setThietBiTen(mapThietBi.get("thietbi_ten").toString());
        objThietBi.setDmThietBiID(Integer.parseInt(mapThietBi.get("danhmuc_thietbi_id").toString()));
        objThietBi.setTinhTrangID(Integer.parseInt(mapThietBi.get("tinhtrang_id").toString()));
        try{
            objThietBi.setThietBiNgayNhap(Date.valueOf(mapThietBi.get("thietbi_ngaynhap").toString()));
        }catch(NullPointerException e){
            objThietBi.setThietBiNgayNhap(null);
        }
        try{
            objThietBi.setThietBiNgayCap(Date.valueOf(mapThietBi.get("thietbi_ngaycap").toString()));
        }catch(NullPointerException e){
            objThietBi.setThietBiNgayCap(null);
        }
        try{
            objThietBi.setThietBiNguoiCap(Integer.parseInt(mapThietBi.get("thietbi_nguoicap").toString()));
        }catch(NullPointerException e){
            objThietBi.setThietBiNguoiCap(0);
        }
        try{
            objThietBi.setCapChoNhanVienID(Integer.parseInt(mapThietBi.get("thietbi_capcho").toString()));
        }catch(NullPointerException e){
            objThietBi.setCapChoNhanVienID(0);
        }
        try{
            objThietBi.setThietBiTrangThaiCapPhat(mapThietBi.get("thietbi_trangthai_capphat").toString());
        }catch(NullPointerException e){
            objThietBi.setThietBiTrangThaiCapPhat(null);
        }
        objThietBi.setThietBiNgayThuHoi(null);
    }
    
    public void actionThemThietBi() throws IOException{
        System.out.println("npvu test: "+objThietBi.getThietBiID());
        if(tbProvider.addThietBi(objThietBi)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        WindowUtils.reload();
    }
    
    public void actionXoaThietBi(Map mapThietBi){
        ThietBiModel objDelThietBi = new ThietBiModel();
        try{
            objDelThietBi.setThietBiID(Long.parseLong(mapThietBi.get("thietbi_id").toString()));
            objDelThietBi.setThietBiTen(mapThietBi.get("thietbi_ten").toString());
            if(this.enableXoaThietBi(objDelThietBi.getDmThietBiID())){
                boolean delThietBi = tbProvider.delThietBi(objDelThietBi);
            }else {
                System.out.println("false");
            }         
        } catch(Exception e){
            e.printStackTrace();
        }
        this.actionGetListThietBi();
    }
    
    public boolean enableEditThietBi(int thietBiID){
        return true;
    }
    
    public boolean enableXoaThietBi(int thietBiID){
        return true;
    }
    
    public void showModalCapPhat(){
        System.out.println("npvu te");
        objThietBi.setThietBiTen("abc");
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
