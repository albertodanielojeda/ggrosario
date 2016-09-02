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
    
    /**
     * Guarda un objeto en la base de datos
     * @param unObjeto Objeto que se desea guardar
     */
    public static void guardar(Object unObjeto) { 
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(unObjeto);
        transaction.commit();
        session.close();
    }
    
    /**
     * Actualiza un objeto de la base de datos
     * @param unObjeto Objeto que se desea actualizar
     */
    public static void actualizar(Object unObjeto) throws HibernateException { 
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.merge(unObjeto);
        }catch (HibernateException he){
            System.out.println(he.getMessage());
        }
        transaction.commit();
        session.close();
        
    }
    
    public static void eliminar(Object unObjeto) throws HibernateException { 
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(unObjeto);
        transaction.commit();
        session.close();
    }
    
    /**
     * Recupera un objeto de la base de datos
     * @param id Identificador que el objeto tiene en la BD
     * @param clase Nombre de la clase de la que es instancia el objeto a recuperar
     * @return Object Un objeto. Debe ser casteado al tipo de objeto que se quiso recuperar (<code>clase</code>)
     * 
     */
    public static Object obtener (String id, String clase) throws HibernateException {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Object unObjeto;
        unObjeto = session.get("com.herokuapp.ggrosario.modelo."+clase, id);
        transaction.commit();
        session.close();
        return unObjeto;
    }
}
