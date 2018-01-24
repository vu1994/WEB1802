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
    /**
     * Creates a new instance of ThongKeBaoCao
     */
    public ThongKeBaoCao() {
    }
    
    public List<ThietBiModel> actionGetListThongKeTonKho(){
        ThongKeBaoCaoDataprovider tkbcDp = new ThongKeBaoCaoDataprovider();
        return tkbcDp.getDsThongKeTonKho();
    }
}
