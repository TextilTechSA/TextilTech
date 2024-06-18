package br.senac.eco2you.modelo.entidade.usuario.empresa;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.endereco.Endereco;
import br.senac.eco2you.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "empresa")
public abstract class Empresa extends Usuario implements Serializable {
	
	private static final long serialVersionUID = -8515242038787027028L;

	@Column(name = "cnpj_empresa", length = 18, nullable = false)
	private String cnpj;
	
	@Column(name = "horario_abertura_empresa", length = 50, nullable = false)
	private LocalTime horarioAbertura;
	
	@Column(name = "horario_fechamento_empresa", length = 50, nullable = false)
	private LocalTime horarioFechamento;
	
	@Column(name = "descricao_empresa", length = 250, nullable = true)
	private String descricao;
	
	public Empresa() {}
	
	public Empresa(String nome, String cnpj, String email, String senha) {
		super(nome, email, senha);
		setCnpj(cnpj);
	}
	
	public Empresa(String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, String email, String senha) {
		super(nome, email, senha);
		setCnpj(cnpj);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
	}
	
	public Empresa(String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, Endereco endereco, String email, String senha) {
		super(nome, endereco, email, senha);
		setCnpj(cnpj);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
	}
	
	public Empresa(long id, String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, Endereco endereco, String descricao, String email, String senha) {
		super(nome, endereco, email, senha);
		setCnpj(cnpj);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
		setDescricao(descricao);
	}
	
	public Empresa(String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, Endereco endereco, String descricao, String email, String senha) {
		super(nome, endereco, email, senha);
		setCnpj(cnpj);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
		setDescricao(descricao);
	}
	
	public Empresa(long id, String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, Endereco endereco, String email, String senha) {
		super(nome, endereco, email, senha);
		setCnpj(cnpj);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
	}
	
	public Empresa(String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, String descricao, String email, String senha) {
		super(nome, email, senha);
		setCnpj(cnpj);
		setHorarioAbertura(horarioAbertura);
		setHorarioFechamento(horarioFechamento);
		setDescricao(descricao);
	}

	public String getCnpj() {
		return cnpj;
	}
 
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
 
	public LocalTime getHorarioAbertura() {
		return horarioAbertura;
	}
	
	public void setHorarioAbertura(LocalTime horarioAbertura) {
		this.horarioAbertura = horarioAbertura;
	}
	
	public LocalTime getHorarioFechamento() {
		return horarioFechamento;
	}
	
	public void setHorarioFechamento(LocalTime horarioFechamento) {
		this.horarioFechamento = horarioFechamento;
	}
	
	public String getDescricao() {
			return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
