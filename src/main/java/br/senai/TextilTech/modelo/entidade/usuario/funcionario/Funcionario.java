package br.senai.TextilTech.modelo.entidade.usuario.funcionario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import br.senai.TextilTech.modelo.entidade.usuario.Usuario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "funcionario")
public abstract class Funcionario extends Usuario implements Serializable {

	private static final long serialVersionUID = 4793117183161147338L;

	@Column(name = "cargo_funcionario", length = 65, nullable = false)
	private String cargo;
	
	@Column(name = "departamento_funcionario", length = 65, nullable = false)
	private String departamento;
	
	@Column(name = "salario_funcionario", length = 65, nullable = false)
	private Double salario;
	
	@Column(name = "horario_funcionamento_funcionario", length = 65, nullable = false)
	private String horarioFuncionamento;
	
	public Funcionario() {}

	public Funcionario(String cargo, String departamento, Double salario, String horarioFuncionamento) {
		super();
		this.cargo = cargo;
		this.departamento = departamento;
		this.salario = salario;
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
}
