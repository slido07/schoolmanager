package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Niveau.class)
public abstract class Niveau_ {

	public static volatile SingularAttribute<Niveau, String> libelle;
	public static volatile SingularAttribute<Niveau, String> description;
	public static volatile SingularAttribute<Niveau, Long> id;

	public static final String LIBELLE = "libelle";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

