/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Niveau;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEnseignementDao {
    public Enseignement ajouter(Enseignement enseignement);
    public int supprimer(Enseignement enseignement);
    public int supprimer(Long id);
    public int modifier(Enseignement enseignement);
    public List<Enseignement> lister();
    public List<Enseignement> lister(Niveau niveau);
    public List<Enseignement> lister(Matiere matiere);
    public Enseignement trouver(Long id);   
}
