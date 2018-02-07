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

//    public List<Map> actionGetListPhongBanAll() {
//        setListPhongBanAll(pbProvider.getListPhongBan());
//        setActionEdit(true);
//        return listPhongBan;
//    }

//    public void actionAddorEditPhongBan() {
//        if (pbProvider.addEditPhongBan(objPhongBan)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
//        this.actionGetListPhongBanAll();
//        objPhongBan = new PhongBanModel();
//        setSlPhongBan(pbProvider.getSoLuongPhongBan());
//
//    }
//
//    public void preActionEditPhongBan(Map mapDmPhongBan) throws ParseException {
//        mapDmPhongBan.put("editPB", true);
//        setActionEdit(false);
//    }

//    public void actionEditPhongBan(Map mapDmPhongBan) throws ParseException {
//        objPhongBan.setPhongbanID(Long.parseLong(mapDmPhongBan.get("pb_id").toString()));
//        objPhongBan.setPhongbanTen(mapDmPhongBan.get("pb_ten").toString());
//        this.actionAddorEditPhongBan();
//        uiNhanVien.actionGetListDmNhanVien();
//        setActionEdit(true);
//    }
//
//    public void actionXoaDmPhongBan(int dmPhongBanID) {
//        pbProvider.delDmPhongBan(dmPhongBanID);
//        this.actionGetListPhongBanAll();
//        setSlPhongBan(pbProvider.getSoLuongPhongBan());
//    }

    public void actionGetListDmYeuCauFilterPB(int pb_id) {
        listYeuCauSC = ycProvider.getListYeuCauTheoId(pb_id);
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

}
