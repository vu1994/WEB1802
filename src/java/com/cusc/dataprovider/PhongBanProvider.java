/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.model.PhongBanModel;
import com.cusc.util.HibernateUtil;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author thyen
 */
public class PhongBanProvider implements Serializable {  
    
    public List<Map> getListPhongBan(){
        Session session = HibernateUtil.currentSession();
        List<Map> listPhongBan = new ArrayList();
        try {
            session.beginTransaction();
            listPhongBan = session.createSQLQuery("SELECT * FROM phongban").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
            for(Map dmPhongBan : listPhongBan){
                dmPhongBan.put("editTen", false);
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listPhongBan;
    }
    
     public boolean addPhongBan(PhongBanModel objPhongBan){
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(objPhongBan);
            session.getTransaction().commit();
	} catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
	} finally {
            session.close();
	}
        return true;
    }
}
    
    

