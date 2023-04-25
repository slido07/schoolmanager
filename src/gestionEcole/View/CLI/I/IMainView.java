/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.View.CLI.I;

/**
 *
 * @author HP
 */
public interface IMainView {
    public void welcomeMsg();
    public int showMenu();
    public int showAdd();
    public int showDel();
    public int showConsult();
    public int showUpdate();
    public int showBulletin();
    public int getChoice(int nbOptions);
    public int inputChoice();
    
}
