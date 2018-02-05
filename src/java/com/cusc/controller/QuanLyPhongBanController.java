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
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thyen
 */
@ManagedBean(name="QuanLyPhongBanController")
@ViewScoped
public class QuanLyPhongBanController implements Serializable{
    
    private PhongBanModel objPhongBan = new PhongBanModel();
    private List<Map> listPhongBan;
    private List<Map> listPhongBanAll;
    private PhongBanProvider pbProvider = new PhongBanProvider();
    private String pbID;
    public QuanLyPhongBanController() {
        objPhongBan = new PhongBanModel();
        pbID =  WindowUtils.getUrlParameter("pb");
        this.actionGetListPhongBanAll();
        if(pbID == null){
            this.actionGetListPhongBan();
        } else {
            this.actionGetListDmPhongBanFilterPB(Integer.parseInt(pbID));
        }
        
    }
      
    public List<Map> actionGetListPhongBan(){
        setListPhongBan(pbProvider.getListPhongBan());
        return listPhongBan;
    }
    public List<Map> actionGetListPhongBanAll(){
        setListPhongBanAll(pbProvider.getListPhongBan());
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
        
    }
     
    public void preActionEditPhongBan(Map mapDmPhongBan) throws ParseException{
        mapDmPhongBan.put("editPB", true);
        objPhongBan.setPhongbanID(Long.parseLong(mapDmPhongBan.get("pb_id").toString()));
        objPhongBan.setPhongbanTen(mapDmPhongBan.get("pb_ten").toString());
    }
     
   
    public void actionXoaDmPhongBan(int dmPhongBanID){
        pbProvider.delDmPhongBan(dmPhongBanID);
        this.actionGetListPhongBanAll();
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

   
}
