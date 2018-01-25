/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.ThongKeBaoCaoDataprovider;
import com.cusc.dataprovider.TinhTrangDataprovider;
import com.cusc.model.DanhMucTinhTrangModel;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author npvu
 */
@ManagedBean(name="ThongKeBaoCaoController")
@RequestScoped
public class ThongKeBaoCaoController {
    
    private int selectedTinhTrang;
    private String filterName;
    private List<Map> listThietBiModel;
    ThongKeBaoCaoDataprovider tkbcDp = new ThongKeBaoCaoDataprovider();
    
    public ThongKeBaoCaoController() {
        if(listThietBiModel != null){
            listThietBiModel.clear();
        }
        this.actionGetListThongKeTonKho();
    }
    
    public List<Map> actionGetListThongKeTonKho(){
        listThietBiModel = tkbcDp.getDsThongKeTonKho();
        return listThietBiModel;
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
}
