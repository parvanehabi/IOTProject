package services;

import beans.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;

public class DatabaseService {
    private static final SessionFactory sessionFactory;
//    public static Session session;
    static {

        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
//            session = ourSessionFactory.openSession();
        } catch (Throwable ex) {
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
    @Transactional
    public static List<Object> selectAll(String entityName,String column,String Op,Object value, String orderby) throws Exception {
        final Session session = getSession();
        try {
            final Query query;

            if (column == null) {
                String z = " from " + entityName + " o" + orderby;
                query = session.createQuery(z);
            } else {
                String z = " from " + entityName + " o where o." + column + Op + " :" + column + orderby;
                query = session.createQuery(z);
                if (value.getClass().equals(new Integer(0).getClass()))
                    query.setParameter(column, ((Integer) value).intValue());
                else if (value.getClass().equals(new String("").getClass()))
                    query.setParameter(column, value);
            }

            return query.list();
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            session.close();
        }
    }

    @Transactional
    public static List<Object> selectAllWithJoin(String entityName,String column,String Op,Object value, String joinCol) throws Exception {
        final Session session = getSession();
        try {
            final Query query;

            if (column == null) {
                String z = " from " + entityName + " o join fetch o."+joinCol ;
                query = session.createQuery(z);
            } else {
                String z = " from " + entityName + " o join fetch o."+joinCol+" where o." + column + Op + " :" + column;
                query = session.createQuery(z);
                if (value.getClass().equals(new Integer(0).getClass()))
                    query.setParameter(column, ((Integer) value).intValue());
                else if (value.getClass().equals(new String("").getClass()))
                    query.setParameter(column, value);
            }

            return query.list();
        } catch (Exception e){
        e.printStackTrace();
        throw e;
    }finally {
            session.close();
        }

    }

    public static void insertObject(Object o){
        final Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.save(o);
        tx.commit();
        session.close();
    }

    public static void updateObject(Object o){
        final Session session = getSession();
        Transaction tx= session.beginTransaction();
        session.update(o);
        tx.commit();
        session.close();
    }

}
