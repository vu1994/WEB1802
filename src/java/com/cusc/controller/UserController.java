/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.UserDataProvider;
import com.cusc.model.UserModel;
import com.cusc.util.ShowGrowlUtils;
import com.cusc.util.WindowUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cuscsoft
 */
@ManagedBean (name="UserController")
@SessionScoped
public class UserController implements Serializable{
    @ManagedProperty(value="#{ShowGrowlUtils}")
    private ShowGrowlUtils showGrowl;
    private UserModel objUser = new UserModel();
    private Map<String, Object> mapLogin = new HashMap<>();
    private String screenname;
    private String password;
    private String nvTen;
    
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
        
    }
    
    public void callWhenLoadPage(){
        screenname = null;
        password = null;
        nvTen = null;
        showGrowl.setMessage("Đăng nhập thành công");
        showGrowl.showGrowlOnPageLoad();
    }
    
    public void login() throws IOException{
        UserDataProvider userProvider = new UserDataProvider();
        objUser = userProvider.getUserModelByScreenname(screenname);
        FacesContext context = FacesContext.getCurrentInstance();
        if (objUser != null) {
            if (password.equals(objUser.getUserPassword())) {
                mapLogin.put("logined", true);
                mapLogin.put("screenname", objUser.getUserScreenname());
                mapLogin.put("nvTen", objUser.getNvTen());
                mapLogin.put("nvID", objUser.getNvID());
                mapLogin.put("userRole", objUser.getUserRole());
                showGrowl.setShowGrowlSuccess(true);
                WindowUtils.reload();
            } else {
                mapLogin.put("logined", false);
                FacesMessage message = new FacesMessage("Tài khoản hoặc mật khẩu không đúng");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, message);
            }
        } else {
            mapLogin.put("logined", false);
            FacesMessage message = new FacesMessage("Tài khoản không tồn tại");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, message);
        }
        screenname = null;
        password = null;
        nvTen = null;
    }
    
    public void logout() throws IOException{
        mapLogin.put("logined", false);
        mapLogin.put("screenname", null);
        mapLogin.put("nvTen", null);
        mapLogin.put("nvID", null);
        mapLogin.put("userRole", null);
        WindowUtils.reload();
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNvTen() {
        return nvTen;
    }

    public void setNvTen(String nvTen) {
        this.nvTen = nvTen;
    }

    public UserModel getObjUser() {
        return objUser;
    }

    public void setObjUser(UserModel objUser) {
        this.objUser = objUser;
    }
    
    public Map<String, Object> getMapLogin() {
        return mapLogin;
    }

    public void setMapLogin(Map<String, Object> mapLogin) {
        this.mapLogin = mapLogin;
    }

    public ShowGrowlUtils getShowGrowl() {
        return showGrowl;
    }

    public void setShowGrowl(ShowGrowlUtils showGrowl) {
        this.showGrowl = showGrowl;
    }
}
