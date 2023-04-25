/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import gestionEcole.jpa.dao.I.ICoursDao;
import gestionEcole.jpa.dao.impl.CoursDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "cours")
public class Cours implements Serializable {

    private static final ICoursDao coursDao = new CoursDaoImpl();
    //attributs
    private static List<Cours> liste = getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "id_enseignement")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Enseignement enseignement;

    @JoinColumn(name = "id_classe")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Classe classe;

    @JoinColumn(name = "id_enseignant")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Enseignant enseignant;

    //constructeurs
    public Cours() {
    }

    public Cours(Enseignement enseignement, Classe classe, Enseignant enseignant) {
        this.enseignement = enseignement;
        this.classe = classe;
        this.enseignant = enseignant;
    }

    //créer un cours sans enseignant
    public Cours(Enseignement enseignement, Classe classe) {
        this(enseignement, classe, null);
    }

    //méthodes de classe
    //retourne la liste des cours
    public static List<Cours> getListe() {
        liste = coursDao.lister();
        return liste;
    }

    public static List<Cours> getListe(Enseignement enseignement) {
        liste = coursDao.lister(enseignement);
        return liste;
    }

    public static List<Cours> getListe(Classe classe) {
        liste = coursDao.lister(classe);
        return liste;
    }

    public static Cours getInstance(Long id) {
        return coursDao.trouver(id);
    }

    //autres méthodes
    //getters
    public Long getId() {
        return id;
    }

    public Enseignement getEnseignement() {
        return this.enseignement;
    }

    public Classe getClasse() {
        return this.classe;
    }

    public Enseignant getEnseignant() {
        return this.enseignant;
    }

    //retourne le libelle du cours former du code matiere et du libelle de la classe
    public String getLibelle() {
        return this.getEnseignement().getMatiere().getCode() + " " + this.classe.getLibelle();
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setEnseignement(Enseignement enseignement) {
        this.enseignement = enseignement;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public boolean isEmpty() {
        List<Evaluation> listeC = Evaluation.getListe(this);
        return listeC.isEmpty();
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
        final Cours other = (Cours) obj;
        return Objects.equals(this.id, other.id);
    }

    //affichage
    @Override
    public String toString() {
        return "Nom : " + this.getLibelle();
    }

    //retourne la moyenne de l'élève pour une période donnée dans un cours donné
    public double getMoyenne(Periode periode, Eleve eleve) {
        if (periode == null) {
            return 0;
        }
        if (eleve == null) {
            return 0;
        }
        double moyenne = 0;
        List<Note> listeNotes = Note.getListe(periode, eleve, this);
        if (!listeNotes.isEmpty()) {
            for (Note n : listeNotes) {
                moyenne += (n.getValeur() * n.getEvaluation().getPoids());
            }
        }
        //pour l'enseignement donné
        //pour l'eleve donné
        return moyenne;
    }
}
