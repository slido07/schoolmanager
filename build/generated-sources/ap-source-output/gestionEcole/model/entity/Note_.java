package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Note.class)
public abstract class Note_ {

	public static volatile SingularAttribute<Note, Evaluation> evaluation;
	public static volatile SingularAttribute<Note, Double> valeur;
	public static volatile SingularAttribute<Note, Long> id;
	public static volatile SingularAttribute<Note, Eleve> eleve;

	public static final String EVALUATION = "evaluation";
	public static final String VALEUR = "valeur";
	public static final String ID = "id";
	public static final String ELEVE = "eleve";

}

