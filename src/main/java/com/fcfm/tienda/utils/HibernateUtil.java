package com.fcfm.tienda.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by dany on 8/16/2015.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try{
            sessionFactory = new AnnotationConfiguration();
        }catch(Throwable ex){
            //log exception
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }
}
