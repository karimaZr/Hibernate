/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.NamedQuery;
import ma.projet.dao.IDao;
import ma.projet.entities.Catégorie;
import ma.projet.entities.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query; // Import the Query class
import ma.projet.util.HibernateUtil;
import ma.projet.entities.Produit;

import javax.persistence.NamedQuery;
import javax.persistence.criteria.CriteriaQuery;
/**
 * 
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
    public List<Produit> getAll() {
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
    public Produit getById(int id) {
        Produit commande = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            commande = (Produit) session.get(Produit.class, id);
            tx.commit();
            return commande;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return commande;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
public List<Produit> findProductsByCategory(int categoryId) {
    List<Produit> produits = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        
        // Utilisez HQL pour rechercher les produits par catégorie
        String hql = "select distinct p from Produit p join fetch p.catégorie c where c.id = :categoryId";
        produits = session.createQuery(hql)
            .setParameter("categoryId", categoryId)
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
        
        // Utilisez HQL pour rechercher les produits commandés entre deux dates
        String hql = "select distinct p from Produit p join fetch p.commandes c where c.date between :startDate and :endDate";
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





