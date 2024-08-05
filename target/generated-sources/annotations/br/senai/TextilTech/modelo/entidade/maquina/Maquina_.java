package br.senai.TextilTech.modelo.entidade.maquina;

import br.senai.TextilTech.modelo.entidade.norma.Norma;
import java.time.LocalTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Maquina.class)
public abstract class Maquina_ {

	public static volatile SingularAttribute<Maquina, String> tipo;
	public static volatile SingularAttribute<Maquina, String> funcionamento;
	public static volatile SingularAttribute<Maquina, LocalTime> horarioFechamentoOperacao;
	public static volatile ListAttribute<Maquina, Norma> normas;
	public static volatile SingularAttribute<Maquina, String> nivelPerigo;
	public static volatile SingularAttribute<Maquina, String> nome;
	public static volatile SingularAttribute<Maquina, Long> id;
	public static volatile SingularAttribute<Maquina, String> capacidadeOperacao;
	public static volatile SingularAttribute<Maquina, String> descricao;
	public static volatile SingularAttribute<Maquina, LocalTime> horarioInicioOperacao;

	public static final String TIPO = "tipo";
	public static final String FUNCIONAMENTO = "funcionamento";
	public static final String HORARIO_FECHAMENTO_OPERACAO = "horarioFechamentoOperacao";
	public static final String NORMAS = "normas";
	public static final String NIVEL_PERIGO = "nivelPerigo";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String CAPACIDADE_OPERACAO = "capacidadeOperacao";
	public static final String DESCRICAO = "descricao";
	public static final String HORARIO_INICIO_OPERACAO = "horarioInicioOperacao";

}

