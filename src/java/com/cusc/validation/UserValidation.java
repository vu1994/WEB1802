/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.validation;

import com.cusc.controller.UserController;
import com.cusc.dataprovider.UserDataProvider;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cuscsoft
 */
@FacesValidator("com.cusc.validation.UserValidation")
public class UserValidation implements Validator{
    @ManagedProperty(value="#{UserController}")
    private UserController uiUser;

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        UserDataProvider userProvider = new UserDataProvider();
        if (uiUser.getObjUser() == null) {
           FacesMessage msg = new FacesMessage("",
                            "Tên đăng nhập không tồn tại");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    public UserController getUiUser() {
        return uiUser;
    }

    public void setUiUser(UserController uiUser) {
        this.uiUser = uiUser;
    }
    
}
