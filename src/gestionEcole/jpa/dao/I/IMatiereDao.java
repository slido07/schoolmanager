/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Matiere;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IMatiereDao {
    public Matiere ajouter(Matiere matiere);
    public int supprimer(Matiere matiere);
    public int supprimer(Long id);
    public List<Matiere> lister();
    public Matiere trouver(Long id);
    public int modifier(Matiere matiere);
    
}
