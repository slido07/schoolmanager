/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.CLI.impl;

import gestionEcole.View.CLI.I.IModificationView;

/**
 *
 * @author HP
 */
public class ModificationViewImpl implements IModificationView {
    
    @Override
    public void updateMsg() {
        System.out.println("\t---Veuillez saisir/choisir la nouvelle valeur de l'objet à modifier---");
    }

    @Override
    public void showSucessMsg() {
        System.out.println("\n-------------MODIFICATION EFFECTUE------------");
    }
    
    @Override
    public void showCancelMsg() {
        System.out.println("\n-------------MODIFICATION ANNULEE------------");
    }
}
