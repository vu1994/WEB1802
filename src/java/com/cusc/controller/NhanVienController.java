/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.NhanVienProvider;
import com.cusc.model.DanhMucThietBiModel;
import com.cusc.model.NhanVienModel;
import com.cusc.util.WindowUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thyen
 */
@ManagedBean(name="DanhMucNhanVienController")
@ViewScoped
public class NhanVienController {
    private NhanVienProvider nvProvider = new NhanVienProvider();
    private List<Map> listDmNhanVien;
    private int selectedPhongBan;
    private NhanVienModel objNhanVien = new NhanVienModel();
    
    
    public NhanVienController(){
        this.actionGetListDmNhanVien();
    }
    
    public void actionGetListDmNhanVien(){
        listDmNhanVien = nvProvider.getListNhanVien();
    }
    
    public void preActionNhanVien(){
         System.out.println("thêm");
         objNhanVien = new NhanVienModel();
         
    }
    
     public void actionAddOrEditNhanVien() throws IOException{
        System.out.println("tstststs");
        nvProvider.addOrEditNhanVien(objNhanVien);
        this.actionGetListDmNhanVien();
    }
    
    public void actionChangePhongBan(){
        if(selectedPhongBan == 0){
            this.actionGetListDmNhanVien();
        }else{
            listDmNhanVien = nvProvider.getListNhanVienTheoPhongBan(selectedPhongBan);
        } 
    }
     public void actionXoaDmNhanVien(int dmNhanVienID){
        nvProvider.delDmNhanVien(dmNhanVienID);
        this.actionGetListDmNhanVien();
    }
    
    
     public void preActionEditNhanVien(Map mapDmNhanVien) throws ParseException{
        objNhanVien.setNhanvienID(Long.parseLong(mapDmNhanVien.get("nv_id").toString()));
        objNhanVien.setNhanvienTen(mapDmNhanVien.get("nv_ten").toString());
        objNhanVien.setNhanvienGioitinh(Boolean.parseBoolean(mapDmNhanVien.get("nv_gioitinh").toString()));
        objNhanVien.setNhanvienDiaChi(mapDmNhanVien.get("nv_diachi").toString());
        objNhanVien.setNhanvienEmail(mapDmNhanVien.get("nv_email").toString());
        objNhanVien.setNhanvienSdt(mapDmNhanVien.get("nv_sdt").toString());
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(mapDmNhanVien.get("nv_ngaysinh").toString());
        objNhanVien.setNhanvienNgaysinh(date);
        objNhanVien.setNhanvienGioitinh(Boolean.parseBoolean(mapDmNhanVien.get("nv_gioitinh").toString()));
        objNhanVien.setNhanvienPhongban(Integer.parseInt(mapDmNhanVien.get("pb_id").toString()));
         System.out.println(objNhanVien);
     }
    
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
