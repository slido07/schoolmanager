/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListCours extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListCours(){
        initComponents(tab());
    }
    
    public ListCours(Classe classe){
        initComponents(tab(classe));
        this.getjLabel1().setText("                                   "
                + " LISTE DES COURS DE LA " + classe.getLibelle());
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Cours> listeC = consultationC.getListeCours();
        if(listeC.isEmpty()){
            return null;
        }
        final int N = listeC.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeC.get(i).getLibelle();
            tab[i][2] = listeC.get(i).getEnseignement().getCoefficient();
        }
        return tab;
    }
    
    public final Object[][] tab(Classe classe) {
        if(classe == null){
            return null;
        }
        int cpt = 1;
        List<Cours> listeC = consultationC.getListeCours(classe);
        if(listeC.isEmpty()){
            return null;
        }
        final int N = listeC.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeC.get(i).getLibelle();
            tab[i][2] = listeC.get(i).getEnseignement().getCoefficient();
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "     Libellé     ", "Coefficient"};
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
                + " LISTE DES COURS DE L'ETABLISSEMENT ";
    }
    
}
