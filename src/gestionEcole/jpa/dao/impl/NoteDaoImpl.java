/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Note;
import gestionEcole.model.entity.Periode;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.INoteDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class NoteDaoImpl implements INoteDao {

    private EntityManager manager;

    public NoteDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public Note ajouter(Note note) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(note);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return note;
    }

    @Override
    public int supprimer(Note note) {
        return supprimer(note.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Note n WHERE n.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;
    }

    @Override
    public int modifier(Note note) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            //on récupère l'élève concerné
            Note n = manager.find(Note.class, note.getId());
            //si le coefficient a été modifié
            if (note.getValeur() != n.getValeur()) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Note n SET n.valeur = " + note.getValeur()
                        + " WHERE n.id = :id");
                query.setParameter("id", note.getId());
                updatedCount = query.executeUpdate();
                transaction.commit();
            }
        } catch (Exception ex) {
            transaction.rollback();
        }
        return updatedCount;
    }

    @Override
    public List<Note> lister() {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n "
                    + " ORDER BY n.evaluation.periode.id, n.eleve.id, n.evaluation.type.id", Note.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Note> lister(Periode periode, Eleve eleve) {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n WHERE n.evaluation.periode.id = "
                    + periode.getId() + "AND n.eleve.id = " + eleve.getId() + " ORDER BY n.evaluation.type.id",
                     Note.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Note> lister(Periode periode, Eleve eleve, Cours cours) {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n WHERE n.evaluation.periode.id = "
                    + periode.getId() + "AND n.eleve.id = " + eleve.getId() + "AND n.evaluation.cours.id = "
                    + cours.getId() + " ORDER BY n.evaluation.type.id", Note.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Note trouver(Long id) {
        try {
            Note note = manager.find(Note.class, id);
            return note;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public List<Note> lister(Periode periode, Enseignement enseignement, Eleve eleve) {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n WHERE n.evaluation.periode.id = "
                    + periode.getId() + " AND n.eleve.id = " + eleve.getId() + " AND n.evaluation.cours.enseignement.id = "
                    + enseignement.getId() + " ORDER BY n.evaluation.type.id ", Note.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Note> lister(Evaluation evaluation) {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n WHERE n.evaluation.id = :id_ev "
                    + "ORDER BY n.eleve.id, n.evaluation.type.id",
                     Note.class);
            query.setParameter("id_ev", evaluation.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Note> lister(Evaluation evaluation, Eleve eleve) {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n WHERE n.evaluation.id = :id_ev "
                    + " AND n.eleve.id = :id_el "
                    + " ORDER BY n.eleve.id, n.evaluation.type.id",
                     Note.class);
            query.setParameter("id_ev", evaluation.getId());
            query.setParameter("id_el", eleve.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Note> lister(Periode periode, Cours cours) {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n WHERE n.evaluation.periode.id = "
                    + periode.getId() + " AND n.evaluation.cours.id = "
                    + cours.getId() + " ORDER BY n.eleve.id, n.evaluation.type.id ", Note.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Note> lister(Periode periode, Cours cours, Eleve eleve) {
        List<Note> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Note> query = manager.createQuery("SELECT n FROM Note n WHERE n.evaluation.periode.id = "
                    + periode.getId() + " AND n.evaluation.cours.id = "
                    + cours.getId() + " AND n.eleve.id = " + eleve.getId()
                    + " ORDER BY n.evaluation.type.id ", Note.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

}
