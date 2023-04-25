/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.TypeEvaluation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.ITypeEvaluationDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class TypeEvaluationDaoImpl implements ITypeEvaluationDao {

    private EntityManager manager;

    public TypeEvaluationDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public TypeEvaluation ajouter(TypeEvaluation type) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(type);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return type;
    }

    @Override
    public int supprimer(TypeEvaluation type) {
        return supprimer(type.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM TypeEvaluation t WHERE t.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;
    }

    @Override
    public List<TypeEvaluation> lister() {
        List<TypeEvaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<TypeEvaluation> query = manager.createQuery("SELECT t FROM TypeEvaluation t ORDER BY t.id", TypeEvaluation.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public TypeEvaluation trouver(Long id) {
        try {
            TypeEvaluation type = manager.find(TypeEvaluation.class, id);
            return type;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public int modifier(TypeEvaluation type) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            TypeEvaluation t = manager.find(TypeEvaluation.class, type.getId());
            if (!type.getCode().equals(t.getCode())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE TypeEvaluation t SET t.code = " + type.getCode()
                        + " WHERE t.id = :id");
                query.setParameter("id", type.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            if (!type.getLibelle().equals(t.getLibelle())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE TypeEvaluation t SET t.libelle = " + type.getLibelle()
                        + " WHERE t.id = :id");
                query.setParameter("id", type.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
        }
        return updatedCount;
    }

}
