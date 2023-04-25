/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Periode;
import gestionEcole.model.entity.TypeEvaluation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import gestionEcole.jpa.dao.I.IEvaluationDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author HP
 */
public class EvaluationDaoImpl implements IEvaluationDao {

    private EntityManager manager;

    public EvaluationDaoImpl() {
        try {
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        } catch (Exception ex) {
        }
    }

    @Override
    public Evaluation ajouter(Evaluation evaluation) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(evaluation);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return evaluation;
    }

    @Override
    public int supprimer(Evaluation evaluation) {
        return supprimer(evaluation.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Evaluation ev WHERE ev.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;
    }

    @Override
    public int modifier(Evaluation evaluation) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            //on récupère l'évaluation concernée
            Evaluation ev = manager.find(Evaluation.class, evaluation.getId());

            //si les périodes sont différentes on fait une màj
            if (!evaluation.getPeriode().equals(ev.getPeriode())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Evaluation ev SET ev.periode = " + evaluation.getPeriode()
                        + " WHERE ev.id = :id");
                query.setParameter("id", evaluation.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour le cours
            if (!evaluation.getCours().equals(ev.getCours())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Evaluation ev SET ev.cours = " + evaluation.getCours()
                        + " WHERE ev.id = :id");
                query.setParameter("id", evaluation.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour la date
            if (!evaluation.getDate().equals(ev.getDate())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Evaluation ev SET ev.date = " + evaluation.getDate()
                        + " WHERE ev.id = :id");
                query.setParameter("id", evaluation.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour son barème
            if (evaluation.getBareme() != ev.getBareme()) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Evaluation ev SET ev.bareme = " + evaluation.getBareme()
                        + " WHERE ev.id = :id");
                query.setParameter("id", evaluation.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour son poids
            if (evaluation.getPoids() != ev.getPoids()) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Evaluation ev SET ev.poids = " + evaluation.getPoids()
                        + " WHERE ev.id = :id");
                query.setParameter("id", evaluation.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }

        } catch (Exception ex) {
            transaction.rollback();
        }
        return updatedCount;
    }

    @Override
    public List<Evaluation> lister() {
        List<Evaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Evaluation> query = manager.createQuery("SELECT ev FROM Evaluation ev "
                    + "ORDER BY ev.periode.id, ev.type.id",
                    Evaluation.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Evaluation> lister(Classe classe) {
        List<Evaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Evaluation> query = manager.createQuery("SELECT ev FROM Evaluation ev "
                    + " WHERE ev.cours.classe.id = :id_classe ORDER BY ev.periode.id, ev.type.id",
                    Evaluation.class);
            query.setParameter("id_classe", classe.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Evaluation> lister(Cours cours) {
        List<Evaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Evaluation> query = manager.createQuery("SELECT ev FROM Evaluation ev "
                    + " WHERE ev.cours.id = :id_cours ORDER BY ev.periode.id, ev.type.id",
                    Evaluation.class);
            query.setParameter("id_cours", cours.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Evaluation> lister(Periode periode) {
        List<Evaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Evaluation> query = manager.createQuery("SELECT ev FROM Evaluation ev "
                    + " WHERE ev.periode.id = :id_periode ORDER BY ev.type.id",
                    Evaluation.class);
            query.setParameter("id_periode", periode.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Evaluation trouver(Long id) {
        try {
            Evaluation evaluation = manager.find(Evaluation.class, id);
            return evaluation;
        } catch (Exception ex) {
        }
        return null;
    }

    @Override
    public List<Evaluation> lister(Periode periode, Cours cours) {
        List<Evaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Evaluation> query = manager.createQuery("SELECT ev FROM Evaluation ev "
                    + " WHERE ev.periode.id = :id_periode AND ev.cours.id = :id_cours ORDER BY ev.type.id",
                    Evaluation.class);
            query.setParameter("id_periode", periode.getId());
            query.setParameter("id_cours", cours.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Evaluation> lister(TypeEvaluation type) {
        List<Evaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Evaluation> query = manager.createQuery("SELECT ev FROM Evaluation ev "
                    + " WHERE ev.type.id = :id_type ORDER BY ev.periode.id",
                    Evaluation.class);
            query.setParameter("id_type", type.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public List<Evaluation> lister(Periode periode, Classe classe) {
        List<Evaluation> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Evaluation> query = manager.createQuery("SELECT ev FROM Evaluation ev "
                    + " WHERE ev.periode.id = :id_periode AND ev.cours.classe.id = :id_classe ORDER BY ev.type.id",
                    Evaluation.class);
            query.setParameter("id_periode", periode.getId());
            query.setParameter("id_classe", classe.getId());
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

}
