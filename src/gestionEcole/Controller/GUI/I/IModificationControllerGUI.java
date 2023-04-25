/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.Controller.GUI.I;

import java.time.LocalDate;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public interface IModificationControllerGUI {
    public void controller();
    public String newNom(JFrame f);
    public String newPrenom(JFrame f);
    public String newLibelle(JFrame f);
    public String newCode(JFrame f);
    public String newDescription(JFrame f);
    public String newSubdivision(JFrame f);
    public char newSexe(JFrame f);
    public int newCoefficient(JFrame f);
    public int newBareme(JFrame f);
    public double newPoids(JFrame f);
    public double newValeur(JFrame f);
    public LocalDate newDate(JFrame f);
}
