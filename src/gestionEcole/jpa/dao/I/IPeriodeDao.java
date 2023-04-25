/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Periode;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IPeriodeDao {
    public Periode ajouter(Periode periode);
    public int supprimer(Periode periode);
    public int supprimer(Long id);
    public List<Periode> lister();
    public Periode trouver(Long id);
    public int modifier(Periode periode);

}
