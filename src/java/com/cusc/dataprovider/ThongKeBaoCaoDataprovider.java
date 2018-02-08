/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.util.HibernateUtil;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import com.cusc.model.ThietBiModel;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author npvu
 */
public class ThongKeBaoCaoDataprovider implements Serializable {  
    public List<Map> getDsThongKeTonKho(){
        return this.getDsThongKeTonKho("", 0);
    }
    
    public List<Map> getDsThongKeTonKho(String filterName, int filterTinhTrang){
        Session session = HibernateUtil.currentSession();
        List<Map> listThietBi = new ArrayList();
        String where = "1 = 1";
        if(filterName!=null && !filterName.isEmpty()){
            where += " AND tb.thietbi_ten like '%"+filterName+"%' ";
        }
        if(filterTinhTrang != 0){
            where += " AND tb.tinhtrang_id = "+filterTinhTrang;
        }
        try {
            session.beginTransaction();
            listThietBi = session.createSQLQuery("SELECT tb.*, dmtb.danhmuc_thietbi_ten, tt.tinhtrang_ten"
                    + " FROM thietbi tb"
                    + " LEFT JOIN danhmuc_thietbi dmtb ON tb.danhmuc_thietbi_id = dmtb.danhmuc_thietbi_id"
                    + " LEFT JOIN tinhtrang tt ON tb.tinhtrang_id = tt.tinhtrang_id"
                    + " WHERE "+where).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
            session.getTransaction().commit();
	} catch (Exception e) {
            e.printStackTrace();

	} finally {
            session.close();
	}
        return listThietBi;
    }
    
    public Integer thongKeTrangThaiTB(int tinhtrangID){
        Session session = HibernateUtil.currentSession();
        Integer thongKe = 0;
        try {
            session.beginTransaction();
            Object result = session.createSQLQuery("SELECT ((SELECT count(0) from thietbi WHERE tinhtrang_id=:tinhtrangID group by tinhtrang_id)  / count(0) ) * 100 from thietbi")
                    .setInteger("tinhtrangID", tinhtrangID)
                    .uniqueResult();
            if(result!=null){
            thongKe = Integer.parseInt(String.format("%.0f", result));
            }
            session.getTransaction().commit();;
            
	} catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return 0;
	} finally {
            session.close();
	}
//        System.out.println("com.cusc.dataprovider.ThongKeBaoCaoDataprovider.thongKeTrangThaiTB()"+thongKe);
        return thongKe;
    }
    
    public Integer thongKeTrangThaiCP(String tinhtrangCP){
        Session session = HibernateUtil.currentSession();
        Integer thongKe = 0;
        try {
            session.beginTransaction();
            Object result = session.createSQLQuery("SELECT ((SELECT count(0) from thietbi WHERE thietbi_trangthai_capphat LIKE (:tinhtrangCP) group by tinhtrang_id)  / (SELECT count(0) from thietbi WHERE thietbi_trangthai_capphat IS NOT NULL AND thietbi_trangthai_capphat != '')) * 100")
                    .setString("tinhtrangCP", tinhtrangCP)
                    .uniqueResult();
            if(result!=null){
            thongKe = Integer.parseInt(String.format("%.0f", result));
            }
            session.getTransaction().commit();;
            
	} catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return 0;
	} finally {
            session.close();
	}
        System.out.println("com.cusc.dataprovider.ThongKeBaoCaoDataprovider.thongKeTrangThaiTB()"+thongKe);
        return thongKe;
    }
}
