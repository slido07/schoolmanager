/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Note;
import gestionEcole.model.entity.Periode;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListNote extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListNote(){
        initComponents(tab());
    }
    
    public ListNote(Periode periode, Cours cours){
        initComponents(tab(periode, cours));
        this.getjLabel1().setText("                                    "
                + " LISTE DES NOTES DU " + periode.getLibelle() + " EN " + cours.getLibelle());
    }
    
    public ListNote(Periode periode, Cours cours, Eleve eleve){
        initComponents(tab(periode, cours, eleve));
        this.getjLabel1().setText("                                    "
                + " LISTE DES NOTES DE L'ELEVE " + eleve.getNom() + " " + eleve.getPrenom()+ " AU " + periode.getLibelle() 
                + " EN " + cours.getLibelle());
    }
    
    public ListNote(Evaluation ev){
        initComponents(tab(ev));
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Note> listeN = consultationC.getListeNote();
        if(listeN.isEmpty()){
            return null;
        }
        final int N = listeN.size();
        Object [][] tab = new Object[N][8];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeN.get(i).getEvaluation().getPeriode().getLibelle();
            tab[i][2] = listeN.get(i).getEleve().getId();
            tab[i][3] = listeN.get(i).getEleve().getNom();
            tab[i][4] = listeN.get(i).getEleve().getPrenom();
            tab[i][5] = listeN.get(i).getEvaluation().getCours().getLibelle();
            tab[i][6] = listeN.get(i).getEvaluation().getType().getLibelle();
            tab[i][7] = listeN.get(i).getValeur();
        }        
        return tab;
    }
    
    public final Object[][] tab(Periode periode, Cours cours) {
        int cpt = 1;
        List<Note> listeN = consultationC.getListeNote(periode, cours);
        if(listeN.isEmpty()){
            return null;
        }
        final int N = listeN.size();
        Object [][] tab = new Object[N][8];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeN.get(i).getEvaluation().getPeriode().getLibelle();
            tab[i][2] = listeN.get(i).getEleve().getId();
            tab[i][3] = listeN.get(i).getEleve().getNom();
            tab[i][4] = listeN.get(i).getEleve().getPrenom();
            tab[i][5] = listeN.get(i).getEvaluation().getCours().getLibelle();
            tab[i][6] = listeN.get(i).getEvaluation().getType().getLibelle();
            tab[i][7] = listeN.get(i).getValeur();
        }
        return tab;
    }
    
    public final Object[][] tab(Periode periode, Cours cours, Eleve eleve) {
        int cpt = 1;
        List<Note> listeN = consultationC.getListeNote(periode, eleve, cours);
        if(listeN.isEmpty()){
            return null;
        }
        final int N = listeN.size();
        Object [][] tab = new Object[N][8];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeN.get(i).getEvaluation().getPeriode().getLibelle();
            tab[i][2] = listeN.get(i).getEleve().getId();
            tab[i][3] = listeN.get(i).getEleve().getNom();
            tab[i][4] = listeN.get(i).getEleve().getPrenom();
            tab[i][5] = listeN.get(i).getEvaluation().getCours().getLibelle();
            tab[i][6] = listeN.get(i).getEvaluation().getType().getLibelle();
            tab[i][7] = listeN.get(i).getValeur();
        }
        return tab;
    }
    
    public final Object[][] tab(Evaluation ev){
        int cpt = 1;
        List<Note> listeN = consultationC.getListeNote(ev);
        if(listeN.isEmpty()){
            return null;
        }
        final int N = listeN.size();
        Object [][] tab = new Object[N][8];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeN.get(i).getEvaluation().getPeriode().getLibelle();
            tab[i][2] = listeN.get(i).getEleve().getId();
            tab[i][3] = listeN.get(i).getEleve().getNom();
            tab[i][4] = listeN.get(i).getEleve().getPrenom();
            tab[i][5] = listeN.get(i).getEvaluation().getCours().getLibelle();
            tab[i][6] = listeN.get(i).getEvaluation().getType().getLibelle();
            tab[i][7] = listeN.get(i).getValeur();
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "Période", "Matricule", "Nom", "Prénom", "Cours", "Type", "Note obtenue"};
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, 
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
        };
        return types;
    }

    @Override
    public String label() {
        return "                                                              "
                + " LISTE DES NOTES DE L'ETABLISSEMENT ";
    }
    
}
