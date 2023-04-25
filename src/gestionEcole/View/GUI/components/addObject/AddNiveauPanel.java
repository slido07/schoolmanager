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
public class AddNiveauPanel extends JPanel {
    
    private javax.swing.JTextField inputDescrip;
    private javax.swing.JTextField inputLibelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelAddNiveau;
    public javax.swing.JButton validate;
    
    private final IAjoutControllerGUI control = new AjoutControllerGUIImpl();
    private String libelle;
    private String description;
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread(){
        @Override
        public void run(){
            setLibelle(inputLibelle.getText());
            setDescription(inputDescrip.getText());
            if((libelle.isEmpty()) || (description.isEmpty())){
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            }
            else{
                setVisible(false);
                control.addNiveau(libelle, description);
            }
        }
    };
    
    public AddNiveauPanel() {
        initComponents();
    }
                         
    private void initComponents() {

        labelAddNiveau = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputLibelle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputDescrip = new javax.swing.JTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));

        labelAddNiveau.setBackground(new java.awt.Color(153, 255, 255));
        labelAddNiveau.setText("       AJOUT D'UN NIVEAU");

        jLabel1.setText("Libellé :");

        inputLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputLibelleActionPerformed(evt);
        });

        jLabel2.setText("Description :");

        inputDescrip.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputDescripActionPerformed(evt);
        });

        validate.setBackground(new java.awt.Color(255, 153, 255));
        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(labelAddNiveau, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(validate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelAddNiveau, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(validate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
    }                        

    private void inputLibelleActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == inputLibelle)
            setLibelle(inputLibelle.getText());
       
    }                                            

    private void inputDescripActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == inputDescrip)
            setDescription(inputDescrip.getText());
    }                                            

    private void validateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == validate){
            thrd.start();
        }
    }                                        

    public String getLibelle(){
        return libelle;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setLibelle(String _libelle){
        this.libelle = _libelle;
    }
    
    public void setDescription(String _descrip){
        this.description = _descrip;
    }   
    
}
