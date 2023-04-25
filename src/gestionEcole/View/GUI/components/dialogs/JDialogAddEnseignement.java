/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.dialogs;

import gestionEcole.View.GUI.components.addObject.AddEnseignementPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class JDialogAddEnseignement extends JDialog {
    
    private AddEnseignementPanel form;
    private JPanel panelSouth;
    private JButton closeButton;
    
    public JDialogAddEnseignement(){
        
    }
    
    public JDialogAddEnseignement(JFrame owner, String title, AddEnseignementPanel _form){
        super(owner, title, true);
        this.form = _form;
        initComponent(_form);
        setLocationRelativeTo(owner);
    }
    
    private void initComponent(AddEnseignementPanel form){
        this.setLayout(new BorderLayout(5, 5));
        this.setPreferredSize(new Dimension(720, 450));
        this.setResizable(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        panelSouth = new JPanel();
        panelSouth.setPreferredSize(new Dimension(720, 50));
        panelSouth.setLayout(new BorderLayout());
        closeButton = new JButton("Fermer");
        closeButton.setSize(15, 15);
        closeButton.addActionListener((ActionEvent evt) -> {
            closeButtonActionPerformed(evt);
        });
        
        panelSouth.add(closeButton, BorderLayout.CENTER);

        this.getContentPane().add(form, BorderLayout.CENTER); 
        this.getContentPane().add(panelSouth, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
    
    public AddEnseignementPanel getForm(){
        return this.form;
    }
    
    private void closeButtonActionPerformed(ActionEvent evt){
        if(evt.getSource() == closeButton){
            this.setVisible(false);
        }
    }

}
