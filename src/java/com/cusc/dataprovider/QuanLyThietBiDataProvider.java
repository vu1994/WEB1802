/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.model.ThietBiModel;
import com.cusc.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author SunnyNguyen
 */
public class QuanLyThietBiDataProvider implements Serializable{

    public List<Map> getListThietBi(){
        Session session = HibernateUtil.currentSession();
        List<Map> listThietBi = new ArrayList();
        try {
            session.beginTransaction();
            listThietBi = session.createSQLQuery("SELECT tb.*, dmtb.danhmuc_thietbi_ten, tt.tinhtrang_ten"
                    + " FROM thietbi tb"
                    + " LEFT JOIN danhmuc_thietbi dmtb ON tb.danhmuc_thietbi_id = dmtb.danhmuc_thietbi_id"
                    + " LEFT JOIN tinhtrang tt ON tb.tinhtrang_id = tt.tinhtrang_id"
                    + "  ").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
            int stt = 1;
            for(Map mapThietBi : listThietBi){
                mapThietBi.put("rowIndex", stt);
                stt++;
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listThietBi;
    }
    
    public boolean addThietBi(ThietBiModel objThietBi){
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(objThietBi);
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
