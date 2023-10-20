/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.beans.Homme;
import ma.projet.config.util.HibernateUtil;
import ma.projet.idao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class HommeService implements IDao<Homme> {

    @Override
    public boolean create(Homme o) {
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
    public Homme getById(int id){
    Homme homme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
            return homme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return homme;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
    @Override
    public List<Homme> getAll() {
    List<Homme> hommes = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        hommes = session.createQuery("from Homme").list();
        tx.commit();
        return hommes;
    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
        return hommes;
    } finally {
        if (session != null) {
            session.close();
        }
    }
}
}
