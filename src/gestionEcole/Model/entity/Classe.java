/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import gestionEcole.jpa.dao.I.IClasseDao;
import gestionEcole.jpa.dao.impl.ClasseDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "classes")
public class Classe implements Serializable {

    private static final IClasseDao classeDao = new ClasseDaoImpl();
    //attributs
    private static List<Classe> liste = getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "subdivision", length = 4)
    private String subdivision; //A, B, C etc...

    @JoinColumn(name = "id_niveau")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Niveau niveau;

    //constructeurs
    public Classe() {
    }

    public Classe(Niveau niveau, String subdivision) {
        this.niveau = niveau;
        this.subdivision = subdivision;
    }

    public Classe(Classe classe) {
        this.subdivision = classe.subdivision;
        this.niveau = classe.niveau;
    }

    /*Méthodes de classe */
    //retourne la liste des classes
    public static List<Classe> getListe() {
        liste = classeDao.lister();
        return liste;
    }

    public static List<Classe> getListe(Niveau niveau) {
        liste = classeDao.lister(niveau);
        return liste;
    }

    public static Classe getInstance(Long id) {
        return classeDao.trouver(id);
    }

    /* Autres méthodes d'instance */
    //getters
    public Long getId() {
        return id;
    }

    public Niveau getNiveau() {
        return this.niveau;
    }

    public String getSubdivision() {
        return this.subdivision;
    }

    public String getLibelle() {    //6eA, 5eB etc.....
        return this.niveau.getLibelle() + this.subdivision;
    }
    //setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Nom: " + this.getLibelle();
    }

    public boolean isEmpty() {
        List<Eleve> listeEleve = Eleve.getListe(this);
        return listeEleve.isEmpty();
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
        final Classe other = (Classe) obj;
        return Objects.equals(this.id, other.id);
    }

}
