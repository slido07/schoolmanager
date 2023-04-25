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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import gestionEcole.jpa.dao.I.IEleveDao;
import gestionEcole.jpa.dao.I.IEvaluationDao;
import gestionEcole.jpa.dao.I.INoteDao;
import gestionEcole.jpa.dao.impl.EleveDaoImpl;
import gestionEcole.jpa.dao.impl.EvaluationDaoImpl;
import gestionEcole.jpa.dao.impl.NoteDaoImpl;

/**
 *
 * @author HP
 */

@Entity
@Table(name = "eleves")
public class Eleve extends Personne implements Serializable {

    public static final IEleveDao eleveDao = new EleveDaoImpl();
    public static final IEvaluationDao evaluationDao = new EvaluationDaoImpl();
    public static final INoteDao noteDao = new NoteDaoImpl();
    //attributs
    private static List<Eleve> liste = getListe();

    @Column(name = "sexe", length = 1)
    private char sexe;  //"M" ou "F"

    @JoinColumn(name = "id_classe")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private Classe classe;

    //constructeurs
    public Eleve() {
    }

    public Eleve(String nom, String prenom, char sexe, Classe classe) {
        super(nom, prenom);
        this.sexe = sexe;
        this.classe = classe;
    }

    //méthodes de classe
    //retourne la liste des élèves
    public static List<Eleve> getListe() {
        liste = eleveDao.lister();
        return liste;
    }

    public static List<Eleve> getListe(Classe classe) {
        liste = eleveDao.lister(classe);
        return liste;
    }

    public static List<Eleve> getListe(Niveau niveau) {
        liste = eleveDao.lister(niveau);
        return liste;
    }

    public static Eleve getInstance(Long id) {
        return eleveDao.trouver(id);
    }

    //calculer l'effectif des élèves dans une classe
    public static int getEffectif(Classe classe) {
        if (classe == null) {
            return 0;
        }
        int effectif = getListe(classe).size();
        return effectif;
    }

    //autres méthodes        
    //retourne le rang d'un élève dans sa classe au cours d'une période
    public int getRang(Periode periode) {
        if (periode == null) {
            return 0;
        }
        List<Eleve> listeE = getListe(this.classe);
        if (listeE.isEmpty()) {
            return 0;
        }
        final int N = listeE.size();
        double tRangs[] = new double[N];
        for (int i = 0; i < N; i++) {
            //on remplit le tableau avec les moyennes de tous les élèves de cette classe
            tRangs[i] = periode.getMoyenne(listeE.get(i));
        }
        //on trie ensuite le tableau dans l'ordre décroissant
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (tRangs[j] < tRangs[i]) {
                    double tmp = tRangs[j];
                    tRangs[j] = tRangs[i];
                    tRangs[i] = tmp;
                }
            }
        }
        //on recherche ensuite le rang de l'élève
        for (int i = 0; i < N; i++) {
            if (periode.getMoyenne(this) == tRangs[i]) {
                int j = i + 1;
                return j;
            }
        }
        //si la moyenne de l'élève n'existe pas encore on retourne 0
        return 0;
    }

    //retourne le rang de l'élève dans un cours donné au cours d'une période
    public int getRang(Periode periode, Cours cours) {
        if (periode == null) {
            return 0;
        }
        if (cours == null) {
            return 0;
        }
        List<Eleve> listeE = getListe(this.classe);
        if (listeE.isEmpty()) {
            return 0;
        }
        final int N = listeE.size();
        double tRangs[] = new double[N];

        for (int i = 0; i < N; i++) {
            //on remplit le tableau avec les moyennes de tous les élèves de cette classe dans l'enseignement spécifié en paramètre
            tRangs[i] = cours.getMoyenne(periode, listeE.get(i));
        }
        //on trie ensuite le tableau dans l'ordre décroissant
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (tRangs[j] < tRangs[i]) {
                    double tmp = tRangs[j];
                    tRangs[j] = tRangs[i];
                    tRangs[i] = tmp;
                }
            }
        }
        //on recherche ensuite le rang de l'élève
        for (int i = 0; i < N; i++) {
            if (cours.getMoyenne(periode, this) == tRangs[i]) {
                int j = i + 1;
                return j;
            }
        }
        //si la moyenne de l'élève n'existe pas encore on retourne 0
        return 0;
    }

    public void supprimerNote() { //suppression de toutes les notes d'un élève
        List<Note> listeNotes = Note.getListe();
        if (!listeNotes.isEmpty()) {
            for (Note note : listeNotes) {
                if (note.getEleve().equals(this)) {
                    noteDao.supprimer(note);
                }
            }
        }
    }

    //retourn un boolean sur l'obtenabilité du bulletin de l'élève
    public boolean isBulletinObtainable(Periode periode) {
        //chargement de toutes les évaluations de la classe de l'élève pour la période
        List<Evaluation> listeEv = evaluationDao.lister(periode, this.classe);
        if (listeEv.isEmpty()) {
            return false;
        }
        for (Evaluation evaluation : listeEv) {
            if (noteDao.lister(evaluation, this).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    //acesseurs
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

    public char getSexe() {
        return this.sexe;
    }

    public Classe getClasse() {
        return this.classe;
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

    //setters
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
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
        return "Nom : " + this.nom + " | Prenom : " + this.prenom + " | Matricule : " + this.id
                + " | Sexe : " + this.sexe + " | Classe : " + this.classe.getLibelle();
    }

}
