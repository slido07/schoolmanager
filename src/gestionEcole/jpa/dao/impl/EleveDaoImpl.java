/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Eleves/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Niveau;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.IEleveDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class EleveDaoImpl implements IEleveDao {

    private EntityManager manager;

    public EleveDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public Eleve ajouter(Eleve eleve) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(eleve);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return eleve;
    }

    @Override
    public int supprimer(Eleve eleve) {
        return supprimer(eleve.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Eleve e WHERE e.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;
    }

    @Override
    public int modifier(Eleve eleve) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            //on récupère l'élève concerné
            Eleve el = manager.find(Eleve.class, eleve.getId());
            //si les noms sont différents on fait une màj
            if (!eleve.getNom().equals(el.getNom())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Eleve e SET e.nom = " + eleve.getNom() + " WHERE e.id = :id");
                query.setParameter("id", eleve.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour le prénom
            if (!eleve.getPrenom().equals(el.getPrenom())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Eleve e SET e.prenom = " + eleve.getPrenom() + " WHERE e.id = :id");
                query.setParameter("id", eleve.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour le sexe
            if (eleve.getSexe() != el.getSexe()) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Eleve e SET e.sexe = " + eleve.getSexe() + " WHERE e.id = :id");
                query.setParameter("id", eleve.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour sa classe
            if (!eleve.getClasse().equals(el.getClasse())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Eleve e SET e.classe = " + eleve.getClasse()
                        + " WHERE e.id = :id");
                query.setParameter("id", eleve.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }

        } catch (Exception ex) {
            transaction.rollback();
        }
        return updatedCount;
    }

    @Override
    public List<Eleve> lister() {
        List<Eleve> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Eleve> query = manager.createQuery("SELECT e FROM Eleve e ORDER BY e.classe.id, e.id", Eleve.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Eleve> lister(Classe classe) {
        List<Eleve> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Eleve> query = manager.createQuery("SELECT e FROM Eleve e WHERE e.classe.id = :id_classe"
                    + " ORDER BY e.id", Eleve.class);
            query.setParameter("id_classe", classe.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Eleve> lister(Niveau niveau) {
        List<Eleve> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Eleve> query = manager.createQuery("SELECT e FROM Eleve e WHERE e.classe.niveau.id = :id_niveau"
                    + " ORDER BY e.id", Eleve.class);
            query.setParameter("id_niveau", niveau.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Eleve trouver(Long id) {
        try {
            Eleve eleve = manager.find(Eleve.class, id);
            return eleve;
        } catch (Exception ex) {
        }
        return null;
    }

}
