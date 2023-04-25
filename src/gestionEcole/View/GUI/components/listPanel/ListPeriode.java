/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Periode;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListPeriode extends PanelListForm {
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();

    
    public ListPeriode(){
        initComponents(tab());
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Periode> listeP = consultationC.getListePeriode();
        if(listeP.isEmpty()){
            return null;
        }
        final int N = listeP.size();
        Object [][] tab = new Object[N][2];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeP.get(i).getLibelle();
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "Libellé"};
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class
        };
        return types;
    }

    @Override
    public String label() {
        return "                                                              "
                + " LISTE DES PERIODES DE L'ETABLISSEMENT ";
    }
    
}
