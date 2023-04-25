/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.Controller.GUI.impl;

import gestionEcole.Controller.GUI.I.IConsultationControllerGUI;
import gestionEcole.Controller.GUI.I.IModificationControllerGUI;
import gestionEcole.View.GUI.components.messages.UpdateMessages;
import gestionEcole.jpa.dao.I.*;
import gestionEcole.jpa.dao.impl.*;
import gestionEcole.model.entity.*;
import gestionEcole.schoolManager.GUI.Main.MainViewGUI;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ModificationControllerGUIImpl implements IModificationControllerGUI {

    //objets dao
    private static final INiveauDao niveauDao = new NiveauDaoImpl();
    private static final IClasseDao classeDao = new ClasseDaoImpl();
    private static final IEleveDao eleveDao = new EleveDaoImpl();
    private static final IEnseignantDao enseignantDao = new EnseignantDaoImpl();
    private static final IMatiereDao matiereDao = new MatiereDaoImpl();
    private static final ITypeEvaluationDao typeEvaluationDao = new TypeEvaluationDaoImpl();
    private static final IEnseignementDao enseignementDao = new EnseignementDaoImpl();
    private static final ICoursDao coursDao = new CoursDaoImpl();
    private static final IPeriodeDao periodeDao = new PeriodeDaoImpl();
    private static final IEvaluationDao evaluationDao = new EvaluationDaoImpl();
    private static final INoteDao noteDao = new NoteDaoImpl();
    //objets controller
    private static final IConsultationControllerGUI consultC = new ConsultationControllerGUIImpl();

    @Override
    public void controller() {
        Niveau niveau;
        Classe classe;
        Eleve eleve;
        Periode periode;
        Matiere matiere;
        TypeEvaluation type;
        Cours cours;
        Enseignant enseignant;
        Enseignement enseignement;
        Evaluation evaluation;
        Note note;
        int action;

        UpdateMessages msg = new UpdateMessages();
        MainViewGUI.getMainFrame().setVisible(true);
        action = MainViewGUI.getMainFrame().getCurrentState();

        switch (action) {
            case 19: //libelle de niveau
                niveau = consultC.controlNiveau();
                if (niveau != null) {
                    String lib = newLibelle(MainViewGUI.getMainFrame());
                    if (lib != null) {
                        niveau.setLibelle(lib);
                        niveauDao.modifier(niveau);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 20: //niveau description
                niveau = consultC.controlNiveau();
                if (niveau != null) {
                    String desc = newDescription(MainViewGUI.getMainFrame());
                    if (desc != null) {
                        niveau.setDescription(desc);
                        niveauDao.modifier(niveau);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 21: //classe subdivision
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                if (classe != null) {
                    String sub = newSubdivision(MainViewGUI.getMainFrame());
                    if (sub != null) {
                        classe.setSubdivision(sub);
                        classeDao.modifier(classe);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 22: //eleve nom
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                eleve = consultC.controlEleve(classe);
                if (eleve != null) {
                    String nom = newNom(MainViewGUI.getMainFrame());
                    if (nom != null) {
                        eleve.setNom(nom);
                        eleveDao.modifier(eleve);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 23: //eleve prenom
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                eleve = consultC.controlEleve(classe);
                if (eleve != null) {
                    String prenom = newPrenom(MainViewGUI.getMainFrame());
                    if (prenom != null) {
                        eleve.setPrenom(prenom);
                        eleveDao.modifier(eleve);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 24: //eleve sexe
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                eleve = consultC.controlEleve(classe);
                if (eleve != null) {
                    char sexe = newSexe(MainViewGUI.getMainFrame());
                    if (sexe != 'N') {
                        eleve.setSexe(sexe);
                        eleveDao.modifier(eleve);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 25: //eleve classe
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                eleve = consultC.controlEleve(classe);
                if (eleve != null) {
                    Classe newClasse = consultC.controlClasse(niveau);
                    if (newClasse != null) {
                        eleve.setClasse(newClasse);
                        eleveDao.modifier(eleve);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 28: //enseignant nom
                enseignant = consultC.controlEnseignant();
                if (enseignant != null) {
                    String nom = newNom(MainViewGUI.getMainFrame());
                    if (nom != null) {
                        enseignant.setNom(nom);
                        enseignantDao.modifier(enseignant);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 29:  //enseignant prenom
                enseignant = consultC.controlEnseignant();
                if (enseignant != null) {
                    String prenom = newPrenom(MainViewGUI.getMainFrame());
                    if (prenom != null) {
                        enseignant.setPrenom(prenom);
                        enseignantDao.modifier(enseignant);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 32: //periode libelle
                periode = consultC.controlPeriode();
                if (periode != null) {
                    String libelle = newLibelle(MainViewGUI.getMainFrame());
                    if (libelle != null) {
                        periode.setLibelle(libelle);
                        periodeDao.modifier(periode);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 33: //matiere code
                matiere = consultC.controlMatiere();
                if (matiere != null) {
                    String code = newCode(MainViewGUI.getMainFrame());
                    if (code != null) {
                        matiere.setCode(code);
                        matiereDao.modifier(matiere);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 34: //matiere libelle
                matiere = consultC.controlMatiere();
                if (matiere != null) {
                    String libelle = newLibelle(MainViewGUI.getMainFrame());
                    if (libelle != null) {
                        matiere.setLibelle(libelle);
                        matiereDao.modifier(matiere);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 35: //type code
                type = consultC.controlType();
                if (type != null) {
                    String code = newCode(MainViewGUI.getMainFrame());
                    if (code != null) {
                        type.setCode(code);
                        typeEvaluationDao.modifier(type);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 36: //type libelle
                type = consultC.controlType();
                if (type != null) {
                    String libelle = newLibelle(MainViewGUI.getMainFrame());
                    if (libelle != null) {
                        type.setLibelle(libelle);
                        typeEvaluationDao.modifier(type);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 37: //enseignement coefficient
                niveau = consultC.controlNiveau();
                enseignement = consultC.controlEnseignement(niveau);
                if (enseignement != null) {
                    int coef = newCoefficient(MainViewGUI.getMainFrame());
                    if (coef != 0) {
                        enseignement.setCoefficient(coef);
                        enseignementDao.modifier(enseignement);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 38: //cours enseignant
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                cours = consultC.controlCours(classe);
                if (cours != null) {
                    enseignant = consultC.controlEnseignant();
                    if (enseignant != null) {
                        cours.setEnseignant(enseignant);
                        coursDao.modifier(cours);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 39: //evaluation bareme
                periode = consultC.controlPeriode();
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                cours = consultC.controlCours(classe);
                evaluation = consultC.controlEvaluation(periode, cours);
                if (evaluation != null) {
                    int bareme = newBareme(MainViewGUI.getMainFrame());
                    if (bareme != 0) {
                        evaluation.setBareme(bareme);
                        evaluationDao.modifier(evaluation);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 40: //evaluation poids
                periode = consultC.controlPeriode();
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                cours = consultC.controlCours(classe);
                evaluation = consultC.controlEvaluation(periode, cours);
                if (evaluation != null) {
                    double poids = newPoids(MainViewGUI.getMainFrame());
                    if (poids != 0) {
                        evaluation.setPoids(poids);
                        evaluationDao.modifier(evaluation);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 41: //evaluation date
                periode = consultC.controlPeriode();
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                cours = consultC.controlCours(classe);
                evaluation = consultC.controlEvaluation(periode, cours);
                if (evaluation != null) {
                    LocalDate date = newDate(MainViewGUI.getMainFrame());
                    if (date != null) {
                        evaluation.setDate(date);
                        evaluationDao.modifier(evaluation);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;
            case 42: //note valeur
                periode = consultC.controlPeriode();
                niveau = consultC.controlNiveau();
                classe = consultC.controlClasse(niveau);
                cours = consultC.controlCours(classe);
                eleve = consultC.controlEleve(classe);
                note = consultC.controlNote(periode, eleve, cours);
                if (note != null) {
                    double valeur = newValeur(MainViewGUI.getMainFrame());
                    if (valeur != 0) {
                        note.setValeur(valeur);
                        noteDao.modifier(note);
                        msg.successMsg(MainViewGUI.getMainFrame());
                    } else {
                        msg.errorMsg(MainViewGUI.getMainFrame());
                    }
                } else {
                    msg.cancelMsg(MainViewGUI.getMainFrame());
                }
                break;

        }
    }

    @Override
    public String newNom(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau nom", "Mise à jour de nom",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            String nom = formatUp(rep);
            return nom;
        }
        return rep;
    }

    @Override
    public String newPrenom(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau prénom", "Mise à jour de prénom",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            String prenom = rep;
            return prenom;
        }
        return rep;
    }

    @Override
    public String newLibelle(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau libellé", "Mise à jour de libellé",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            String libelle = rep;
            return libelle;
        }
        return rep;
    }

    @Override
    public String newCode(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau code", "Mise à jour de code",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            String code = formatUp(rep);
            return code;
        }
        return rep;
    }

    @Override
    public String newDescription(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez la nouvelle description ", "Mise à jour de description",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            String description = rep;
            return description;
        }
        return rep;
    }

    @Override
    public String newSubdivision(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez la nouvelle subdivision ", "Mise à jour de subdivision",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            String subdivision = formatUp(rep);
            if (subdivision.length() > 4) {
                subdivision = subdivision.substring(0, 4);
            }
            return subdivision;
        }
        return rep;
    }

    @Override
    public char newSexe(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau sexe (M/F) ", "Mise à jour de description",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            char sexe = getSexe(rep);
            return sexe;
        }
        return 'N';
    }

    @Override
    public int newCoefficient(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau coefficent ", "Mise à jour de coefficient",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            int coefficient = getInt(rep);
            return coefficient;
        }
        return 0;
    }

    @Override
    public int newBareme(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau barème", "Mise à jour de barème",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            int bareme = getInt(rep);
            return bareme;
        }
        return 0;
    }

    @Override
    public double newPoids(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez le nouveau poids", "Mise à jour de poids d'évaluation",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            double poids = getDouble(rep);
            return poids;
        }
        return 0;
    }

    @Override
    public double newValeur(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez la nouvelle valeur de la note", "Mise à jour de note",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            double valeur = getDouble(rep);
            return valeur;
        }
        return 0;
    }

    @Override
    public LocalDate newDate(JFrame f) {
        String rep = JOptionPane.showInputDialog(f, "Entrez la nouvelle date", "Mise à jour de date",
                JOptionPane.PLAIN_MESSAGE);
        if (rep != null) {
            LocalDate date = getLocalDate(rep);
            return date;
        }
        return null;
    }

    private int getInt(String text) {
        int value = 0;
        try {
            value = Integer.parseInt(text);
            return value;
        } catch (NumberFormatException e) {
        }
        return value;
    }

    private double getDouble(String text) {
        double value = 0;
        try {
            value = Double.parseDouble(text);
            return value;
        } catch (NumberFormatException e) {
        }
        return value;
    }

    private LocalDate getLocalDate(String text) {
        LocalDate value = null;
        try {
            value = LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
            return value;
        } catch (DateTimeException e) {
        }
        return value;
    }

    private String formatUp(String text) {
        char c;
        String value = text;
        for (int i = 0; i < value.length(); i++) {
            c = value.charAt(i);
            value = value.replace(c, Character.toUpperCase(c));
        }
        return value;
    }

    private char getSexe(String text) {
        char sexe = text.charAt(0);
        sexe = Character.toUpperCase(sexe);
        if ((sexe != 'M') && (sexe != 'F')) {
            sexe = 'N'; //N signifie une saisie invalide 
        }
        return sexe;
    }

}
