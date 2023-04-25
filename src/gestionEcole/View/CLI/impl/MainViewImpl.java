/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.CLI.impl;

import gestionEcole.View.CLI.I.IMainView;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class MainViewImpl implements IMainView {

    @Override
    public void welcomeMsg() {
        System.out.println("\t\t+----------------------------------------------------------+");
        System.out.println("\t\t|  BIENVENU(E) DANS LE PROGRAMME GESTIONNAIRE DE NOTES     |");
        System.out.println("\t\t+----------------------------------------------------------+\n");
    }

    //menu principal utilisateur qui retourne le choix de l'utilisateur au controlleur principal
    @Override
    public int showMenu() {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|       MENU PRINCIPAL     |");
        System.out.println("+--------------------------+\n");
        System.out.println("1 - AJOUTS");
        System.out.println("2 - SUPPRESSIONS");
        System.out.println("3 - CONSULTATIONS");
        System.out.println("4 - MODIFICATIONS");
        System.out.println("5 - BULLETIN");
        System.out.println("6 - QUITTER LE PROGRAMME");
        final int nbOptions = 6;
        return getChoice(nbOptions);
    }

    //menu spécifique à l'ajout
    @Override
    public int showAdd() {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|          AJOUTS          |");
        System.out.println("+--------------------------+\n");
        System.out.println("1 - Ajouter un niveau");
        System.out.println("2 - Ajouter une classe");
        System.out.println("3 - Ajouter un élève");
        System.out.println("4 - Ajouter une matière");
        System.out.println("5 - Ajouter une période");
        System.out.println("6 - Ajouter un enseignant");
        System.out.println("7 - Ajouter un type d'évaluation");
        System.out.println("8 - Ajouter une évaluation");
        System.out.println("9 - Ajouter des enseignements pour un niveau dans chaque matière");
        System.out.println("10 - Ajout de cours dans une classe pour chaque enseignement");
        System.out.println("11 - Ajouter une note pour chaque élève dans une évaluation");
        System.out.println("12- Quitter la section Ajouts");
        final int nbOptions = 12;
        return getChoice(nbOptions);
    }

    //menu spécifique à la supppression
    @Override
    public int showDel() { //add supprimer * eleve d'une classe, * classe d'un niveau, etc........
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|        SUPPRESSIONS      |");
        System.out.println("+--------------------------+\n");
        System.out.println("1 - Supprimer un niveau");
        System.out.println("2 - Supprimer une classe");
        System.out.println("3 - Supprimer un élève");
        System.out.println("4 - Supprimer une matière");
        System.out.println("5 - Supprimer une période");
        System.out.println("6 - Supprimer un enseignant");
        System.out.println("7 - Supprimer un type d'évaluation");
        System.out.println("8 - Supprimer une évaluation");
        System.out.println("9 - Supprimer toutes les classes d'un niveau");
        System.out.println("10 - Supprimer tous les élèves d'une classe");
        System.out.println("11- Quitter la section Suppressions");
        final int nbOptions = 11;
        return getChoice(nbOptions);
    }

    @Override
    public int showConsult() {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|      CONSULTATIONS       |");
        System.out.println("+--------------------------+\n");
        System.out.println("1 - Consulter la liste des niveaux");
        System.out.println("2 - Consulter la liste des classes d'un niveau");
        System.out.println("3 - Consulter la liste des élèves d'une classe");
        System.out.println("4 - Consulter la liste des matières");
        System.out.println("5 - Consulter la liste des périodes");
        System.out.println("6 - Consulter la liste des enseignants");
        System.out.println("7 - Consulter la liste des types d'évaluation");
        System.out.println("8 - Consulter la liste des enseignements d'un niveau");
        System.out.println("9 - Consulter la liste des cours d'une classe");
        System.out.println("10- Consulter la liste des évaluations dans un cours pour une période");
        System.out.println("11- Consulter les dates des évaluations dans un cours pour une période");
        System.out.println("12- Consulter la liste des notes d'un élève dans un cours pour une période");
        System.out.println("13- Consulter la liste des notes de tous les élèves d'une classe dans un cours pour une période");
        System.out.println("14- Quitter la section Consultations");
        final int nbOptions = 14;
        return getChoice(nbOptions);
    }

    @Override
    public int showUpdate() {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|      MODIFICATIONS       |");
        System.out.println("+--------------------------+\n");
        System.out.println("1 - Modifier le coefficient d'un enseignement");
        System.out.println("2 - Modifier l'enseignant d'un cours");
        System.out.println("3 - Modifier la classe d'un élève");
        System.out.println("4 - Modifier le barème d'une évaluation");
        System.out.println("5 - Modifier le poids d'une évaluation");
        System.out.println("6 - Modifier la date d'une évaluation");
        System.out.println("7 - Modifier la valeur d'une note");
        System.out.println("8 - Quitter la section Modifications");
        final int nbOptions = 8;
        return getChoice(nbOptions);
    }

    @Override
    public int showBulletin() {
        System.out.println();
        System.out.println("+--------------------------+");
        System.out.println("|         BULLETIN         |");
        System.out.println("+--------------------------+\n");
        System.out.println("1 - Afficher le bulletin d'un élève dans une période donnée");
        System.out.println("2 - Afficher la moyenne générale dans un cours");
        System.out.println("3 - Quitter la section Bulletin");
        final int nbOptions = 3;
        return getChoice(nbOptions);
    }

    @Override
    public int getChoice(int nbOptions) {
        int choix = 0;
        do {
            System.out.print("\nVeuillez saisir le numero correspondant à l'opération à effectuer : ");
            choix = inputChoice();
            if ((choix < 1) || (choix > nbOptions)) {
                System.out.println();
                System.out.print("Choix invalide!!! Veuillez reprendre.");
            }
        } while ((choix < 1) || (choix > nbOptions));
        System.out.println();
        return choix;
    }

    @Override
    public int inputChoice() {
        int choix = 0;
        boolean error = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                choix = scanner.nextInt();
                error = false;
            } catch (InputMismatchException badInput) {
                System.out.print("Erreur!!! La valeur saisie est invalide.\n\nVeuillez ressaisir une valeur valide : ");
            }
        } while (error);
        return choix;
    }

}
