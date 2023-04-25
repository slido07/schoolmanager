/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.View.CLI.I;

import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Periode;

/**
 *
 * @author HP
 */
public interface IBulletinView {
    public void showBulletin(Periode periode, Eleve eleve);
    public String rang(int rang);
    public String mention(double moyenne);
    public void showMoyenne(Periode periode, Cours cours);
    public void showCancelMsg();
    public void noticeInsufficientNoteQty();
}
