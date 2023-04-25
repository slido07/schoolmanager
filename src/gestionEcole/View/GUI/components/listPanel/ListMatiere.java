/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Matiere;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListMatiere extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListMatiere(){
        initComponents(tab());
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Matiere> listeM = consultationC.getListeMatiere();
        if(listeM.isEmpty()){
            return null;
        }
        final int N = listeM.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeM.get(i).getCode();
            tab[i][2] = listeM.get(i).getLibelle();
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "Code", "Libellé"};
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class
        };
        return types;
    }

    @Override
    public String label() {
        return "                                                              "
                + " LISTE DES MATIERES DE L'ETABLISSEMENT ";
    }
    
}
