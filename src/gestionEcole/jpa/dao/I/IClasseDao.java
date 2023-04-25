/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Niveau;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IClasseDao {
    public Classe ajouter(Classe classe);
    public int supprimer(Classe classe);
    public int supprimer(Long id);
    public Classe trouver(Long id);
    public int modifier(Classe classe);
    public List<Classe> lister();
    public List<Classe> lister(Niveau niveau);
    public List<Classe> lister(Long id_niveau);
    
}
