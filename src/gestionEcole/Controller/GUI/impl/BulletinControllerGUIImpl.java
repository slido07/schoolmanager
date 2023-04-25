/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.GUI.impl;

import gestionEcole.Controller.GUI.I.IBulletinControllerGUI;
import gestionEcole.Controller.GUI.I.IConsultationControllerGUI;
import gestionEcole.View.GUI.components.bulletin.PanelBulletin;
import gestionEcole.View.GUI.components.messages.BulletinMessages;
import gestionEcole.View.GUI.components.messages.ConsultMessages;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Niveau;
import gestionEcole.model.entity.Periode;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class BulletinControllerGUIImpl implements IBulletinControllerGUI {

    private static final IConsultationControllerGUI consultC = new ConsultationControllerGUIImpl();
    private static final ConsultMessages msg = new ConsultMessages();
    private static final BulletinMessages bmsg = new BulletinMessages();
    JFrame frame = MainViewGUI.getMainFrame();
    @Override
    public void getBulletin() { //génération du bulletin d'un élève pour une période donnée
        Periode periode = consultC.controlPeriode();
        if(periode == null){
            msg.errorMsg(frame);
            return;
        }
        Niveau niveau = consultC.controlNiveau();
        if(niveau == null){
            msg.errorMsg(frame);
            return;
        }
        Classe classe = consultC.controlClasse(niveau);
        if(classe == null){
            msg.errorMsg(frame);
            return;
        }
        Eleve eleve = consultC.controlEleve(classe);
        if(eleve == null){
            msg.errorMsg(frame);
            return;
        }
        PanelBulletin bulletin = new PanelBulletin(periode, eleve); //on crée un objet panel bulletin
        if(bulletin.isObtained()){ //si le bulletin a été effectivement généré par l'objet on l'affiche
            showBulletin(bulletin);
        }
        
    }

    @Override
    public void getMoyenneCours() {
        Periode periode = consultC.controlPeriode();
        if(periode == null){
            msg.errorMsg(frame);
            return;
        }
        Niveau niveau = consultC.controlNiveau();
        if(niveau == null){
            msg.errorMsg(frame);
            return;
        }
        Classe classe = consultC.controlClasse(niveau);
        if(classe == null){
            msg.errorMsg(frame);
            return;
        }
        Cours cours = consultC.controlCours(classe);
        if(cours == null){
            msg.errorMsg(frame);
            return;
        }
        bmsg.showMoyCours(frame, periode, cours);
    }
    
    @Override
    public void showBulletin(PanelBulletin bulletin){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //taille de l'écran
        MainViewGUI.getMainFrame().getOutputPanel().removeAll(); //on efface le panneau d'affichage
        MainViewGUI.getMainFrame().repaint(); //on le repeint 
        MainViewGUI.getMainFrame().getOutputPanel().add(bulletin, BorderLayout.CENTER); //puis on ajoute le bulletin à la fenetre
        MainViewGUI.getMainFrame().pack();
        MainViewGUI.getMainFrame().setSize(screenSize);
        MainViewGUI.getMainFrame().setLocation(0, 0);
        MainViewGUI.getMainFrame().setVisible(true);
    }
    
}
