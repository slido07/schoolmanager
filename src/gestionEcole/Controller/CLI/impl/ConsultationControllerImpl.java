/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.CLI.impl;

import gestionEcole.View.CLI.I.IConsultationView;
import gestionEcole.View.CLI.I.IMainView;
import gestionEcole.model.entity.*;
import gestionEcole.View.CLI.impl.ConsultationViewImpl;
import gestionEcole.View.CLI.impl.MainViewImpl;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ConsultationControllerImpl implements IConsultationControllerCLI {

    private static final IConsultationView consultationV = new ConsultationViewImpl();
    private static final IMainView mainV = new MainViewImpl();

    //controlleur principal de la section consultation
    @Override
    public void controller() {
        boolean status = true;
        Classe classe;
        Periode periode;
        Niveau niveau;
        Cours cours;
        Eleve eleve;
        do {
            switch (mainV.showConsult()) {
                case 1: //liste des niveaux                    
                    consultationV.showNiveau();
                    break;
                case 2: //liste des classes d'un niveau
                    do {
                        niveau = controlNiveau();
                        consultationV.showClasse(niveau);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 3: //liste des élèves d'une classe
                    do {
                        niveau = controlNiveau();
                        classe = controlClasse(niveau);
                        consultationV.showEleve(classe);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 4: //liste des matieres
                    consultationV.showMatiere();
                    break;
                case 5: //liste des periodes
                    consultationV.showPeriode();
                    break;
                case 6: //liste des enseignants
                    consultationV.showEnseignant();
                    break;
                case 7: //liste des types d'évaluation
                    consultationV.showType();
                    break;
                case 8: //liste des enseignements d'un niveau
                    do {
                        niveau = controlNiveau();
                        consultationV.showEnseignement(niveau);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 9: //liste des cours d'une classe
                    do {
                        niveau = controlNiveau();
                        classe = controlClasse(niveau);
                        consultationV.showCours(classe);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 10: //liste des evaluations dans un cours pour une période
                    do {
                        periode = controlPeriode();
                        niveau = controlNiveau();
                        classe = controlClasse(niveau);
                        cours = controlCours(classe);
                        consultationV.showEvaluation(periode, cours);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 11: //dates des évaluations dans un cours pour une période
                    do {
                        periode = controlPeriode();
                        niveau = controlNiveau();
                        classe = controlClasse(niveau);
                        cours = controlCours(classe);
                        consultationV.showEvaluationDate(periode, cours);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 12: //liste des notes d'un élève dans un cours pour une période donnée
                    do {
                        periode = controlPeriode();
                        niveau = controlNiveau();
                        classe = controlClasse(niveau);
                        cours = controlCours(classe);
                        eleve = getEleve(classe);
                        consultationV.showNote(periode, cours, eleve);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 13:  //liste des notes de tous les élèves d'une classe dans un cours donné
                    do {
                        periode = controlPeriode();
                        niveau = controlNiveau();
                        classe = controlClasse(niveau);
                        cours = controlCours(classe);
                        consultationV.showNote(periode, cours);
                    } while (consultationV.repeatAction() == 'O');
                    break;
                case 14: //quitter
                    status = false;
                    break;
            }
        } while (status == true);
    }

    /* méthodes récupérant la listes des objets du Model */
    @Override
    public List<Niveau> getListeNiveau() {
        List<Niveau> liste = Niveau.getListe();
        return liste;
    }

    @Override
    public List<Classe> getListeClasse() {
        List<Classe> liste = Classe.getListe();
        return liste;
    }

    @Override
    public List<Classe> getListeClasse(Niveau niveau) {
        List<Classe> liste = Classe.getListe(niveau);
        return liste;
    }

    @Override
    public List<Enseignement> getListeEnseignement() {
        List<Enseignement> liste = Enseignement.getListe();
        return liste;
    }

    @Override
    public List<Enseignement> getListeEnseignement(Niveau niveau) {
        List<Enseignement> liste = Enseignement.getListe(niveau);
        return liste;
    }

    @Override
    public List<Cours> getListeCours() {
        List<Cours> liste = Cours.getListe();
        return liste;
    }

    @Override
    public List<Cours> getListeCours(Classe classe) {
        List<Cours> liste = Cours.getListe(classe);
        return liste;
    }

    @Override
    public List<Enseignant> getListeEnseignant() {
        List<Enseignant> liste = Enseignant.getListe();
        return liste;
    }

    @Override
    public List<Eleve> getListeEleve() {
        List<Eleve> liste = Eleve.getListe();
        return liste;
    }

    @Override
    public List<Eleve> getListeEleve(Classe classe) {
        List<Eleve> liste = Eleve.getListe(classe);
        return liste;
    }

    @Override
    public List<Eleve> getListeEleve(Niveau niveau) {
        List<Eleve> liste = Eleve.getListe(niveau);
        return liste;
    }

    @Override
    public List<Matiere> getListeMatiere() {
        List<Matiere> liste = Matiere.getListe();
        return liste;
    }

    @Override
    public List<TypeEvaluation> getListeType() {
        List<TypeEvaluation> liste = TypeEvaluation.getListe();
        return liste;
    }

    @Override
    public List<Evaluation> getListeEvaluation() {
        List<Evaluation> liste = Evaluation.getListe();
        return liste;
    }

    @Override
    public List<Evaluation> getListeEvaluation(Periode periode, Cours cours) {
        List<Evaluation> liste = Evaluation.getListe(periode, cours);
        return liste;
    }

    @Override
    public List<Evaluation> getListeEvaluation(Periode periode) {
        List<Evaluation> liste = Evaluation.getListe(periode);
        return liste;
    }

    @Override
    public List<Evaluation> getListeEvaluation(Cours cours) {
        List<Evaluation> liste = Evaluation.getListe(cours);
        return liste;
    }

    @Override
    public List<Evaluation> getListeEvaluation(Classe classe) {
        List<Evaluation> liste = Evaluation.getListe(classe);
        return liste;
    }

    @Override
    public List<Note> getListeNote() {
        List<Note> liste = Note.getListe();
        return liste;
    }

    @Override
    public List<Note> getListeNote(Evaluation evaluation) {
        List<Note> liste = Note.getListe(evaluation);
        return liste;
    }

    @Override
    public List<Note> getListeNote(Periode periode, Eleve eleve) {
        List<Note> liste = Note.getListe(periode, eleve);
        return liste;
    }

    @Override
    public List<Note> getListeNote(Periode periode, Eleve eleve, Cours cours) {
        List<Note> liste = Note.getListe(periode, eleve, cours);
        return liste;
    }

    @Override
    public List<Note> getListeNote(Periode periode, Cours cours) {
        List<Note> liste = Note.getListe(periode, cours);
        return liste;
    }

    @Override
    public List<Periode> getListePeriode() {
        List<Periode> liste = Periode.getListe();
        return liste;
    }

    /* méthodes get permettant de récupérer un objet affiché à partir de son numéro d'ordre  */
    @Override
    public Niveau getNiveau() {
        int i;
        List<Niveau> liste = getListeNiveau();
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        consultationV.showNiveau();
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Classe getClasse(Niveau niveau) {
        int i;
        List<Classe> liste;
        liste = getListeClasse(niveau);
        consultationV.showClasse(niveau);
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Enseignement getEnseignement(Niveau niveau) {
        int i;
        List<Enseignement> liste;
        liste = getListeEnseignement(niveau);
        consultationV.showEnseignement(niveau);
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Cours getCours(Classe classe) {
        int i;
        List<Cours> liste;
        liste = getListeCours(classe);
        consultationV.showCours(classe);
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Eleve getEleve(Classe classe) {
        int i;
        List<Eleve> liste = getListeEleve(classe);
        consultationV.showEleve(classe);
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Enseignant getEnseignant() {
        int i;
        List<Enseignant> liste = getListeEnseignant();
        consultationV.showEnseignant();
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Matiere getMatiere() {
        int i;
        List<Matiere> liste = getListeMatiere();
        consultationV.showMatiere();
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public TypeEvaluation getType() {
        int i;
        List<TypeEvaluation> liste = getListeType();
        consultationV.showType();
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Periode getPeriode() {
        int i;
        List<Periode> liste = getListePeriode();
        consultationV.showPeriode();
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Evaluation getEvaluation(Periode periode, Cours cours) {
        int i;
        List<Evaluation> liste;
        liste = getListeEvaluation(periode, cours);
        consultationV.showEvaluation(periode, cours);
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Note getNote(Periode periode, Cours cours, Eleve eleve) {
        int i;
        List<Note> liste;
        liste = getListeNote(periode, eleve, cours);
        consultationV.showNote(periode, cours, eleve);
        if (!liste.isEmpty()) {
            i = consultationV.getNumber();
            i--;
            if ((i >= 0) && (i < liste.size())) {
                return liste.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    /* fonctions de controle des valeurs des objets avant de les renvoyer  */
    @Override
    public Niveau controlNiveau() {
        Niveau niveau;
        boolean status;
        if (getListeNiveau().isEmpty()) {
            consultationV.noticeEmptyList(Niveau.class.getSimpleName());
            return null;
        }

        do {
            niveau = getNiveau();
            //si le niveau sélectionné n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (niveau == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return niveau;
    }

    @Override
    public Classe controlClasse(Niveau niveau) {
        Classe classe;
        boolean status;
        if (niveau == null) {
            return null;
        }

        if (niveau.isEmpty()) {
            consultationV.noticeEmptyList(Classe.class.getSimpleName());
            return null;
        }

        do {
            classe = getClasse(niveau);
            //si la classe sélectionnée n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (classe == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return classe;
    }

    @Override
    public Cours controlCours(Classe classe) {
        Cours cours;
        boolean status;
        if (classe == null) {
            return null;
        }

        if (getListeCours(classe).isEmpty()) {
            consultationV.noticeEmptyList(Cours.class.getSimpleName());
            return null;
        }

        do {
            cours = getCours(classe);
            //si le cours sélectionné n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (cours == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return cours;
    }

    @Override
    public Enseignement controlEnseignement(Niveau niveau) {
        Enseignement enseignement;
        boolean status;
        if (niveau == null) {
            return null;
        }

        if (getListeEnseignement(niveau).isEmpty()) {
            consultationV.noticeEmptyList(Enseignement.class.getSimpleName());
            return null;
        }

        do {
            enseignement = getEnseignement(niveau);
            //si l'enseignement sélectionné n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (enseignement == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return enseignement;
    }

    @Override
    public Periode controlPeriode() {
        Periode periode;
        boolean status;
        if (getListePeriode().isEmpty()) {
            consultationV.noticeEmptyList(Periode.class.getSimpleName());
            return null;
        }

        do {
            periode = getPeriode();
            //si la période sélectionnée n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (periode == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return periode;
    }

    @Override
    public Matiere controlMatiere() {
        Matiere matiere;
        boolean status;
        if (getListeMatiere().isEmpty()) {
            consultationV.noticeEmptyList(Matiere.class.getSimpleName());
            return null;
        }

        do {
            matiere = getMatiere();
            //si la matière sélectionnée n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (matiere == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return matiere;
    }

    @Override
    public TypeEvaluation controlType() {
        TypeEvaluation type;
        boolean status;
        if (getListeType().isEmpty()) {
            consultationV.noticeEmptyList(TypeEvaluation.class.getSimpleName());
            return null;
        }
        do {
            type = getType();
            //si le type sélectionné n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (type == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return type;
    }

    @Override
    public Eleve controlEleve(Classe classe) {
        Eleve eleve;
        boolean status;
        if (classe == null) {
            return null;
        }
        if (classe.isEmpty()) {
            consultationV.noticeEmptyList(Eleve.class.getSimpleName());
            return null;
        }
        do {
            eleve = getEleve(classe);
            //si l'élève sélectionné n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (eleve == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return eleve;
    }

    @Override
    public Enseignant controlEnseignant() {
        Enseignant enseignant;
        boolean status;
        if (getListeEnseignant().isEmpty()) {
            consultationV.noticeEmptyList(Enseignant.class.getSimpleName());
            return null;
        }
        do {
            enseignant = getEnseignant();
            //si l'enseignant sélectionné n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (enseignant == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return enseignant;
    }

    @Override
    public Evaluation controlEvaluation(Periode periode, Cours cours) {
        Evaluation evaluation;
        boolean status;
        if (periode == null) {
            return null;
        }
        if (cours == null) {
            return null;
        }
        if (getListeEvaluation(periode, cours).isEmpty()) {
            consultationV.noticeEmptyList(Evaluation.class.getSimpleName());
            return null;
        }
        do {
            evaluation = getEvaluation(periode, cours);
            //si l'évaluation sélectionnée n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (evaluation == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return evaluation;
    }

    @Override
    public Note controlNote(Periode periode, Eleve eleve, Cours cours) {
        Note note;
        boolean status;
        if (periode == null) {
            return null;
        }
        if (cours == null) {
            return null;
        }
        if (eleve == null) {
            return null;
        }
        if (getListeNote(periode, eleve, cours).isEmpty()) {
            consultationV.noticeEmptyList(Note.class.getSimpleName());
            return null;
        }
        do {
            note = getNote(periode, cours, eleve);
            //si la note sélectionnée n'existe pas on reprend l'opération jusqu'à une saisie correcte
            if (note == null) {
                consultationV.showErrorMsg();
                status = false;
            } else {
                status = true;
            }
        } while (status == false);
        return note;
    }

}
