/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.addObject;

import gestionEcole.View.GUI.components.messages.AddMessages;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Periode;
import gestionEcole.model.entity.TypeEvaluation;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author HP
 */
public class AddEvaluationPanel extends JPanel {

    private javax.swing.JLabel headLabel;
    private javax.swing.JFormattedTextField inputBareme;
    private javax.swing.JFormattedTextField inputDate;
    private javax.swing.JFormattedTextField inputPoids;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton validate;

    private int bareme;
    private double poids;
    private LocalDate date;
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread() {
        @Override
        public void run() {
            setBareme(getInt(inputBareme));
            setPoids(getDouble(inputPoids));
            setDate(getLocalDate(inputDate));
            if ((bareme == 0) || (poids == 0) || (date == null)) {
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            } else {
                setVisible(false);
            }
        }
    };

    public AddEvaluationPanel() {
        initComponents();
    }

    public AddEvaluationPanel(Periode periode, Cours cours, TypeEvaluation type) {
        initComponents();
        headLabel.setText("AJOUT D'UN(E) " + type.getLibelle() + " DANS LE COURS " + cours.getLibelle() + " AU " + periode.getLibelle());
    }

    private void initComponents() {

        headLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        try {
            MaskFormatter formatter = new MaskFormatter("####-##-##");
            formatter.setPlaceholderCharacter('#');
            inputDate = new javax.swing.JFormattedTextField(formatter);
            inputBareme = new javax.swing.JFormattedTextField();
            inputPoids = new javax.swing.JFormattedTextField();
            validate = new javax.swing.JButton();

            setBackground(new java.awt.Color(102, 255, 255));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            headLabel.setPreferredSize(new java.awt.Dimension(500, 15));
            add(headLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 500, 20)); //x,y, largeur, hauteur

            jLabel2.setText("Date(AAAA-MM-JJ):");
            jLabel2.setMaximumSize(new java.awt.Dimension(130, 14));
            jLabel2.setPreferredSize(new java.awt.Dimension(130, 14));
            add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 170, 130, 30));

            jLabel3.setText("Barème :");
            add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, 30));

            jLabel4.setText("Poids :");
            add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 30));

        } catch (ParseException e) {
        }
        inputDate.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputDateActionPerformed(evt);
        });
        inputDate.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputDateKeyTyped(evt);
            }
        });
        add(inputDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 90, 20));

        inputBareme.setText("0");
        inputBareme.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputBaremeActionPerformed(evt);
        });
        inputBareme.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputBaremeKeyTyped(evt);
            }
        });
        add(inputBareme, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 40, 20));

        inputPoids.setText("0");
        inputPoids.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputPoidsActionPerformed(evt);
        });
        inputPoids.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputPoidsKeyTyped(evt);
            }
        });
        add(inputPoids, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 60, 20));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 80, 30));
    }

    private void inputBaremeKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  //on ignore l'évènement
        }
    }

    private void inputPoidsKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
            evt.consume();  //on ignore l'évènement
        }
    }

    private void inputBaremeActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputBareme) {
            setBareme(getInt(inputBareme));
        }
    }

    private void inputPoidsActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputPoids) {
            setPoids(getDouble(inputPoids));
        }
    }

    private void inputDateKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();  //on ignore l'évènement
        }
    }

    private void inputDateActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == inputDate) {
            setDate(getLocalDate(inputDate));
        }
    }

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == validate) {
            thrd.start();
        }
    }

    private int getInt(JTextField tf) {
        int value = 0;
        try {
            value = Integer.parseInt(tf.getText());
            return value;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    private double getDouble(JTextField tf) {
        double value = 0;
        try {
            value = Double.parseDouble(tf.getText());
            return value;
        } catch (NumberFormatException e) {
        }
        return value;
    }

    private LocalDate getLocalDate(JTextField tf) {
        LocalDate value = null;
        try {
            value = LocalDate.parse(tf.getText(), DateTimeFormatter.ISO_DATE);
            return value;
        } catch (DateTimeException e) {
        }
        return value;
    }

    public int getBareme() {
        return bareme;
    }

    public double getPoids() {
        return poids;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setBareme(int bareme) {
        this.bareme = bareme;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
