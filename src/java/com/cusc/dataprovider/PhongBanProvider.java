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
            int stt = 1;
            for(Map mapPhongBan : listPhongBan){
                mapPhongBan.put("rowIndex", stt);
                mapPhongBan.put("editPB", false);
                stt++;
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listPhongBan;
    }
    
    public List<Map> getListPhongBanTheoId(int pbID){
        Session session = HibernateUtil.currentSession();
        List<Map> listPhongBanId = new ArrayList();
        try {
            session.beginTransaction();
            listPhongBanId = session.createSQLQuery("SELECT * "
                    + " FROM phongban"
                    + " WHERE pb_id = "+pbID).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listPhongBanId;
    }
    
     public boolean addEditPhongBan(PhongBanModel objPhongBan){
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
     
      public boolean delDmPhongBan(int dmPhongBanID){
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM phongban WHERE pb_id = "+dmPhongBanID).executeUpdate();
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
    
    

