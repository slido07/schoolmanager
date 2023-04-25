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
import gestionEcole.jpa.dao.I.IPeriodeDao;
import gestionEcole.jpa.dao.impl.PeriodeDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "periodes")
public class Periode implements Serializable {

    private static final IPeriodeDao periodeDao = new PeriodeDaoImpl();
    //attributs
    private static List<Periode> liste = getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "libelle", length = 30)
    private String libelle;

    //constructeurs 
    public Periode() {
    }

    public Periode(String libelle) {
        this.libelle = libelle;
    }

    //méthodes de classes
    public static List<Periode> getListe() {
        liste = periodeDao.lister();
        return liste;
    }

    public static Periode getInstance(Long id) {
        return periodeDao.trouver(id);
    }

    //Autres méthodes
    //accesseurs
    //getters
    public String getLibelle() {
        return this.libelle;
    }

    public Long getId() {
        return this.id;
    }

    //moyenne générale d'un élève au cours d'une période
    public double getMoyenne(Eleve eleve) {
        double moyenne = 0;
        int somCoef = 0;
        List<Note> listeNotes = Note.getListe(this, eleve);
        if (!listeNotes.isEmpty()) {
            for (Note note : listeNotes) {
                moyenne += (note.getEvaluation().getCours().getMoyenne(this, eleve)
                        * note.getEvaluation().getCours().getEnseignement().getCoefficient());
                somCoef += note.getEvaluation().getCours().getEnseignement().getCoefficient();
            }
            moyenne /= somCoef;
        }
        return moyenne;
    }

    //moyenne générale dans un cours au cours d'une période 
    public double getMoyenne(Cours cours) {
        if (cours == null) {
            return 0;
        }
        double moyenne = 0;
        List<Eleve> listeEleves = Eleve.getListe(cours.getClasse());
        if (!listeEleves.isEmpty()) {
            for (Eleve eleve : listeEleves) {
                moyenne += cours.getMoyenne(this, eleve);
            }
            moyenne /= listeEleves.size();
        }
        return moyenne;
    }

    //moyenne générale de la classe pour une période
    public double getMoyenne(Classe classe) {
        if (classe == null) {
            return 0;
        }
        double moyenne = 0;
        List<Eleve> listeEleves = Eleve.getListe(classe);
        if (!listeEleves.isEmpty()) {
            for (Eleve eleve : listeEleves) {
                moyenne += this.getMoyenne(eleve);
            }
            moyenne /= listeEleves.size();
        }
        return moyenne;
    }

    //setters
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setNumero(Long id) {
        this.id = id;
    }

    public boolean isEmpty() {
        List<Evaluation> listeEv = Evaluation.getListe(this);
        return listeEv.isEmpty();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Periode other = (Periode) obj;
        return Objects.equals(this.id, other.id);
    }

    //affichage
    @Override
    public String toString() {
        return "Nom : " + this.getLibelle();
    }

}
