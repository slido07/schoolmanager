package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Classe.class)
public abstract class Classe_ {

	public static volatile SingularAttribute<Classe, String> subdivision;
	public static volatile SingularAttribute<Classe, Long> id;
	public static volatile SingularAttribute<Classe, Niveau> niveau;

	public static final String SUBDIVISION = "subdivision";
	public static final String ID = "id";
	public static final String NIVEAU = "niveau";

}

