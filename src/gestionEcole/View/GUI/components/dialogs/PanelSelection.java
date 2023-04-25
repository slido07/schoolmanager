/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.dialogs;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class PanelSelection extends JPanel {

    private javax.swing.JFormattedTextField inputNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton validate;

    private int selectedNumber;
    Thread thrd = new Thread() {
        @Override
        public void run() {
            setSelectedNumber(getInt(inputNumber));
            if (selectedNumber > 0) {
                setVisible(false);
            } else {
                setVisible(true);
            }
        }
    };

    public PanelSelection() {
        selectedNumber = 0;
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputNumber = new javax.swing.JFormattedTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setMinimumSize(new java.awt.Dimension(300, 80));
        setPreferredSize(new java.awt.Dimension(400, 100));

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 100));

        jLabel1.setText("Sélectionnez un numéro de la liste :");
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel1.add(jLabel1);

        inputNumber.setMinimumSize(new java.awt.Dimension(50, 20));
        inputNumber.setPreferredSize(new java.awt.Dimension(60, 20));
        inputNumber.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputNumberActionPerformed(evt);
        });
        inputNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                inputNumberKeyTyped(evt);
            }
        });
        jPanel1.add(inputNumber);

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });

        jPanel1.add(validate);

        add(jPanel1);
    }

    public void inputNumberKeyTyped(KeyEvent evt) {
        if (evt.getSource() == inputNumber) {
            char c = evt.getKeyChar();
            if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                evt.consume();  //on ignore l'évènement
            }
        }
    }

    private void inputNumberActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputNumber) {
            setSelectedNumber(getInt(inputNumber));
        }
    }

    public void validateActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == validate) {
            setSelectedNumber(getInt(inputNumber));
            if (selectedNumber > 0) {
                setVisible(false);
            } else {
                setVisible(true);
            }
        }
    }

    private int getInt(JTextField tf) {
        int value = 0;
        try {
            value = Integer.parseInt(tf.getText());
            return value;
        } catch (NumberFormatException e) {
        }
        return value;
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    public void setSelectedNumber(int value) {
        this.selectedNumber = value;
    }

    public JButton getValidate() {
        return this.validate;
    }

    public JFormattedTextField getInputNumber() {
        return inputNumber;
    }

}
