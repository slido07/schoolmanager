package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Eleve.class)
public abstract class Eleve_ extends gestionEcole.model.entity.Personne_ {

	public static volatile SingularAttribute<Eleve, Classe> classe;
	public static volatile SingularAttribute<Eleve, Character> sexe;

	public static final String CLASSE = "classe";
	public static final String SEXE = "sexe";

}

