/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.model.entity;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDate;
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
import gestionEcole.jpa.dao.I.IEvaluationDao;
import gestionEcole.jpa.dao.I.INoteDao;
import gestionEcole.jpa.dao.impl.EvaluationDaoImpl;
import gestionEcole.jpa.dao.impl.NoteDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "evaluations")
public class Evaluation implements Serializable {

    private static final IEvaluationDao evaluationDao = new EvaluationDaoImpl();
    private static final INoteDao noteDao = new NoteDaoImpl();
    //attributs 
    private static List<Evaluation> liste = getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Periode periode;

    @JoinColumn(name = "id_cours")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Cours cours;

    @Column(name = "bareme")
    private int bareme;

    @Column(name = "poids")
    private double poids; //pourcentage de pertinence d'une evaluation(sommmePoids =1) 
    //valeurs par defaut INTER = 0.1, DST = 0.4, EX = 0.5

    @Column(name = "date_ev")
    private LocalDate date;   //valeur par defaut == date locale courante

    @JoinColumn(name = "id_type")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private TypeEvaluation type;

    public Evaluation() {

    }

    public Evaluation(Periode periode, Cours cours, int bareme, double poids, TypeEvaluation type) {
        this.periode = periode;
        this.cours = cours;
        this.bareme = bareme;
        this.poids = poids;
        this.type = type;
    }
    //créer une evaluation avec 20 comme bareme par défaut

    public Evaluation(Periode periode, Cours cours, double poids, TypeEvaluation type) {
        this(periode, cours, 20, poids, type);
    }

    //méthodes de classes
    //retourne la liste des evaluations
    public static List<Evaluation> getListe() {
        liste = evaluationDao.lister();
        return liste;
    }

    public static List<Evaluation> getListe(TypeEvaluation type) {
        liste = evaluationDao.lister(type);
        return liste;
    }

    public static List<Evaluation> getListe(Classe classe) {
        liste = evaluationDao.lister(classe);
        return liste;
    }

    public static List<Evaluation> getListe(Cours cours) {
        liste = evaluationDao.lister(cours);
        return liste;
    }

    public static List<Evaluation> getListe(Periode periode) {
        liste = evaluationDao.lister(periode);
        return liste;
    }

    public static List<Evaluation> getListe(Periode periode, Cours cours) {
        liste = evaluationDao.lister(periode, cours);
        return liste;
    }

    public static Evaluation getInstance(Long id) {
        return evaluationDao.trouver(id);
    }

    //Autres méthodes
    //accesseurs
    //getters
    public Periode getPeriode() {
        return this.periode;
    }

    public Cours getCours() {
        return this.cours;
    }

    public int getBareme() {
        return this.bareme;
    }

    public double getPoids() {
        return this.poids;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public TypeEvaluation getType() {
        return this.type;
    }

    public Long getId() {
        return id;
    }

    //setters
    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public void setBareme(int bareme) {
        this.bareme = bareme;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(TypeEvaluation type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEmpty() {
        List<Note> listeN = Note.getListe(this);
        return listeN.isEmpty();
    }

    public void supprimerNote() {
        List<Note> listeN = Note.getListe(this);
        if (!listeN.isEmpty()) {
            for (Note note : listeN) {
                noteDao.supprimer(note);
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Evaluation other = (Evaluation) obj;
        return Objects.equals(this.id, other.id);
    }

    //affichage
    @Override
    public String toString() {
        return " Periode : " + this.periode.getLibelle() + " | Cours : " + this.cours.getLibelle() + " | Type : " + this.getType().getLibelle()
                + " , Bareme : " + this.bareme + " | Poids : " + this.poids;
    }

}
