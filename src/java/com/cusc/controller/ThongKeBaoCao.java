/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.ThongKeBaoCaoDataprovider;
import com.cusc.model.ThietBiModel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author npvu
 */
@ManagedBean(name="ThongKeBaoCao")
@RequestScoped
public class ThongKeBaoCao {
    
    private int selectedTinhTrang;
    private String filterName;
    private List<ThietBiModel> listThietBiModel;
    ThongKeBaoCaoDataprovider tkbcDp = new ThongKeBaoCaoDataprovider();
    
    public ThongKeBaoCao() {
        actionGetListThongKeTonKho();
    }
    
    public List<ThietBiModel> actionGetListThongKeTonKho(){
        listThietBiModel = tkbcDp.getDsThongKeTonKho();
        return listThietBiModel;
    }
    
    public List<ThietBiModel> actionFilterListThongKeTonKho(){
        listThietBiModel = tkbcDp.getDsThongKeTonKho(filterName, selectedTinhTrang);
        return listThietBiModel;
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

    public List<ThietBiModel> getListThietBiModel() {
        return listThietBiModel;
    }

    public void setListThietBiModel(List<ThietBiModel> listThietBiModel) {
        this.listThietBiModel = listThietBiModel;
    }
}
