/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.CLI.impl;

import gestionEcole.View.CLI.I.IAjoutView;
import gestionEcole.View.CLI.I.IConsultationView;
import gestionEcole.View.CLI.I.IMainView;
import gestionEcole.View.CLI.impl.*;
import gestionEcole.jpa.dao.I.*;
import gestionEcole.model.entity.*;
import gestionEcole.jpa.dao.impl.*;
import java.time.LocalDate;
import java.util.List;
import gestionEcole.Controller.CLI.I.IAjoutControllerCLI;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class AjoutControllerImpl implements IAjoutControllerCLI {
    //objets dao
    private static final INiveauDao niveauDao = new NiveauDaoImpl();
    private static final IClasseDao classeDao = new ClasseDaoImpl();
    private static final IEleveDao eleveDao = new EleveDaoImpl();
    private static final IEnseignantDao enseignantDao = new EnseignantDaoImpl();
    private static final IMatiereDao matiereDao = new MatiereDaoImpl();
    private static final ITypeEvaluationDao typeDao = new TypeEvaluationDaoImpl();
    private static final IEnseignementDao enseignementDao = new EnseignementDaoImpl();
    private static final ICoursDao coursDao = new CoursDaoImpl();
    private static final IPeriodeDao periodeDao = new PeriodeDaoImpl();
    private static final IEvaluationDao evaluationDao = new EvaluationDaoImpl();
    private static final INoteDao noteDao = new NoteDaoImpl();

    //objets controller
    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    private static final IAjoutView addV = new AjoutViewImpl();
    private static final IConsultationView consultationV = new ConsultationViewImpl();
    private static final IMainView mainV = new MainViewImpl();

    //controlleur principal de la section ajout
    @Override
    public void controller() {
        boolean status = true;
        do {
            switch (mainV.showAdd()) {
                case 1: //ajout d'un niveau
                    do {
                        addNiveau();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 2: //ajout d'une classe
                    do {
                        addClasse();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 3: //ajout d'un élève
                    do {
                        addEleve();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 4: //ajout d'une matiere
                    do {
                        addMatiere();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 5: //ajout d'une periode
                    do {
                        addPeriode();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 6: //ajout d'un enseignant
                    do {
                        addEnseignant();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 7: //ajout d'un type d'évaluation
                    do {
                        addType();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 8: //ajout d'une évaluation
                    do {
                        addEvaluation();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 9: //ajout d'enseignements
                    do {
                        addEnseignement();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 10:
                    do {
                        addCours();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 11: //ajout d'une note
                    do {
                        addNote();
                    } while (addV.repeatAction() == 'O');
                    break;
                case 12: //quitter
                    status = false;
                    break;
            }
        } while (status == true);
    }

    @Override
    public void addNiveau() {
        addV.showAddNiveauMsg();
        String libelle = addV.inputLibelle();
        String description = addV.inputDescription();
        Niveau niveau = new Niveau(libelle, description);

        niveauDao.ajouter(niveau); //ajout à la base de données
        addV.showSucessMsg();
    }

    @Override
    public void addClasse() {
        addV.showAddClasseMsg();
        Niveau niveau = consultationC.controlNiveau();
        if (niveau == null) {
            return;
        }
        String subdivision = addV.inputSubdivision();
        Classe classe = new Classe(niveau, subdivision);
        //verification si la classe n'a pas déjà été ajouté
        List<Classe> listeC = consultationC.getListeClasse();
        if (!listeC.isEmpty()) {
            for (Classe c : listeC) {
                if ((c.getNiveau().equals(niveau)) && (c.getSubdivision().equals(subdivision))) {
                    addV.alreadyDoneAction();
                    return;
                }
            }
        }
        classe = classeDao.ajouter(classe);
        if(classe != null){
            addV.showSucessMsg();

        }
    }

    @Override
    public void addEleve() {
        addV.showAddEleveMsg();
        Niveau niveau = consultationC.controlNiveau();
        if (niveau == null) {
            return;
        }
        Classe classe = consultationC.controlClasse(niveau);
        if (classe == null) {
            return;
        }
        String nom = addV.inputNom();
        String prenom = addV.inputPrenom();
        char sexe = addV.inputSexe();
        Eleve eleve = new Eleve(nom, prenom, sexe, classe);
     
        eleve = eleveDao.ajouter(eleve);
        if(eleve != null){
           addV.showSucessMsg();
        }
    }

    @Override
    public void addEnseignant() {
        addV.showAddEnseignantMsg();
        String nom = addV.inputNom();
        String prenom = addV.inputPrenom();
        Enseignant enseignant = new Enseignant(nom, prenom);
        enseignant = enseignantDao.ajouter(enseignant);
        if(enseignant != null){
            addV.showSucessMsg();
        }
    }

    @Override
    public void addMatiere() {
        addV.showAddMatiereMsg();
        String libelle = addV.inputLibelle();
        String code = addV.inputCode();
        Matiere matiere = new Matiere(code, libelle);

        //verification si la matiere n'a pas déjà été ajoutée
        List<Matiere> listeM = consultationC.getListeMatiere();
        if (!listeM.isEmpty()) {
            for (Matiere m : listeM) {
                if (m.getCode().equals(code)) {
                    addV.alreadyDoneAction();
                    return;
                }
            }
        }
        matiere = matiereDao.ajouter(matiere);
        if(matiere != null){
            addV.showSucessMsg();
        }
    }

    @Override
    public void addType() {
        addV.showAddTypeMsg();
        String libelle = addV.inputLibelle();
        String code = addV.inputCode();
        TypeEvaluation type = new TypeEvaluation(code, libelle);

        //verification si le type n'a pas déjà été ajouté
        List<TypeEvaluation> listeT = consultationC.getListeType();
        if (!listeT.isEmpty()) {
            for (TypeEvaluation t : listeT) {
                if (t.getCode().equals(code)) {
                    addV.alreadyDoneAction();
                    return;
                }
            }
        }
        type = typeDao.ajouter(type);
        if(type != null){
            addV.showSucessMsg();
        }
    }

    @Override
    public void addEnseignement(Matiere matiere, Niveau niveau) {
        //vérification si un enseignement n'existe pas déjà pour cette matière et ce niveau si la liste enregistrée 
        //est non vide
        List<Enseignement> listeEns = consultationC.getListeEnseignement();
        if (!listeEns.isEmpty()) {
            for (Enseignement enseignement : listeEns) {
                if ((enseignement.getNiveau().equals(niveau)) && (enseignement.getMatiere().equals(matiere))) {
                    //si l'élément a déjà été créé on ne l'ajoute plus   
                    addV.alreadyDoneAction();
                    return;
                }
            }
        }
        addV.showAddEnseignementMsg(niveau, matiere);
        addV.showCoeffChoice();
        int coefficient = addV.inputCoefficient();
        Enseignement enseignement = new Enseignement(matiere, niveau, coefficient);
        enseignement = enseignementDao.ajouter(enseignement);
        if(enseignement != null){
            addV.showSucessMsg();
        }
    }

    //ajout d'enseignements pour toutes les matières dans un niveau
    @Override
    public void addEnseignement() {
        Niveau niveau = consultationC.controlNiveau();
        if (niveau == null) {
            return;
        }
        List<Matiere> listeM = consultationC.getListeMatiere();
        if (!listeM.isEmpty()) {
            listeM.forEach(matiere -> {
                addEnseignement(matiere, niveau);
            });
        } else {
            consultationV.noticeEmptyList(Matiere.class.getSimpleName());
        }
    }

    @Override
    public void addCours(Enseignement enseignement, Classe classe) {
        //vérification si un cours n'existe pas déjà pour cette classe si la liste enregistrée est non vide
        List<Cours> listeC = consultationC.getListeCours();
        if (!listeC.isEmpty()) {
            for (Cours cours : listeC) {
                if (cours.getClasse().equals(classe) && cours.getEnseignement().equals(enseignement)) {
                    //si l'élément a déjà été créé on ne l'ajoute plus   
                    addV.alreadyDoneAction();
                    return;
                }
            }
        }
        addV.showAddCoursMsg(enseignement, classe);
        addV.showEnseignantChoice();
        Enseignant enseignant = consultationC.controlEnseignant();
        Cours cours = new Cours(enseignement, classe, enseignant);
        cours = coursDao.ajouter(cours);
        if(cours != null){
            addV.showSucessMsg();
        }
    }

    //ajout de cours pour tous les enseignements d'un niveau dans une classe
    @Override
    public void addCours() {
        Niveau niveau = consultationC.controlNiveau();
        Classe classe = consultationC.controlClasse(niveau);
        if (classe == null) {
            return;
        }
        //liste des enseignements du même niveau que cette classe
        List<Enseignement> listeEns = consultationC.getListeEnseignement(classe.getNiveau());
        if (!listeEns.isEmpty()) {
            listeEns.forEach(enseignement -> {
                addCours(enseignement, classe);
            });
        } else {
            consultationV.noticeEmptyList(Enseignement.class.getSimpleName());
        }
    }

    @Override
    public void addPeriode() {
        addV.showAddPeriodeMsg();
        String libelle = addV.inputLibelle();
        Periode periode = new Periode(libelle);
        periode = periodeDao.ajouter(periode);
        if(periode != null){
            addV.showSucessMsg();
        }
    }

    @Override
    public void addEvaluation() {
        addV.showAddEvaluationMsg();
        Periode periode = consultationC.controlPeriode();
        if (periode == null) {
            return;
        }
        Niveau niveau = consultationC.controlNiveau();
        Classe classe = consultationC.controlClasse(niveau);
        if (classe == null) {
            return;
        }
        Cours cours = consultationC.controlCours(classe);
        if (cours == null) {
            return;
        }
        TypeEvaluation type = consultationC.controlType();
        if (type == null) {
            return;
        }
        double poids = addV.inputPoids();
        LocalDate date = addV.inputDate();
        Evaluation evaluation = new Evaluation(periode, cours, poids, type);
        evaluation.setDate(date);
        evaluation = evaluationDao.ajouter(evaluation);
        if(evaluation != null){
            addV.showSucessMsg();
        }
    }

    @Override
    public void addNote() {
        double valeur;
        boolean saved;
        Periode periode = consultationC.controlPeriode();
        if (periode == null) {
            return;
        }
        Niveau niveau = consultationC.controlNiveau();
        Classe classe = consultationC.controlClasse(niveau);
        if (classe == null) {
            return;
        }
        Cours cours = consultationC.controlCours(classe);
        Evaluation evaluation = consultationC.controlEvaluation(periode, cours);
        if (evaluation == null) {
            return;
        }
        //liste des élèves de la classe concernée par l'évaluation
        List<Eleve> listeE = consultationC.getListeEleve(classe);
        if (listeE.isEmpty()) {
            consultationV.noticeEmptyList(Eleve.class.getSimpleName());
            return;
        }
        //liste des notes pour cette évaluation
        List<Note> listeN = consultationC.getListeNote(evaluation);
        for (Eleve eleve : listeE) {
            saved = false;
            addV.showAddNoteMsg(eleve);
            valeur = addV.inputValeur();
            //vérification si la note n'a pas déjà été ajoutée  
            if (!listeN.isEmpty()) {
                for (Note n : listeN) {
                    if ((n.getEleve().equals(eleve)) && (n.getEvaluation().equals(evaluation))) {
                        addV.alreadyDoneAction();
                        saved = true;
                    }
                }
            }
            if (!saved) {
                Note note = new Note(evaluation, eleve, valeur);
                note = noteDao.ajouter(note);
                if(note != null){
                    addV.showSucessMsg();
                }
            }
        }
    }

}
