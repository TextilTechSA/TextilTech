package br.senai.TextilTech.modelo.entidade.usuario.funcionario;

import br.senai.TextilTech.modelo.entidade.maquina.Maquina;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ extends br.senai.TextilTech.modelo.entidade.usuario.Usuario_ {

	public static volatile SingularAttribute<Funcionario, Double> salario;
	public static volatile SingularAttribute<Funcionario, String> departamento;
	public static volatile SingularAttribute<Funcionario, String> horarioFuncionamento;
	public static volatile SingularAttribute<Funcionario, String> cargo;
	public static volatile ListAttribute<Funcionario, Maquina> maquinas;

	public static final String SALARIO = "salario";
	public static final String DEPARTAMENTO = "departamento";
	public static final String HORARIO_FUNCIONAMENTO = "horarioFuncionamento";
	public static final String CARGO = "cargo";
	public static final String MAQUINAS = "maquinas";

}

