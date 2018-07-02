package db;

import models.Author;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBAuthor {

    private static Session session;
    private static Transaction transaction;

    public static void save(Author author){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(author);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static List<Author> getAll(){
        session = session.getSessionFactory().openSession();
        List<Author> results = null;
        try {
            Criteria criteria = session.createCriteria(Author.class);
            results = criteria.list();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return results;
    }

    public static Author find(int id){
        Author result = null;
        session = session.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Author.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Author) criteria.uniqueResult();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public static void delete(Author author){
        session = session.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


    public static void deleteAll(){
        session = session.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Author.class);
            List<Author> results = criteria.list();
            transaction = session.beginTransaction();
            for(Author author: results){
                session.delete(author);
            }
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }
        }
    }

