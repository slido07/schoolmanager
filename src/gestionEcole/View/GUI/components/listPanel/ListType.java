/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.TypeEvaluation;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListType extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListType(){
        initComponents(tab());
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<TypeEvaluation> listeT = consultationC.getListeType();
        if(listeT.isEmpty()){
            return null;
        }
        final int N = listeT.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeT.get(i).getCode();
            tab[i][2] = listeT.get(i).getLibelle();
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
                + " LISTE DES TYPES D'EVALUATION DE L'ETABLISSEMENT ";
    }
    
}
