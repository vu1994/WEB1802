package com.cusc.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HibernateUtil {

	private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);
	private static Configuration configuration;
        private static SessionFactory sessionFactory;
    
    static {
            try {
            	Configuration cfg = new Configuration().configure("hibernate.cfg.xml");        	
            	StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            	sb.applySettings(cfg.getProperties());
            	StandardServiceRegistry standardServiceRegistry = sb.build();           	
            	sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);      	
            } catch (Throwable th) {
                    System.err.println("Enitial SessionFactory creation failed" + th);
                    throw new ExceptionInInitializerError(th);
            }
    }

    @SuppressWarnings("rawtypes")
	public static final ThreadLocal session = new ThreadLocal();

    
    @SuppressWarnings("unchecked")
	public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Open a new Session, if this thread has none yet
        if (s == null || s.isOpen() == false) {
//        	System.out.println("session bi null");
            s = sessionFactory.openSession();
            // Store it in the ThreadLocal variable
            session.set(s);
        }
        return s;
    }

  
    public static SessionFactory getSessionFactory() {
    	if (sessionFactory == null) {
            rebuildSessionFactory();
        }
        return sessionFactory;
    }

    /**
     * Closes the current SessionFactory and releases all resources.
     * <p>
     * The only other method that can be called on HibernateUtil
     * after this one is rebuildSessionFactory(Configuration).
     */
    public static void shutdown() {
        log.debug("Shutting down Hibernate");
        // Close caches and connection pools
        getSessionFactory().close();

        // Clear static variables
        sessionFactory = null;
    }


    /**
     * Rebuild the SessionFactory with the static Configuration.
     * <p>
     * Note that this method should only be used with static SessionFactory
     * management, not with JNDI or any other external registry. This method also closes
     * the old static variable SessionFactory before, if it is still open.
     */
     public static void rebuildSessionFactory() {
        log.debug("Using current Configuration to rebuild SessionFactory");
        rebuildSessionFactory(configuration);
     }

    /**
     * Rebuild the SessionFactory with the given Hibernate Configuration.
     * <p>
     * HibernateUtil does not configure() the given Configuration object,
     * it directly calls buildSessionFactory(). This method also closes
     * the old static variable SessionFactory before, if it is still open.
     *
     * @param cfg
     */
     public static void rebuildSessionFactory(Configuration cfg) {
        log.debug("Rebuilding the SessionFactory from given Configuration");
        if (sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
        sessionFactory = cfg.buildSessionFactory();
        
        configuration = cfg;
     }
     
     public static Configuration getConfiguration() {
 		return configuration;
 	}
	
    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s != null && s.isOpen()){
            s.close();
        }
        session.set(null);
    } 
    
    
}