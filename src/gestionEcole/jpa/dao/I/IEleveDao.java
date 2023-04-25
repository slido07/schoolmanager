/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Niveau;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEleveDao {
    public Eleve ajouter(Eleve eleve);
    public int supprimer(Eleve eleve);
    public int supprimer(Long id);
    public int modifier(Eleve eleve);
    public List<Eleve> lister();
    public List<Eleve> lister(Classe classe);
    public List<Eleve> lister(Niveau niveau); 
    public Eleve trouver(Long id);
   
}
