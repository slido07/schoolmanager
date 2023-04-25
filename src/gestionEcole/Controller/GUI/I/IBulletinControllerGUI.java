/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.Controller.GUI.I;

import gestionEcole.View.GUI.components.bulletin.PanelBulletin;

/**
 *
 * @author HP
 */
public interface IBulletinControllerGUI {
    public void getBulletin();
    public void getMoyenneCours();
    public void showBulletin(PanelBulletin bulletin);
}
