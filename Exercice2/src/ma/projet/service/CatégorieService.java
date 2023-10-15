/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entities.Catégorie;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lachgar
 */
public class CatégorieService implements IDao<Catégorie> {

    @Override
    public boolean create(Catégorie o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

   
   
    @Override
    public List<Catégorie> getAll() {
    List<Catégorie> produits = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        produits = session.createQuery("from Produit").list();
        tx.commit();
        return produits;
    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
        return produits;
    } finally {
        if (session != null) {
            session.close();
        }
    }
}
    @Override
    public Catégorie getById(int id) {
        Catégorie client = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            client = (Catégorie) session.get(Catégorie.class, id);
            tx.commit();
            return client;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return client;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
