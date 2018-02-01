/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.DanhMucThietBiDataProvider;
import com.cusc.dataprovider.QuanLyThietBiDataProvider;
import com.cusc.dataprovider.ThongKeBaoCaoDataprovider;
import com.cusc.dataprovider.TinhTrangDataprovider;
import com.cusc.model.DanhMucTinhTrangModel;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author npvu
 */
@ManagedBean(name="ThongKeBaoCaoController")
@ViewScoped
public class ThongKeBaoCaoController implements Serializable {
    
    private int selectedTinhTrang;
    private String filterName;
    private List<Map> listNhomThietBi;
    private List<Map> listThietBiModel;
    ThongKeBaoCaoDataprovider tkbcDp = new ThongKeBaoCaoDataprovider();
    
    public ThongKeBaoCaoController() {
        try{
            this.actionGetListThongKeTonKho();
        }catch(Exception e){
            
        }
        
    }
    
    public void actionGetListThongKeTonKho(){
        // Lấy danh sách nhóm thiết bị
        DanhMucThietBiDataProvider dmTBProvider = new DanhMucThietBiDataProvider();
        QuanLyThietBiDataProvider tbProvider = new QuanLyThietBiDataProvider();
        listNhomThietBi = dmTBProvider.getListDmThietBi();
        // Lấy danh sách thiết bị theo từng nhóm
        for(Map mapNhomThietBi : listNhomThietBi){
            List<Map> listThietBi = tbProvider.getListThietBiByNhom(Long.parseLong(mapNhomThietBi.get("danhmuc_thietbi_id").toString()));
            // Khai báo số liệu thống kê
            int tongso = 0;
            
            // -- tinh trang
            int ttMoi = 0;
            int ttDaSuDung = 0;
            int ttDangSuDung = 0;
            int ttBiHong = 0;
            
            // -- trang thai cap phat
            int ttCapMoi = 0;
            int ttCapBoSung = 0;
            int ttThuHoi = 0;
            int ttChuaCapPhat = 0;

            // Ghi số liệu thống kê
            tongso = listThietBi.size();
            
            for(Map mapThietBi : listThietBi){
                // Đếm tình trạng
                int tinhTrang = Integer.parseInt(mapThietBi.get("tinhtrang_id").toString());
                switch(tinhTrang){
                    case 1: ttMoi++; break;
                    case 2: ttDangSuDung++; break;
                    case 3: ttDaSuDung++; break;
                    case 4: ttBiHong++; break;
                }
                
                // Đếm trạng thái cấp phát
                String trangThaiCP = mapThietBi.get("thietbi_trangthai_capphat").toString();
                switch(trangThaiCP){
                    case "Cấp mới": ttCapMoi++; break;
                    case "Cấp bổ sung": ttCapBoSung++; break;
                    case "Đã thu hồi": ttThuHoi++; break;
                    default:ttChuaCapPhat++;
                }
                
            }
            mapNhomThietBi.put("tongso", tongso);
            mapNhomThietBi.put("ttMoi", ttMoi);
            mapNhomThietBi.put("ttDangSuDung", ttDangSuDung);
            mapNhomThietBi.put("ttDaSuDung", ttDaSuDung);
            mapNhomThietBi.put("ttBiHong", ttBiHong);
            
            mapNhomThietBi.put("ttCapMoi", ttCapMoi);
            mapNhomThietBi.put("ttCapBoSung", ttCapBoSung);
            mapNhomThietBi.put("ttThuHoi", ttThuHoi);
            mapNhomThietBi.put("ttChuaCapPhat", ttChuaCapPhat);
            mapNhomThietBi.put("ttDaCapPhat", tongso - ttChuaCapPhat);
        }
    }
    
    public List<Map> actionFilterListThongKeTonKho(){
        listThietBiModel = tkbcDp.getDsThongKeTonKho(filterName, selectedTinhTrang);
        return listThietBiModel;
    } 
    
    public List<DanhMucTinhTrangModel> actionGetListDMTinhTrang(){
        TinhTrangDataprovider dmttDp = new TinhTrangDataprovider();
        return dmttDp.getDmTinhTrang();
    }
    
    public int getSelectedTinhTrang() {
        return selectedTinhTrang;
    }

    public void setSelectedTinhTrang(int selectedTinhTrang) {
        this.selectedTinhTrang = selectedTinhTrang;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public List<Map> getListThietBiModel() {
        return listThietBiModel;
    }

    public void setListThietBiModel(List<Map> listThietBiModel) {
        this.listThietBiModel = listThietBiModel;
    }

    public List<Map> getListNhomThietBi() {
        return listNhomThietBi;
    }

    public void setListNhomThietBi(List<Map> listNhomThietBi) {
        this.listNhomThietBi = listNhomThietBi;
    }
}
