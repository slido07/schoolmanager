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
public class AddPeriodePanel extends JPanel {
    
    private javax.swing.JTextField inputLibelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton validate;
    
    private String libelle;
    private final IAjoutControllerGUI control = new AjoutControllerGUIImpl();
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread(){
        @Override
        public void run(){
            setLibelle(inputLibelle.getText());
            if(libelle.isEmpty()){
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            }
            else{
                setVisible(false);
                control.addPeriode(libelle);
            }
        }
    };
    
    public AddPeriodePanel() {
        initComponents();
    }

                             
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputLibelle = new javax.swing.JTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("AJOUT D'UNE PERIODE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 30));

        jLabel2.setText("Libellé :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 60, 30));

        inputLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputLibelleActionPerformed(evt);
        });
        add(inputLibelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 200, 20));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 90, 30));
    }                        

    private void inputLibelleActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == inputLibelle)
           setLibelle(inputLibelle.getText());
    }                                            

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == validate){
            thrd.start();
        }
    }                                        

    public String getLibelle(){
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
