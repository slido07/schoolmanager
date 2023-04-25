/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.CLI.impl;

import gestionEcole.View.CLI.I.IConsultationView;
import gestionEcole.View.CLI.I.IMainView;
import gestionEcole.View.CLI.I.ISuppressionView;
import gestionEcole.jpa.dao.impl.*;
import gestionEcole.jpa.dao.I.*;
import gestionEcole.model.entity.*;
import gestionEcole.View.CLI.impl.ConsultationViewImpl;
import gestionEcole.View.CLI.impl.MainViewImpl;
import gestionEcole.View.CLI.impl.SuppressionViewImpl;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;
import gestionEcole.Controller.CLI.I.ISuppressionControllerCLI;

/**
 *
 * @author HP
 */
public class SuppressionControllerImpl implements ISuppressionControllerCLI {

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
    //private  final NoteDaoImpl noteDao = new NoteDaoImpl();
    //objets controller
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    private static final IConsultationView consultationV = new ConsultationViewImpl();
    private static final ISuppressionView suppressionV = new SuppressionViewImpl();
    private static final IMainView mainV = new MainViewImpl();

    //controlleur principal de la section suppression
    @Override
    public void controller() {
        Niveau niveau;
        boolean status = true;
        do {
            switch (mainV.showDel()) {
                case 1: //suppression d'un niveau
                    delNiveau();
                    break;
                case 2: //suppression d'une classe
                    delClasse();
                    break;
                case 3: //suppression d'un élève
                    delEleve();
                    break;
                case 4: //suppression d'une matiere
                    delMatiere();
                    break;
                case 5: //suppression d'une periode
                    delPeriode();
                    break;
                case 6: //suppression d'un enseignant
                    delEnseignant();
                    break;
                case 7: //suppression d'un type d'évaluation
                    delType();
                    break;
                case 8: //suppression d'une évaluation
                    delEvaluation();
                    break;
                case 9: //toutes les classes d'un niveau
                    niveau = consultationC.controlNiveau();
                    delClasse(niveau);
                    break;
                case 10:   //tous les élèves d'une classe
                    niveau = consultationC.controlNiveau();
                    Classe classe = consultationC.controlClasse(niveau);
                    delEleve(classe);
                    break;
                case 11: //quitter
                    status = false;
                    break;
            }
        } while (status == true);
    }

    @Override
    public void delNiveau() {
        suppressionV.showDelNiveauMsg();
        Niveau niveau = consultationC.controlNiveau();
        if (niveau == null) {
            return;
        }
        char answer = suppressionV.showWarningMsgDelNiveau();
        if (answer == 'O') { // on vérifie si aucune classe n'est enregistrée à ce niveau
            if (niveau.isEmpty()) {
                //suppression du niveau
                niveauDao.supprimer(niveau);
                suppressionV.showSucessMsg();
            } else {
                suppressionV.showDelNiveauExitMsg();
            }
        } else {
            suppressionV.showCancelMsg();
        }
    }

    @Override
    public void delClasse() {
        char answer;
        List<Eleve> listeEleve;
        suppressionV.showDelClasseMsg();
        Niveau niveau = consultationC.controlNiveau();
        Classe classe = consultationC.controlClasse(niveau), newClasse;
        if (classe == null) {
            return;
        }
        listeEleve = consultationC.getListeEleve(classe);
        answer = suppressionV.showWarningMsgDelClasse();
        if (answer == 'O') //modification de la classe de tous les élèves avant la poursuite de l'opération
        {
            niveau = consultationC.controlNiveau();
            newClasse = consultationC.controlClasse(niveau);
            if (newClasse == null) {
                return;
            }
            //si la liste d'élève est non vide
            if (!listeEleve.isEmpty()) {
                for (Eleve eleve : listeEleve) {
                    eleve.setClasse(newClasse);
                    eleveDao.modifier(eleve);
                }
            } else {
                consultationV.noticeEmptyList(Eleve.class.getSimpleName());
            }
        }
        answer = suppressionV.pursueOperation();
        if (answer == 'O') {    //on poursuit l'opération de suppression
            //on vérifie si la classe est vide
            if (classe.isEmpty()) {
                //suppression de la classe
                classeDao.supprimer(classe);
                suppressionV.showSucessMsg();
            } else {
                suppressionV.showDelClasseExitMsg();
            }
        } else {
            suppressionV.showCancelMsg();
        }
    }

    @Override
    public void delClasse(Niveau niveau) {
        if (niveau == null) {
            return;
        }
        char answer;
        List<Classe> listeClasse = consultationC.getListeClasse(niveau);
        if (listeClasse.isEmpty()) {
            consultationV.noticeEmptyList(Classe.class.getSimpleName());
            return;
        }
        suppressionV.showDelClasseMsg(niveau);
        answer = suppressionV.showWarningMsgDelClasse(niveau);

        if (answer == 'O') //on vérifie si toutes les classes du niveau sont vides
        {
            for (Classe classe : listeClasse) {
                if (!classe.isEmpty()) {  //si l'une d'elles est non vides
                    suppressionV.showDelClasseExitMsg(classe);
                    return;   //on arrête la fonction
                }
            }
            //si elles sont toutes vides on peut alors les supprimer
            listeClasse.stream().map(classe -> {
                classeDao.supprimer(classe);
                return classe;
            }).forEachOrdered(_item -> {
                suppressionV.showSucessMsg();
            });
        }
    }

    @Override
    public void delEleve() {
        suppressionV.showDelEleveMsg();
        Niveau niveau = consultationC.controlNiveau();
        Classe classe = consultationC.controlClasse(niveau);
        Eleve eleve = consultationC.controlEleve(classe);
        if (eleve == null) {
            return;
        }
        char answer = suppressionV.showWarningMsgDelEleve();
        if (answer == 'O') { //suppression de toutes les notes enregistrées pour cet élève
            eleve.supprimerNote();
            //suppression de l'élève lui-même
            eleveDao.supprimer(eleve);
            suppressionV.showSucessMsg();
        } else {  //sinon l'opération est annulée
            suppressionV.showCancelMsg();
        }
    }

    @Override
    public void delEleve(Classe classe) {
        if (classe == null) {
            return;
        }
        suppressionV.showDelEleveMsg(classe);
        List<Eleve> listeE = consultationC.getListeEleve(classe);
        if (listeE.isEmpty()) {
            consultationV.noticeEmptyList(Eleve.class.getSimpleName());
            return;
        }
        //on prévient l'utilisateur des conséquences de cette action
        char answer = suppressionV.showWarningMsgDelEleve();
        if (answer == 'O') { //suppression de toutes les notes enregistrées pour chaque élève
            listeE.stream().map(eleve -> {
                eleve.supprimerNote();
                return eleve;
            }).map(eleve -> {
                //suppression de l'élève lui-même
                eleveDao.supprimer(eleve);
                return eleve;
            }).forEachOrdered(_item -> {
                suppressionV.showSucessMsg();
            });
        } else {  //sinon l'opération est annulée
            suppressionV.showCancelMsg();
        }
    }

    @Override
    public void delEnseignant() {
        suppressionV.showDelEnseignantMsg();
        Enseignant enseignant = consultationC.controlEnseignant();
        if (enseignant == null) {
            return;
        }
        enseignantDao.supprimer(enseignant);
        suppressionV.showSucessMsg();
    }

    @Override
    public void delMatiere() {
        suppressionV.showDelMatiereMsg();
        Matiere matiere = consultationC.controlMatiere();
        if (matiere == null) {
            return;
        }
        //on vérifie si aucun enseignement ne dépend de cette matière
        if (matiere.isEmpty()) {
            matiereDao.supprimer(matiere);
            suppressionV.showSucessMsg();
        } else {
            suppressionV.showDelMatiereExitMsg();
        }
    }

    @Override
    public void delPeriode() {
        suppressionV.showDelPeriodeMsg();
        Periode periode = consultationC.controlPeriode();
        if (periode == null) {
            return;
        }
        if (periode.isEmpty()) {
            periodeDao.supprimer(periode);
            suppressionV.showSucessMsg();
        } else {
            suppressionV.showDelPeriodeExitMsg();
        }
    }

    @Override
    public void delType() {
        suppressionV.showDelTypeMsg();
        TypeEvaluation type = consultationC.controlType();
        if (type == null) {
            return;
        }
        if (type.isEmpty()) {
            typeEvaluationDao.supprimer(type);
            suppressionV.showSucessMsg();
        } else {
            suppressionV.showDelTypeExitMsg();
        }
    }

    //à revoir
    @Override
    public void delEnseignement() {
        Niveau niveau = consultationC.controlNiveau();
        Enseignement enseignement = consultationC.controlEnseignement(niveau);
        if (enseignement == null) {
            return;
        }
        suppressionV.showDelEnseignementMsg();
        if (enseignement.isEmpty()) {
            enseignementDao.supprimer(enseignement);
            suppressionV.showSucessMsg();
        } else {
            suppressionV.showDelEnseignementExitMsg();
        }
    }

    @Override
    public void delCours() {
        Niveau niveau = consultationC.controlNiveau();
        Classe classe = consultationC.controlClasse(niveau);
        Cours cours = consultationC.controlCours(classe);
        if (cours == null) {
            return;
        }
        suppressionV.showDelCoursMsg();
        if (cours.isEmpty()) {
            coursDao.supprimer(cours);
            suppressionV.showSucessMsg();
        } else {
            suppressionV.showDelCoursExitMsg();
        }
    }

    @Override
    public void delEvaluation() {
        Periode periode = consultationC.controlPeriode();
        Niveau niveau = consultationC.controlNiveau();
        Classe classe = consultationC.controlClasse(niveau);
        Cours cours = consultationC.controlCours(classe);
        Evaluation evaluation = consultationC.controlEvaluation(periode, cours);
        if (evaluation == null) {
            return;
        }
        suppressionV.showDelEvaluationMsg();
        //suppression de toutes les notes de l'évaluation
        if (!evaluation.isEmpty()) {
            evaluation.supprimerNote();
        }
        evaluationDao.supprimer(evaluation);
        suppressionV.showSucessMsg();
    }

}
