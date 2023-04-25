/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.jpa.dao.impl;

import gestionEcole.model.entity.Niveau;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import gestionEcole.jpa.dao.I.INiveauDao;
import gestionEcole.jpa.util.HibernateSessionFactory;
import org.hibernate.SessionFactory;

/**
 *
 * @author HP
 */
public class NiveauDaoImpl implements INiveauDao {

    private EntityManager manager;
    
    public NiveauDaoImpl(){
        try{
            SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
            this.manager = sessionFactory.createEntityManager();
        }catch(Exception ex){
        }
        
    }
    
    @Override
    public Niveau ajouter(Niveau niveau) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(niveau);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            return null;
        }
        return niveau;
    }

    @Override
    public int supprimer(Niveau niveau) {       
        return supprimer(niveau.getId());
    }

    @Override
    public int supprimer(Long id) {
        int deletedCount =0;
        EntityTransaction transaction = manager.getTransaction();          
        try {
            transaction.begin();
            Query query = manager.createQuery("DELETE FROM Niveau n WHERE n.id = :id");
            deletedCount = query.setParameter("id", id).executeUpdate();
            transaction.commit();                
             } catch (Exception ex) {
                 transaction.rollback();
            }
        return deletedCount;
    }

    @Override
    public List<Niveau> lister() {
        List<Niveau> liste = new ArrayList<>();
        EntityTransaction transaction = manager.getTransaction();          
        try {
               transaction.begin();
               TypedQuery<Niveau> query = manager.createQuery("SELECT n FROM Niveau n ORDER BY n.id", Niveau.class);
               liste = query.getResultList();
               transaction.commit();
            } catch (Exception ex) {
               transaction.rollback();
        }
        return liste;
    }
    
    @Override
    public Niveau trouver(Long id){
        try {
                Niveau niveau = manager.find(Niveau.class, id);
                return niveau;
            } catch (Exception ex) {
            }
        return null;
    }

    @Override
    public int modifier(Niveau niveau) {
        int updatedCount = 0;
        EntityTransaction transaction = manager.getTransaction();
        try{
            Niveau n = manager.find(Niveau.class, niveau.getId());
            if(!niveau.getDescription().equals(n.getDescription())){
                transaction.begin();
                Query query = manager.createQuery("UPDATE Niveau n SET n.description = " + niveau.getDescription()
                + " WHERE n.id = :id");
                query.setParameter("id", niveau.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
            if(!niveau.getLibelle().equals(n.getLibelle())){
                transaction.begin();
                Query query = manager.createQuery("UPDATE Niveau n SET n.libelle = " + niveau.getLibelle()
                + " WHERE n.id = :id");
                query.setParameter("id", niveau.getId());
                updatedCount += query.executeUpdate();
                transaction.commit();
            }
        }catch(Exception e){
            transaction.rollback();
        }
        return updatedCount;
    }
        
}
