/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.listPanel;

import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Niveau;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ListClasse extends PanelListForm {
    
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
        
    public ListClasse(){
        initComponents(tab());
    }
    
    public ListClasse(Niveau niveau){
        initComponents(tab(niveau));
        this.getjLabel1().setText("                                       "
                + " LISTE DES CLASSES DE LA " + niveau.getLibelle());
    }

    @Override
    public final Object[][] tab() {
        int cpt = 1;
        List<Classe> listeC = consultationC.getListeClasse();
        if(listeC.isEmpty()){
            return null;
        }
        final int N = listeC.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeC.get(i).getNiveau().getLibelle();
            tab[i][2] = listeC.get(i).getSubdivision();
        }
        return tab;
    }
    
    public final Object[][] tab(Niveau niveau) {
        int cpt = 1;
        if(niveau == null){
            return null;
        }
        List<Classe> listeC = consultationC.getListeClasse(niveau);
        if(listeC.isEmpty()){
            return null;
        }
        final int N = listeC.size();
        Object [][] tab = new Object[N][3];
        
        for(int i =0; i < N; i++){
            tab[i][0] = cpt++;
            tab[i][1] = listeC.get(i).getNiveau().getLibelle();
            tab[i][2] = listeC.get(i).getSubdivision();
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        String[] titres = new String[]{"Numéro", "     Niveau     ", "Subdivision"};
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
                + " LISTE DES CLASSES DE L'ETABLISSEMENT ";
    }
    
}
