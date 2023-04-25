/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.addObject;

import gestionEcole.View.GUI.components.messages.AddMessages;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Periode;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class AddNotePanel extends JPanel {
    
    private javax.swing.JLabel headLabel;
    private javax.swing.JFormattedTextField inputValeur;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton validate;
    
    private double valeur;
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread(){
       @Override
       public void run(){
           setValeur(getDouble(inputValeur));
           if(valeur == 0){
               setVisible(true);
               msg.signalEmptyField(MainViewGUI.getMainFrame());
           }
           else{
               setVisible(false);
           }
       } 
    };
    
    public AddNotePanel() {
        initComponents();
    }
    
    public AddNotePanel(Periode periode, Evaluation evaluation, Eleve eleve) {
        initComponents();
        headLabel.setText("AJOUT D'UNE NOTE POUR L'ELEVE " + eleve.getNom() + " " + eleve.getPrenom() + " AU " +
                periode.getLibelle() + " EN " + evaluation.getType().getCode() + " " + evaluation.getCours().getLibelle());
    }
                     
    private void initComponents() {

        headLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputValeur = new javax.swing.JFormattedTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(headLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 220, 30)); //x, y, largeur, hauteur

        jLabel2.setText("Valeur de la note obtenue :");
        jLabel2.setMaximumSize(new java.awt.Dimension(300, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(250, 20));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 20));

        inputValeur.setText("0");
        inputValeur.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputValeurActionPerformed(evt);
        });
        inputValeur.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputValeurKeyTyped(evt);
            }
        });
        add(inputValeur, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 40, -1));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 90, 30));
    }                        

    private void inputValeurKeyTyped(java.awt.event.KeyEvent evt) {                                     
        char c = evt.getKeyChar();
        if(((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')){
            evt.consume();  //on ignore l'évènement
        }
    }                                    

    private void inputValeurActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(evt.getSource() == inputValeur)
            setValeur(getDouble(inputValeur));
    }                                           

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == validate){
            thrd.start();
        }
    }                                        

    private double getDouble(JTextField tf){
        double value = 0;
        try{
            value = Double.parseDouble(tf.getText());
            return value;
        }
        catch(NumberFormatException e){
        }
        return value;
    }
    
    public double getValeur(){
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
    
}
