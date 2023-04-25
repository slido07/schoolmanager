/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.CLI.impl;

import gestionEcole.View.CLI.I.IAjoutView;
import gestionEcole.View.CLI.I.IMainView;
import gestionEcole.View.CLI.I.IModificationView;
import gestionEcole.View.CLI.impl.AjoutViewImpl;
import gestionEcole.jpa.dao.impl.CoursDaoImpl;
import gestionEcole.jpa.dao.impl.EnseignementDaoImpl;
import gestionEcole.jpa.dao.impl.EleveDaoImpl;
import gestionEcole.jpa.dao.impl.EvaluationDaoImpl;
import gestionEcole.jpa.dao.impl.NoteDaoImpl;
import gestionEcole.jpa.dao.I.IEleveDao;
import gestionEcole.jpa.dao.I.INoteDao;
import gestionEcole.jpa.dao.I.ICoursDao;
import gestionEcole.jpa.dao.I.IEnseignementDao;
import gestionEcole.jpa.dao.I.IEvaluationDao;
import gestionEcole.model.entity.*;
import gestionEcole.View.CLI.impl.MainViewImpl;
import gestionEcole.View.CLI.impl.ModificationViewImpl;
import java.time.LocalDate;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;
import gestionEcole.Controller.CLI.I.IModificationControllerCLI;

/**
 *
 * @author HP
 */
public class ModificationControllerImpl implements IModificationControllerCLI {
    //objets dao
    private static final IEnseignementDao enseignementDao = new EnseignementDaoImpl();
    private static final ICoursDao coursDao = new CoursDaoImpl();
    private static final IEleveDao eleveDao = new EleveDaoImpl();
    private static final IEvaluationDao evaluationDao = new EvaluationDaoImpl();
    private static final INoteDao noteDao = new NoteDaoImpl();
    //objets vues et controller
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    private static final IAjoutView addV = new AjoutViewImpl();
    private static final IModificationView modificationV = new ModificationViewImpl();
    private static final IMainView mainV = new MainViewImpl();

    @Override
    public void controller() {
        boolean status = true;
        int coefficient, bareme;
        double poids, valeur;
        LocalDate date;
        Enseignement enseignement;
        Cours cours;
        Classe classe, newClasse;
        Enseignant enseignant;
        Eleve eleve;
        Evaluation evaluation;
        Note note;
        Niveau niveau;
        Periode periode;

        do {
            switch (mainV.showUpdate()) {
                case 1:  //coefficient d'un enseignement
                    niveau =  consultationC.controlNiveau();
                    enseignement =  consultationC.controlEnseignement(niveau);
                    if (enseignement != null) {
                        modificationV.updateMsg();
                        coefficient = addV.inputCoefficient();
                        enseignement.setCoefficient(coefficient);
                        enseignementDao.modifier(enseignement);
                        modificationV.showSucessMsg();
                    }
                    break;
                case 2:   //enseignant d'un cours
                    niveau =  consultationC.controlNiveau();
                    classe =  consultationC.controlClasse(niveau);
                    cours =  consultationC.controlCours(classe);
                    if (cours != null) {
                        modificationV.updateMsg();
                        enseignant =  consultationC.controlEnseignant();
                        cours.setEnseignant(enseignant);
                        coursDao.modifier(cours);
                        modificationV.showSucessMsg();
                    }
                    break;
                case 3:   //classe d'un élève
                    niveau =  consultationC.controlNiveau();
                    classe =  consultationC.controlClasse(niveau);
                    eleve =  consultationC.controlEleve(classe);
                    if (eleve != null) {
                        modificationV.updateMsg();
                        niveau =  consultationC.controlNiveau();
                        newClasse =  consultationC.controlClasse(niveau);
                        if (newClasse != null) {
                            eleve.setClasse(newClasse);
                            eleveDao.modifier(eleve);
                            modificationV.showSucessMsg();
                        }
                    }
                    break;
                case 4:   //barème d'une évaluation
                    periode =  consultationC.controlPeriode();
                    niveau =  consultationC.controlNiveau();
                    classe =  consultationC.controlClasse(niveau);
                    cours =  consultationC.controlCours(classe);
                    evaluation =  consultationC.controlEvaluation(periode, cours);
                    if (evaluation != null) {
                        modificationV.updateMsg();
                        bareme = addV.inputBareme();
                        evaluation.setBareme(bareme);
                        evaluationDao.modifier(evaluation);
                        modificationV.showSucessMsg();
                    }
                    break;
                case 5:  //poids d'une évaluation
                    periode =  consultationC.controlPeriode();
                    niveau =  consultationC.controlNiveau();
                    classe =  consultationC.controlClasse(niveau);
                    cours =  consultationC.controlCours(classe);
                    evaluation =  consultationC.controlEvaluation(periode, cours);
                    if (evaluation != null) {
                        modificationV.updateMsg();
                        poids = addV.inputPoids();
                        evaluation.setPoids(poids);
                        evaluationDao.modifier(evaluation);
                        modificationV.showSucessMsg();
                    }
                    break;
                case 6:   //date d'une évaluation
                    periode =  consultationC.controlPeriode();
                    niveau =  consultationC.controlNiveau();
                    classe =  consultationC.controlClasse(niveau);
                    cours =  consultationC.controlCours(classe);
                    evaluation =  consultationC.controlEvaluation(periode, cours);
                    if (evaluation != null) {
                        modificationV.updateMsg();
                        date = addV.inputDate();
                        evaluation.setDate(date);
                        evaluationDao.modifier(evaluation);
                        modificationV.showSucessMsg();
                    }
                    break;
                case 7:  //valeur d'une note
                    periode =  consultationC.controlPeriode();
                    niveau =  consultationC.controlNiveau();
                    classe =  consultationC.controlClasse(niveau);
                    cours =  consultationC.controlCours(classe);
                    eleve =  consultationC.controlEleve(classe);
                    note =  consultationC.controlNote(periode, eleve, cours);
                    if (note != null) {
                        modificationV.updateMsg();
                        valeur = addV.inputValeur();
                        note.setValeur(valeur);
                        noteDao.modifier(note);
                        modificationV.showSucessMsg();
                    }
                    break;
                case 8:  //quitter la section 
                    status = false;
                    break;
            }
        } while (status == true);
    }

}
