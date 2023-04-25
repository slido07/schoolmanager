/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Note;
import gestionEcole.model.entity.Periode;
import java.util.List;

/**
 *
 * @author HP
 */
public interface INoteDao {
    public Note ajouter(Note note);
    public int supprimer(Note note);
    public int supprimer(Long id);
    public int modifier(Note note);
    public List<Note> lister();
    public List<Note> lister(Periode periode, Cours cours);
    public List<Note> lister(Periode periode, Cours cours, Eleve eleve);
    public List<Note> lister(Periode periode, Eleve eleve);
    public List<Note> lister(Periode periode, Enseignement enseignement, Eleve eleve);
    public List<Note> lister(Periode periode, Eleve eleve, Cours cours);
    public List<Note> lister(Evaluation evaluation);
    public List<Note> lister(Evaluation evaluation, Eleve eleve);
    public Note trouver(Long id);
}
