/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.CLI.impl;

import gestionEcole.model.entity.*;
import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.View.CLI.I.IConsultationView;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class ConsultationViewImpl implements IConsultationView {

    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();

    //affichage de la liste des niveaux de l'établissement
    @Override
    public void showNiveau() {
        int i = 1;
        List<Niveau> liste = consultationC.getListeNiveau();

        //afficher tous les niveaux de l'etablissement
        System.out.println("\n\t******* Liste de tous les niveaux de l'établissement enregistrés ******* ");
        if (liste.isEmpty()) {
            noticeEmptyList(Niveau.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+----------------------+----------------+");
        System.out.println("\t|  Numero  |    Description       |    Libelle     |");
        System.out.println("\t+----------+----------------------+----------------+");
        for (Niveau niveau : liste) {
            System.out.printf("\t|%6d    |    %-14s   |    %-10s  |\n",
                    i++, niveau.getDescription(), niveau.getLibelle());
        }
        System.out.println("\t+----------+----------------------+----------------+");
    }

    //afficher toutes les classes d'un niveau
    @Override
    public void showClasse(Niveau niveau) {
        int i = 1;
        if (niveau == null) {
            return;
        }
        List<Classe> liste = consultationC.getListeClasse(niveau);

        System.out.println("\n\t******* Liste des classes de la " + niveau.getLibelle() + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Class.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+------------------+");
        System.out.println("\t|  Numero  |      Libelle     |");
        System.out.println("\t+----------+------------------+");
        for (Classe classe : liste) {
            System.out.printf("\t|%5d     |      %-12s|\n", i++, classe.getLibelle());
        }
        System.out.println("\t+----------+------------------+");
    }

//afficher tous les élèves d'une classe
    @Override
    public void showEleve(Classe classe) {
        int i = 1;
        if (classe == null) {
            return;
        }
        List<Eleve> liste = consultationC.getListeEleve(classe);

        System.out.println("\n\t******* Liste de tous les élèves de la " + classe.getLibelle() + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Eleve.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+----------------+---------------------------------------+-----------+--------+");
        System.out.println("\t|  Numero  |       Nom      |          Prenoms                      | Matricule |  Sexe  |");
        System.out.println("\t+----------+----------------+---------------------------------------+-----------+--------+");
        for (Eleve eleve : liste) {
            System.out.printf("\t|%5d     |  %-14s| %-38s|%6d      | %c     |\n",
                    i++, eleve.getNom(), eleve.getPrenom(), eleve.getId(), eleve.getSexe());
            System.out.println("\t+----------+----------------+---------------------------------------+-----------+--------+");
        }
        System.out.println("\t| Effectif total  : " + Eleve.getEffectif(classe) + "       |");
        System.out.println("\t+----------+----------------+");
    }

    //afficher toutes les matières
    @Override
    public void showMatiere() {
        int i = 1;
        List<Matiere> liste = consultationC.getListeMatiere();

        System.out.println("\n\t******* Liste de toutes les matières de l'établissement *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Matiere.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+---------+---------------------------------------+");
        System.out.println("\t|  Numero  |  Code   |   Libellé                             |");
        System.out.println("\t+----------+---------+---------------------------------------+");
        for (Matiere matiere : liste) {
            System.out.printf("\t|%6d    |  %-7s|   %-36s|\n", i++, matiere.getCode(), matiere.getLibelle());
        }
        System.out.println("\t+----------+---------+---------------------------------------+");
    }

    @Override
    public void showPeriode() {
        int i = 1;
        List<Periode> liste = consultationC.getListePeriode();

        System.out.println("\n\t******* Liste des périodes de l'établissement *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Periode.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+--------------------+");
        System.out.println("\t|  Numero  |       Libelle      |");
        System.out.println("\t+----------+--------------------+");
        for (Periode periode : liste) {
            System.out.printf("\t|%5d     |  %-18s|\n", i++, periode.getLibelle());
        }
        System.out.println("\t+----------+--------------------+");
    }

    @Override
    public void showEnseignant() {
        int i = 1;
        List<Enseignant> liste = consultationC.getListeEnseignant();

        System.out.println("\n\t******* Liste de tous les enseignants de l'établissement *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Enseignant.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+------------------+-------------------------------------------+");
        System.out.println("\t|  Numero  |        Nom       |                  Prenoms                  |");
        System.out.println("\t+----------+------------------+-------------------------------------------+");
        for (Enseignant enseignant : liste) {
            System.out.printf("\t|%5d     |  %-16s| %-42s|\n",
                    i++, enseignant.getNom(), enseignant.getPrenom());
        }
        System.out.println("\t+----------+------------------+-------------------------------------------+");
    }

//afficher toutes les matières
    @Override
    public void showType() {
        int i = 1;
        List<TypeEvaluation> liste = consultationC.getListeType();

        System.out.println("\n\t****** Liste de toutes les types d'évaluation de l'établissement *******");
        if (liste.isEmpty()) {
            noticeEmptyList(TypeEvaluation.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+---------+---------------------------------------+");
        System.out.println("\t|  Numero  |  Code   |   Libellé                             |");
        System.out.println("\t+----------+---------+---------------------------------------+");
        for (TypeEvaluation type : liste) {
            System.out.printf("\t|%6d    |  %-7s|   %-36s|\n", i++, type.getCode(), type.getLibelle());
        }
        System.out.println("\t+----------+---------+---------------------------------------+");
    }

    @Override
    public void showEnseignement(Niveau niveau) {
        int i = 1;
        if (niveau == null) {
            return;
        }
        List<Enseignement> liste = consultationC.getListeEnseignement(niveau);

        System.out.println("\n\t******** Liste de tous les enseignements de la " + niveau.getLibelle() + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Enseignement.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+--------------------+");
        System.out.println("\t|  Numero  |       Libelle      |");
        System.out.println("\t+----------+--------------------+");
        for (Enseignement enseignement : liste) {
            System.out.printf("\t|%5d     |  %-18s|\n", i++, enseignement.getLibelle());
        }
        System.out.println("\t+----------+--------------------+");
    }

    //afficher tous les cours d'une classe
    @Override
    public void showCours(Classe classe) {
        int i = 1;
        if (classe == null) {
            return;
        }
        List<Cours> liste = consultationC.getListeCours(classe);

        System.out.println("\n\t******* Liste de tous les cours de la classe de " + classe.getLibelle() + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Cours.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+--------------------+");
        System.out.println("\t|  Numero  |       Libelle      |");
        System.out.println("\t+----------+--------------------+");
        for (Cours cours : liste) {
            System.out.printf("\t|%5d     |  %-18s|\n", i++, cours.getLibelle());
        }
        System.out.println("\t+----------+--------------------+");
    }

    //afficher toutes les évaluations d'un cours pour une période
    @Override
    public void showEvaluation(Periode periode, Cours cours) {
        int i = 1;
        if (periode == null) {
            return;
        }
        if (cours == null) {
            return;
        }
        List<Evaluation> liste = consultationC.getListeEvaluation(periode, cours);

        System.out.println("\n\t******* Liste de toutes les évaluations en " + cours.getLibelle() + "\n\tPériode : " + periode.getLibelle()
                + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Evaluation.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+-------------------------------+----------+-------+");
        System.out.println("\t|  Numero  |        Type                   |  Barème  | Poids |");
        System.out.println("\t+----------+-------------------------------+----------+-------+");
        for (Evaluation evaluation : liste) {
            System.out.printf("\t|%5d     | %-30s|%5d     |%6.2f |\n",
                    i++, evaluation.getType().getLibelle(), evaluation.getBareme(), evaluation.getPoids());
        }
        System.out.println("\t+----------+-------------------------------+----------+-------+");
    }

    //affichage de toutes les notes relatives à tous les élèves d'une classe au cours d'une période
    @Override
    public void showNote(Periode periode, Classe classe) {
        int i = 1;
        List<Note> liste = consultationC.getListeNote();
        if (periode == null) {
            return;
        }
        if (classe == null) {
            return;
        }

        System.out.println("\n\t******* Liste de toutes les notes des élèves de " + classe.getLibelle() + "\n\tPériode : " + periode.getLibelle()
                + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Note.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+-----------+----------------------+--------------------------------+----------+-------+-------------+------+");
        System.out.println("\t|  Numero  | Matricule | Nom de l'élève       | Prenoms                        |  Cours   |  Type | Note obtenue| Poids|");
        System.out.println("\t+----------+-----------+----------------------+--------------------------------+----------+-------+-------------+------+");
        for (Note note : liste) {
            if (note.getEvaluation().getPeriode().equals(periode)) {
                if (note.getEleve().getClasse().equals(classe)) {
                    System.out.printf("\t|%5d     |%5d       | %-20s| %-30s | %-8s | %-6s| %-12s| %05.2f|\n",
                            i++, note.getEleve().getId(), note.getEleve().getNom(), note.getEleve().getPrenom(),
                            note.getEvaluation().getCours().getLibelle(), note.getEvaluation().getType().getCode(),
                            note.getValeur() + "/" + note.getEvaluation().getBareme(), note.getEvaluation().getPoids());
                }
            }
        }
        System.out.println("\t+----------+-----------+----------------------+--------------------------------+----------+-------+-------------+------+");
    }

    //affichage de toutes les notes relatives à tous les élèves d'une classe dans un cours au cours d'une période
    @Override
    public void showNote(Periode periode, Cours cours) {
        int i = 1;
        if (periode == null) {
            return;
        }
        if (cours == null) {
            return;
        }
        List<Note> liste = consultationC.getListeNote(periode, cours);

        System.out.println("\n\t******* Liste de toutes les notes des élèves de " + cours.getClasse().getLibelle() + "\n\tCours : " + cours.getLibelle()
                + "\n\tPériode : " + periode.getLibelle() + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Note.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+-----------+----------------------+--------------------------------+-------+-------------+------+");
        System.out.println("\t|  Numero  | Matricule | Nom de l'élève       | Prenoms                        |  Type | Note obtenue| Poids|");
        System.out.println("\t+----------+-----------+----------------------+--------------------------------+-------+-------------+------+");
        for (Note note : liste) {
            System.out.printf("\t|%5d     |%5d      | %-20s | %-30s | %-6s|   %05.2f/%2d  | %4.2f |\n",
                    i++, note.getEleve().getId(), note.getEleve().getNom(), note.getEleve().getPrenom(), note.getEvaluation()
                    .getType().getCode(), note.getValeur(), note.getEvaluation().getBareme(),
                    note.getEvaluation().getPoids());
        }
        System.out.println("\t+----------+-----------+----------------------+--------------------------------+-------+-------------+------+");
    }

    //affichage de toutes les notes relatives à un élève dans un cours au cours d'une période
    @Override
    public void showNote(Periode periode, Cours cours, Eleve eleve) {
        int i = 1;
        if (periode == null) {
            return;
        }
        if (cours == null) {
            return;
        }
        if (eleve == null) {
            return;
        }
        List<Note> liste = consultationC.getListeNote(periode, eleve, cours);

        System.out.println("\n\t******* Liste de toutes les notes de l'élève : " + eleve.getNom() + " " + eleve.getPrenom() + "\n\tMatricule : "
                + eleve.getId() + "\n\tCours : " + cours.getLibelle() + "\n\tPériode : " + periode.getLibelle() + " *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Note.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+-------+-------------+------+");
        System.out.println("\t|  Numero  |  Type | Note obtenue| Poids|");
        System.out.println("\t+----------+-------+-------------+------+");
        for (Note note : liste) {
            System.out.printf("\t|%5d     | %-6s|   %05.2f/%2d  |%4.2f  |\n",
                    i++, note.getEvaluation().getType().getCode(), note.getValeur(), note.getEvaluation().getBareme(),
                    note.getEvaluation().getPoids());
        }
        System.out.println("\t+----------+-------+-------------+------+");
    }

    //afficher toutes les dates des evaluations d'une classe pour une période
    @Override
    public void showEvaluationDate(Periode periode, Cours cours) {
        int i = 1;
        List<Evaluation> liste = consultationC.getListeEvaluation(periode, cours);
        if (periode == null) {
            return;
        }
        if (cours == null) {
            return;
        }

        System.out.println("\n\t******* Liste de de toutes les évalutions en " + cours.getLibelle() + " au " + periode.getLibelle()
                + " avec leurs dates *******");
        if (liste.isEmpty()) {
            noticeEmptyList(Evaluation.class.getSimpleName());
            return;
        }
        System.out.println("\t+----------+-------------------------------+----------+-------+--------------+");
        System.out.println("\t|  Numero  |        Type                   |  Barème  | Poids |     Dates    |");
        System.out.println("\t+----------+-------------------------------+----------+-------+--------------+");
        for (Evaluation evaluation : liste) {
            System.out.printf("\t|%5d     | %-30s|%5d     |  %4.2f |  %-12s|\n",
                    i++, evaluation.getType().getLibelle(), evaluation.getBareme(), evaluation.getPoids(), evaluation.getDate());
        }
        System.out.println("\t+----------+-------------------------------+----------+-------+--------------+");
    }

    @Override
    public int getNumber() {
      int numero = 0;
        boolean error = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nSélectionner le numero de la liste  coresspondant : ");
                numero = scanner.nextInt();     //si l'InpuMismatchException est levée alors error restera à true
                error = false;                       //et donc le bloc d'instruction est repris jusqu'à une bonne saisie
            } catch (InputMismatchException badInput) {
                showErrorMsg();
            }

        } while (error);
        return numero;
    }

    @Override
    public void showErrorMsg() {
        System.out.println("\n********** Désolé l'élément sélectionné n'est pas enregistré dans la liste !!!! **********");
    }

    @Override
    public char repeatAction() {
        System.out.print("\nVoulez-vous répéter cette action ? (tapez \"O\" ou \"N\") : ");
        char answer = giveAnswer();
        System.out.println();
        return answer;
    }

    @Override
    public char giveAnswer() { //retourne O ou N comme réponse de l'utilisateur 
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String text;
        char answer;
        do {
            text = scanner.next();
            answer = text.charAt(0);
            answer = Character.toUpperCase(answer);
            if ((answer != 'O') && (answer != 'N')) {
                System.out.print("\nErreur!!! Vous devez saisir \"O\" ou \"N\" comme réponse s'il vous plait."
                        + "\n\nVeuillez ressaisir votre réponse : ");
            }
        } while ((answer != 'O') && (answer != 'N'));
        return answer;
    }

    @Override
    public void showCancelMsg() {
        System.out.println("\n-------------OPERATION ANNULEE------------");
    }

    @Override
    public void noticeEmptyList(String className) {
        System.out.printf("********** Désolé, il n'a aucun(e)  %-14s de cette catégorie enregisté(e) dans votre base de données pour le momment. **********\n",
                className);
    }
}
