/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.model.NhanVienModel;
import com.cusc.model.UserModel;
import com.cusc.util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author cuscsoft
 */
public class UserDataProvider implements Serializable{
    
    public UserModel getUserModelByScreenname(String screenname){
        Session session = HibernateUtil.currentSession();
        UserModel objUser = new UserModel();
        try {
            session.beginTransaction();
            objUser = (UserModel) session.createSQLQuery("SELECT *"
                    + " FROM user u"
                    + " LEFT JOIN nhanvien nv ON nv.nv_id = u.nv_id"
                    + " WHERE u.user_screenname = :screenname")
                    .addEntity(UserModel.class)
                    .setString("screenname", screenname.toLowerCase())
                    .uniqueResult();
            session.getTransaction().commit();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return objUser;
    }
}
