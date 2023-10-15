/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entities.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lachgar
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
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
    public boolean delete(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
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
    public boolean update(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
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
    public List<Produit> findAll() {
    List<Produit> produits = null;
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
    public Produit findById(int id) {
        Produit client = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            client = (Produit) session.get(Produit.class, id);
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
    public List<Produit> findProductsAbovePrice(double priceThreshold) {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        
        // Use HQL (Hibernate Query Language) to retrieve products with a price above the threshold
        String hql = "from Produit p where p.prix > :priceThreshold";
        produits = session.createQuery(hql)
            .setParameter("priceThreshold", priceThreshold)
            .list();
        
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
public List<Produit> findProductsOrderedBetweenDates(Date startDate, Date endDate) {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        
        // Utilisez HQL pour rechercher des produits commandé entre deux dates
        String hql = "select p from Produit p where p.dateAchat between :startDate and :endDate";
        produits = session.createQuery(hql)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate)
            .list();
        
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



}
