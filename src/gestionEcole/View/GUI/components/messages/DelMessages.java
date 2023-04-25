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
public class DelMessages {
    private boolean warningMsgRep;
    private boolean modifyClasse;
    private boolean delEleveOk;
    public DelMessages(){
       warningMsgRep = false;
       modifyClasse = false;
       delEleveOk = false;
    }
    
    public void successMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "SUPPRESIION EFFECTUE", "OPERATION EFFECTUEE", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void cancelMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "SUPPRESSION ANNULEE", "ANNULATION", JOptionPane.WARNING_MESSAGE);
    }
    
    public void errorMsg(JFrame f){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "ECHEC DE SUPPRESSION", "ECHEC", JOptionPane.ERROR_MESSAGE);
    }
    
    public void warningMsg(JFrame f){
        f.setVisible(true);
        int rep = JOptionPane.showConfirmDialog(f, "Attention avant de supprimer cet objet tous ceux qui en dépendent doivent être supprimés\nÊtes-vous sûr d'avoir supprimé ses dépendants?",
                "AVERTISSEMENT", JOptionPane.YES_NO_OPTION);
        if(rep == JOptionPane.YES_OPTION){
            setWarningMsgRep(true);            
        }
    }
    
    public void warningDelEleveMsg(JFrame f){
        f.setVisible(true);
        int rep = JOptionPane.showConfirmDialog(f, "Attention avant de supprimer cet élève toutes ses notes doivent être supprimées\nVoulez-vous poursuivre cette opération?",
                "AVERTISSEMENT", JOptionPane.YES_NO_OPTION);
        if(rep == JOptionPane.YES_OPTION){
            setDelEleveOk(true);            
        }
    }
    
    public void objectDelCancelled(JFrame f, String objName){
        f.setVisible(true);
        JOptionPane.showMessageDialog(f, "La suprresion du(de la) " + objName + " n'est pas autorisée car d'autres objets dépendent encore de lui",
                "OPERATION ANNULEE", JOptionPane.INFORMATION_MESSAGE);
    }

    public void modifyEleveClasse(JFrame f){
        f.setVisible(true);
        int rep = JOptionPane.showConfirmDialog(f, "Attention avant de supprimer cette classe tous ses élèves doivent être supprimés\nPréférez-vous modifier leur classe plutôt?",
                "AVERTISSEMENT", JOptionPane.YES_NO_OPTION);
        if(rep == JOptionPane.YES_OPTION){
            setModifyClasse(true);            
        }
    }

    public boolean isWarningMsgRep() {
        return warningMsgRep;
    }

    public void setWarningMsgRep(boolean warningMsgRep) {
        this.warningMsgRep = warningMsgRep;
    }

    public boolean isModifyClasse() {
        return modifyClasse;
    }

    public void setModifyClasse(boolean modifyClasse) {
        this.modifyClasse = modifyClasse;
    }

    public boolean isDelEleveOk() {
        return delEleveOk;
    }

    public void setDelEleveOk(boolean delEleveOk) {
        this.delEleveOk = delEleveOk;
    }
       
    
}
