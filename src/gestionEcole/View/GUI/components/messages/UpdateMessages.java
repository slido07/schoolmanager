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
public class UpdateMessages {
    
    public UpdateMessages(){
        
    }
    
    public void successMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Mise à jour effectuée avec succès", "MISE A JOUR EFFECTUEE",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void cancelMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Mise à jour annulée", "ANNULATION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void errorMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "L'opération de mise à jour a échoué", "ECHEC DE MISE A JOUR",
                JOptionPane.ERROR_MESSAGE);
    }
}
