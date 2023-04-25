package gestionEcole.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cours.class)
public abstract class Cours_ {

	public static volatile SingularAttribute<Cours, Classe> classe;
	public static volatile SingularAttribute<Cours, Enseignement> enseignement;
	public static volatile SingularAttribute<Cours, Long> id;
	public static volatile SingularAttribute<Cours, Enseignant> enseignant;

	public static final String CLASSE = "classe";
	public static final String ENSEIGNEMENT = "enseignement";
	public static final String ID = "id";
	public static final String ENSEIGNANT = "enseignant";

}

