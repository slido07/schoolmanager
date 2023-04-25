/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.GUI.components.messages;

import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Periode;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class BulletinMessages {
    
    public BulletinMessages(){
        
    }
    
    public void showMoyCours(JFrame f, Periode periode, Cours cours){
        String answer = "La moyenne générale en " + cours.getLibelle() + " est de : " + 
                doubleFormat(periode.getMoyenne(cours));
        JOptionPane.showMessageDialog(f, answer, "Moyenne générale en " + cours.getLibelle(), 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String doubleFormat(double value){ //formatter l'affichage d'un double 
        String result = Double.toString(value);
        if(result.length() > 5){
            result = result.substring(0, 5);
        }
        return result;
    }
    
}
