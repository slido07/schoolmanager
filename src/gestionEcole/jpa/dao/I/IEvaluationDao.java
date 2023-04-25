/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Periode;
import gestionEcole.model.entity.TypeEvaluation;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEvaluationDao {
    public Evaluation ajouter(Evaluation evaluation);
    public int supprimer(Evaluation evaluation);
    public int supprimer(Long id);
    public int modifier(Evaluation evaluation);
    public List<Evaluation> lister();
    public List<Evaluation> lister(TypeEvaluation type);
    public List<Evaluation> lister(Classe classe);
    public List<Evaluation> lister(Cours cours);
    public List<Evaluation> lister(Periode periode); 
    public List<Evaluation> lister(Periode periode, Cours cours);
    public List<Evaluation> lister(Periode periode, Classe classe);
    public Evaluation trouver(Long id);
}
