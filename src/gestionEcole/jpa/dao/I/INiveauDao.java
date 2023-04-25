/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Niveau;
import java.util.List;

/**
 *
 * @author HP
 */
public interface INiveauDao {
    public Niveau ajouter(Niveau niveau);
    public int supprimer(Niveau niveau);
    public int supprimer(Long id);
    public Niveau trouver(Long id);
    public List<Niveau> lister();
    public int modifier(Niveau niveau);
}
