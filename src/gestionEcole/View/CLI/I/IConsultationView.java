/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.View.CLI.I;

import gestionEcole.model.entity.*;

/**
 *
 * @author HP
 */
public interface IConsultationView {
    //méthodes d'affichage des listes des différentes entités du système
    public void showNiveau();
    public void showClasse(Niveau niveau);
    public void showEleve(Classe classe);
    public void showMatiere();
    public void showPeriode();
    public void showEnseignant();
    public void showType();
    public void showEnseignement(Niveau niveau);
    public void showCours(Classe classe);
    public void showEvaluation(Periode periode, Cours cours);
    public void showNote(Periode periode, Classe classe);
    public void showNote(Periode periode, Cours cours);
    public void showNote(Periode periode, Cours cours, Eleve eleve);
    public void showEvaluationDate(Periode periode, Cours cours);
    
    //messages d'erreurs
    public void showErrorMsg();
    public void showCancelMsg();
    public void noticeEmptyList(String className);
    
    //question à l'utilisateur
    public char repeatAction();
    public char giveAnswer();
    
    //lecture du numéro de la liste choisi par l'utilisateur 
    public int getNumber();
    
}
