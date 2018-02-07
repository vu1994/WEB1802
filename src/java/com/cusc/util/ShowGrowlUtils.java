/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuscsoft
 */
@ManagedBean(name="ShowGrowlUtils")
@SessionScoped
public class ShowGrowlUtils {
    private boolean showGrowlSuccess = false;
    private String message;
    private String type;
    
    
    public ShowGrowlUtils() {
    }
    
    public void showGrowlOnPageLoad(){
        if(showGrowlSuccess){
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(message);
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            context.addMessage(null, msg);
            showGrowlSuccess = false;
        }
    }
    
    public boolean isShowGrowlSuccess() {
        return showGrowlSuccess;
    }

    public void setShowGrowlSuccess(boolean showGrowlSuccess) {
        this.showGrowlSuccess = showGrowlSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
