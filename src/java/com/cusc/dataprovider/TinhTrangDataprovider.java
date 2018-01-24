/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cusc.dataprovider;

import com.cusc.model.DanhMucTinhTrangModel;
import com.cusc.util.HibernateUtil;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author npvu
 */
public class TinhTrangDataprovider implements Serializable {  
    
    public List<DanhMucTinhTrangModel> getDmTinhTrang(){
        Session session = HibernateUtil.currentSession();
        List<DanhMucTinhTrangModel> listDmTinhTrang = new ArrayList();
        try {
            session.beginTransaction();
            listDmTinhTrang = session.createQuery("FROM DanhMucTinhTrangModel").list();
            session.getTransaction().commit();
	} catch (Exception e) {
            e.printStackTrace();

	} finally {
            session.close();
	}
        return listDmTinhTrang;
    }
}
