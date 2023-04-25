/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.dialogs;

import gestionEcole.View.GUI.components.listPanel.PanelListForm;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class JDialogSelection extends JDialog {
    
    private PanelSelection select;
    
    public JDialogSelection() {
    }
    
    public JDialogSelection(JFrame owner, String title, PanelListForm liste) {
        super(owner, title, true);
        initComponent(liste);
        this.setLocationRelativeTo(owner);
    }
    
    private void initComponent(PanelListForm liste) {
        this.setLayout(new BorderLayout(5, 5));
        this.setPreferredSize(new Dimension(720, 450));
        this.setResizable(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        this.getContentPane().add(liste, BorderLayout.CENTER);
        select = new PanelSelection();
        this.getContentPane().add(select, BorderLayout.SOUTH);
        
        this.getSelect().getValidate().addActionListener((ActionEvent evt) -> {
            closeDialogActionPerformed(evt);
        });
        
        this.getSelect().getInputNumber().addKeyListener(new KeyAdapter(){
            @Override
            public  void keyTyped(KeyEvent evt){
                inputNumberKeyTyped(evt);
            }
        });
        
        this.pack();
        this.setSize(720, 450);
        this.setVisible(true);
    }
    
    public int getSelection() {
        int value = select.getSelectedNumber();
        return value;
    }
    
    public PanelSelection getSelect() {
        return this.select;
    }
    
    private void closeDialogActionPerformed(ActionEvent evt) {
        if (evt.getSource() == this.getSelect().getValidate()) {
            this.getSelect().validateActionPerformed(evt);
            //on cache la fenêtre lorsqu'on clique sur le bouton
            this.setVisible(false);
        }
    }
    
    public void inputNumberKeyTyped(KeyEvent evt) {
        if (evt.getSource() == this.getSelect().getInputNumber()) {
            this.getSelect().inputNumberKeyTyped(evt);
        }
    }
   
    
}
