/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.util.HibernateUtil;
import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.util.ArrayList;
import com.cusc.model.ThietBiModel;
import org.hibernate.Session;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author npvu
 */
public class ThongKeBaoCaoDataprovider implements Serializable {  
    public List<ThietBiModel> getDsThongKeTonKho(){
        return this.getDsThongKeTonKho("", 0);
    }
    
    public List<ThietBiModel> getDsThongKeTonKho(String filterName, int filterTinhTrang){
        Session session = HibernateUtil.currentSession();
        List<ThietBiModel> listThietBi = new ArrayList();
       try {
            session.beginTransaction();
            listThietBi = session.createQuery("FROM ThietBiModel").list();
            session.getTransaction().commit();
	} catch (Exception e) {
            e.printStackTrace();

	} finally {
            session.close();
	}
        return listThietBi;
    }
}
