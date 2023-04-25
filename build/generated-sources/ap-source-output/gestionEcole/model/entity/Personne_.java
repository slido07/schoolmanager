package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Personne.class)
public abstract class Personne_ {

	public static volatile SingularAttribute<Personne, Long> id;
	public static volatile SingularAttribute<Personne, String> nom;
	public static volatile SingularAttribute<Personne, String> prenom;

	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";

}

