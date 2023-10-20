/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.beans.Marriage;
import ma.projet.config.util.HibernateUtil;
import ma.projet.idao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class MarriageService implements IDao<Marriage>{
    
    @Override
    public boolean create(Marriage o) {
        Session session = null;
        Transaction trx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trx = session.beginTransaction();
            session.save(o);
            trx.commit();
            return true;
        } catch (HibernateException e) {
            if (trx != null) {
                trx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
    
    @Override
    public Marriage getById(int id){
    Marriage mariage = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            mariage = (Marriage) session.get(Marriage.class, id);
            tx.commit();
            return mariage;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return mariage;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
    @Override
    public List<Marriage> getAll() {
    List<Marriage> mariages = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        mariages = session.createQuery("from Marriage").list();
        tx.commit();
        return mariages;
    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
        return mariages;
    } finally {
        if (session != null) {
            session.close();
        }
    }
}
    
}
