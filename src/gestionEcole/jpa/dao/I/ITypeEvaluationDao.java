/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestionEcole.jpa.dao.I;

import gestionEcole.model.entity.TypeEvaluation;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ITypeEvaluationDao {
    public TypeEvaluation ajouter(TypeEvaluation type);
    public int supprimer(TypeEvaluation type);
    public int supprimer(Long id);
    public List<TypeEvaluation> lister();
    public TypeEvaluation trouver(Long id);
    public int modifier(TypeEvaluation type);
}
