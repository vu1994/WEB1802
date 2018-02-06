/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.PhongBanProvider;
import com.cusc.model.PhongBanModel;
import com.cusc.util.WindowUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thyen
 */
@ManagedBean(name="QuanLyPhongBanController")
@ViewScoped
public class QuanLyPhongBanController implements Serializable{
    
    @ManagedProperty(value = "#{DanhMucNhanVienController}")
    private NhanVienController uiNhanVien;
    private PhongBanModel objPhongBan = new PhongBanModel();
    private List<Map> listPhongBan;
    private List<Map> listPhongBanAll;
    private PhongBanProvider pbProvider = new PhongBanProvider();
    private String pbID;
    private Integer slPhongBan;
    private Boolean actionEdit = true;
    
    public QuanLyPhongBanController() {
        objPhongBan = new PhongBanModel();
        pbID =  WindowUtils.getUrlParameter("pb");
        this.actionGetListPhongBanAll();
        if(pbID == null){
            this.actionGetListPhongBan();
        } else {
            this.actionGetListDmPhongBanFilterPB(Integer.parseInt(pbID));
        }
        setSlPhongBan(pbProvider.getSoLuongPhongBan());
    }
      
    public List<Map> actionGetListPhongBan(){
        setListPhongBan(pbProvider.getListPhongBan());
        return listPhongBan;
    }
    public List<Map> actionGetListPhongBanAll(){
        setListPhongBanAll(pbProvider.getListPhongBan());
        setActionEdit(true);
        return listPhongBan;
    }
    
    public void actionAddorEditPhongBan(){
       if(pbProvider.addEditPhongBan(objPhongBan)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        this.actionGetListPhongBanAll();
        objPhongBan = new PhongBanModel();
        setSlPhongBan(pbProvider.getSoLuongPhongBan());
        
    }
     
    public void preActionEditPhongBan(Map mapDmPhongBan) throws ParseException{
       mapDmPhongBan.put("editPB", true);
        setActionEdit(false);
    }
    
    
    public void actionEditPhongBan(Map mapDmPhongBan) throws ParseException{
        objPhongBan.setPhongbanID(Long.parseLong(mapDmPhongBan.get("pb_id").toString()));
        objPhongBan.setPhongbanTen(mapDmPhongBan.get("pb_ten").toString());
        this.actionAddorEditPhongBan();
        uiNhanVien.actionGetListDmNhanVien();
        setActionEdit(true);
    }
     
   
    public void actionXoaDmPhongBan(int dmPhongBanID){
        pbProvider.delDmPhongBan(dmPhongBanID);
        this.actionGetListPhongBanAll();
        setSlPhongBan(pbProvider.getSoLuongPhongBan());
    }
    public void actionGetListDmPhongBanFilterPB(int pb_id){
        listPhongBan = pbProvider.getListPhongBanTheoId(pb_id);
    }
    
    
    public List<Map> getListPhongBan() {
        return listPhongBan;
    }

    public void setListPhongBan(List<Map> listPhongBan) {
        this.listPhongBan = listPhongBan;
    }
    
    public PhongBanModel getObjPhongBan() {
        return objPhongBan;
    }

    public void setObjPhongBan(PhongBanModel objPhongBan) {
        this.objPhongBan = objPhongBan;
    }

    public String getPbID() {
        return pbID;
    }

    public void setPbID(String pbID) {
        this.pbID = pbID;
    }

    public List<Map> getListPhongBanAll() {
        return listPhongBanAll;
    }

    public void setListPhongBanAll(List<Map> listPhongBanAll) {
        this.listPhongBanAll = listPhongBanAll;
    }

    public Boolean getActionEdit() {
        return actionEdit;
    }

    public void setActionEdit(Boolean actionEdit) {
        this.actionEdit = actionEdit;
    }

    public NhanVienController getUiNhanVien() {
        return uiNhanVien;
    }

    public void setUiNhanVien(NhanVienController uiNhanVien) {
        this.uiNhanVien = uiNhanVien;
    }

    public Integer getSlPhongBan() {
        return slPhongBan;
    }

    public void setSlPhongBan(Integer slPhongBan) {
        this.slPhongBan = slPhongBan;
    }

   
}
