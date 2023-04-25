/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Enseignant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.IEnseignantDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class EnseignantDaoImpl implements IEnseignantDao {
    
    private  EntityManager manager;

    public EnseignantDaoImpl() {
        try{
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        this.manager = sessionFactory.createEntityManager();
        }catch(Exception ex){
        }
    }


    @Override
    public Enseignant ajouter(Enseignant enseignant) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(enseignant);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return enseignant;

    }

    @Override
    public int supprimer(Enseignant enseignant) {        
        return supprimer(enseignant.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Enseignant e WHERE e.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return deletedCount;
    }

    @Override
    public int modifier(Enseignant enseignant) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try {
            //on récupère l'élève concerné
            Enseignant ens = manager.find(Enseignant.class, enseignant.getId());
            //si les noms sont différents on fait une màj
            if (!enseignant.getNom().equals(ens.getNom())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Enseignant ens SET ens.nom = " + enseignant.getNom() + 
                        " WHERE ens.id = :id");
                query.setParameter("id", enseignant.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            //on fait de même pour le prénom
            if (!enseignant.getPrenom().equals(ens.getPrenom())) {
                transaction.begin();
                Query query = manager.createQuery("UPDATE Enseignant ens SET ens.prenom = " + enseignant.getPrenom() + 
                        " WHERE ens.id = :id");
                query.setParameter("id", enseignant.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
        } catch (Exception ex) {
            transaction.rollback();
        }
        return updatedCount;
    }

    @Override
    public List<Enseignant> lister() {
        List<Enseignant> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            TypedQuery<Enseignant> query = manager.createQuery("SELECT ens FROM Enseignant ens ORDER BY ens.id", 
                    Enseignant.class);
            liste = query.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
        return liste;
    }

    @Override
    public Enseignant trouver(Long id) {
        try {
                Enseignant enseignant = manager.find(Enseignant.class, id);
                return enseignant;
            } catch (Exception ex) {
            }
        return null;
    }
    
}
