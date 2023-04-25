/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.Controller.CLI.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Niveau;

/**
 *
 * @author HP
 */
public interface ISuppressionControllerCLI {
    public void delNiveau();
    public void delClasse();
    public void delClasse(Niveau niveau);
    public void delEleve();
    public void delEleve(Classe classe);
    public void delPeriode();
    public void delMatiere();
    public void delType();
    public void delEnseignant();
    public void delEnseignement();
    public void delCours();
    public void delEvaluation();
    public void controller();
}
