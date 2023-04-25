/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.Controller.CLI.I;

import gestionEcole.model.entity.*;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IConsultationControllerCLI {   
    //listes des différents entités enregistrées dans la base de données
    public List<Niveau> getListeNiveau();
    public List<Classe> getListeClasse();
    public List<Classe> getListeClasse(Niveau niveau);
    public List<Eleve> getListeEleve();
    public List<Eleve> getListeEleve(Niveau niveau);
    public List<Eleve> getListeEleve(Classe classe);
    public List<Enseignant> getListeEnseignant();
    public List<Periode> getListePeriode();
    public List<Matiere> getListeMatiere();
    public List<TypeEvaluation> getListeType();
    public List<Enseignement> getListeEnseignement();
    public List<Enseignement> getListeEnseignement(Niveau niveau);
    public List<Cours> getListeCours();
    public List<Cours> getListeCours(Classe classe);
    public List<Evaluation> getListeEvaluation();
    public List<Evaluation> getListeEvaluation(Periode periode);
    public List<Evaluation> getListeEvaluation(Cours cours);
    public List<Evaluation> getListeEvaluation(Classe classe);
    public List<Evaluation> getListeEvaluation(Periode periode, Cours cours);
    public List<Note> getListeNote();
    public List<Note> getListeNote(Evaluation evaluation);
    public List<Note> getListeNote(Periode periode, Eleve eleve);
    public List<Note> getListeNote(Periode periode, Cours cours);
    public List<Note> getListeNote(Periode periode, Eleve eleve, Cours cours);
    
    //getters des éléments de cette liste
    public Niveau getNiveau();
    public Classe getClasse(Niveau niveau);
    public Eleve getEleve(Classe classe);
    public Enseignant getEnseignant();
    public Enseignement getEnseignement(Niveau niveau);
    public Cours getCours(Classe classe);
    public Evaluation getEvaluation(Periode periode, Cours cours);
    public Periode getPeriode();
    public Matiere getMatiere();
    public TypeEvaluation getType();
    public Note getNote(Periode periode, Cours cours, Eleve eleve);
    
    //controlleurs de données
    public Niveau controlNiveau();
    public Periode controlPeriode();
    public Matiere controlMatiere();
    public TypeEvaluation controlType();
    public Classe controlClasse(Niveau niveau);
    public Eleve controlEleve(Classe classe);
    public Enseignant controlEnseignant();
    public Enseignement controlEnseignement(Niveau niveau);
    public Cours controlCours(Classe classe);
    public Evaluation controlEvaluation(Periode periode, Cours cours);
    public Note controlNote(Periode periode,Eleve eleve ,Cours cours);
    
    //controlleur principal
    public void controller();    
    
}
