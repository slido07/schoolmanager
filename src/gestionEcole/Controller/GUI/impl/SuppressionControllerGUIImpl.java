/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.GUI.impl;

import gestionEcole.Controller.GUI.I.IConsultationControllerGUI;
import gestionEcole.Controller.GUI.I.ISuppressionControllerGUI;
import gestionEcole.View.GUI.components.messages.DelMessages;
import gestionEcole.jpa.dao.I.*;
import gestionEcole.jpa.dao.impl.*;
import gestionEcole.model.entity.*;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.util.List;

/**
 *
 * @author HP
 */
public class SuppressionControllerGUIImpl implements ISuppressionControllerGUI {

    //objets dao
    private static final INiveauDao niveauDao = new NiveauDaoImpl();
    private static final IClasseDao classeDao = new ClasseDaoImpl();
    private static final IEleveDao eleveDao = new EleveDaoImpl();
    private static final IEnseignantDao enseignantDao = new EnseignantDaoImpl();
    private static final IMatiereDao matiereDao = new MatiereDaoImpl();
    private static final ITypeEvaluationDao typeEvaluationDao = new TypeEvaluationDaoImpl();
    private static final IEnseignementDao enseignementDao = new EnseignementDaoImpl();
    private static final ICoursDao coursDao = new CoursDaoImpl();
    private static final IPeriodeDao periodeDao = new PeriodeDaoImpl();
    private static final IEvaluationDao evaluationDao = new EvaluationDaoImpl();
    private static final INoteDao noteDao = new NoteDaoImpl();

    private static final IConsultationControllerGUI consultC = new ConsultationControllerGUIImpl();

    @Override
    public void delNiveau() {
        DelMessages msg = new DelMessages();
        Niveau niveau = consultC.controlNiveau();
        if (niveau == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        msg.warningMsg(MainViewGUI.getMainFrame());
        if (msg.isWarningMsgRep()) { //si la réponse est oui
            if (niveau.isEmpty()) {
                niveauDao.supprimer(niveau);
                msg.successMsg(MainViewGUI.getMainFrame());
            } else {
                msg.objectDelCancelled(MainViewGUI.getMainFrame(), Niveau.class.getSimpleName());
                msg.errorMsg(MainViewGUI.getMainFrame());
            }
        } else {
            msg.cancelMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delClasse() {
        DelMessages msg = new DelMessages();
        List<Eleve> listeEleve;
        Niveau niveau = consultC.controlNiveau();
        if (niveau == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Classe classe = consultC.controlClasse(niveau), newClasse;
        if (classe == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        listeEleve = consultC.getListeEleve(classe);
        msg.modifyEleveClasse(MainViewGUI.getMainFrame());
        if (msg.isModifyClasse()) {
            niveau = consultC.controlNiveau();
            newClasse = consultC.controlClasse(niveau);
            if (newClasse == null) {
                msg.errorMsg(MainViewGUI.getMainFrame());
                return;
            }
            //si la liste d'élève est non vide
            if (!listeEleve.isEmpty()) {
                for (Eleve eleve : listeEleve) {
                    eleve.setClasse(newClasse);
                    eleveDao.modifier(eleve);
                }
            }
        }
        if (classe.isEmpty()) {
            classeDao.supprimer(classe);
            msg.successMsg(MainViewGUI.getMainFrame());
        } else {
            msg.objectDelCancelled(MainViewGUI.getMainFrame(), Classe.class.getSimpleName());
            msg.errorMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delEleve() {
        DelMessages msg = new DelMessages();
        Niveau niveau = consultC.controlNiveau();
        Classe classe = consultC.controlClasse(niveau);
        Eleve eleve = consultC.controlEleve(classe);
        if (eleve == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        msg.warningDelEleveMsg(MainViewGUI.getMainFrame());
        if (msg.isDelEleveOk()) {
            eleve.supprimerNote();
            //suppression de l'élève lui-même
            eleveDao.supprimer(eleve);
            msg.successMsg(MainViewGUI.getMainFrame());
        } else {
            msg.cancelMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delPeriode() {
        Periode periode = consultC.controlPeriode();
        DelMessages msg = new DelMessages();
        if (periode == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        if (periode.isEmpty()) {
            periodeDao.supprimer(periode);
            msg.successMsg(MainViewGUI.getMainFrame());
        } else {
            msg.objectDelCancelled(MainViewGUI.getMainFrame(), Periode.class.getSimpleName());
            msg.errorMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delMatiere() {
        DelMessages msg = new DelMessages();
        Matiere matiere = consultC.controlMatiere();
        if (matiere == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        if (matiere.isEmpty()) {
            matiereDao.supprimer(matiere);
            msg.successMsg(MainViewGUI.getMainFrame());
        } else {
            msg.objectDelCancelled(MainViewGUI.getMainFrame(), Matiere.class.getSimpleName());
            msg.errorMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delType() {
        DelMessages msg = new DelMessages();
        TypeEvaluation type = consultC.controlType();
        if (type == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        if (type.isEmpty()) {
            typeEvaluationDao.supprimer(type);
            msg.successMsg(MainViewGUI.getMainFrame());
        } else {
            msg.objectDelCancelled(MainViewGUI.getMainFrame(), "Type d'évaluation");
            msg.errorMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delEnseignant() {
        DelMessages msg = new DelMessages();
        Enseignant enseignant = consultC.controlEnseignant();
        if (enseignant == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        enseignantDao.supprimer(enseignant);
        msg.successMsg(MainViewGUI.getMainFrame());
    }

    @Override
    public void delEnseignement() {
        DelMessages msg = new DelMessages();
        Niveau niveau = consultC.controlNiveau();
        Enseignement enseignement = consultC.controlEnseignement(niveau);
        if (enseignement == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        if (enseignement.isEmpty()) {
            enseignementDao.supprimer(enseignement);
            msg.successMsg(MainViewGUI.getMainFrame());
        } else {
            msg.objectDelCancelled(MainViewGUI.getMainFrame(), Enseignement.class.getSimpleName());
            msg.errorMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delCours() {
        DelMessages msg = new DelMessages();
        Niveau niveau = consultC.controlNiveau();
        Classe classe = consultC.controlClasse(niveau);
        Cours cours = consultC.controlCours(classe);
        if (cours == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        if (cours.isEmpty()) {
            coursDao.supprimer(cours);
            msg.successMsg(MainViewGUI.getMainFrame());
        } else {
            msg.objectDelCancelled(MainViewGUI.getMainFrame(), Cours.class.getSimpleName());
            msg.errorMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void delEvaluation() {
        DelMessages msg = new DelMessages();
        Periode periode = consultC.controlPeriode();
        Niveau niveau = consultC.controlNiveau();
        Classe classe = consultC.controlClasse(niveau);
        Cours cours = consultC.controlCours(classe);
        Evaluation evaluation = consultC.controlEvaluation(periode, cours);
        if (evaluation == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        //suppression de toutes les notes de l'évaluation
        if (!evaluation.isEmpty()) {
            evaluation.supprimerNote();
        }
        evaluationDao.supprimer(evaluation);
        msg.successMsg(MainViewGUI.getMainFrame());
    }

    @Override
    public void delNote() {
        DelMessages msg = new DelMessages();
        Periode periode = consultC.controlPeriode();
        if (periode == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Niveau niveau = consultC.controlNiveau();
        Classe classe = consultC.controlClasse(niveau);
        Cours cours = consultC.controlCours(classe);
        if (cours == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Eleve eleve = consultC.controlEleve(classe);
        if (eleve == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Note note = consultC.controlNote(periode, eleve, cours);
        if (note == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        noteDao.supprimer(note);
        msg.successMsg(MainViewGUI.getMainFrame());
    }

}
