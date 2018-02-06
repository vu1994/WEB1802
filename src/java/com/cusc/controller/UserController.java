/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.controller;

import com.cusc.dataprovider.UserDataProvider;
import com.cusc.model.UserModel;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cuscsoft
 */
@ManagedBean (name="UserController")
@SessionScoped
public class UserController implements Serializable{
    private UserModel objUser = new UserModel();
    private String screenname;
    private String password;
    private String nvTen;
    
    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }
    
    public void login(){
        UserDataProvider userProvider = new UserDataProvider();
        objUser = userProvider.getUserModelByScreenname(screenname);
        if (objUser != null) {
            if (password.equals(objUser.getUserPassword())) {

            } else {

            }
        } else {
            FacesMessage msg = new FacesMessage("",
                            "Tên đăng nhập không tồn tại");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
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
}
