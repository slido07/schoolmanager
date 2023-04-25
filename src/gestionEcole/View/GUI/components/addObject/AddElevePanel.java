/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.addObject;

import gestionEcole.View.GUI.components.messages.AddMessages;
import gestionEcole.model.entity.Classe;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class AddElevePanel extends JPanel {

    private javax.swing.JTextField inputNom;
    private javax.swing.JTextField inputPrenom;
    private javax.swing.JTextField inputSexe;
    private javax.swing.JLabel headLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton validate;

    private String nom;
    private String prenom;
    private char sexe;
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread() {
        @Override
        public void run() {
            setNom(inputNom.getText());
            setPrenom(inputPrenom.getText());
            setSexe(inputSexe.getText().charAt(0));
            setSexe(Character.toUpperCase(sexe));
            if ((nom.isEmpty()) || (prenom.isEmpty()) || ((sexe != 'M') && (sexe != 'F'))) {
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            } else {
                setVisible(false);
            }
        }
    };

    public AddElevePanel() {
        initComponents();
    }
    
    public AddElevePanel(Classe classe) {
        initComponents();
        headLabel.setText("AJOUT D'UN ELEVE EN " + classe.getLibelle());
    }


    private void initComponents() {

        headLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputSexe = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputNom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputPrenom = new javax.swing.JTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headLabel.setBackground(new java.awt.Color(102, 255, 255));
        headLabel.setSize(400, 20);
        add(headLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 400, 30));

        jLabel3.setText("Sexe (M/F) :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, 20));  //x, y, largeur , hauteur

        inputSexe.setText("#");
        inputSexe.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputSexeActionPerformed(evt);
        });
        inputSexe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                inputSexeKeyTyped(evt);
            }
        });
        add(inputSexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 30, -1));

        jLabel4.setText("Nom :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 50, 20));

        inputNom.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputNomActionPerformed(evt);
        });
        add(inputNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 190, -1));

        jLabel5.setText("Prénom :");
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel5.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 30));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 60, -1));

        inputPrenom.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputPrenomActionPerformed(evt);
        });
        add(inputPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, -1));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 100, 30));
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

    private void inputSexeActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputSexe) {
            setSexe(inputSexe.getText().charAt(0));
            setSexe(Character.toUpperCase(sexe));
        }
    }

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == validate) {
            thrd.start();
        }
    }

    private void inputSexeKeyTyped(KeyEvent evt) {
        if (evt.getSource() == inputSexe) {
            char c = evt.getKeyChar();
            if ((c != 'm') && (c != 'M') && (c != 'f') && (c != 'F') && (c != KeyEvent.VK_BACK_SPACE)) {
                evt.consume();  //on ignore l'évènement
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setNom(String nom) {
        this.nom = formatUp(nom);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
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
