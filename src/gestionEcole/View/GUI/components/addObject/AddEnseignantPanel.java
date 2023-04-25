/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.addObject;

import gestionEcole.Controller.GUI.I.IAjoutControllerGUI;
import gestionEcole.Controller.GUI.impl.AjoutControllerGUIImpl;
import gestionEcole.View.GUI.components.messages.AddMessages;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class AddEnseignantPanel extends JPanel {

    private javax.swing.JTextField inputNom;
    private javax.swing.JTextField inputPrenom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton validate;

    private String nom;
    private String prenom;
    private final IAjoutControllerGUI control = new AjoutControllerGUIImpl();
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread() {
        @Override
        public void run() {
            setNom(inputNom.getText());
            setPrenom(inputPrenom.getText());
            if ((nom.isEmpty()) || (prenom.isEmpty())) {
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            } else {
                setVisible(false);
                control.addEnseignant(nom, prenom);
            }
        }
    };

    public AddEnseignantPanel() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputPrenom = new javax.swing.JTextField();
        inputNom = new javax.swing.JTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("     AJOUT D'UN ENSEIGNANT   ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 150, 29));

        jLabel4.setText("Nom :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 50, 20));

        jLabel5.setText("Prénom :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 50, -1));

        inputPrenom.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputPrenomActionPerformed(evt);
        });
        add(inputPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 210, -1));

        inputNom.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputNomActionPerformed(evt);
        });
        add(inputNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 170, -1));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 100, 30));
    }

    private void inputNomActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputNom) {
            setNom(inputNom.getText());
        }
    }

    private void inputPrenomActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputPrenom) {
            setPrenom(inputPrenom.getText());
        }
    }

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == validate) {
            thrd.start();
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        formatUp(nom);
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private String formatUp(String text) {
        char c;
        String value = text;
        for (int i = 0; i < value.length(); i++) {
            c = value.charAt(i);
            value = value.replace(c, Character.toUpperCase(c));
        }
        return value;
    }

}
