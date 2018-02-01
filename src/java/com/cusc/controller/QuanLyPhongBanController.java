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
    private List<Map> listPhongBanMenu;
    private PhongBanProvider pbProvider = new PhongBanProvider();
    private String pbID;
    public QuanLyPhongBanController() {
        pbID =  WindowUtils.getUrlParameter("pb");
        this.actionGetListPhongBanMenu();
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
    public List<Map> actionGetListPhongBanMenu(){
        setListPhongBanMenu(pbProvider.getListPhongBan());
        return listPhongBan;
    }
    
     public void actionThemPhongBan(){
        if(pbProvider.addPhongBan(objPhongBan)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        this.actionGetListPhongBan();
        
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

    public List<Map> getListPhongBanMenu() {
        return listPhongBanMenu;
    }

    public void setListPhongBanMenu(List<Map> listPhongBanMenu) {
        this.listPhongBanMenu = listPhongBanMenu;
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

   
}
