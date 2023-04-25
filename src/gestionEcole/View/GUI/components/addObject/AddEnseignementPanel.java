/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.addObject;

import gestionEcole.View.GUI.components.messages.AddMessages;
import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Niveau;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class AddEnseignementPanel extends JPanel {

    private javax.swing.JLabel headLabel;
    private javax.swing.JFormattedTextField inputCoef;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton validate;

    private int coefficient;
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread() {
        @Override
        public void run() {
            setCoefficient(getInt(inputCoef));
            if (coefficient == 0) {
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            } else {
                setVisible(false);
            }
        }
    };

    public AddEnseignementPanel() {
        initComponents();
    }

    public AddEnseignementPanel(Niveau niveau, Matiere matiere) {
        initComponents();
        headLabel.setText("AJOUT D'UN ENSEIGNEMENT EN " + niveau.getLibelle() + " DANS LA MATIERE " + matiere.getLibelle()
                + "(" + matiere.getCode() + ")");
    }

    private void initComponents() {

        headLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputCoef = new javax.swing.JFormattedTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headLabel.setPreferredSize(new java.awt.Dimension(400, 20));
        add(headLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 400, 30));

        jLabel2.setText("Coefficient :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 70, 20));

        inputCoef.setText("0");
        inputCoef.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputCoefActionPerformed(evt);
        });
        inputCoef.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputCoefKeyTyped(evt);
            }
        });
        add(inputCoef, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 60, 20));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));
    }

    private void inputCoefActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputCoef) {
            setCoefficient(getInt(inputCoef));
        }
    }

    private void inputCoefKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  //on ignore l'évènement
        }
    }

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == validate) {
            thrd.start();
        }
    }

    public int getInt(JTextField tf) {
        int value = 0;
        try {
            value = Integer.parseInt(tf.getText());
            return value;
        } catch (NumberFormatException e) {
        }
        return value;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

}
