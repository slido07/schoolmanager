/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Niveau;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListEnseignement extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListEnseignement(){
        initComponents(tab());
    }
    
    public ListEnseignement(Niveau niveau){
        initComponents(tab(niveau));
        this.getjLabel1().setText("                               "
                + " LISTE DES ENSEIGNEMENTS DE LA " + niveau.getLibelle());
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Enseignement> listeE = consultationC.getListeEnseignement();
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getLibelle();
            tab[i][2] = listeE.get(i).getCoefficient();
        }
        return tab;
    }
    
    public final Object[][] tab(Niveau niveau) {
        int cpt = 1;
        List<Enseignement> listeE = consultationC.getListeEnseignement(niveau);
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getLibelle();
            tab[i][2] = listeE.get(i).getCoefficient();
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "Libellé", "Coefficient"};
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
        };
        return types;
    }

    @Override
    public String label() {
        return "                                                              "
                + " LISTE DES ENSEIGNEMENTS DE L'ETABLISSEMENT ";
    }
    
}
