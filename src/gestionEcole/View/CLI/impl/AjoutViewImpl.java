/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.CLI.impl;

import gestionEcole.View.CLI.I.IAjoutView;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Niveau;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.time.format.DateTimeParseException;

/**
 *
 * @author HP
 */
public class AjoutViewImpl implements IAjoutView {

    @Override
    public void showSucessMsg() {
        System.out.println("\n-------------AJOUT EFFECTUE------------\n");
    }

    @Override
    public void showCancelMsg() {
        System.out.println("\n-------------AJOUT ANNULE------------");
    }

    @Override
    public void showErrorMsg() {
        System.out.println("\n*** Erreur!!! La valeur saisie est invalide.\nVeuillez ressaisir une valeur valide ***");
    }

    @Override
    public void showAddNiveauMsg() {
        System.out.println("\t+-------------------------+");
        System.out.println("\t|    AJOUT D'UN NIVEAU    | ");
        System.out.println("\t+-------------------------+\n");
    }

    @Override
    public void showAddClasseMsg() {
        System.out.println("\t+--------------------------+");
        System.out.println("\t|    AJOUT D'UNE CLASSE    | ");
        System.out.println("\t+--------------------------+\n");
    }

    @Override
    public void showAddEleveMsg() {
        System.out.println("\t+------------------------+");
        System.out.println("\t|    AJOUT D'UN ELEVE    | ");
        System.out.println("\t+------------------------+\n");
    }

    @Override
    public void showAddEnseignantMsg() {
        System.out.println("\t+-----------------------------+");
        System.out.println("\t|    AJOUT D'UN ENSEIGNANT    |");
        System.out.println("\t+-----------------------------+\n");
    }

    @Override
    public void showEnseignantChoice() {
        System.out.println("\t+-----------------------------+");
        System.out.println("\t|    CHOIX DE L' ENSEIGNANT   |");
        System.out.println("\t+-----------------------------+");
    }

    @Override
    public void showCoeffChoice() {
        System.out.println("\t+-----------------------------+");
        System.out.println("\t|     CHOIX DU COEFFICIENT    |");
        System.out.println("\t+-----------------------------+");
    }

    @Override
    public void showAddMatiereMsg() {
        System.out.println("\t+--------------------------+");
        System.out.println("\t|    AJOUT D'UNE MATIERE   | ");
        System.out.println("\t+--------------------------+\n");
    }

    @Override
    public void showAddTypeMsg() {
        System.out.println("\t+-----------------------------------+");
        System.out.println("\t|    AJOUT D'UN TYPE D'EVALUATION   | ");
        System.out.println("\t+-----------------------------------+\n");
    }

    @Override
    public void showAddEnseignementMsg(Niveau niveau, Matiere matiere) {
        System.out.println("\t+----------------------------------------------------------------+");
        System.out.printf("\t|    AJOUT D'UN ENSEIGNEMENT  EN %-6s DANS LA MATIERE %-8s |\n", niveau.getLibelle(), matiere.getCode());
        System.out.println("\t+----------------------------------------------------------------+");
    }

    @Override
    public void showAddCoursMsg(Enseignement enseignement, Classe classe) {
        System.out.println("\t+----------------------------------------------------------------+");
        System.out.printf("\t|    AJOUT D'UN COURS EN %-7s DANS L'ENSEIGNEMENT %-10s  |\n", classe.getLibelle(), enseignement.getLibelle());
        System.out.println("\t+----------------------------------------------------------------+\n");
    }

    @Override
    public void showAddPeriodeMsg() {
        System.out.println("\t+---------------------------+");
        System.out.println("\t|    AJOUT D'UNE PERIODE    | ");
        System.out.println("\t+---------------------------+\n");
    }

    @Override
    public void showAddEvaluationMsg() {
        System.out.println("\t+------------------------------+");
        System.out.println("\t|    AJOUT D'UNE EVALUATION    | ");
        System.out.println("\t+------------------------------+\n");
    }

    @Override
    public void showAddNoteMsg(Eleve eleve) {
        System.out.println("\t+---------------------------------------------------------------------------------------+");
        System.out.printf("\t|    AJOUT D'UNE NOTE POUR L'ELEVE %-50s   |\n", eleve.getNom() + " " + eleve.getPrenom());
        System.out.println("\t+---------------------------------------------------------------------------------------+\n");
    }

    @Override
    public char repeatAction() {
        System.out.print("\nVoulez-vous répéter cette action ? (tapez O ou N) : ");
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
    public void alreadyDoneAction() {
        System.out.println("Désolé, cette opération a déjà été effectuée !!!");
    }

    public int inputNumero() {
        int numero = 0;
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        do {
            try {
                System.out.print("\nNumero : ");               
                numero = scanner.nextInt();        //si l'InpuMismatchException est levée alors error restera à true
                error = false;                     //et donc le bloc d'instruction est repris jusqu'à une bonne saisie
            } catch (InputMismatchException badInput) {
                showErrorMsg();
            }

        } while (error);
        return numero;
    }

    @Override
    public int inputCoefficient() {
        int coefficient = 0;
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        do {
            try {                
                System.out.print("\nCoefficient : ");
                coefficient = scanner.nextInt();     //si l'InpuMismatchException est levée alors error restera à true
                error = false;                       //et donc le bloc d'instruction est repris jusqu'à une bonne saisie
            } catch (InputMismatchException badInput) {
                showErrorMsg();
            }

        } while (error);
        return coefficient;
    }

    @Override
    public int inputBareme() {
        int bareme = 0;
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        do {
            try {                
                System.out.print("\nBarème : ");
                bareme = scanner.nextInt();     //si l'InpuMismatchException est levée alors error restera à true
                error = false;                       //et donc le bloc d'instruction est repris jusqu'à une bonne saisie
            } catch (InputMismatchException badInput) {
                showErrorMsg();
            }

        } while (error);
        return bareme;
    }

    @Override
    public double inputPoids() {
        double poids = 0;
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        do {
            try {                
                System.out.print("\nPoids : ");
                poids = scanner.nextDouble();      //si l'InpuMismatchException est levée alors error restera à true
                error = false;                     //et donc le bloc d'instruction est repris jusqu'à une bonne saisie
            } catch (InputMismatchException badInput) {
                showErrorMsg();
            }
        } while (error);
        return poids;
    }

    @Override
    public double inputValeur() {
        double valeur = 0;
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        do {
            try {                
                System.out.print("\nValeur : ");
                valeur = scanner.nextDouble();       //si l'InpuMismatchException est levée alors error restera à true
                error = false;                      //et donc le bloc d'instruction est repris jusqu'à une bonne saisie
            } catch (InputMismatchException badInput) {
                showErrorMsg();
            }
        } while (error);
        return valeur;
    }

    @Override
    public String inputLibelle() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nLibelle : ");
        String libelle = scanner.next();
        return libelle;
    }

    @Override
    public String inputDescription() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nDescription : ");
        String description = scanner.next();
        return description;
    }

    @Override
    public String inputSubdivision() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String subdivision;
        char c;
        System.out.print("\nSubdivision de la classe : ");
        subdivision = scanner.next();
        int l = subdivision.length();
        if (l > 3) {
            subdivision = subdivision.substring(0, 2);
        }
        for (int i = 0; i < subdivision.length(); i++) {
            c = subdivision.charAt(i);
            subdivision = subdivision.replace(c, Character.toUpperCase(c));
        }
        return subdivision;
    }

    @Override
    public char inputSexe() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String textChar;
        char sexe;
        do {
            System.out.print("\nSexe de l'élève (M/F) : ");
            textChar = scanner.next();
            sexe = textChar.charAt(0);
            sexe = Character.toUpperCase(sexe);
            if ((sexe != 'M') && (sexe != 'F')) {
                System.out.print("Désolé le sexe choisi est invalide.\nVeuillez ressaisir un sexe valide : ");
            }
        } while ((sexe != 'M') && (sexe != 'F'));
        return sexe;
    }

    @Override
    public String inputNom() {
        char c;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nNom : ");
        String nom = scanner.next();
        //met en majuscule le nom saisi
        for (int i = 0; i < nom.length(); i++) {
            c = nom.charAt(i);
            nom = nom.replace(c, Character.toUpperCase(c));
        }
        return nom;
    }

    @Override
    public String inputPrenom() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nPrenom : ");
        String prenom = scanner.next();
        return prenom;
    }

    @Override
    public String inputCode() {
        char c;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.print("\nCode : ");
        String code = scanner.next();
        //met en majuscule le code saisi
        for (int i = 0; i < code.length(); i++) {
            c = code.charAt(i);
            code = code.replace(c, Character.toUpperCase(c));
        }
        return code;
    }

    @Override
    public LocalDate inputDate() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String _date;
        LocalDate date = null;
        boolean error = true;
        do {
            try {
                System.out.print("\nEntrez la date de l'évaluation (au format \" AAAA-MM-JJ \" ) : ");
                _date = scanner.next();
                date = LocalDate.parse(_date, DateTimeFormatter.ISO_DATE);
                error = false;
            } catch (DateTimeParseException badInput) {
                showErrorMsg();
                System.out.println("*******  Le format de la date à saisir doit être \" AAAA-MM-JJ \" *******");
            }
        } while (error);
        return date;
    }

}
