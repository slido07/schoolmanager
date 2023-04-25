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
public class AddMatierePanel extends JPanel {
    
    private javax.swing.JTextField inputCode;
    private javax.swing.JTextField inputLibelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelGetCode;
    private javax.swing.JLabel labelGetLibel;
    private javax.swing.JButton validate;
    
    private String code;
    private String libelle;
    private final IAjoutControllerGUI control = new AjoutControllerGUIImpl();
    AddMessages msg = new AddMessages();
    Thread thrd = new Thread(){
      @Override
      public void run(){
          setLibelle(inputLibelle.getText());
          setCode(formatCode(inputCode));
          if((libelle.isEmpty()) || (code.isEmpty())){
              setVisible(true);
              msg.signalEmptyField(MainViewGUI.getMainFrame());
          }
          else{
              setVisible(false);
              control.addMatiere(code, libelle);
          }
      }  
    };
    
    public AddMatierePanel() {
        initComponents();
    }
                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelGetCode = new javax.swing.JLabel();
        inputLibelle = new javax.swing.JTextField();
        labelGetLibel = new javax.swing.JLabel();
        inputCode = new javax.swing.JTextField();
        validate = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("AJOUT D'UNE MATIERE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 120, 30));

        labelGetCode.setText("Code :");
        add(labelGetCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 50, 30));

        inputLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputLibelleActionPerformed(evt);
        });
        add(inputLibelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 220, 30));

        labelGetLibel.setText("Libellé :");
        add(labelGetLibel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 60, 30));

        inputCode.addActionListener((java.awt.event.ActionEvent evt) -> {
            inputCodeActionPerformed(evt);
        });
        add(inputCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 110, 30));

        validate.setText("Valider");
        validate.addActionListener((java.awt.event.ActionEvent evt) -> {
            validateActionPerformed(evt);
        });
        add(validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 90, 30));
    }                       

    private void inputLibelleActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == inputLibelle)
            setLibelle(inputLibelle.getText());
    }                                            

    private void inputCodeActionPerformed(java.awt.event.ActionEvent evt) {                                          
       if(evt.getSource() == inputCode)
           setCode(formatCode(inputCode));
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
