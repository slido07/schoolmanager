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
import gestionEcole.jpa.dao.I.IEnseignementDao;
import gestionEcole.jpa.dao.impl.EnseignementDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "enseignements")
public class Enseignement implements Serializable {

    private static final IEnseignementDao enseignementDao = new EnseignementDaoImpl();

    private static List<Enseignement> liste = getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "id_matiere")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Matiere matiere;

    @JoinColumn(name = "id_niveau")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Niveau niveau;

    @Column(name = "coefficient")
    private int coefficient;

    //constructeurs
    public Enseignement() {
    }

    public Enseignement(Matiere matiere, Niveau niveau, int coefficient) {
        this.matiere = matiere;
        this.niveau = niveau;
        this.coefficient = coefficient;
    }

    //crée un enseignement sans spécifier le coefficient qui prendra 2 comme valeur par défaut  
    public Enseignement(Matiere matiere, Niveau niveau) {
        this(matiere, niveau, 2);
    }

    //méthodes de classes
    //retourne la liste des enseignements
    public static List<Enseignement> getListe() {
        liste = enseignementDao.lister();
        return liste;
    }

    public static List<Enseignement> getListe(Matiere matiere) {
        liste = enseignementDao.lister(matiere);
        return liste;
    }

    public static List<Enseignement> getListe(Niveau niveau) {
        return enseignementDao.lister(niveau);
    }

    public static Enseignement getInstance(Long id) {
        return enseignementDao.trouver(id);
    }

    //Autres méthodes
    //accesseurs
    //getters
    public Long getId() {
        return id;
    }

    public Matiere getMatiere() {
        return this.matiere;
    }

    public Niveau getNiveau() {
        return this.niveau;
    }

    public int getCoefficient() {
        return this.coefficient;
    }

    public String getLibelle() {
        return this.matiere.getCode() + " " + this.niveau.getLibelle();
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public boolean isEmpty() {
        List<Cours> listeCours = Cours.getListe(this);
        return listeCours.isEmpty();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Enseignement other = (Enseignement) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    //affichage
    @Override
    public String toString() {
        return "Nom : " + this.getLibelle() + "\t| Coefficient : " + this.coefficient;
    }

}
