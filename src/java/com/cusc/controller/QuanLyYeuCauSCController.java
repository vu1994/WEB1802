/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.PhongBanProvider;
import com.cusc.dataprovider.YeuCauSuaChuaProvider;
import com.cusc.model.PhongBanModel;
import com.cusc.model.YeuCauSuaChuaModel;
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
@ManagedBean(name = "QuanLyYeuCauSCController")
@ViewScoped
public class QuanLyYeuCauSCController implements Serializable {

    @ManagedProperty(value = "#{UserController}")
    private UserController uiUser;
    private YeuCauSuaChuaModel objYeuCauSC = new YeuCauSuaChuaModel();
    private List<Map> listYeuCauSC;
    private YeuCauSuaChuaProvider ycProvider = new YeuCauSuaChuaProvider();
    private String pbID;
  
   

    public QuanLyYeuCauSCController() {
        objYeuCauSC = new YeuCauSuaChuaModel();
        pbID = WindowUtils.getUrlParameter("pb");
        if (pbID == null) {
            this.actionGetListYeuCau();
        } else {
            this.actionGetListDmYeuCauFilterPB(Integer.parseInt(pbID));
        }
     }

    public List<Map> actionGetListYeuCau() {
        setListYeuCauSC(ycProvider.getListYeuCau());
        return listYeuCauSC;
    }
    public void changeTrangThaiYeuCau(Map mapDmYeuCau){
        System.out.println(">>>>"+mapDmYeuCau.toString());
        objYeuCauSC.setYeucauID(Long.parseLong(mapDmYeuCau.get("yeucau_id").toString()));
        objYeuCauSC.setYeucauNgayYeuCau((Date)mapDmYeuCau.get("yeucau_ngayyeucau"));
        objYeuCauSC.setYeucauNvID(Integer.parseInt(mapDmYeuCau.get("yeucau_nv_id").toString()));
        objYeuCauSC.setYeucauTbID(Integer.parseInt(mapDmYeuCau.get("yeucau_tb_id").toString()));
        objYeuCauSC.setYeucauTinhTrangHong(mapDmYeuCau.get("yeucau_tinhtranghong").toString());
        if(Integer.parseInt(mapDmYeuCau.get("yeucau_tinhtrangsc").toString())==0){
            objYeuCauSC.setYeucauTinhTrangSC(1);
        }else{
            objYeuCauSC.setYeucauTinhTrangSC(0);
        }
        this.actionAddorEditYeuCau();
        this.actionGetListYeuCau();
    }

    public void actionGetListDmYeuCauFilterPB(int pb_id) {
        listYeuCauSC = ycProvider.getListYeuCauTheoId(pb_id);
    }
    
    public void actionAddorEditYeuCau(){
       if(ycProvider.addEditYeuCau(objYeuCauSC)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
        this.actionGetListYeuCau();
        objYeuCauSC = new YeuCauSuaChuaModel();
       
    }

    public String getPbID() {
        return pbID;
    }

    public void setPbID(String pbID) {
        this.pbID = pbID;
    }

    public YeuCauSuaChuaModel getObjYeuCauSC() {
        return objYeuCauSC;
    }

    public void setObjYeuCauSC(YeuCauSuaChuaModel objYeuCauSC) {
        this.objYeuCauSC = objYeuCauSC;
    }

    public List<Map> getListYeuCauSC() {
        return listYeuCauSC;
    }

    public void setListYeuCauSC(List<Map> listYeuCauSC) {
        this.listYeuCauSC = listYeuCauSC;
    }

    public UserController getUiUser() {
        return uiUser;
    }

    public void setUiUser(UserController uiUser) {
        this.uiUser = uiUser;
    }

}
