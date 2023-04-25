/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionEcole.schoolManager.GUI.Main;

import gestionEcole.View.GUI.components.addObject.AddTypePanel;
import gestionEcole.View.GUI.components.addObject.AddMatierePanel;
import gestionEcole.View.GUI.components.addObject.AddEnseignantPanel;
import gestionEcole.View.GUI.components.addObject.AddNiveauPanel;
import gestionEcole.View.GUI.components.addObject.AddPeriodePanel;
import gestionEcole.Controller.GUI.I.*;
import gestionEcole.Controller.GUI.impl.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class MainViewGUI extends JFrame {
    
    static MainViewGUI mainProg = new MainViewGUI();
    private int currentState;
    private final IConsultationControllerGUI consultC = new ConsultationControllerGUIImpl();
    private final IAjoutControllerGUI addC = new AjoutControllerGUIImpl();
    private final ISuppressionControllerGUI delC = new SuppressionControllerGUIImpl();
    private final IModificationControllerGUI updC = new ModificationControllerGUIImpl();
    private final IBulletinControllerGUI bulletinC = new BulletinControllerGUIImpl();
    //constantes utilisées par la fenêtre
    //GET
    public static int GET_NIVEAU = 1;
    public static int GET_CLASSE_ALL = 2;
    public static int GET_CLASSE_NIVEAU = 3;
    public static int GET_ELEVE_ALL = 4;
    public static int GET_ELEVE_CLASSE = 5;
    public static int GET_ENSEIGNANT = 6;
    public static int GET_PERIODE = 7;
    public static int GET_MATIERE = 8;
    public static int GET_ENSEIGNEMENT_ALL = 9;
    public static int GET_ENSEIGNEMENT_NIVEAU = 10;
    public static int GET_COURS_ALL = 11;
    public static int GET_COURS_CLASSE = 12;
    public static int GET_TYPE = 13;
    public static int GET_EVALUATION_CLASSE = 14;
    public static int GET_EVALUATION_COURS = 15;
    public static int GET_NOTE_CLASSE = 16;
    public static int GET_NOTE_EVALUATION = 17;
    public static int GET_NOTE_ELEVE = 18;
    //UPDATE
    public static int UPD_NIVEAU_LIBELLE = 19;
    public static int UPD_NIVEAU_DESCRIPTION = 20;
    public static int UPD_CLASSE_SUBDIVISION = 21;
    public static int UPD_ELEVE_NOM = 22;
    public static int UPD_ELEVE_PRENOM = 23;
    public static int UPD_ELEVE_SEXE = 24;
    public static int UPD_ELEVE_CLASSE = 25;
    
    public static int UPD_ENSEIGNANT_NOM = 28;
    public static int UPD_ENSEIGNANT_PRENOM = 29;
    
    public static int UPD_PERIODE_LIBELLE = 32;
    public static int UPD_MATIERE_CODE = 33;
    public static int UPD_MATIERE_LIBELLE = 34;
    public static int UPD_TYPE_CODE = 35;
    public static int UPD_TYPE_LIBELLE = 36;
    public static int UPD_ENSEIGNEMENT_COEFFICIENT = 37;
    public static int UPD_COURS_ENSEIGNANT = 38;
    public static int UPD_EVALUATION_BAREME = 39;
    public static int UPD_EVALUATION_POIDS = 40;
    public static int UPD_EVALUATION_DATE = 41;
    public static int UPD_NOTE_VALEUR = 42;
    
    private MainViewGUI() {
        currentState = 0;
        initComponents();
        this.setLocationRelativeTo(null);
    }
                         
    private void initComponents() {

        panelOutput = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        panelNorth = new javax.swing.JPanel();
        panelSouth = new javax.swing.JPanel();
        barMenu = new javax.swing.JMenuBar();
        addMenu = new javax.swing.JMenu();
        addNiveau = new javax.swing.JMenuItem();
        addClasse = new javax.swing.JMenuItem();
        addEleve = new javax.swing.JMenuItem();
        addEnseignant = new javax.swing.JMenuItem();
        addPeriode = new javax.swing.JMenuItem();
        addMatiere = new javax.swing.JMenuItem();
        addEnseignement = new javax.swing.JMenuItem();
        addCours = new javax.swing.JMenuItem();
        addType = new javax.swing.JMenuItem();
        addEvaluation = new javax.swing.JMenuItem();
        addNote = new javax.swing.JMenuItem();
        consultMenu = new javax.swing.JMenu();
        getNiveau = new javax.swing.JMenuItem();
        getClasse = new javax.swing.JMenu();
        getAllClasse = new javax.swing.JMenuItem();
        getClasseNiv = new javax.swing.JMenuItem();
        getEleve = new javax.swing.JMenu();
        getAllEleve = new javax.swing.JMenuItem();
        getEleveClasse = new javax.swing.JMenuItem();
        getEnseignant = new javax.swing.JMenuItem();
        getPeriode = new javax.swing.JMenuItem();
        getMatiere = new javax.swing.JMenuItem();
        getEnseignement = new javax.swing.JMenu();
        getAllEns = new javax.swing.JMenuItem();
        getEnsNiv = new javax.swing.JMenuItem();
        getCours = new javax.swing.JMenu();
        getAllCours = new javax.swing.JMenuItem();
        getCoursClasse = new javax.swing.JMenuItem();
        getType = new javax.swing.JMenuItem();
        getEvaluation = new javax.swing.JMenu();
        getEvClasse = new javax.swing.JMenuItem();
        getEvCours = new javax.swing.JMenuItem();
        getNote = new javax.swing.JMenu();
        getNoteClasse = new javax.swing.JMenuItem();
        getNoteEv = new javax.swing.JMenuItem();
        getNoteEleve = new javax.swing.JMenuItem();
        updateMenu = new javax.swing.JMenu();
        updateNiveau = new javax.swing.JMenu();
        updNiveauLibelle = new javax.swing.JMenuItem();
        updNiveauDescription = new javax.swing.JMenuItem();
        updateClasse = new javax.swing.JMenu();
        updClasseSubdivision = new javax.swing.JMenuItem();
        updateEleve = new javax.swing.JMenu();
        updEleveNom = new javax.swing.JMenuItem();
        updElevePrenom = new javax.swing.JMenuItem();
        updEleveSexe = new javax.swing.JMenuItem();
        updEleveClasse = new javax.swing.JMenuItem();
        updateEnseignant = new javax.swing.JMenu();
        updEnseignantNom = new javax.swing.JMenuItem();
        updEnseignantPrenom = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        updPeriodeLibelle = new javax.swing.JMenuItem();
        updateMatiere = new javax.swing.JMenu();
        updMatiereCode = new javax.swing.JMenuItem();
        updMatiereLibelle = new javax.swing.JMenuItem();
        updateEnseignement = new javax.swing.JMenu();
        updEnsCoefficient = new javax.swing.JMenuItem();
        updateCours = new javax.swing.JMenu();
        updCoursEnseignant = new javax.swing.JMenuItem();
        updateType = new javax.swing.JMenu();
        updTypeCode = new javax.swing.JMenuItem();
        updTypeLibelle = new javax.swing.JMenuItem();
        updateEvaluation = new javax.swing.JMenu();
        updEvBareme = new javax.swing.JMenuItem();
        updEvPoids = new javax.swing.JMenuItem();
        updEvDate = new javax.swing.JMenuItem();
        updateNote = new javax.swing.JMenu();
        updNoteValeur = new javax.swing.JMenuItem();
        delMenu = new javax.swing.JMenu();
        delNiveau = new javax.swing.JMenuItem();
        delClasse = new javax.swing.JMenuItem();
        delEleve = new javax.swing.JMenuItem();
        delEnseignant = new javax.swing.JMenuItem();
        delPeriode = new javax.swing.JMenuItem();
        delMatiere = new javax.swing.JMenuItem();
        delEnseignement = new javax.swing.JMenuItem();
        delCours = new javax.swing.JMenuItem();
        delType = new javax.swing.JMenuItem();
        delEv = new javax.swing.JMenuItem();
        delNote = new javax.swing.JMenuItem();
        bulletinMenu = new javax.swing.JMenu();
        bulletin = new javax.swing.JMenuItem();
        showMoyenneCours = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("  LOGICIEL DE GESTION D'ECOLE");
        setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        setName("mainFrame"); // NOI18N
        getContentPane().setLayout(new java.awt.BorderLayout(0, 0));

        panelOutput.setBackground(new java.awt.Color(153, 255, 255));
        panelOutput.setFont(new java.awt.Font("Times New Roman", 0, 14)); 
        panelOutput.setMaximumSize(new java.awt.Dimension(720, 600));
        panelOutput.setPreferredSize(new java.awt.Dimension(720, 600));
        panelOutput.setLayout(new java.awt.BorderLayout(5, 5));
        getContentPane().add(panelOutput, java.awt.BorderLayout.CENTER);

        panelLeft.setBackground(new java.awt.Color(102, 255, 255));
        panelLeft.setPreferredSize(new java.awt.Dimension(100, 120));
        getContentPane().add(panelLeft, java.awt.BorderLayout.WEST);

        panelRight.setBackground(new java.awt.Color(102, 255, 255));
        panelRight.setPreferredSize(new java.awt.Dimension(30, 120));
        getContentPane().add(panelRight, java.awt.BorderLayout.EAST);

        panelNorth.setBackground(new java.awt.Color(102, 255, 255));
        panelNorth.setPreferredSize(new java.awt.Dimension(720, 40));
        getContentPane().add(panelNorth, java.awt.BorderLayout.PAGE_START);

        panelSouth.setBackground(new java.awt.Color(102, 255, 255));
        panelSouth.setMaximumSize(new java.awt.Dimension(720, 300));
        panelSouth.setPreferredSize(new java.awt.Dimension(720, 60));
        getContentPane().add(panelSouth, java.awt.BorderLayout.PAGE_END);

        barMenu.setBackground(new java.awt.Color(255, 204, 255));
        barMenu.setForeground(new java.awt.Color(51, 51, 255));

        addMenu.setBackground(new java.awt.Color(153, 153, 255));
        addMenu.setText("   Ajout");

        addNiveau.setText(" Niveau");
        addNiveau.addActionListener((java.awt.event.ActionEvent evt) -> {
            addNiveauActionPerformed(evt);
        });
        addMenu.add(addNiveau);

        addClasse.setText("Classe");
        addClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            addClasseActionPerformed(evt);
        });
        addMenu.add(addClasse);

        addEleve.setText("Elève");
        addEleve.addActionListener((java.awt.event.ActionEvent evt) -> {
            addEleveActionPerformed(evt);
        });
        addMenu.add(addEleve);

        addEnseignant.setText("Enseignant");
        addEnseignant.addActionListener((java.awt.event.ActionEvent evt) -> {
            addEnseignantActionPerformed(evt);
        });
        addMenu.add(addEnseignant);

        addPeriode.setText("Période");
        addPeriode.addActionListener((java.awt.event.ActionEvent evt) -> {
            addPeriodeActionPerformed(evt);
        });
        addMenu.add(addPeriode);

        addMatiere.setText("Matière");
        addMatiere.addActionListener((java.awt.event.ActionEvent evt) -> {
            addMatiereActionPerformed(evt);
        });
        addMenu.add(addMatiere);

        addEnseignement.setText("Enseignement");
        addEnseignement.addActionListener((java.awt.event.ActionEvent evt) -> {
            addEnseignementActionPerformed(evt);
        });
        addMenu.add(addEnseignement);

        addCours.setText("Cours");
        addCours.addActionListener((java.awt.event.ActionEvent evt) -> {
            addCoursActionPerformed(evt);
        });
        addMenu.add(addCours);

        addType.setText("Type d'évaluation");
        addType.addActionListener((java.awt.event.ActionEvent evt) -> {
            addTypeActionPerformed(evt);
        });
        addMenu.add(addType);

        addEvaluation.setText("Evaluation");
        addEvaluation.addActionListener((java.awt.event.ActionEvent evt) -> {
            addEvaluationActionPerformed(evt);
        });
        addMenu.add(addEvaluation);

        addNote.setText("Note");
        addNote.addActionListener((java.awt.event.ActionEvent evt) -> {
            addNoteActionPerformed(evt);
        });
        addMenu.add(addNote);

        barMenu.add(addMenu);

        consultMenu.setText(" Consultation");

        getNiveau.setText("Niveau");
        getNiveau.addActionListener((java.awt.event.ActionEvent evt) -> {
            getNiveauActionPerformed(evt);
        });
        consultMenu.add(getNiveau);

        getClasse.setText("Classe");

        getAllClasse.setText("Liste de toutes les classes");
        getAllClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            getAllClasseActionPerformed(evt);
        });
        getClasse.add(getAllClasse);

        getClasseNiv.setText("Liste des classes par niveau");
        getClasseNiv.addActionListener((java.awt.event.ActionEvent evt) -> {
            getClasseNivActionPerformed(evt);
        });
        getClasse.add(getClasseNiv);

        consultMenu.add(getClasse);

        getEleve.setText("Eleve");

        getAllEleve.setText("Liste de tous les élèves");
        getAllEleve.addActionListener((java.awt.event.ActionEvent evt) -> {
            getAllEleveActionPerformed(evt);
        });
        getEleve.add(getAllEleve);

        getEleveClasse.setText("Liste des élèves d'une classe");
        getEleveClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            getEleveClasseActionPerformed(evt);
        });
        getEleve.add(getEleveClasse);

        consultMenu.add(getEleve);

        getEnseignant.setText("Enseignant");
        getEnseignant.addActionListener((java.awt.event.ActionEvent evt) -> {
            getEnseignantActionPerformed(evt);
        });
        consultMenu.add(getEnseignant);

        getPeriode.setText("Période");
        getPeriode.addActionListener((java.awt.event.ActionEvent evt) -> {
            getPeriodeActionPerformed(evt);
        });
        consultMenu.add(getPeriode);

        getMatiere.setText("Matière");
        getMatiere.addActionListener((java.awt.event.ActionEvent evt) -> {
            getMatiereActionPerformed(evt);
        });
        consultMenu.add(getMatiere);

        getEnseignement.setText("Enseignement");

        getAllEns.setText("Liste de tous les enseignements");
        getAllEns.addActionListener((java.awt.event.ActionEvent evt) -> {
            getAllEnsActionPerformed(evt);
        });
        getEnseignement.add(getAllEns);

        getEnsNiv.setText("Liste des enseignements d'un niveau");
        getEnsNiv.addActionListener((java.awt.event.ActionEvent evt) -> {
            getEnsNivActionPerformed(evt);
        });
        getEnseignement.add(getEnsNiv);

        consultMenu.add(getEnseignement);

        getCours.setText("Cours");

        getAllCours.setText("Liste de tous les cours");
        getAllCours.addActionListener((java.awt.event.ActionEvent evt) -> {
            getAllCoursActionPerformed(evt);
        });
        getCours.add(getAllCours);

        getCoursClasse.setText("Liste des cours d'une classe");
        getCoursClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            getCoursClasseActionPerformed(evt);
        });
        getCours.add(getCoursClasse);

        consultMenu.add(getCours);

        getType.setText("Type d'évaluation");
        getType.addActionListener((java.awt.event.ActionEvent evt) -> {
            getTypeActionPerformed(evt);
        });
        consultMenu.add(getType);

        getEvaluation.setText("Evaluation");

        getEvClasse.setText("Liste des évaluations faites dans une classe");
        getEvClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            getEvClasseActionPerformed(evt);
        });
        getEvaluation.add(getEvClasse);

        getEvCours.setText("Liste des évaluations faites dans un cours");
        getEvCours.addActionListener((java.awt.event.ActionEvent evt) -> {
            getEvCoursActionPerformed(evt);
        });
        getEvaluation.add(getEvCours);

        consultMenu.add(getEvaluation);

        getNote.setText("Note");

        getNoteClasse.setText("Liste des notes des élèves d'une classe dans un cours");
        getNoteClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            getNoteClasseActionPerformed(evt);
        });
        getNote.add(getNoteClasse);

        getNoteEv.setText("Liste des notes obtenues dans une évaluation");
        getNoteEv.addActionListener((java.awt.event.ActionEvent evt) -> {
            getNoteEvActionPerformed(evt);
        });
        getNote.add(getNoteEv);

        getNoteEleve.setText("Liste des notes d'un élève dans un cours");
        getNoteEleve.addActionListener((java.awt.event.ActionEvent evt) -> {
            getNoteEleveActionPerformed(evt);
        });
        getNote.add(getNoteEleve);

        consultMenu.add(getNote);

        barMenu.add(consultMenu);

        updateMenu.setText("  Modification ");

        updateNiveau.setText("Niveau");

        updNiveauLibelle.setText("Libellé");
        updNiveauLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            updNiveauLibelleActionPerformed(evt);
        });
        updateNiveau.add(updNiveauLibelle);

        updNiveauDescription.setText("Description");
        updNiveauDescription.addActionListener((java.awt.event.ActionEvent evt) -> {
            updNiveauDescriptionActionPerformed(evt);
        });
        updateNiveau.add(updNiveauDescription);

        updateMenu.add(updateNiveau);

        updateClasse.setText("Classe");

        updClasseSubdivision.setText("Subdivision");
        updClasseSubdivision.addActionListener((java.awt.event.ActionEvent evt) -> {
            updClasseSubdivisionActionPerformed(evt);
        });
        updateClasse.add(updClasseSubdivision);

        updateMenu.add(updateClasse);

        updateEleve.setText("Elève");

        updEleveNom.setText("Nom");
        updEleveNom.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEleveNomActionPerformed(evt);
        });
        updateEleve.add(updEleveNom);

        updElevePrenom.setText("Prénom");
        updElevePrenom.addActionListener((java.awt.event.ActionEvent evt) -> {
            updElevePrenomActionPerformed(evt);
        });
        updateEleve.add(updElevePrenom);

        updEleveSexe.setText("Sexe");
        updEleveSexe.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEleveSexeActionPerformed(evt);
        });
        updateEleve.add(updEleveSexe);

        updEleveClasse.setText("Classe");
        updEleveClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEleveClasseActionPerformed(evt);
        });
        updateEleve.add(updEleveClasse);

        updateMenu.add(updateEleve);

        updateEnseignant.setText("Enseignant");

        updEnseignantNom.setText("Nom");
        updEnseignantNom.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEnseignantNomActionPerformed(evt);
        });
        updateEnseignant.add(updEnseignantNom);

        updEnseignantPrenom.setText("Prénom");
        updEnseignantPrenom.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEnseignantPrenomActionPerformed(evt);
        });
        updateEnseignant.add(updEnseignantPrenom);

        updateMenu.add(updateEnseignant);

        jMenu1.setText("Période");

        updPeriodeLibelle.setText("Libellé");
        updPeriodeLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            updPeriodeLibelleActionPerformed(evt);
        });
        jMenu1.add(updPeriodeLibelle);

        updateMenu.add(jMenu1);

        updateMatiere.setText("Matière");

        updMatiereCode.setText("Code");
        updMatiereCode.addActionListener((java.awt.event.ActionEvent evt) -> {
            updMatiereCodeActionPerformed(evt);
        });
        updateMatiere.add(updMatiereCode);

        updMatiereLibelle.setText("Libellé");
        updMatiereLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            updMatiereLibelleActionPerformed(evt);
        });
        updateMatiere.add(updMatiereLibelle);

        updateMenu.add(updateMatiere);

        updateEnseignement.setText("Enseignement");

        updEnsCoefficient.setText("Coefficient");
        updEnsCoefficient.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEnsCoefficientActionPerformed(evt);
        });
        updateEnseignement.add(updEnsCoefficient);

        updateMenu.add(updateEnseignement);

        updateCours.setText("Cours");

        updCoursEnseignant.setText("Enseignant");
        updCoursEnseignant.addActionListener((java.awt.event.ActionEvent evt) -> {
            updCoursEnseignantActionPerformed(evt);
        });
        updateCours.add(updCoursEnseignant);

        updateMenu.add(updateCours);

        updateType.setText("Type d'évaluation");

        updTypeCode.setText("Code");
        updTypeCode.addActionListener((java.awt.event.ActionEvent evt) -> {
            updTypeCodeActionPerformed(evt);
        });
        updateType.add(updTypeCode);

        updTypeLibelle.setText("Libellé");
        updTypeLibelle.addActionListener((java.awt.event.ActionEvent evt) -> {
            updTypeLibelleActionPerformed(evt);
        });
        updateType.add(updTypeLibelle);

        updateMenu.add(updateType);

        updateEvaluation.setText("Evaluation");

        updEvBareme.setText("Barème");
        updEvBareme.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEvBaremeActionPerformed(evt);
        });
        updateEvaluation.add(updEvBareme);

        updEvPoids.setText("Poids");
        updEvPoids.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEvPoidsActionPerformed(evt);
        });
        updateEvaluation.add(updEvPoids);

        updEvDate.setText("Date");
        updEvDate.addActionListener((java.awt.event.ActionEvent evt) -> {
            updEvDateActionPerformed(evt);
        });
        updateEvaluation.add(updEvDate);

        updateMenu.add(updateEvaluation);

        updateNote.setText("Note");

        updNoteValeur.setText("Valeur attribuée");
        updNoteValeur.addActionListener((java.awt.event.ActionEvent evt) -> {
            updNoteValeurActionPerformed(evt);
        });
        updateNote.add(updNoteValeur);

        updateMenu.add(updateNote);

        barMenu.add(updateMenu);

        delMenu.setText(" Suppression ");

        delNiveau.setText("Niveau");
        delNiveau.addActionListener((java.awt.event.ActionEvent evt) -> {
            delNiveauActionPerformed(evt);
        });
        delMenu.add(delNiveau);

        delClasse.setText("Classe");
        delClasse.addActionListener((java.awt.event.ActionEvent evt) -> {
            delClasseActionPerformed(evt);
        });
        delMenu.add(delClasse);

        delEleve.setText("Eleve");
        delEleve.addActionListener((ActionEvent evt) -> {
            delEleveActionPerformed(evt);
        });
        delMenu.add(delEleve);

        delEnseignant.setText("Enseignant");
        delEnseignant.addActionListener((java.awt.event.ActionEvent evt) -> {
            delEnseignantActionPerformed(evt);
        });
        delMenu.add(delEnseignant);

        delPeriode.setText("Période");
        delPeriode.addActionListener((java.awt.event.ActionEvent evt) -> {
            delPeriodeActionPerformed(evt);
        });
        delMenu.add(delPeriode);

        delMatiere.setText("Matière");
        delMatiere.addActionListener((java.awt.event.ActionEvent evt) -> {
            delMatiereActionPerformed(evt);
        });
        delMenu.add(delMatiere);

        delEnseignement.setText("Enseignement");
        delEnseignement.addActionListener((java.awt.event.ActionEvent evt) -> {
            delEnseignementActionPerformed(evt);
        });
        delMenu.add(delEnseignement);

        delCours.setText("Cours");
        delCours.addActionListener((java.awt.event.ActionEvent evt) -> {
            delCoursActionPerformed(evt);
        });
        delMenu.add(delCours);

        delType.setText("Type d'évaluation");
        delType.addActionListener((java.awt.event.ActionEvent evt) -> {
            delTypeActionPerformed(evt);
        });
        delMenu.add(delType);

        delEv.setText("Evaluation");
        delEv.addActionListener((java.awt.event.ActionEvent evt) -> {
            delEvActionPerformed(evt);
        });
        delMenu.add(delEv);

        delNote.setText("Note");
        delNote.addActionListener((java.awt.event.ActionEvent evt) -> {
            delNoteActionPerformed(evt);
        });
        delMenu.add(delNote);

        barMenu.add(delMenu);

        bulletinMenu.setText(" Bulletin");

        bulletin.setText("Bulletin de notes d'un élève");
        bulletin.addActionListener((java.awt.event.ActionEvent evt) -> {
            bulletinActionPerformed(evt);
        });
        bulletinMenu.add(bulletin);

        showMoyenneCours.setText("Moyenne générale dans un cours ");
        showMoyenneCours.addActionListener((java.awt.event.ActionEvent evt) -> {
            showMoyenneCoursActionPerformed(evt);
        });
        bulletinMenu.add(showMoyenneCours);

        barMenu.add(bulletinMenu);

        setJMenuBar(barMenu);

        pack();
    }                       

    private void addClasseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == addClasse){
            addC.addClasse();
        }
    }                                         

    private void addPeriodeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(evt.getSource() == addPeriode){
        AddPeriodePanel addP = new AddPeriodePanel();
        showForm(addP);
        } 
    }                                          

    private void getNiveauActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == getNiveau){
            setCurrentState(GET_NIVEAU);
            consultC.controller();
        }            
    }                                         

    private void getAllClasseActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == getAllClasse){
            setCurrentState(GET_CLASSE_ALL);
            consultC.controller();
        }
    }                                            

    private void getClasseNivActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == getClasseNiv){
            setCurrentState(GET_CLASSE_NIVEAU);
            consultC.controller();
        }
    }                                            

    private void getAllEleveActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(evt.getSource() == getAllEleve){
            setCurrentState(GET_ELEVE_ALL);
            consultC.controller();
        }
    }                                           

    private void getEleveClasseActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(evt.getSource() == getEleveClasse){
            setCurrentState(GET_ELEVE_CLASSE);
            consultC.controller();
        }
    }                                              

    private void getEnseignantActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(evt.getSource() == getEnseignant){
            setCurrentState(GET_ENSEIGNANT);
            consultC.controller();
        }
    }                                             

    private void getPeriodeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(evt.getSource() == getPeriode){
            setCurrentState(GET_PERIODE);
            consultC.controller();
        }
    }                                          

    private void getMatiereActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(evt.getSource() == getMatiere){
            setCurrentState(GET_MATIERE);
            consultC.controller();
        }
    }                                          

    private void getAllEnsActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == getAllEns){
            setCurrentState(GET_ENSEIGNEMENT_ALL);
            consultC.controller();
        }
    }                                         

    private void getEnsNivActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == getEnsNiv){
            setCurrentState(GET_ENSEIGNEMENT_NIVEAU);
            consultC.controller();
        }
    }                                         

    private void getAllCoursActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(evt.getSource() == getAllCours){
            setCurrentState(GET_COURS_ALL);
            consultC.controller();
        }
    }                                           

    private void getCoursClasseActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(evt.getSource() == getCoursClasse){
            setCurrentState(GET_COURS_CLASSE);
            consultC.controller();
        }
    }                                              

    private void getTypeActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(evt.getSource() == getType){
            setCurrentState(GET_TYPE);
            consultC.controller();
        }
    }                                       

    private void getEvClasseActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(evt.getSource() == getEvClasse){
            setCurrentState(GET_EVALUATION_CLASSE);
            consultC.controller();
        }
    }                                           

    private void getEvCoursActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(evt.getSource() == getEvCours){
            setCurrentState(GET_EVALUATION_COURS);
            consultC.controller();
        }
    }                                          

    private void getNoteClasseActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(evt.getSource() == getNoteClasse){
            setCurrentState(GET_NOTE_CLASSE);
            consultC.controller();
        }
    }                                             

    private void getNoteEvActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == getNoteEv){
            setCurrentState(GET_NOTE_EVALUATION);
            consultC.controller();
        }
    }                                         

    private void getNoteEleveActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == getNoteEleve){
            currentState = GET_NOTE_ELEVE;
            consultC.controller();
        }
    }                                            

    private void addNiveauActionPerformed(java.awt.event.ActionEvent evt) {                                          
    if(evt.getSource() == addNiveau){
        AddNiveauPanel addNiv = new AddNiveauPanel();
        showForm(addNiv);
    }
    }                                         

    private void addEleveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == addEleve){
            addC.addEleve();
        }
    }                                        

    private void addEnseignantActionPerformed(java.awt.event.ActionEvent evt) {                                              
       if(evt.getSource() == addEnseignant){
        AddEnseignantPanel addE = new AddEnseignantPanel();
           showForm(addE);
       } 
    }                                             

    private void addMatiereActionPerformed(java.awt.event.ActionEvent evt) {                                           
       if(evt.getSource() == addMatiere){
           AddMatierePanel addM = new AddMatierePanel();
           showForm(addM);
       }         
    }                                          

    private void addEnseignementActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(evt.getSource() == addEnseignement){
            addC.addEnseignement();
        }       
    }                                               

    private void addCoursActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == addCours){
            addC.addCours();
        }      
    }                                        

    private void addTypeActionPerformed(java.awt.event.ActionEvent evt) {                                        
       if(evt.getSource() == addType){
           AddTypePanel addT = new AddTypePanel();
           showForm(addT);
       }        
    }                                       

    private void addEvaluationActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(evt.getSource() == addEvaluation){
            addC.addEvaluation();
        }
    }                                             

    private void addNoteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(evt.getSource() == addNote){
            addC.addNote();
        }        
    }                                       

    private void delNiveauActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == delNiveau){
            delC.delNiveau();
        }        
    }                                         

    private void delClasseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == delClasse){
            delC.delClasse();
        }
    }   
    
    private void delEleveActionPerformed(java.awt.event.ActionEvent evt){
        if(evt.getSource() == delEleve){
            delC.delEleve();
        }
    }

    private void delEnseignantActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(evt.getSource() == delEnseignant){
            delC.delEnseignant();
        }
    }                                             

    private void delPeriodeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(evt.getSource() == delPeriode){
            delC.delPeriode();
        }
    }                                          

    private void delMatiereActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(evt.getSource() == delMatiere){
            delC.delMatiere();
        }
    }                                          

    private void delEnseignementActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if(evt.getSource() == delEnseignement){
            delC.delEnseignement();
        }
    }                                               

    private void delCoursActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == delCours){
            delC.delCours();
        }
    }                                        

    private void delTypeActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(evt.getSource() == delType){
            delC.delType();
        }
    }                                       

    private void delEvActionPerformed(java.awt.event.ActionEvent evt) {                                      
        if(evt.getSource() == delEv){
            delC.delEvaluation();
        }
    }                                     

    private void delNoteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if(evt.getSource() == delNote){
            delC.delNote();
        }
    }                                       

    private void updEleveNomActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(evt.getSource() == updEleveNom){
            setCurrentState(UPD_ELEVE_NOM);
            updC.controller();
        }
    }                                           

    private void updElevePrenomActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(evt.getSource() == updElevePrenom){
            setCurrentState(UPD_ELEVE_PRENOM);
            updC.controller();
        }
    }                                              

    private void updNoteValeurActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(evt.getSource() == updNoteValeur){
            setCurrentState(UPD_NOTE_VALEUR);
            updC.controller();
        }
    }                                             

    private void updNiveauLibelleActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if(evt.getSource() == updNiveauLibelle){
            setCurrentState(UPD_NIVEAU_LIBELLE);
            updC.controller();
        }
    }                                                

    private void updNiveauDescriptionActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        if(evt.getSource() == updNiveauDescription){
            setCurrentState(UPD_NIVEAU_DESCRIPTION);
            updC.controller();
        }
    }                                                    

    private void updClasseSubdivisionActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        if(evt.getSource() == updClasseSubdivision){
            setCurrentState(UPD_CLASSE_SUBDIVISION);
            updC.controller();
        }
    }                                                    

    private void updEleveSexeActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(evt.getSource() == updEleveSexe){
            setCurrentState(UPD_ELEVE_SEXE);
            updC.controller();
        }
    }                                            

    private void updEleveClasseActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(evt.getSource() == updEleveClasse){
            setCurrentState(UPD_ELEVE_CLASSE);
            updC.controller();
        }
    }                                              

    private void updEnseignantNomActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if(evt.getSource() == updEnseignantNom){
            setCurrentState(UPD_ENSEIGNANT_NOM);
            updC.controller();
        }
    }                                                

    private void updEnseignantPrenomActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        if(evt.getSource() == updEnseignantPrenom){
            setCurrentState(UPD_ENSEIGNANT_PRENOM);
            updC.controller();
        }
    }                                                   

    private void updPeriodeLibelleActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if(evt.getSource() == updPeriodeLibelle){
            setCurrentState(UPD_PERIODE_LIBELLE);
            updC.controller();
        }
    }                                                 

    private void updMatiereCodeActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(evt.getSource() == updMatiereCode){
            setCurrentState(UPD_MATIERE_CODE);
            updC.controller();
        }
    }                                              

    private void updMatiereLibelleActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if(evt.getSource() == updMatiereLibelle){
            setCurrentState(UPD_MATIERE_LIBELLE);
            updC.controller();
        }
    }                                                 

    private void updEnsCoefficientActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if(evt.getSource() == updEnsCoefficient){
            setCurrentState(UPD_ENSEIGNEMENT_COEFFICIENT);
            updC.controller();
        }
    }                                                 

    private void updCoursEnseignantActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        if(evt.getSource() == updCoursEnseignant){
            setCurrentState(UPD_COURS_ENSEIGNANT);
            updC.controller();
        }
    }                                                  

    private void updTypeCodeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(evt.getSource() == updTypeCode){
            setCurrentState(UPD_TYPE_CODE);
            updC.controller();
        }
    }                                           

    private void updTypeLibelleActionPerformed(java.awt.event.ActionEvent evt) {                                               
        if(evt.getSource() == updTypeLibelle){
            setCurrentState(UPD_TYPE_LIBELLE);
            updC.controller();
        }
    }                                              

    private void updEvBaremeActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(evt.getSource() == updEvBareme){
            setCurrentState(UPD_EVALUATION_BAREME);
            updC.controller();
        }
    }                                           

    private void updEvPoidsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(evt.getSource() == updEvPoids){
            setCurrentState(UPD_EVALUATION_POIDS);
            updC.controller();
        }
    }                                          

    private void updEvDateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(evt.getSource() == updEvDate){
            setCurrentState(UPD_EVALUATION_DATE);
            updC.controller();
        }
    }                                         

    private void showMoyenneCoursActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if(evt.getSource() == showMoyenneCours){
            bulletinC.getMoyenneCours();
        }
    }                                                

    private void bulletinActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(evt.getSource() == bulletin){
            bulletinC.getBulletin();
        }
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //méthode run du thread
        java.awt.EventQueue.invokeLater(() -> {
            new MainViewGUI().setVisible(true);
        });
    }

    
    
    public JPanel getOutputPanel(){
        return this.panelOutput;
    }
    
    //retourne la fenêtre principale
    public static MainViewGUI getMainFrame(){
        return mainProg;
    }

    
    public int getCurrentState(){
        return currentState;
    }
    
    public void setCurrentState(int state){
        this.currentState = state;
    }
    
    public void showForm(JPanel panel){
        MainViewGUI.getMainFrame().getOutputPanel().removeAll();
        MainViewGUI.getMainFrame().repaint();
        MainViewGUI.getMainFrame().getOutputPanel().add(panel, BorderLayout.CENTER);
        MainViewGUI.getMainFrame().setVisible(true);
    }
    
    //variables du frame
    private javax.swing.JMenuItem addClasse;
    private javax.swing.JMenuItem addCours;
    private javax.swing.JMenuItem addEleve;
    private javax.swing.JMenuItem addEnseignant;
    private javax.swing.JMenuItem addEnseignement;
    private javax.swing.JMenuItem addEvaluation;
    private javax.swing.JMenuItem addMatiere;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem addNiveau;
    private javax.swing.JMenuItem addNote;
    private javax.swing.JMenuItem addPeriode;
    private javax.swing.JMenuItem addType;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JMenuItem bulletin;
    private javax.swing.JMenu bulletinMenu;
    private javax.swing.JMenu consultMenu;
    private javax.swing.JMenuItem delClasse;
    private javax.swing.JMenuItem delCours;
    private javax.swing.JMenuItem delEleve;
    private javax.swing.JMenuItem delEnseignant;
    private javax.swing.JMenuItem delEnseignement;
    private javax.swing.JMenuItem delEv;
    private javax.swing.JMenuItem delMatiere;
    private javax.swing.JMenu delMenu;
    private javax.swing.JMenuItem delNiveau;
    private javax.swing.JMenuItem delNote;
    private javax.swing.JMenuItem delPeriode;
    private javax.swing.JMenuItem delType;
    private javax.swing.JMenuItem getAllClasse;
    private javax.swing.JMenuItem getAllCours;
    private javax.swing.JMenuItem getAllEleve;
    private javax.swing.JMenuItem getAllEns;
    private javax.swing.JMenu getClasse;
    private javax.swing.JMenuItem getClasseNiv;
    private javax.swing.JMenu getCours;
    private javax.swing.JMenuItem getCoursClasse;
    private javax.swing.JMenu getEleve;
    private javax.swing.JMenuItem getEleveClasse;
    private javax.swing.JMenuItem getEnsNiv;
    private javax.swing.JMenuItem getEnseignant;
    private javax.swing.JMenu getEnseignement;
    private javax.swing.JMenuItem getEvClasse;
    private javax.swing.JMenuItem getEvCours;
    private javax.swing.JMenu getEvaluation;
    private javax.swing.JMenuItem getMatiere;
    private javax.swing.JMenuItem getNiveau;
    private javax.swing.JMenu getNote;
    private javax.swing.JMenuItem getNoteClasse;
    private javax.swing.JMenuItem getNoteEleve;
    private javax.swing.JMenuItem getNoteEv;
    private javax.swing.JMenuItem getPeriode;
    private javax.swing.JMenuItem getType;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelNorth;
    private javax.swing.JPanel panelOutput;
    private javax.swing.JPanel panelRight;
    private javax.swing.JPanel panelSouth;
    private javax.swing.JMenuItem showMoyenneCours;
    private javax.swing.JMenuItem updClasseSubdivision;
    private javax.swing.JMenuItem updCoursEnseignant;
    private javax.swing.JMenuItem updEleveClasse;
    private javax.swing.JMenuItem updEleveNom;
    private javax.swing.JMenuItem updElevePrenom;
    private javax.swing.JMenuItem updEleveSexe;
    private javax.swing.JMenuItem updEnsCoefficient;
    private javax.swing.JMenuItem updEnseignantNom;
    private javax.swing.JMenuItem updEnseignantPrenom;
    private javax.swing.JMenuItem updEvBareme;
    private javax.swing.JMenuItem updEvDate;
    private javax.swing.JMenuItem updEvPoids;
    private javax.swing.JMenuItem updMatiereCode;
    private javax.swing.JMenuItem updMatiereLibelle;
    private javax.swing.JMenuItem updNiveauDescription;
    private javax.swing.JMenuItem updNiveauLibelle;
    private javax.swing.JMenuItem updNoteValeur;
    private javax.swing.JMenuItem updPeriodeLibelle;
    private javax.swing.JMenuItem updTypeCode;
    private javax.swing.JMenuItem updTypeLibelle;
    private javax.swing.JMenu updateClasse;
    private javax.swing.JMenu updateCours;
    private javax.swing.JMenu updateEleve;
    private javax.swing.JMenu updateEnseignant;
    private javax.swing.JMenu updateEnseignement;
    private javax.swing.JMenu updateEvaluation;
    private javax.swing.JMenu updateMatiere;
    private javax.swing.JMenu updateMenu;
    private javax.swing.JMenu updateNiveau;
    private javax.swing.JMenu updateNote;
    private javax.swing.JMenu updateType;
    
}
