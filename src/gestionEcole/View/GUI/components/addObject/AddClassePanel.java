/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.addObject;

import gestionEcole.View.GUI.components.messages.AddMessages;
import gestionEcole.model.entity.Niveau;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class AddClassePanel extends JPanel {

    private javax.swing.JTextField inputSubdivision;
    private javax.swing.JLabel headLabel;
    private javax.swing.JLabel labelGetSubdivision;
    private javax.swing.JButton validate;

    private String subdivision;
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread() {
        @Override
        public void run() {
            setSubdivision(inputSubdivision.getText());
            if (subdivision.isEmpty()) {
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            } else {
                setVisible(false);
            }
        }
    };

    public AddClassePanel() {
        initComponents();
    }
    
    public AddClassePanel(Niveau niveau) {
        initComponents();
        headLabel.setText("AJOUT D'UNE CLASSE EN " + niveau.getLibelle());
    }

    private void initComponents() {

        headLabel = new javax.swing.JLabel();
        labelGetSubdivision = new javax.swing.JLabel();
        inputSubdivision = new javax.swing.JTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headLabel.setBackground(new Color(102, 255, 255));
        headLabel.setSize(400, 20);
        add(headLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 21, 400, 30));  //x, y, largeur, longeur

        labelGetSubdivision.setText("Subdivision :");
        labelGetSubdivision.setMaximumSize(new java.awt.Dimension(100, 40));
        labelGetSubdivision.setMinimumSize(new java.awt.Dimension(50, 20));
        labelGetSubdivision.setPreferredSize(new java.awt.Dimension(60, 20));
        add(labelGetSubdivision, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 69, 100, 30));

        inputSubdivision.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputSubdivisionActionPerformed(evt);
        });
        add(inputSubdivision, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 74, 110, -1));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 87, 33));
    }

    private void inputSubdivisionActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputSubdivision) {
            setSubdivision(formatSub(inputSubdivision));
        }
    }

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == validate) {
            thrd.start();
        }
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    private String formatSub(JTextField tf) {
        char c;
        String value = tf.getText();
        for (int i = 0; i < value.length(); i++) {
            c = value.charAt(i);
            value = value.replace(c, Character.toUpperCase(c));
        }
        if (value.length() > 4) { //on récupère uniquement les 4 premiers caractères
            value = value.substring(0, 4);
        }
        return value;
    }

}
