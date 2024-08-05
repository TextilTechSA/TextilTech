package br.senai.TextilTech.modelo.entidade.norma;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Norma.class)
public abstract class Norma_ {

	public static volatile SingularAttribute<Norma, String> homologacao;
	public static volatile SingularAttribute<Norma, String> tipo;
	public static volatile SingularAttribute<Norma, LocalDate> dataEdicao;
	public static volatile SingularAttribute<Norma, LocalDate> dataRevisao;
	public static volatile SingularAttribute<Norma, String> nome;
	public static volatile SingularAttribute<Norma, Long> id;
	public static volatile SingularAttribute<Norma, String> descricao;
	public static volatile SingularAttribute<Norma, LocalDate> dataAbertura;

	public static final String HOMOLOGACAO = "homologacao";
	public static final String TIPO = "tipo";
	public static final String DATA_EDICAO = "dataEdicao";
	public static final String DATA_REVISAO = "dataRevisao";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String DESCRICAO = "descricao";
	public static final String DATA_ABERTURA = "dataAbertura";

}

