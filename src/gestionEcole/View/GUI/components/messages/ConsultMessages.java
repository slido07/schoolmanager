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
public class ConsultMessages {
    
    public ConsultMessages(){
        
    }
    
    public void cancelMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "CONSULTATION ANNULEE", "ANNULATION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void errorMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "L'élément sélectionné n'appartient pas à la liste", "ERREUR",
                JOptionPane.ERROR_MESSAGE);
    }
    
    public void badChoice(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Le nombre saisi n'est pas valide", "MAIVAISE SAISIE", JOptionPane.ERROR_MESSAGE);
    }
    
    public int repeatAction(JFrame f){
        f.setVisible(true);
        int rep = JOptionPane.showConfirmDialog(f, "Voulez-vous répéter cette action?", "REPEAT ACTION",
                JOptionPane.YES_NO_OPTION);
        if(rep == JOptionPane.YES_OPTION){
           return 1;            
        }
        return 0;
    }
    
    public void noticeEmptyList(JFrame f, String objName){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "Désolé, aucun " + objName +  "de cette liste n'a été persisté pour le moment", 
                "LISTE VIDE",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private int getInt(String input){ //alright
        int value = 0;
        try{
            value = Integer.parseInt(input);
            return value;
        }
        catch(NumberFormatException e){
        }
        return value;
    }
    
    public int getSelectedNumber(JFrame f){
        f.setVisible(true);
        String userInput = JOptionPane.showInputDialog(f, "Sélectionnez un numéro de la liste", "0");
        
        int inputValue = getInt(userInput);
        return inputValue;
    }
}
