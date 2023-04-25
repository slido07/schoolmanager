/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Matiere;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.IMatiereDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class MatiereDaoImpl implements IMatiereDao {

    private EntityManager manager;

    public MatiereDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public Matiere ajouter(Matiere matiere) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(matiere);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return matiere;
    }

    @Override
    public int supprimer(Matiere matiere) {
        return supprimer(matiere.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Matiere m WHERE m.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;

    }

    @Override
    public List<Matiere> lister() {
        List<Matiere> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Matiere> query = manager.createQuery("SELECT m FROM Matiere m ORDER BY m.code", Matiere.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Matiere trouver(Long id) {
        try {
            Matiere matiere = manager.find(Matiere.class, id);
            return matiere;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public int modifier(Matiere matiere) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            Matiere m = manager.find(Matiere.class, matiere.getId());
            if (!matiere.getCode().equals(m.getCode())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Matiere m SET m.code = " + matiere.getCode()
                        + " WHERE m.id = :id");
                query.setParameter("id", matiere.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            if (!matiere.getLibelle().equals(m.getLibelle())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Matiere m SET m.libelle = " + matiere.getLibelle()
                        + " WHERE m.id = :id");
                query.setParameter("id", matiere.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
        }
        return updatedCount;
    }

}
