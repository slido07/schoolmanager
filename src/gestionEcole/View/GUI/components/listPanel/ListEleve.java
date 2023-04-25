/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Eleve;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListEleve extends PanelListForm {
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    
    public ListEleve(){
        initComponents(tab());
    }
    
    public ListEleve(Classe classe){
        initComponents(tab(classe));
        this.getjLabel1().setText("                                      "
                + " LISTE DES ELEVES DE LA " + classe.getLibelle());
    }
    
    
    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Eleve> listeE = consultationC.getListeEleve();
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][6];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getNom();
            tab[i][2] = listeE.get(i).getPrenom();
            tab[i][3] = listeE.get(i).getId();
            tab[i][4] = listeE.get(i).getSexe();
            tab[i][5] = listeE.get(i).getClasse().getLibelle();
        }
        return tab;   
    }
    
    public final Object[][] tab(Classe classe) {
        if(classe == null){
            return null;
        }
        int cpt = 1;
        List<Eleve> listeE = consultationC.getListeEleve(classe);
        if(listeE.isEmpty()){
            return null;
        }
        final int N = listeE.size();
        Object [][] tab = new Object[N][6];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeE.get(i).getNom();
            tab[i][2] = listeE.get(i).getPrenom();
            tab[i][3] = listeE.get(i).getId();
            tab[i][4] = listeE.get(i).getSexe();
            tab[i][5] = listeE.get(i).getClasse().getLibelle();
        }
        return tab;   
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "   Nom    ", "        Prénom     ", "Matricule", "Sexe", "  Classe  "};
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, 
            java.lang.Character.class, java.lang.String.class
        };
        return types;
    }

    @Override
    public String label() {
        return "                                                              "
                + " LISTE DES ELEVES DE L'ETABLISSEMENT ";
    }

    
}
