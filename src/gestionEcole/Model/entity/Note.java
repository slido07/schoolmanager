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
import gestionEcole.jpa.dao.I.INoteDao;
import gestionEcole.jpa.dao.impl.NoteDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "notes")
public class Note implements Serializable {

    private static final INoteDao noteDao = new NoteDaoImpl();
    //attributs
    private static List<Note> liste = Note.getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "id_evaluation")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Evaluation evaluation;

    @JoinColumn(name = "id_eleve")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Eleve eleve;

    @Column(name = "valeur")
    private double valeur;

    //constructeurs
    public Note() {
    }

    public Note(Evaluation evaluation, Eleve eleve, double valeur) {
        this.evaluation = evaluation;
        this.eleve = eleve;
        this.valeur = valeur;
    }

    //méthodes de classes
    //retourne la liste des notes de l'etablissement
    public static List<Note> getListe() {
        liste = noteDao.lister();
        return liste;
    }

    //liste des notes d'un enseignement donné pour un élève
    public static double[] getTabType(Periode periode, Enseignement enseignement, Eleve eleve) {
        //faire en sorte de regrouper les notes en fonctions des types d'évaluation
        List<TypeEvaluation> listeT = TypeEvaluation.getListe();
        if (listeT.isEmpty()) {
            return null;
        }
        final int N = listeT.size();
        List<Note> listeN = noteDao.lister(periode, enseignement, eleve);
        double[] tabNote = new double[N];
        if (listeN.isEmpty()) {
            return null;
        }
        double moyenneT = 0;
        int cpt = 0;
        //pour un type de la liste on parcours toutes les notes de l'élève puis on fait leur moyenne pour ce type 
        for (int i = 0; i < N; i++) {
            for (Note n : listeN) {
                if (n.getEvaluation().getType().equals(listeT.get(i))) {
                    moyenneT += n.getValeur();
                    cpt++;
                }
            }
            moyenneT /= cpt;
            tabNote[i] = moyenneT;
            moyenneT = 0;
            cpt = 0;
        }
        return tabNote;
    }

    public static List<Note> getListe(Periode periode, Eleve eleve) {
        liste = noteDao.lister(periode, eleve);
        return liste;
    }

    public static List<Note> getListe(Periode periode, Eleve eleve, Cours cours) {
        liste = noteDao.lister(periode, eleve, cours);
        return liste;
    }

    public static List<Note> getListe(Evaluation evaluation) {
        liste = noteDao.lister(evaluation);
        return liste;
    }

    public static List<Note> getListe(Periode periode, Cours cours) {
        liste = noteDao.lister(periode, cours);
        return liste;
    }

    public static List<Note> getListe(Periode periode, Cours cours, Eleve eleve) {
        liste = noteDao.lister(periode, cours, eleve);
        return liste;
    }

    public static Note getInstance(Long id) {
        return noteDao.trouver(id);
    }

    //méthodes de saisie des valeurs au clavier
    //Autres méthodes
    //accesseurs
    //getters
    public Long getId() {
        return id;
    }

    public Evaluation getEvaluation() {
        return this.evaluation;
    }

    public Eleve getEleve() {
        return this.eleve;
    }

    public double getValeur() {
        return this.valeur;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Note other = (Note) obj;
        return Objects.equals(this.id, other.id);
    }

    //affichage
    @Override
    public String toString() {
        return " Periode : " + this.evaluation.getPeriode().getLibelle() + "  \t| Cours : " + this.evaluation.getCours().getLibelle() + " , Type : " + this.evaluation.getType().getLibelle()
                + " \t| Eleve : " + this.eleve.getNom() + " " + this.eleve.getPrenom() + " , matricule " + this.eleve.getId() + "  \t| Note obtenue : "
                + this.valeur + "/" + this.evaluation.getBareme();
    }

}
