package gestionEcole.jpa.util;

import gestionEcole.model.entity.TypeEvaluation;
import gestionEcole.model.entity.Classe;
import gestionEcole.model.entity.Cours;
import gestionEcole.model.entity.Matiere;
import gestionEcole.model.entity.Note;
import gestionEcole.model.entity.Enseignant;
import gestionEcole.model.entity.Niveau;
import gestionEcole.model.entity.Eleve;
import gestionEcole.model.entity.Evaluation;
import gestionEcole.model.entity.Enseignement;
import gestionEcole.model.entity.Periode;
import java.util.Arrays;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djim
 */
class AnnotatedClassCollection {
    
    public static List<Class<?>> getAnnotatedClasses() {
        Class<?>[] classes = new Class<?>[]{
            Niveau.class,
            Classe.class,
            Eleve.class,
            Enseignant.class,
            Enseignement.class,
            Cours.class,
            Evaluation.class,
            Matiere.class,
            Note.class,
            Periode.class,
            TypeEvaluation.class           
        };

        return Arrays.asList(classes);
    }

    private AnnotatedClassCollection() {
        throw new AssertionError("No need to instanciate this class ...");
    }
}
