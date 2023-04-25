/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.GUI.impl;

import gestionEcole.View.GUI.components.addObject.AddNotePanel;
import gestionEcole.View.GUI.components.addObject.AddEvaluationPanel;
import gestionEcole.View.GUI.components.addObject.AddElevePanel;
import gestionEcole.View.GUI.components.addObject.AddClassePanel;
import gestionEcole.View.GUI.components.addObject.AddEnseignementPanel;
import gestionEcole.Controller.GUI.I.IAjoutControllerGUI;
import gestionEcole.Controller.GUI.I.IConsultationControllerGUI;
import gestionEcole.View.GUI.components.dialogs.*;
import gestionEcole.View.GUI.components.messages.AddMessages;
import gestionEcole.View.GUI.components.messages.ConsultMessages;
import gestionEcole.jpa.dao.I.*;
import gestionEcole.jpa.dao.impl.*;
import gestionEcole.model.entity.*;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author HP
 */
public class AjoutControllerGUIImpl implements IAjoutControllerGUI {

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
    private static final AddMessages msg = new AddMessages();

    //objets controller
    private static final IConsultationControllerGUI consultC = new ConsultationControllerGUIImpl();

    @Override
    public void addNiveau(String libelle, String description) {
        if ((libelle.isEmpty()) || (description.isEmpty())) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        Niveau niveau = new Niveau(libelle, description);
        niveau = niveauDao.ajouter(niveau); //ajout à la base de données
        if (niveau != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addClasse() {
        Niveau niveau = consultC.controlNiveau();
        JDialogAddClasse dialog;
        if (niveau == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        AddClassePanel addC = new AddClassePanel(niveau);
        dialog = new JDialogAddClasse(MainViewGUI.getMainFrame(), "Renseignements supplémentaires sur la classe à ajouter",
                addC);
        String subdivision = dialog.getForm().getSubdivision();
        if (subdivision == null) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        Classe classe = new Classe(niveau, subdivision);
        classe = classeDao.ajouter(classe);
        if (classe != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addEleve() {
        Niveau niveau = consultC.controlNiveau();
        Classe classe = consultC.controlClasse(niveau);
        if (classe == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        AddElevePanel addE = new AddElevePanel(classe);
        JDialogAddEleve dialog;
        dialog = new JDialogAddEleve(MainViewGUI.getMainFrame(), "Renseignements supplémentaires sur l'élèves à ajouter",
                addE);
        String nom = dialog.getForm().getNom();
        if (nom == null) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        String prenom = dialog.getForm().getPrenom();
        if (prenom == null) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        char sexe = dialog.getForm().getSexe();
        if (sexe == '#') {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        Eleve eleve = new Eleve(nom, prenom, sexe, classe);
        eleve = eleveDao.ajouter(eleve);
        if (eleve != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addPeriode(String libelle) {
        if (libelle.isEmpty()) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        Periode periode = new Periode(libelle);
        periode = periodeDao.ajouter(periode);
        if (periode != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addMatiere(String code, String libelle) {
        if ((code == null) || (libelle == null)) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        Matiere matiere = new Matiere(code, libelle);
        matiere = matiereDao.ajouter(matiere);
        if (matiere != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addType(String code, String libelle) {
        if ((code == null) || (libelle == null)) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        TypeEvaluation type = new TypeEvaluation(code, libelle);
        type = typeDao.ajouter(type);
        if (type != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addEnseignant(String nom, String prenom) {
        if ((nom == null) || (prenom == null)) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        Enseignant enseignant = new Enseignant(nom, prenom);
        enseignant = enseignantDao.ajouter(enseignant);
        if (enseignant != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addEnseignement() {
        Niveau niveau = consultC.controlNiveau();
        if (niveau == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        List<Matiere> listeM = consultC.getListeMatiere();
        if (!listeM.isEmpty()) {
            listeM.forEach(matiere -> {
                addEnseignement(matiere, niveau);
            });
        } else {
            ConsultMessages cMsg = new ConsultMessages();
            cMsg.noticeEmptyList(MainViewGUI.getMainFrame(), Matiere.class.getSimpleName());
        }
    }

    @Override
    public void addEnseignement(Matiere matiere, Niveau niveau) {  //ajout élémentaire d'un enseignement
        List<Enseignement> liste = consultC.getListeEnseignement();
        if (!liste.isEmpty()) {
            //on s'assure que l'enseignement n'a pas déjà été enregistré
            for (Enseignement enseignement : liste) {
                if ((enseignement.getNiveau().equals(niveau)) && (enseignement.getMatiere().equals(matiere))) {
                    //si l'élément a déjà été enregistré on ne l'ajoute plus   
                    msg.alreadyDoneAction(MainViewGUI.getMainFrame());
                    return;
                }
            }
            AddEnseignementPanel addEns = new AddEnseignementPanel(niveau, matiere);
            JDialogAddEnseignement dialog = new JDialogAddEnseignement(MainViewGUI.getMainFrame(), "Renseignement du coefficient",
                    addEns);
            int coefficient = dialog.getForm().getCoefficient();
            if (coefficient == 0) {
                msg.cancelMsg(MainViewGUI.getMainFrame());
                return;
            }
            Enseignement enseignement = new Enseignement(matiere, niveau, coefficient);
            enseignement = enseignementDao.ajouter(enseignement);
            if (enseignement != null) {
                msg.successMsg(MainViewGUI.getMainFrame());
            }
        }
    }

    @Override
    public void addCours() {  //ajout élémentaire d'unc cours
        Niveau niveau = consultC.controlNiveau();
        Classe classe = consultC.controlClasse(niveau);
        if (classe == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Enseignement enseignement = consultC.controlEnseignement(niveau);
        if (enseignement == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Enseignant enseignant = consultC.controlEnseignant();
        if (enseignant == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        //on s'assure que le cours n'a pas déjà été enregistré
        List<Cours> listeC = consultC.getListeCours(classe);
        for (Cours cours : listeC) {
            if ((cours.getEnseignement().equals(enseignement)) && (cours.getClasse().equals(classe))
                    && (cours.getEnseignant().equals(enseignant))) {
                //si l'élément a déjà été enregistré on ne l'ajoute plus   
                msg.alreadyDoneAction(MainViewGUI.getMainFrame());
                return;
            }
        }
        Cours cours = new Cours(enseignement, classe, enseignant);
        cours = coursDao.ajouter(cours);
        if (cours != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addEvaluation() {
        Periode periode = consultC.controlPeriode();
        if (periode == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Niveau niveau = consultC.controlNiveau();
        if (niveau == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Classe classe = consultC.controlClasse(niveau);
        if (classe == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Cours cours = consultC.controlCours(classe);
        if (cours == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        TypeEvaluation type = consultC.controlType();
        if (type == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        AddEvaluationPanel addEv = new AddEvaluationPanel(periode, cours, type);
        JDialogAddEvaluation dialog = new JDialogAddEvaluation(MainViewGUI.getMainFrame(), "Renseignements supplémentaires sur l'évaluation",
                addEv);
        int bareme = dialog.getForm().getBareme();
        if (bareme == 0) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        double poids = dialog.getForm().getPoids();
        if (poids == 0) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        LocalDate date = dialog.getForm().getDate();
        if (date == null) {
            msg.cancelMsg(MainViewGUI.getMainFrame());
            return;
        }
        Evaluation evaluation = new Evaluation(periode, cours, bareme, poids, type);
        evaluation.setDate(date);
        evaluation = evaluationDao.ajouter(evaluation);
        if (evaluation != null) {
            msg.successMsg(MainViewGUI.getMainFrame());
        }
    }

    @Override
    public void addNote() { //ajout dans une évatuation pour tous les élèves
        double valeur;
        boolean saved;
        Periode periode = consultC.controlPeriode();
        if (periode == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Niveau niveau = consultC.controlNiveau();
        if (niveau == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Classe classe = consultC.controlClasse(niveau);
        if (classe == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Cours cours = consultC.controlCours(classe);
        if (cours == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }
        Evaluation evaluation = consultC.controlEvaluation(periode, cours);
        if (evaluation == null) {
            msg.errorMsg(MainViewGUI.getMainFrame());
            return;
        }

        List<Eleve> listeE = consultC.getListeEleve(classe);
        if (listeE.isEmpty()) {
            msg.emptyEleveList(MainViewGUI.getMainFrame());
            return;
        }
        //liste des notes pour cette évaluation
        List<Note> listeN = consultC.getListeNote(evaluation);
        for (Eleve eleve : listeE) { //pour chaque élève de la classe on ajoute une note
            saved = false;
            //vérification si la note n'a pas déjà été ajoutée pour cet élève dans cette évaluation 
            if (!listeN.isEmpty()) {
                for (Note n : listeN) {
                    if ((n.getEleve().equals(eleve)) && (n.getEvaluation().equals(evaluation))) {
                        msg.alreadyDoneAction(MainViewGUI.getMainFrame());
                        saved = true;
                    }
                }
            }
            if (!saved) {
                AddNotePanel addN = new AddNotePanel(periode, evaluation, eleve);
                JDialogAddNote dialog = new JDialogAddNote(MainViewGUI.getMainFrame(), "Renseignement de la valeur de la note de l'élève",
                        addN);

                valeur = dialog.getForm().getValeur();
                if (valeur == 0) {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                    return;
                }
                Note note = new Note(evaluation, eleve, valeur);
                note = noteDao.ajouter(note);
                if (note != null) {
                    msg.successMsg(MainViewGUI.getMainFrame());
                }
            }
        }
    }

}
