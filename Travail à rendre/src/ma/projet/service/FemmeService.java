/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.config.util.HibernateUtil;
import ma.projet.idao.IDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class FemmeService implements IDao<Femme> {

    @Override
    public boolean create(Femme o) {
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
    public Femme getById(int id) {
        Femme femme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
            return femme;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return femme;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<Femme> getAll() {
        List<Femme> femmes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
            tx.commit();
            return femmes;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return femmes;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Femme> findEpousesBetweenDates(int husbandID, Date startDate, Date endDate) {
    List<Femme> epouses = null;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        // Use HQL to search for wives of a husband between two dates
        String hql = "select distinct f from Personne p join p.mariage m join m.femme f " +
                     "where p.id = :husbandID and m.dateDebut >= :startDate and m.dateFin <= :endDate";
        epouses = session.createQuery(hql)
            .setParameter("husbandID", husbandID)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate)
            .list();

        tx.commit();
        return epouses;
    } catch (HibernateException ex) {
        if (tx != null) {
            tx.rollback();
        }
        return epouses;
    } finally {
        if (session != null) {
            session.close();
        }
    }
}

}
