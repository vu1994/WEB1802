/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.PhongBanProvider;
import com.cusc.model.PhongBanModel;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author thyen
 */
@ManagedBean(name="QuanLyPhongBanController")
@RequestScoped
public class QuanLyPhongBanController {
    
    private PhongBanModel objPhongBan = new PhongBanModel();
    private List<Map> listPhongBan;
    private PhongBanProvider pbProvider = new PhongBanProvider();

    public QuanLyPhongBanController() {
        this.actionGetListPhongBan();
    }
    
    public List<Map> actionGetListPhongBan(){
        setListPhongBan(pbProvider.getListPhongBan());
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

    public List<Map> getListPhongBan() {
        return listPhongBan;
    }

    public void setListPhongBan(List<Map> listPhongBan) {
        this.listPhongBan = listPhongBan;
    }

   
}
