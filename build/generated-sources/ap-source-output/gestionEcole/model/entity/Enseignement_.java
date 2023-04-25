package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Enseignement.class)
public abstract class Enseignement_ {

	public static volatile SingularAttribute<Enseignement, Integer> coefficient;
	public static volatile SingularAttribute<Enseignement, Long> id;
	public static volatile SingularAttribute<Enseignement, Niveau> niveau;
	public static volatile SingularAttribute<Enseignement, Matiere> matiere;

	public static final String COEFFICIENT = "coefficient";
	public static final String ID = "id";
	public static final String NIVEAU = "niveau";
	public static final String MATIERE = "matiere";

}

