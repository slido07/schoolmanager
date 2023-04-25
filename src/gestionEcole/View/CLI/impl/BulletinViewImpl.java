/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.View.CLI.impl;

import gestionEcole.model.entity.Note;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Periode;
import gestionEcole.Controller.CLI.impl.ConsultationControllerImpl;
import gestionEcole.View.CLI.I.IBulletinView;
import gestionEcole.View.CLI.I.IConsultationView;
import gestionEcole.model.entity.TypeEvaluation;
import java.util.List;
import gestionEcole.Controller.CLI.I.IConsultationControllerCLI;

/**
 *
 * @author HP
 */
public class BulletinViewImpl implements IBulletinView {

    private static final IConsultationControllerCLI consultationC = new ConsultationControllerImpl();
    private static final IConsultationView consultationV = new ConsultationViewImpl();

    @Override
    public void showBulletin(Periode periode, Eleve eleve) {
        if (periode == null) {
            return;
        }
        if (eleve == null) {
            return;
        }
        String libellePeriode = periode.getLibelle();
        List<Cours> listeCours = consultationC.getListeCours(eleve.getClasse());
        if (listeCours.isEmpty()) {
            consultationV.noticeEmptyList(Cours.class.getSimpleName());
            return;
        }
        double[] tabNote;
        List<TypeEvaluation> listeT = consultationC.getListeType();
        if (listeT.isEmpty()) {
            consultationV.noticeEmptyList(TypeEvaluation.class.getSimpleName());
            return;
        }
        char c;
        //met en majuscule le libelle de la période
        for (int i = 0; i < libellePeriode.length(); i++) {
            c = libellePeriode.charAt(i);
            libellePeriode = libellePeriode.replace(c, Character.toUpperCase(c));
        }
        System.out.println("\t+------------------------------------------------+");
        System.out.printf("\t|       BULLETIN DE NOTES DU %-20s|\n", libellePeriode);
        System.out.println("\t+------------------------------------------------+\n");
        System.out.println("ELEVE : " + eleve.getNom() + " " + eleve.getPrenom());
        System.out.println("MATRICULE : " + eleve.getId());
        System.out.println("SEXE : " + eleve.getSexe());
        System.out.println("CLASSE : " + eleve.getClasse().getLibelle());
        System.out.println("EFFECTIF : " + Eleve.getEffectif(eleve.getClasse()));
        System.out.println("+----------------------+------------------------------------------+-------------+---------+--------+-------------+");
        System.out.println("|     ENSEIGNEMENT     |             NOTES OBTENUEES              | COEFFICIENT | MOYENNE |  RANG  |    MENTION  |");
        System.out.println("+----------------------+-------------+-------------+--------------+-------------+---------+--------+-------------+");
        for (Cours cours : listeCours) {
            tabNote = Note.getTabType(periode, cours.getEnseignement(), eleve);
            //s'il n'ya aucune note enregistrée pour le moment
            if (tabNote == null) {
                consultationV.noticeEmptyList(Note.class.getSimpleName());
                return;
            }
            //s'il manque au moins une note pour un type d'évaluation on n'affiche pas le bulletin
            if (tabNote.length < listeT.size()) {
                noticeInsufficientNoteQty();
                return;
            }
            System.out.printf("| %-20s ", cours.getEnseignement().getMatiere().getLibelle());
            for (int i = 0; i < tabNote.length; i++) {
                System.out.printf("|%-4s : %05.2f ", listeT.get(i).getCode(), tabNote[i]);
            }
            System.out.printf(" |  %5d      |  %05.2f  | %-7s| %-12s|\n",
                    cours.getEnseignement().getCoefficient(), cours.getMoyenne(periode, eleve),
                    rang(eleve.getRang(periode, cours)),
                    mention(cours.getMoyenne(periode, eleve)));
            System.out.println("+----------------------+-------------+-------------+--------------+-------------+---------+--------+-------------+");
        }
        System.out.printf("| MOYENNE GENERALE :    %05.2f        |     RANG :   %-12s  |     MENTION :  %-12s    |\n",
                periode.getMoyenne(eleve), rang(eleve.getRang(periode)), mention(periode.getMoyenne(eleve)));
        System.out.println("+------------------------------------+----------------------------+--------------------------------+");
        System.out.printf("| MOYENNE DE LA CLASSE :    %05.2f   |\n", periode.getMoyenne(eleve.getClasse()));
        System.out.println("+-----------------------------------+");
    }

    @Override
    public String rang(int rang) {
        if (rang == 1) {
            return rang + " er";
        } else {
            return rang + " ième";
        }
    }

    @Override
    public String mention(double moyenne) {
        if ((moyenne >= 16) && (moyenne <= 20)) {
            return "Très Bien";
        } else if ((moyenne >= 14) && (moyenne < 16)) {
            return "Bien";
        } else if ((moyenne >= 12) && (moyenne < 14)) {
            return "Assez Bien";
        } else if ((moyenne >= 10) && (moyenne < 12)) {
            return "Passable";
        } else if ((moyenne >= 8) && (moyenne < 10)) {
            return "Médiocre";
        }
        return "Blame";
    }

    @Override
    public void showMoyenne(Periode periode, Cours cours) {
        if (periode == null) {
            return;
        }
        if (cours == null) {
            return;
        }
        System.out.printf("La moyenne générale en " + cours.getEnseignement().getMatiere().getLibelle()
                + " " + cours.getClasse().getLibelle() + " est de : %05.2f.\n", periode.getMoyenne(cours));
    }

    @Override
    public void showCancelMsg() {
        System.out.println("\n-------------OPERATION ANNULEE------------");
    }

    @Override
    public void noticeInsufficientNoteQty() {
        System.out.println("********** Désolé vous n'avez pas enregistré un nombre suffisant de notes pour chaque type d'évaluation ***********");
        System.out.println("-----------LE BULLETIN NE PEUT ETRE AFFICHE POUR LE MOMENT----------");
    }

}
