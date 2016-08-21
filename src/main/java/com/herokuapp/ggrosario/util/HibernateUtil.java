package com.herokuapp.ggrosario.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Ojeda Alberto Daniel
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }

        return sessionFactory;
    }
    
    public static void guardar(Object unObjeto) { 
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(unObjeto);
        transaction.commit();
        session.close();
    }
    
    public static void actualizar(Object unObjeto) throws HibernateException { 
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(unObjeto);
        transaction.commit();
        session.close();
        
    }
    
    public static void eliminar(Object unObjeto) throws HibernateException { 
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(unObjeto);
        transaction.commit();
        session.close();
    }
    
    public static Object obtener (String id, String clase) throws HibernateException {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object unObjeto;
        unObjeto = getSessionFactory().openSession().get("com.herokuapp.ggrosario.modelo."+clase, id);
        transaction.commit();
        session.close();
        return unObjeto;
        
    }
}
