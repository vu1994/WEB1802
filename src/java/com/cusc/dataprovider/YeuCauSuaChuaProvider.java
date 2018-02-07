/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.model.PhongBanModel;
import com.cusc.model.YeuCauSuaChuaModel;
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
public class YeuCauSuaChuaProvider implements Serializable {  
    
    public List<Map> getListYeuCau(){
        Session session = HibernateUtil.currentSession();
        List<Map> listYeuCau = new ArrayList();
        try {
            session.beginTransaction();
            listYeuCau = session.createSQLQuery("SELECT pb.pb_ten,nv.nv_ten,tb.thietbi_ten,tt.yeucau_tinhtrang_ten,yc.yeucau_tinhtrangsc,"
                         + " yc.yeucau_ngayyeucau,yc.yeucau_tinhtranghong FROM yeucau_suachua yc "
                         + " INNER JOIN thietbi tb ON tb.thietbi_id = yc.yeucau_tb_id "
                         + " INNER JOIN nhanvien nv ON nv.nv_id = yc.yeucau_nv_id "
                         + " INNER JOIN yeucau_tinhtrang tt ON tt.yeucau_tinhtrang_id = yc.yeucau_tinhtrangsc"
                         + " INNER JOIN phongban pb ON pb.pb_id = nv.pb_id").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
            int stt = 1;
            for(Map mapYeuCau : listYeuCau){
                mapYeuCau.put("rowIndex", stt);
                stt++;
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listYeuCau;
    }
    
    public List<Map> getListYeuCauTheoId(int pbID){
        Session session = HibernateUtil.currentSession();
        List<Map> listYeuCau = new ArrayList();
        try {
            session.beginTransaction();
            listYeuCau = session.createSQLQuery("SELECT pb.pb_ten,nv.nv_ten,tb.thietbi_ten,tt.yeucau_tinhtrang_ten,yc.yeucau_tinhtrangsc,"
                         + " yc.yeucau_ngayyeucau,yc.yeucau_tinhtranghong FROM yeucau_suachua yc "
                         + " INNER JOIN thietbi tb ON tb.thietbi_id = yc.yeucau_tb_id "
                         + " INNER JOIN nhanvien nv ON nv.nv_id = yc.yeucau_nv_id "
                         + " INNER JOIN phongban pb ON pb.pb_id = nv.pb_id "
                         + " INNER JOIN yeucau_tinhtrang tt ON tt.yeucau_tinhtrang_id = yc.yeucau_tinhtrangsc"
                         + " WHERE pb.pb_id = "+pbID).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
            int stt = 1;
            for(Map mapYeuCau : listYeuCau){
                mapYeuCau.put("rowIndex", stt);
                stt++;
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listYeuCau;
    }
    
     public boolean addEditYeuCau(YeuCauSuaChuaModel objYeuCau){
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(objYeuCau);
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
     
      public boolean delDmYeuCau(int dmYeuCauID){
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM yeucau_suachua WHERE yeucau_id = "+dmYeuCauID).executeUpdate();
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
    
    

