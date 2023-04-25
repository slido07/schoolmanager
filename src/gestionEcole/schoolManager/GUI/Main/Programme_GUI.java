/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.schoolManager.GUI.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class Programme_GUI {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        MainViewGUI frame = MainViewGUI.getMainFrame();
        frame.getOutputPanel().add(accueil(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(screenSize);
        frame.setLocation(0, 0);
        frame.setVisible(true);

    }

    public static JPanel accueil() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 0, 5));
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setBackground(java.awt.Color.white);

        JLabel label1 = new JLabel("                                        "
                + "BIENVENU(E) DANS LE LOGICIEL DE GESTION D'ECOLE 1.0   ");
        JLabel label2 = new JLabel(" Ce logiciel est idéal pour administrer votre établissement car il permet :  ");
        JLabel label3 = new JLabel(" L'organisation de l'établissement selon chacune de ses structures à travers ");
        JLabel label4 = new JLabel("     # La gestions des différents niveaux de l'établissement");
        JLabel label5 = new JLabel("     # La gestions des différentes classes ");
        JLabel label6 = new JLabel("     # Les inscriptions d'élèves dans l'école ");
        JLabel label7 = new JLabel("     # La gestion des enseignements procurés dans l'établissement ");
        JLabel label8 = new JLabel("     # L'organisation des cours dans chaque classe ");
        JLabel label9 = new JLabel("     # La gestion des évaluations effectuées par périodes dans l'année ");
        JLabel label10 = new JLabel("    # Et enfin la génération de bulletin de notes pour chaque élève de l'établissement ");
        JLabel label11 = new JLabel("                                      "
                + "Nous vous souhaitons une agréable expérience utlilisateur ");
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);
        panel.add(label10);
        panel.add(label11);

        return panel;
    }
}
