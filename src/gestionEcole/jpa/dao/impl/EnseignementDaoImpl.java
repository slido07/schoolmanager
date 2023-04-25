/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Niveau;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.IEnseignementDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class EnseignementDaoImpl implements IEnseignementDao {

    private EntityManager manager;

    public EnseignementDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public Enseignement ajouter(Enseignement enseignement) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(enseignement);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return enseignement;

    }

    @Override
    public int supprimer(Enseignement enseignement) {
        return supprimer(enseignement.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Enseignement ens WHERE ens.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;
    }

    @Override
    public List<Enseignement> lister() {
        List<Enseignement> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Enseignement> query = manager.createQuery("SELECT ens FROM Enseignement ens "
                    + "ORDER BY ens.niveau.id, ens.matiere.code", Enseignement.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Enseignement> lister(Niveau niveau) {
        List<Enseignement> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Enseignement> query = manager.createQuery("SELECT ens FROM Enseignement ens WHERE ens.niveau.id = :id_niveau"
                    + " ORDER BY ens.matiere.code", Enseignement.class);
            query.setParameter("id_niveau", niveau.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Enseignement trouver(Long id) {
        try {
            Enseignement enseignement = manager.find(Enseignement.class, id);
            return enseignement;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public int modifier(Enseignement enseignement) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            //on récupère l'élève concerné
            Enseignement ens = manager.find(Enseignement.class, enseignement.getId());
            //si le coefficient a été modifié
            if (enseignement.getCoefficient() != ens.getCoefficient()) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Enseignement ens SET ens.coefficient = " + enseignement.getCoefficient()
                        + " WHERE ens.id = :id");
                query.setParameter("id", enseignement.getId());
                updatedCount = query.executeUpdate();
                transaction.commit();
            }

        } catch (Exception ex) {
            transaction.rollback();
        }
        return updatedCount;
    }

    @Override
    public List<Enseignement> lister(Matiere matiere) {
        List<Enseignement> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Enseignement> query = manager.createQuery("SELECT ens FROM Enseignement ens WHERE ens.matiere.id = :id_matiere"
                    + " ORDER BY ens.niveau.id, ens.matiere.code", Enseignement.class);
            query.setParameter("id_matiere", matiere.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

}
