/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.Controller.CLI.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Niveau;

/**
 *
 * @author HP
 */
public interface IAjoutControllerCLI {
    public void addNiveau();
    public void addClasse();
    public void addEleve();
    public void addPeriode();
    public void addMatiere();
    public void addType();
    public void addEnseignant();
    public void addEnseignement();
    public void addEnseignement(Matiere matiere, Niveau niveau);
    public void addCours();
    public void addCours(Enseignement enseignement, Classe classe);
    public void addEvaluation();
    public void addNote();
    public void controller();
}
