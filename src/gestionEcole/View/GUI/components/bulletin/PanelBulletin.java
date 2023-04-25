/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.bulletin;

import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Periode;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class PanelBulletin extends JPanel {

    private Bulletin bulletin;
    private boolean Obtained;

    public PanelBulletin() {
        Obtained = false;
    }

    public PanelBulletin(Periode periode, Eleve eleve) {
        initComponents(periode, eleve);
    }

    private void initComponents(Periode periode, Eleve eleve) {
        if (eleve.isBulletinObtainable(periode)) {
            bulletin = new Bulletin(periode, eleve);

            this.setLayout(new BorderLayout(5, 5));
            this.setPreferredSize(new Dimension(600, 600));
            this.setBackground(Color.WHITE);

            this.add(bulletin, BorderLayout.CENTER);
            setObtained(true);
        } else {
            setObtained(false);
            JOptionPane.showMessageDialog(MainViewGUI.getMainFrame(),
                    "Désolé les notes disponibles sont insuffisantes pour générer un bulletin\nVeuillez complèter les notes de l'élève puis recommencer",
                     "INCAPACITE DE GENERER LE BULLETIN", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    public boolean isObtained() {
        return Obtained;
    }

    public void setObtained(boolean isObtained) {
        this.Obtained = isObtained;
    }

}
