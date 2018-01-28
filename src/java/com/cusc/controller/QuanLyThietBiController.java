/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author SunnyNguyen
 */
@ManagedBean (name="QuanLyThietBiController")
@ViewScoped
public class QuanLyThietBiController {
    
    private int viewMode = 0;
    /**
     * Creates a new instance of QuanLyThietBiController
     */
    public QuanLyThietBiController() {
    }

    public int getViewMode() {
        return viewMode;
    }

    public void setViewMode(int viewMode) {
        this.viewMode = viewMode;
    }
    
}
