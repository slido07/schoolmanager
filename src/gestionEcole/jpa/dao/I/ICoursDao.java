/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Enseignement;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ICoursDao {
    public Cours ajouter(Cours cours);
    public int supprimer(Cours cours);
    public int supprimer(Long id);
    public int modifier(Cours cours);
    public List<Cours> lister();
    public List<Cours> lister(Enseignement enseignement);
    public List<Cours> lister(Classe classe);
    public Cours trouver(Long id);
}
