/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.messages;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class AddMessages {  
    
    public AddMessages(){
        
    }
    
    public void successMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Ajout effectué avec succès", "OPERATION EFFECTUEE",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void cancelMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Ajout annulé", "ANNULATION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void errorMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "L'opération d'ajout a échoué", "ECHEC", JOptionPane.ERROR_MESSAGE);
    }
    
    public void alreadyDoneAction(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Cet ajout a déjà été effectué", "OPERATION DEJA EFFECTUEE",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void repeatAction(JFrame f){
        f.setVisible(true);
        int rep = JOptionPane.showConfirmDialog(f, "Voulez-vous répéter cette action?", "REPEAT ACTION", JOptionPane.YES_NO_OPTION);
        if(rep == JOptionPane.YES_OPTION){
            //à implémenter 
            
        }
    }
    
    public void signalEmptyField(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Attention !!!!\nCertains champs n'ont pas été remplis correctement",
                "AVERTISSEMENT", JOptionPane.WARNING_MESSAGE);
    }
    
     public void emptyEleveList(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "La liste des élèves de cette classe est vide", "Liste vide", JOptionPane.WARNING_MESSAGE);
    }
    
}
