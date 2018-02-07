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
import java.util.HashMap;
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
    
    
    public Map getThietBi(int thietBiId){
        Session session = HibernateUtil.currentSession();
        Map mapThietBi = new HashMap();
        try {
            session.beginTransaction();
            mapThietBi = (Map) session.createSQLQuery("SELECT tb.*, dmtb.danhmuc_thietbi_ten, tt.tinhtrang_ten"
                    + " FROM thietbi tb"
                    + " LEFT JOIN danhmuc_thietbi dmtb ON tb.danhmuc_thietbi_id = dmtb.danhmuc_thietbi_id"
                    + " LEFT JOIN tinhtrang tt ON tb.tinhtrang_id = tt.tinhtrang_id"
                    + " WHERE tb.thietbi_id = :thietBiId")
                    .setLong("thietBiId", thietBiId)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
            session.getTransaction().commit();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return mapThietBi;
    }
    public List<Map> getListThietBiByNhom(long nhomID){
        Session session = HibernateUtil.currentSession();
        List<Map> listThietBi = new ArrayList();
        try {
            session.beginTransaction();
            listThietBi = session.createSQLQuery("SELECT tb.*, dmtb.danhmuc_thietbi_ten, tt.tinhtrang_ten"
                    + " FROM thietbi tb"
                    + " LEFT JOIN danhmuc_thietbi dmtb ON tb.danhmuc_thietbi_id = dmtb.danhmuc_thietbi_id"
                    + " LEFT JOIN tinhtrang tt ON tb.tinhtrang_id = tt.tinhtrang_id"
                    + " WHERE dmtb.danhmuc_thietbi_id = :nhomID")
                    .setLong("nhomID", nhomID).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
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
    
    public List<Map> getListThietBiByNhomNV(long nhomID, long nvID){
        Session session = HibernateUtil.currentSession();
        List<Map> listThietBi = new ArrayList();
        try {
            session.beginTransaction();
            listThietBi = session.createSQLQuery("SELECT tb.*, dmtb.danhmuc_thietbi_ten, tt.tinhtrang_ten"
                    + " FROM thietbi tb"
                    + " LEFT JOIN danhmuc_thietbi dmtb ON tb.danhmuc_thietbi_id = dmtb.danhmuc_thietbi_id"
                    + " LEFT JOIN tinhtrang tt ON tb.tinhtrang_id = tt.tinhtrang_id"
                    + " WHERE dmtb.danhmuc_thietbi_id = :nhomID and tb.thietbi_capcho =:nvID")
                    .setLong("nhomID", nhomID)
                    .setLong("nvID", nvID)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
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
    
    public boolean updateThietBi(ThietBiModel objThietBi){
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
    public boolean delThietBi(ThietBiModel objThietBi){
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            session.delete(objThietBi);
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
    
    public List<Map> getListThietBiCapPhat(){
        Session session = HibernateUtil.currentSession();
        List<Map> listThietBiCapPhat = new ArrayList();
        try {
            session.beginTransaction();
            listThietBiCapPhat = session.createSQLQuery("SELECT thietbi_id,nv_ten,pb_ten,thietbi_ten,thietbi_trangthai_capphat, thietbi_ngaycap " + 
                    " FROM nhanvien nv " +
                    " INNER JOIN phongban pb ON pb.pb_id = nv.pb_id " +
                    " INNER JOIN thietbi tb ON tb.thietbi_capcho = nv.nv_id " +
                    " GROUP BY thietbi_id "+ 
                    " ORDER BY pb_ten,nv_ten ")
                   .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
            int stt = 1;
            for(Map mapThietBiCapPhat : listThietBiCapPhat){
                mapThietBiCapPhat.put("rowIndex", stt);
                stt++;
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listThietBiCapPhat;
    }
    
     public List<Map> getListThietBiCapPhatFilterPB(int pbID){
        Session session = HibernateUtil.currentSession();
        List<Map> listThietBiCapPhat = new ArrayList();
        try {
            session.beginTransaction();
            listThietBiCapPhat = session.createSQLQuery("SELECT nv_ten,pb_ten,thietbi_ten,thietbi_trangthai_capphat, thietbi_ngaycap "
                    +" FROM nhanvien nv " 
                    +" INNER JOIN phongban pb ON pb.pb_id = nv.pb_id " 
                    +" INNER JOIN thietbi tb ON tb.thietbi_capcho = nv.nv_id "
                    +" WHERE nv.pb_id = "+pbID 
                    +" ORDER BY pb_ten,nv_ten ")
                   .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
            int stt = 1;
            for(Map mapThietBiCapPhat : listThietBiCapPhat){
                mapThietBiCapPhat.put("rowIndex", stt);
                stt++;
            }
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            session.close();
	}
        return listThietBiCapPhat;
    }
}
