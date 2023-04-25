/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.View.CLI.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Niveau;

/**
 *
 * @author HP
 */
public interface ISuppressionView {
    
    public void showDelNiveauMsg();
    public void showDelClasseMsg();
    public void showDelClasseMsg(Niveau niveau);
    public void showDelEleveMsg();
    public void showDelEleveMsg(Classe classe);
    public void showDelEnseignantMsg();
    public void showDelMatiereMsg();
    public void showDelEnseignementMsg();
    public void showDelCoursMsg();
    public void showDelPeriodeMsg();
    public void showDelEvaluationMsg();
    public void showDelTypeMsg();
    public void showDelNoteMsg();
    
    public char showWarningMsgDelNiveau();
    public char showWarningMsgDelClasse();
    public char showWarningMsgDelClasse(Niveau niveau);
    public char showWarningMsgDelEleve();
    public char showWarningMsgDelEleve(Classe classe);
    
    public void showDelNiveauExitMsg();
    public void showDelClasseExitMsg();
    public void showDelClasseExitMsg(Classe classe);
    public void showDelMatiereExitMsg();
    public void showDelPeriodeExitMsg();
    public void showDelTypeExitMsg();
    public void showDelCoursExitMsg();
    public void showDelEnseignementExitMsg();
    
    public char pursueOperation();
    public char giveAnswer();
    
    public void showSucessMsg();
    public void showCancelMsg();   
    
}
