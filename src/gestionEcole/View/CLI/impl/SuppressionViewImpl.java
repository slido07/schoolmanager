    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.CLI.impl;

import gestionEcole.View.CLI.I.ISuppressionView;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Niveau;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class SuppressionViewImpl implements ISuppressionView {
    
    @Override
    public void showSucessMsg() {
        System.out.println("\n-------------SUPPRESSION EFFECTUE------------");
    }

    @Override
    public void showCancelMsg() {
        System.out.println("\n-------------SUPPRESSION ANNULEE------------");
    }


    @Override
    public void showDelNiveauMsg() {
        System.out.println("\t+-------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UN NIVEAU    | ");
        System.out.println("\t+-------------------------------+\n");
    }

    @Override
    public void showDelClasseMsg() {
        System.out.println("\t+--------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UNE CLASSE    | ");
        System.out.println("\t+--------------------------------+\n");
    }

    @Override
    public void showDelClasseMsg(Niveau niveau) {
        System.out.println("\t+---------------------------------------------------+");
        System.out.printf("\t|  SUPPRESSION DE TOUTES LES CLASSES DE LA %-8s  |\n", niveau.getLibelle());
        System.out.println("\t+---------------------------------------------------+\n");
    }

    @Override
    public void showDelEleveMsg() {
        System.out.println("\t+------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UN ELEVE    | ");
        System.out.println("\t+------------------------------+\n");
    }
    
    @Override
    public void showDelEleveMsg(Classe classe) {
        System.out.println("\t+---------------------------------------------------------+");
        System.out.printf("\t|   SUPPRESSION DE TOUS LES ELEVES DE LA  %-12s   |\n", classe.getLibelle());
        System.out.println("\t+---------------------------------------------------------+");
   }

    @Override
    public void showDelEnseignantMsg() {
        System.out.println("\t+-----------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UN ENSEIGNANT    | ");
        System.out.println("\t+-----------------------------------+\n");
    }

    @Override
    public void showDelMatiereMsg() {
        System.out.println("\t+--------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UNE MATIERE   | ");
        System.out.println("\t+--------------------------------+\n");
    }

    @Override
    public void showDelEnseignementMsg() {
        System.out.println("\t+-------------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UN ENSEIGNEMENT    | ");
        System.out.println("\t+-------------------------------------+\n");
    }

    @Override
    public void showDelCoursMsg() {
        System.out.println("\t+------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UN COURS    | ");
        System.out.println("\t+------------------------------+\n");
    }

    @Override
    public void showDelPeriodeMsg() {
        System.out.println("\t+---------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UNE PERIODE    | ");
        System.out.println("\t+---------------------------------+\n");
    }

    @Override
    public void showDelEvaluationMsg() {
        System.out.println("\t+------------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UNE EVALUATION    | ");
        System.out.println("\t+------------------------------------+\n");
    }

    @Override
    public void showDelTypeMsg() {
        System.out.println("\t+----------------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UN TYPE EVALUATION    | ");
        System.out.println("\t+----------------------------------------+\n");
    }

    @Override
    public void showDelNoteMsg() {
        System.out.println("\t+------------------------------+");
        System.out.println("\t|    SUPPRESSION D'UNE NOTE    | ");
        System.out.println("\t+------------------------------+\n");
    }

    @Override
    public char showWarningMsgDelNiveau() {
        System.out.print("Attention !!!! \nAvant toute suppression d'un niveau il est nécessaire d'avoir supprimé toutes ses classes."
                        + "\n\nÊtes-vous sûr d'avoir supprimé toutes les classes du niveau concerné? (tapez O ou N) : ");
        char answer = giveAnswer();
        return answer;
    }

    @Override
    public void showDelNiveauExitMsg() {
        System.out.println("\nDésolé ce niveau contient toujours des classes.\nveuillez les supprimer puis reprendre l'opération.");
        System.out.println("\n-------------SUPPRESSION NON EFFECTUEE------------");
    }

    @Override
    public void showDelClasseExitMsg() {
        System.out.println("\nDésolé cette classe contient toujours des élèves.\nveuillez les supprimer puis reprendre l'opération.");
        System.out.println("\n-------------SUPPRESSION NON EFFECTUEE------------");
    }
    
    @Override
    public void showDelClasseExitMsg(Classe classe) {
        System.out.printf("\nDésolé la classe de %-4s contient toujours des élèves.\nveuillez les supprimer puis reprendre l'opération.", classe.getLibelle());
        System.out.println("\n\n-------------SUPPRESSION NON EFFECTUEE------------");
    }
    
    @Override
    public void showDelMatiereExitMsg() {
        System.out.println("\nDésolé il existe des enseignements enregistrés pour cette matière.\nveuillez les supprimer puis reprendre l'opération.");
        System.out.println("\n-------------SUPPRESSION NON EFFECTUEE------------");
    }
    
    /**
     *
     */
    @Override
    public void showDelPeriodeExitMsg() {
        System.out.println("\nDésolé il existe des évaluations enregistrées pour cette période.\nveuillez les supprimer puis reprendre l'opération.");
        System.out.println("\n-------------SUPPRESSION NON EFFECTUEE------------");
    }
     
    @Override
    public void showDelTypeExitMsg() {
        System.out.println("\nDésolé il existe des évaluations enregistrées pour ce type d'évaluation.\nveuillez les supprimer puis reprendre l'opération.");
        System.out.println("\n-------------SUPPRESSION NON EFFECTUEE------------");
    }
    
    @Override
    public void showDelCoursExitMsg() {
        System.out.println("\nDésolé il existe des évaluations enregistrées pour ce cours.\nveuillez les supprimer puis reprendre l'opération.");
        System.out.println("\n-------------SUPPRESSION NON EFFECTUEE------------");
    }
    
    @Override
    public void showDelEnseignementExitMsg() {
        System.out.println("\nDésolé il existe des cours enregistrés dans cet enseignement.\nveuillez les supprimer puis reprendre l'opération.");
        System.out.println("\n-------------SUPPRESSION NON EFFECTUEE------------");
    }

    @Override
    public char showWarningMsgDelClasse() {
        System.out.print("Attention !!!! \nAvant toute suppression d'une classe il est nécessaire d'avoir supprimé tous ces élèves ou d'avoir modifié leur classe."
                + "\n\nDésirez-vous tout d'abord modifier la classe de tous ces élèves avant la suppression? (tapez O ou N) : ");
        char answer = giveAnswer();
        return answer;
    }
    
    @Override
    public char showWarningMsgDelClasse(Niveau niveau) {
        System.out.printf("Attention !!!! \nAvant toute suppression d'une classe de la %-3s il est nécessaire d'avoir supprimé tous ces élèves ou d'avoir modifié leur classe."
                + "\n\nÊtes-vous sûr d'avoir supprimé tous les élèves des classes de la %-3s ? (tapez \"O\" ou \"N\") : ", niveau.getLibelle(), niveau.getLibelle());
        char answer = giveAnswer();
        return answer;
    }
 

    @Override
   public char showWarningMsgDelEleve() {
        System.out.print("Attention !!!! La suppression de cet élève entrainera celle de toutes les notes enregistées pour cet élève"
                         + "\n\nVoullez-vous continuer cette opération ? (tapez \"O\" ou \"N\") : ");
        char answer = giveAnswer();
        return answer;
    }

    @Override
    public char showWarningMsgDelEleve(Classe classe) {
        System.out.printf("Attention !!!! La suppression des élèves de la classe de %-4s entrainera celle de toutes leurs notes enregistées", classe.getLibelle()
                         + "\n\nVoullez-vous continuer cette opération ? (tapez \"O\" ou \"N\") : ");
        char answer = giveAnswer();
        return answer;
    }

    @Override
    public char pursueOperation() {
        System.out.print("\nVoulez-vous poursuivre l'opération en cours ? (tapez \"O\" ou \"N\") : ");
        char answer = giveAnswer();
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

}
