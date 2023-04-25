/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import gestionEcole.jpa.dao.I.INiveauDao;
import gestionEcole.jpa.dao.impl.NiveauDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "niveaux")
public class Niveau implements Serializable {

    private static final INiveauDao niveauDao = new NiveauDaoImpl(); //dao 
    //attributs
    private static List<Niveau> liste = getListe(); //- collection de  tous les niveaux

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "libelle", length = 10)
    private String libelle; //6e, 5e, 4e, 3e

    @Column(name = "description", length = 30)
    private String description;

    //constructeurs
    public Niveau() {
    }

    public Niveau(String libelle, Long id, String description) {
        this.libelle = libelle;
        this.id = id;
        this.description = description;
    }

    public Niveau(String libelle, String description) {
        this.libelle = libelle;
        this.description = description;
    }

    public Niveau(Niveau N) {
        this.libelle = N.libelle;
        this.id = N.id;
        this.description = N.description;
    }

    public Niveau(Long id) {
        this.id = id;
    }

    //Méthodes static
    //retourne la liste des niveaux
    public static List<Niveau> getListe() {
        liste = niveauDao.lister();
        return liste;
    }

    public static Niveau getInstance(Long id) {
        return niveauDao.trouver(id);
    }

    //autres méthodes
    //accesseurs
    //getters
    public String getLibelle() {
        return this.libelle;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    //setters
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Niveau other = (Niveau) obj;
        return Objects.equals(this.id, other.id);
    }

    public boolean isEmpty() {  //vérifie si aucune classe n'est enregistrée à ce niveau
        List<Classe> listeClasses = Classe.getListe(this);
        return listeClasses.isEmpty();
    }

    //affichage d'un niveau
    @Override
    public String toString() {
        return "Libelle: " + this.libelle + "\t| Description: " + this.description + "\t| Numero:  " + this.id;
    }

}
