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
import gestionEcole.jpa.dao.I.IMatiereDao;
import gestionEcole.jpa.dao.impl.MatiereDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "matieres")
public class Matiere implements Serializable {

    private static final IMatiereDao matiereDao = new MatiereDaoImpl();
    //attributs
    private static List<Matiere> liste = getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "code", length = 8)
    private String code; //fr, ang, etc...

    //constructeurs
    public Matiere() {
    }

    public Matiere(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    //méthodes de classes
    //retourne la liste des matieres
    public static List<Matiere> getListe() {
        liste = matiereDao.lister();
        return liste;
    }

    public static Matiere getInstance(Long id) {
        return matiereDao.trouver(id);
    }

    //Autres méthodes
    //accesseurs
    //getters
    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public String getCode() {
        return this.code;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEmpty() {
        List<Enseignement> listeE = Enseignement.getListe(this);
        return listeE.isEmpty();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Matiere other = (Matiere) obj;
        return Objects.equals(this.id, other.id);
    }

    //affichage
    @Override
    public String toString() {
        return "Code : " + this.code + "\t| Matiere : " + this.getLibelle();
    }

}
