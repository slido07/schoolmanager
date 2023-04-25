/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Enseignant;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListEnseignant extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListEnseignant(){
        initComponents(tab());
    }
    

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Enseignant> listeE = consultationC.getListeEnseignant();
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][4];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getNom();
            tab[i][2] = listeE.get(i).getPrenom();
            tab[i][3] = listeE.get(i).getId();
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "Nom", "Prénom", "Matricule"};
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, 
        };
        return types;
    }

    @Override
    public String label() {
        return "                                                              "
                + " LISTE DES ENSEIGNANTS DE L'ETABLISSEMENT ";
    }
    
}
