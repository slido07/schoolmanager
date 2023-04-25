/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Enseignement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.ICoursDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class CoursDaoImpl implements ICoursDao {

    private final EntityManager manager;

    public CoursDaoImpl() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
    }

    @Override
    public Cours ajouter(Cours cours) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(cours);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return cours;
    }

    @Override
    public int supprimer(Cours cours) {
        return supprimer(cours.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Cours c WHERE c.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;

    }

    @Override
    public List<Cours> lister() {
        List<Cours> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Cours> query = manager.createQuery("SELECT c FROM Cours c "
                    + "ORDER BY c.classe.niveau.id, c.classe.subdivision, c.enseignement.matiere.code", Cours.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Cours> lister(Classe classe) {
        List<Cours> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Cours> query = manager.createQuery("SELECT c FROM Cours c  WHERE c.classe.id = :id_classe"
                    + " ORDER BY c.classe.subdivision, c.enseignement.matiere.code", Cours.class);
            query.setParameter("id_classe", classe.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Cours trouver(Long id) {
        try {
            Cours cours = manager.find(Cours.class, id);
            return cours;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public int modifier(Cours cours) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            //on récupère l'élève concerné
            Cours c = manager.find(Cours.class, cours.getId());
            //si l'enseignant a été modifié
            if (!cours.getEnseignant().equals(c.getEnseignant())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Cours c SET c.enseignant = " + cours.getEnseignant()
                        + " WHERE c.id = :id");
                query.setParameter("id", cours.getId());
                updatedCount = query.executeUpdate();
                transaction.commit();
            }

        } catch (Exception ex) {
            transaction.rollback();
        }
        return updatedCount;
    }

    @Override
    public List<Cours> lister(Enseignement enseignement) {
        List<Cours> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Cours> query = manager.createQuery("SELECT c FROM Cours c  WHERE c.enseignement.id = :id_ens"
                    + " ORDER BY c.classe.subdivision", Cours.class);
            query.setParameter("id_ens", enseignement.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

}
