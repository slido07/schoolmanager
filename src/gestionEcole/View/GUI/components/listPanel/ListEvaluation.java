/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Periode;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListEvaluation extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListEvaluation(){
        initComponents(tab());
    }
    
    public ListEvaluation(Periode periode, Cours cours){
        initComponents(tab(periode, cours));
        this.getjLabel1().setText("                                "
                + " LISTE DES EVALUATIONS DU " + periode.getLibelle() + " EN " + cours.getLibelle());
    }  
    
    public ListEvaluation(Classe classe){
        initComponents(tab(classe));
        this.getjLabel1().setText("                                "
                + " LISTE DES EVALUATIONS DE LA " + classe.getLibelle());
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Evaluation> listeE = consultationC.getListeEvaluation();
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][7];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getPeriode().getLibelle();           
            tab[i][2] = listeE.get(i).getCours().getLibelle();
            tab[i][3] = listeE.get(i).getType().getLibelle();
            tab[i][4] = listeE.get(i).getBareme();
            tab[i][5] = listeE.get(i).getPoids();
            tab[i][6] = listeE.get(i).getDate();
        }
        return tab;
    }
    
    public final Object[][] tab(Periode periode, Cours cours) {
        if(periode == null){
            return null;
        }
        if(cours == null){
            return null;
        }
        int cpt = 1;
        List<Evaluation> listeE = consultationC.getListeEvaluation(periode, cours);
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][7];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getPeriode().getLibelle();           
            tab[i][2] = listeE.get(i).getCours().getLibelle();
            tab[i][3] = listeE.get(i).getType().getLibelle();
            tab[i][4] = listeE.get(i).getBareme();
            tab[i][5] = listeE.get(i).getPoids();
            tab[i][6] = listeE.get(i).getDate();
        }
        return tab;
    }
    
    public final Object[][] tab(Classe classe){
        if(classe == null){
            return null;
        }
        int cpt = 1;
        List<Evaluation> listeE = consultationC.getListeEvaluation(classe);
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][7];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getPeriode().getLibelle();           
            tab[i][2] = listeE.get(i).getCours().getLibelle();
            tab[i][3] = listeE.get(i).getType().getLibelle();
            tab[i][4] = listeE.get(i).getBareme();
            tab[i][5] = listeE.get(i).getPoids();
            tab[i][6] = listeE.get(i).getDate();
        }
        return tab;     
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "Période", "Cours", "Type", "Barème", "Poids", "Date"};
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, 
            java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.time.LocalDate.class
        };
        return types;
    }

    @Override
    public String label() {
        return "                                                              "
                + " LISTE DES EVALUATIONS DE L'ETABLISSEMENT ";
    }
    
}
