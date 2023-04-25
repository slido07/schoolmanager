/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Table;
import gestionEcole.jpa.dao.I.IEnseignantDao;
import gestionEcole.jpa.dao.impl.EnseignantDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "enseignants")
public class Enseignant extends Personne implements Serializable {

    public static final IEnseignantDao enseignantDao = new EnseignantDaoImpl();
    //attributs
    private static List<Enseignant> liste = getListe();

    //constructeurs
    public Enseignant() {
    }

    public Enseignant(String nom, String prenom) {
        super(nom, prenom);
    }

    //méthodes de classe
    //retourne la liste des enseignants
    public static List<Enseignant> getListe() {
        liste = enseignantDao.lister();
        return liste;
    }

    public static Enseignant getInstance(Long id) {
        return enseignantDao.trouver(id);
    }

    //Autres méthodes
    //getters
    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String getPrenom() {
        return this.prenom;
    }

    @Override
    public Long getId() {
        return id;
    }

    //setters
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        return Objects.equals(this.id, other.id);
    }

    //affichage
    @Override
    public String toString() {
        return "Nom : " + this.nom + " | Prenom : " + this.prenom + " | Numero : " + this.id;
    }

}
