/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.GUI.impl;

import gestionEcole.View.GUI.components.listPanel.PanelListForm;
import gestionEcole.View.GUI.components.listPanel.*;
import gestionEcole.View.GUI.components.messages.ConsultMessages;
import gestionEcole.model.entity.*;
import java.awt.BorderLayout;
import java.util.List;
import gestionEcole.Controller.GUI.I.IConsultationControllerGUI;
import gestionEcole.View.GUI.components.dialogs.JDialogSelection;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author HP
 */
public class ConsultationControllerGUIImpl implements IConsultationControllerGUI {

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
    public List<Eleve> getListeEleve() {
        List<Eleve> liste = Eleve.getListe();
        return liste;
    }

    @Override
    public List<Eleve> getListeEleve(Niveau niveau) {
        List<Eleve> liste = Eleve.getListe(niveau);
        return liste;
    }

    @Override
    public List<Eleve> getListeEleve(Classe classe) {
        List<Eleve> liste = Eleve.getListe(classe);
        return liste;
    }

    @Override
    public List<Enseignant> getListeEnseignant() {
        List<Enseignant> liste = Enseignant.getListe();
        return liste;
    }

    @Override
    public List<Periode> getListePeriode() {
        List<Periode> liste = Periode.getListe();
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
    public List<Evaluation> getListeEvaluation() {
        List<Evaluation> liste = Evaluation.getListe();
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
    public List<Evaluation> getListeEvaluation(Periode periode, Cours cours) {
        List<Evaluation> liste = Evaluation.getListe(periode, cours);
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
    public List<Note> getListeNote(Periode periode, Cours cours) {
        List<Note> liste = Note.getListe(periode, cours);
        return liste;
    }
    
    @Override
    public List<Note> getListeNote(Periode periode, Cours cours, Eleve eleve) {
        List<Note> liste = Note.getListe(periode, cours, eleve);
        return liste;
    }

    @Override
    public List<Note> getListeNote(Periode periode, Eleve eleve, Cours cours) {
        List<Note> liste = Note.getListe(periode, eleve, cours);
        return liste;
    }

    @Override
    public Niveau getNiveau() {
        int i;
        ListNiveau listeN = new ListNiveau();  //panel d'affichage de la liste des niveaux
        List<Niveau> liste = getListeNiveau();
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DU NIVEAU   ", listeN);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Niveau.class.getSimpleName());
        }
        return null;

    }

    @Override
    public Classe getClasse(Niveau niveau) {
        int i;
        ListClasse listeC = new ListClasse(niveau);  //panel d'affichage de la liste des niveaux
        List<Classe> liste = getListeClasse(niveau);
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE LA CLASSE   ", listeC);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Classe.class.getSimpleName());
        }
        return null;
    }

    @Override
    public Eleve getEleve(Classe classe) {
        int i;
        ListEleve listeE = new ListEleve(classe);  //panel d'affichage de la liste des élèves
        List<Eleve> liste = getListeEleve(classe);
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE L'ELEVE   ", listeE);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Eleve.class.getSimpleName());
        }
        return null;
    }

    @Override
    public Enseignant getEnseignant() {
        int i;
        ListEnseignant listeE = new ListEnseignant();  //panel d'affichage de la liste des niveaux
        List<Enseignant> liste = getListeEnseignant();
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE L'ENSEIGNANT   ", listeE);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Enseignant.class.getSimpleName());
        }
        return null;
    }

    @Override
    public Enseignement getEnseignement(Niveau niveau) {
        int i;
        ListEnseignement listeEns = new ListEnseignement();  //panel d'affichage de la liste des niveaux
        List<Enseignement> liste = getListeEnseignement(niveau);
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE L'ENSEIGNEMENT   ", listeEns);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Enseignement.class.getSimpleName());
        }
        return null;
       
    }

    @Override
    public Cours getCours(Classe classe) {
        int i;
        ListCours listeC = new ListCours();  //panel d'affichage de la liste des niveaux
        List<Cours> liste = getListeCours(classe);
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DU COURS   ", listeC);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Cours.class.getSimpleName());
        }
        return null;
       
    }

    @Override
    public Evaluation getEvaluation(Periode periode, Cours cours) {
        int i;
        ListEvaluation listeEv = new ListEvaluation(periode, cours);  //panel d'affichage de la liste des niveaux
        List<Evaluation> liste = getListeEvaluation(periode, cours);
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE L'EVALUATION   ", listeEv);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Evaluation.class.getSimpleName());
        }
        return null;
    }

    @Override
    public Periode getPeriode() {
        int i;
        ListPeriode listeP = new ListPeriode();  //panel d'affichage de la liste des niveaux
        List<Periode> liste = getListePeriode();
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE LA PERIODE   ", listeP);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Periode.class.getSimpleName());
        }
        return null;
    }

    @Override
    public Matiere getMatiere() {
        int i;
        ListMatiere listeM = new ListMatiere();  //panel d'affichage de la liste des niveaux
        List<Matiere> liste = getListeMatiere();
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE LA MATIERE   ", listeM);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Matiere.class.getSimpleName());
        }
        return null;
    }

    @Override
    public TypeEvaluation getType() {
        int i;
        ListType listeT = new ListType();  //panel d'affichage de la liste des niveaux
        List<TypeEvaluation> liste = getListeType();
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DU TYPE D'EVALUATION   ", listeT);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), "Type d'évaluation");
        }
        return null;
    }

    @Override
    public Note getNote(Periode periode, Cours cours, Eleve eleve) {
        int i;
        ListNote listeN = new ListNote(periode, cours, eleve);  //panel d'affichage de la liste des niveaux
        List<Note> liste = getListeNote(periode, eleve, cours);
        ConsultMessages msg = new ConsultMessages();
        JDialogSelection dialog;
        /*le controlleur demande à la vue d'afficher les niveaux de l'établissement puis de demander à l'user de saisir le numéro 
       correspondant dans la liste */
        //on efface les panneaux précédents avant 
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().setVisible(true);

        if (!liste.isEmpty()) {
            dialog = new JDialogSelection(MainViewGUI.getMainFrame(), "   CHOIX DE LA NOTE   ", listeN);
            //s'il y'a eu saisie d'un nombre
            if (dialog.getSelection() != 0) {
                i = dialog.getSelection();
                i--;
                if ((i >= 0) && (i < liste.size())) {
                    return liste.get(i);
                } else {
                    return null;
                }
            }
        } else {
            msg.noticeEmptyList(MainViewGUI.getMainFrame(), Note.class.getSimpleName());
        }
        return null;
    }

    @Override
    public Niveau controlNiveau() {
        ConsultMessages msg = new ConsultMessages();
        Niveau niveau;
        niveau = getNiveau();
        if(niveau == null){
            msg.badChoice(MainViewGUI.getMainFrame());
        }
        return niveau;    
    }

    @Override
    public Periode controlPeriode() {
        Periode periode;
        ConsultMessages msg = new ConsultMessages();
        periode = getPeriode();
        if(periode == null){
            msg.badChoice(MainViewGUI.getMainFrame());
        }        
        return periode;
    }

    @Override
    public Matiere controlMatiere() {
        Matiere matiere;
        ConsultMessages msg = new ConsultMessages();
        matiere = getMatiere();
        if (matiere == null) {
           msg.badChoice(MainViewGUI.getMainFrame());
        }
        return matiere;
    }

    @Override
    public TypeEvaluation controlType() {
        TypeEvaluation type;
        ConsultMessages msg = new ConsultMessages();
        type = getType();
        if (type == null) {
            msg.badChoice(MainViewGUI.getMainFrame());
        }
        return type;
    }

    @Override
    public Classe controlClasse(Niveau niveau) {
        Classe classe;
        ConsultMessages msg = new ConsultMessages();
        if (niveau == null) {
            return null;
        }
        classe = getClasse(niveau);
        if(classe == null){
            msg.badChoice(MainViewGUI.getMainFrame());
        }        
        return classe;
    }

    @Override
    public Eleve controlEleve(Classe classe) {
         Eleve eleve;
        ConsultMessages msg = new ConsultMessages();
        if (classe == null) {
            return null;
        }
        eleve = getEleve(classe);
        if(eleve == null){
            msg.badChoice(MainViewGUI.getMainFrame());
        }       
        return eleve;
    }

    @Override
    public Enseignant controlEnseignant() {
        Enseignant enseignant;
        ConsultMessages msg = new ConsultMessages();
        enseignant = getEnseignant();
        if(enseignant == null){
            msg.badChoice(MainViewGUI.getMainFrame());
        }
        return enseignant;
    }

    @Override
    public Enseignement controlEnseignement(Niveau niveau) {
        Enseignement enseignement;
        ConsultMessages msg = new ConsultMessages();
        if (niveau == null) {
            return null;
        }
        enseignement = getEnseignement(niveau);
        if(enseignement == null){
            msg.badChoice(MainViewGUI.getMainFrame());
        }
        return enseignement;
    }

    @Override
    public Cours controlCours(Classe classe) {
        Cours cours;
        ConsultMessages msg = new ConsultMessages();
        if (classe == null) {
            return null;
        }
        cours = getCours(classe);
        if(cours == null){
            msg.badChoice(MainViewGUI.getMainFrame());
        }        
        return cours;
    }

    @Override
    public Evaluation controlEvaluation(Periode periode, Cours cours) {
        Evaluation evaluation;
        ConsultMessages msg = new ConsultMessages();
        if (periode == null) {
            return null;
        }
        if (cours == null) {
            return null;
        }
        evaluation = getEvaluation(periode, cours);
        if(evaluation == null){
          msg.badChoice(MainViewGUI.getMainFrame());  
        }
        return evaluation;
    }

    @Override
    public Note controlNote(Periode periode, Eleve eleve, Cours cours) {
        Note note;
        ConsultMessages msg = new ConsultMessages();
        if (periode == null) {
            return null;
        }
        if (cours == null) {
            return null;
        }
        if (eleve == null) {
            return null;
        }
        note = getNote(periode, cours, eleve);
        if(note == null){
            msg.badChoice(MainViewGUI.getMainFrame()); 
        }       
        return note;
    }
    
    @Override
    public void showListe(PanelListForm liste){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  //taille de l'écran
        MainViewGUI.getMainFrame().getOutputPanel().removeAll(); //on efface le panneau d'affichage
        MainViewGUI.getMainFrame().repaint(); //on le repeint 
        MainViewGUI.getMainFrame().getOutputPanel().add(liste, BorderLayout.CENTER); //puis on ajoute la liste à la fenetre
        MainViewGUI.getMainFrame().pack();
        MainViewGUI.getMainFrame().setSize(screenSize);
        MainViewGUI.getMainFrame().setLocation(0, 0);
        MainViewGUI.getMainFrame().setVisible(true);
    }

    @Override
    public void controller() {
        Classe classe;
        Periode periode;
        Niveau niveau;
        Cours cours;
        Eleve eleve;
        Evaluation evaluation;
        int action;

        MainViewGUI.getMainFrame().setVisible(true);
        action = MainViewGUI.getMainFrame().getCurrentState();

        switch (action) {
            case 1: //liste des niveaux                    
                ListNiveau listeNiv = new ListNiveau();
                showListe(listeNiv);
                break;
            case 2:  //liste de toutes les classes
                ListClasse listeClasse = new ListClasse();
                showListe(listeClasse);
                break;
            case 3: //liste des classes d'un niveau                
                niveau = controlNiveau();
                ListClasse listeC = new ListClasse(niveau);
                showListe(listeC);
                break;
            case 4: //liste de tous les élèves
                ListEleve listeEl = new ListEleve();
                showListe(listeEl);
                break;
            case 5: //liste des élèves d'une classe                   
                niveau = controlNiveau();
                classe = controlClasse(niveau);
                ListEleve listeE = new ListEleve(classe);
                showListe(listeE);
                break;
            case 6: //liste des enseignants
                ListEnseignant listeEn = new ListEnseignant();
                showListe(listeEn);
                break;
            case 7:  //liste des periodes
                ListPeriode listeP = new ListPeriode();
                showListe(listeP);
                break;
            case 8: //liste des matieres
                ListMatiere listeM = new ListMatiere();
                showListe(listeM);
                break;
            case 9: //liste de tous les enseignements
                ListEnseignement listeEns1 = new ListEnseignement();
                showListe(listeEns1);
                break;
            case 10: //liste des enseignements d'un niveau
                niveau = controlNiveau();
                ListEnseignement listeEns = new ListEnseignement(niveau);
                showListe(listeEns);
                break;
            case 11: //liste de tous les cours
                ListCours listeC1 = new ListCours();
                showListe(listeC1);
                break;
            case 12: //liste des cours d'une classe
                niveau = controlNiveau();
                classe = controlClasse(niveau);
                ListCours listeC2 = new ListCours(classe);
                showListe(listeC2);
                break;
            case 13: //liste des types d'évaluation
                ListType listeT = new ListType();
                showListe(listeT);
                break;
            case 14:  //liste des évaluations d'une classe
                niveau = controlNiveau();
                classe = controlClasse(niveau);
                ListEvaluation listeEv = new ListEvaluation(classe);
                showListe(listeEv);
                break;
            case 15: //liste des evaluations dans un cours pour une période
                periode = controlPeriode();
                niveau = controlNiveau();
                classe = controlClasse(niveau);
                cours = controlCours(classe);
                ListEvaluation listeEv1 = new ListEvaluation(periode, cours);
                showListe(listeEv1);
                break;
            case 16: //liste des notes de tous les élèves d'une classe dans un cours donné
                periode = controlPeriode();
                niveau = controlNiveau();
                classe = controlClasse(niveau);
                cours = controlCours(classe);
                ListNote listeNote = new ListNote(periode, cours);
                showListe(listeNote);
                break;
            case 17: //liste des notes de tous les élèves d'une classe dans une évaluation
                periode = controlPeriode();
                niveau = controlNiveau();
                classe = controlClasse(niveau);
                cours = controlCours(classe);
                evaluation = controlEvaluation(periode, cours);
                ListNote listeNev = new ListNote(evaluation);
                showListe(listeNev);
                break;
            case 18: //liste des notes d'un élève dans un cours pour une période donnée
                periode = controlPeriode();
                niveau = controlNiveau();
                classe = controlClasse(niveau);
                cours = controlCours(classe);
                eleve = getEleve(classe);
                ListNote listeNel = new ListNote(periode, cours, eleve);
                showListe(listeNel);
                break;
        }
    }
    

}
