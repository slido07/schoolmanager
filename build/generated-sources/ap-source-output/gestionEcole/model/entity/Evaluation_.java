package gestionEcole.model.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evaluation.class)
public abstract class Evaluation_ {

	public static volatile SingularAttribute<Evaluation, LocalDate> date;
	public static volatile SingularAttribute<Evaluation, Double> poids;
	public static volatile SingularAttribute<Evaluation, Long> id;
	public static volatile SingularAttribute<Evaluation, TypeEvaluation> type;
	public static volatile SingularAttribute<Evaluation, Cours> cours;
	public static volatile SingularAttribute<Evaluation, Integer> bareme;
	public static volatile SingularAttribute<Evaluation, Periode> periode;

	public static final String DATE = "date";
	public static final String POIDS = "poids";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String COURS = "cours";
	public static final String BAREME = "bareme";
	public static final String PERIODE = "periode";

}

