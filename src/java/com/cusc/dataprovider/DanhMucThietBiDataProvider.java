/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.model.DanhMucThietBiModel;
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
 * @author npvu
 */
public class DanhMucThietBiDataProvider implements Serializable {  
    
    public List<Map> getListDmThietBi(){
        Session session = HibernateUtil.currentSession();
        List<Map> listDmThietBi = new ArrayList();
        try {
            session.beginTransaction();
            listDmThietBi = session.createSQLQuery("SELECT * FROM danhmuc_thietbi").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
            for(Map dmThietBi : listDmThietBi){
                dmThietBi.put("editTen", false);
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listDmThietBi;
    }
    
    public DanhMucThietBiModel getDmThietBiByID(int dmThietBiID){
        Session session = HibernateUtil.currentSession();
        DanhMucThietBiModel dmThietBi = new DanhMucThietBiModel();
        try {
            session.beginTransaction();
            dmThietBi = (DanhMucThietBiModel) session.createQuery("FROM DanhMucThietBiModel WHERE dmThietBiID ="+dmThietBiID).uniqueResult();
            session.getTransaction().commit();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return dmThietBi;
    }
    
    public boolean updateDmThietBi(DanhMucThietBiModel dmThietBi){
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(dmThietBi);
            session.getTransaction().commit();
	} catch (Exception e) {
            return false;
	} finally {
            session.close();
	}
        return true;
    }
}
