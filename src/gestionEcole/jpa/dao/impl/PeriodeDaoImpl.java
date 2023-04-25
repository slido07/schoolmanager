/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Periode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.IPeriodeDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class PeriodeDaoImpl implements IPeriodeDao {

    private EntityManager manager;

    public PeriodeDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public Periode ajouter(Periode periode) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(periode);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return periode;
    }

    @Override
    public int supprimer(Periode periode) {
        return supprimer(periode.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Periode p WHERE p.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;

    }

    @Override
    public List<Periode> lister() {
        List<Periode> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Periode> query = manager.createQuery("SELECT p FROM Periode p ORDER BY p.id", Periode.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Periode trouver(Long id) {
        try {
            Periode periode = manager.find(Periode.class, id);
            return periode;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public int modifier(Periode periode) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            Periode p = manager.find(Periode.class, periode.getId());
            if (!periode.getLibelle().equals(p.getLibelle())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Periode p SET p.libelle = " + periode.getLibelle()
                        + " WHERE p.id = :id");
                query.setParameter("id", periode.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
        }
        return updatedCount;
    }

}
