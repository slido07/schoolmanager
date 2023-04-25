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
import gestionEcole.jpa.dao.I.ITypeEvaluationDao;
import gestionEcole.jpa.dao.impl.TypeEvaluationDaoImpl;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "type_evaluations")
public class TypeEvaluation implements Serializable {

    private static final ITypeEvaluationDao typeDao = new TypeEvaluationDaoImpl();
    //attributs
    private static List<TypeEvaluation> liste = getListe();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @Column(name = "code", length = 8)
    private String code; //INTER, DST, TP, EX

    //constructeurs
    public TypeEvaluation() {
    }

    public TypeEvaluation(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    //méthodes de classes
    //retourne la liste des typeEvaluations
    public static List<TypeEvaluation> getListe() {
        liste = typeDao.lister();
        return liste;
    }

    public static TypeEvaluation getInstance(Long id) {
        return typeDao.trouver(id);
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
        List<Evaluation> listeEv = Evaluation.getListe(this);
        return listeEv.isEmpty();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final TypeEvaluation other = (TypeEvaluation) obj;
        return Objects.equals(this.id, other.id);
    }

    //affichage
    @Override
    public String toString() {
        return "TypeEvaluation : " + this.getLibelle() + "\t|  Code : " + this.code;
    }

}
