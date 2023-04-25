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
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class AddTypePanel extends JPanel {
    
    private javax.swing.JTextField inputCode;
    private javax.swing.JTextField inputLibelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton validate;
    
     private String code;
    private String libelle;
    private final IAjoutControllerGUI control = new AjoutControllerGUIImpl();
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread(){
        @Override
        public void run(){
            setCode(formatCode(inputCode));
            setLibelle(inputLibelle.getText());
            if((code.isEmpty()) || (libelle.isEmpty())){
                setVisible(true);
                msg.signalEmptyField(MainViewGUI.getMainFrame());
            }
            else{
                setVisible(false);
                control.addType(code, libelle);
            }
        }
    };
    
    public AddTypePanel() {
        initComponents();
    }
                      
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputLibelle = new javax.swing.JTextField();
        inputCode = new javax.swing.JTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("AJOUT D'UN TYPE D'EVALUATION");
        jLabel1.setPreferredSize(new java.awt.Dimension(170, 14));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 23, 170, 30));

        jLabel2.setText("Libellé :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 50, 30));

        jLabel3.setText("Code :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 50, 30));

        inputLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputLibelleActionPerformed(evt);
        });
        add(inputLibelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 200, 30));

        inputCode.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputCodeActionPerformed(evt);
        });
        add(inputCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 80, 30));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 100, 30));
    }                       

    private void inputCodeActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == inputCode)
            setCode(formatCode(inputCode));
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

    private String formatCode(JTextField tf){
        char c;
        String value = tf.getText();
        for (int i = 0; i < value.length(); i++) {
            c = value.charAt(i);
            value = value.replace(c, Character.toUpperCase(c));
        }
        return value;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getLIbelle(){
        return libelle;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
