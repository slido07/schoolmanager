/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Niveau;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.IClasseDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class ClasseDaoImpl implements IClasseDao {

    private EntityManager manager;

    public ClasseDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public Classe ajouter(Classe classe) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(classe);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return classe;

    }

    @Override
    public int supprimer(Classe classe) {
        return supprimer(classe.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Classe c WHERE c.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;
    }

    @Override
    public Classe trouver(Long id) {
        try {
            Classe classe = manager.find(Classe.class, id);
            return classe;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public List<Classe> lister() {
        List<Classe> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Classe> query = manager.createQuery("SELECT c FROM Classe c ORDER BY c.niveau.id, c.subdivision",
                     Classe.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Classe> lister(Niveau niveau) {
        List<Classe> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Classe> query = manager.createQuery("SELECT c FROM Classe c WHERE c.niveau.id = :id_niveau"
                    + " ORDER BY c.subdivision", Classe.class);
            query.setParameter("id_niveau", niveau.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;

    }

    @Override
    public List<Classe> lister(Long id_niveau) {
        List<Classe> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Classe> query = manager.createQuery("SELECT c FROM Classe c WHERE c.niveau.id = :id_niveau ORDER BY c.id",
                     Classe.class);
            query.setParameter("id_niveau", id_niveau);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public int modifier(Classe classe) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            Classe c = manager.find(Classe.class, classe.getId());
            if (!classe.getSubdivision().equals(c.getSubdivision())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Classe c SET c.subdivision = " + classe.getSubdivision()
                        + " WHERE c.id = :id");
                query.setParameter("id", classe.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
        }
        return updatedCount;
    }
    
}

