/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.Controller.GUI.I;

import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Niveau;

/**
 *
 * @author HP
 */
public interface IAjoutControllerGUI {
    public void addNiveau(String libelle, String description);
    public void addClasse();
    public void addEleve();
    public void addPeriode(String libelle);
    public void addMatiere(String code, String libelle);
    public void addType(String code, String libelle);
    public void addEnseignant(String nom, String prenom);
    public void addEnseignement();
    public void addEnseignement(Matiere matiere, Niveau niveau);
    public void addCours();
    public void addEvaluation();
    public void addNote();
    
}
