/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.bulletin;

import gestionEcole.Controller.GUI.I.IConsultationControllerGUI;
import gestionEcole.Controller.GUI.impl.ConsultationControllerGUIImpl;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Note;
import gestionEcole.model.entity.Periode;
import gestionEcole.model.entity.TypeEvaluation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class Bulletin extends AbstractPanelBulletin {

    private Periode periode;
    private Eleve eleve;
    private static final IConsultationControllerGUI consultC = new ConsultationControllerGUIImpl();

    public Bulletin() {
        initComponents(tab());
    }

    public Bulletin(Periode periode, Eleve eleve) {
        this.periode = periode;
        this.eleve = eleve;
        initComponents(tab());
    }

    @Override
    final public Object[][] tab() {
        List<Note> listeN;
        if (eleve == null) {
            return null;
        }
        if (periode == null) {
            return null;
        }
        //liste des cours
        List<Cours> listeC = consultC.getListeCours(eleve.getClasse());
        if (listeC.isEmpty()) {
            return null;
        }
        List<TypeEvaluation> listeT = consultC.getListeType();
        if (listeT.isEmpty()) {
            return null;
        }
        final int nLine = 5 + listeT.size(); //8 de base
        final int nColumn = listeC.size();
        Object[][] tab = new Object[nLine][nColumn];

        for (int i = 0; i < nLine; i++) {
            //liste des notes du cours
            listeN = consultC.getListeNote(periode, eleve, listeC.get(i));
            tab[i][0] = listeC.get(i).getLibelle(); //libelle du cours
            //notes par types  (3)              
            tab[i][1] = listeN.get(0).getValeur();
            tab[i][2] = listeN.get(1).getValeur();
            tab[i][3] = listeN.get(2).getValeur();
            //suite
            tab[i][4] = listeC.get(i).getEnseignement().getCoefficient();
            tab[i][5] = doubleFormat(listeC.get(i).getMoyenne(periode, eleve));
            tab[i][6] = rang(eleve.getRang(periode, listeC.get(i)));
            tab[i][7] = mention(listeC.get(i).getMoyenne(periode, eleve));
        }
        return tab;
    }

    @Override
    public String[] colTitles() {
        List<TypeEvaluation> listeT = consultC.getListeType();
        String[] titres = new String[]{"      Cours       ", listeT.get(0).getLibelle(), listeT.get(1).getLibelle(), listeT.get(2).getLibelle(),
             "Coefficient", " Moyenne ", "  Rang  ", "     Mention    "
        };
        return titres;
    }

    @Override
    public Class[] colTypes() {
        Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
             java.lang.Integer.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
        };
        return types;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    private String rang(int rang) {
        if (rang == 1) {
            return rang + " er";
        } else {
            return rang + " ième";
        }
    }

    private String mention(double moyenne) {
        if ((moyenne >= 16) && (moyenne <= 20)) {
            return "Très Bien";
        } else if ((moyenne >= 14) && (moyenne < 16)) {
            return "Bien";
        } else if ((moyenne >= 12) && (moyenne < 14)) {
            return "Assez Bien";
        } else if ((moyenne >= 10) && (moyenne < 12)) {
            return "Passable";
        } else if ((moyenne >= 8) && (moyenne < 10)) {
            return "Médiocre";
        }
        return "Blame";
    }

    private String doubleFormat(double value) { //formatter l'affichage d'un double 
        String result = Double.toString(value);
        if (result.length() > 5) {
            result = result.substring(0, 5);
        }
        return result;
    }

    @Override
    public JPanel headPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 0, 5));
        panel.setPreferredSize(new Dimension(200, 150));

        char c;
        String libellePeriode = periode.getLibelle();
        //met en majuscule le libelle de la période
        for (int i = 0; i < libellePeriode.length(); i++) {
            c = libellePeriode.charAt(i);
            libellePeriode = libellePeriode.replace(c, Character.toUpperCase(c));
        }

        JLabel label1 = new JLabel("                    BULLETIN DE NOTES DU " + libellePeriode);
        JLabel label2 = new JLabel("   Matricule : " + eleve.getId());
        JLabel label3 = new JLabel("   Nom : " + eleve.getNom());
        JLabel label4 = new JLabel("   Prénom : " + eleve.getPrenom());
        JLabel label5 = new JLabel("   Sexe : " + eleve.getSexe());
        JLabel label6 = new JLabel("   Classe : " + eleve.getClasse().getLibelle());
        JLabel label7 = new JLabel("   Effectif : " + Eleve.getEffectif(eleve.getClasse()));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);

        return panel;
    }

    @Override
    public JPanel endPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 0, 5));
        panel.setPreferredSize(new Dimension(200, 100));

        JLabel label1 = new JLabel("   Moyenne générale : " + doubleFormat(periode.getMoyenne(eleve)));
        JLabel label2 = new JLabel("   Rang : " + rang(eleve.getRang(periode)));
        JLabel label3 = new JLabel("   Mention : " + mention(periode.getMoyenne(eleve)));
        JLabel label4 = new JLabel("   Moyenne de la classe :  " + doubleFormat(periode.getMoyenne(eleve.getClasse())));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        return panel;
    }

}
