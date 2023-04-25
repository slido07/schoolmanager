/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.View.CLI.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Niveau;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public interface IAjoutView {
    //messages à l'utilisateurs 
    public void showSucessMsg();
    public void showCancelMsg();
    public void showErrorMsg();
    public void showAddNiveauMsg();
    public void showAddClasseMsg();
    public void showAddEleveMsg();
    public void showAddEnseignantMsg();
    public void showEnseignantChoice();
    public void showCoeffChoice();
    public void showAddMatiereMsg();
    public void showAddTypeMsg();
    public void showAddEnseignementMsg(Niveau niveau, Matiere matiere);
    public void showAddCoursMsg(Enseignement enseignement, Classe classe);
    public void showAddPeriodeMsg();
    public void showAddEvaluationMsg();
    public void showAddNoteMsg(Eleve eleve);
    public char repeatAction();
    public char giveAnswer();
    public void alreadyDoneAction();
    
    //méthodes de lecture de données
    public int inputCoefficient();
    public int inputBareme();
    public double inputPoids();
    public double inputValeur();
    public String inputLibelle();
    public String inputDescription();
    public String inputSubdivision();
    public char inputSexe();
    public String inputNom();
    public String inputPrenom();
    public String inputCode();
    public LocalDate inputDate();
    
    
}
