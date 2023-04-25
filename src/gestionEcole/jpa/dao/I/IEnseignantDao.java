/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Enseignant;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEnseignantDao {
    public Enseignant ajouter(Enseignant enseignant);
    public int supprimer(Enseignant enseignant);
    public int supprimer(Long id);
    public int modifier(Enseignant enseignant);
    public List<Enseignant> lister();
    public Enseignant trouver(Long id);
}
