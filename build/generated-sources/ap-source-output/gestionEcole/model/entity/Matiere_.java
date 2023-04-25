package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Matiere.class)
public abstract class Matiere_ {

	public static volatile SingularAttribute<Matiere, String> code;
	public static volatile SingularAttribute<Matiere, String> libelle;
	public static volatile SingularAttribute<Matiere, Long> id;

	public static final String CODE = "code";
	public static final String LIBELLE = "libelle";
	public static final String ID = "id";

}

