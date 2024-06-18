package br.senac.eco2you.modelo.entidade.usuario.empresa.armazem;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.deposito.Deposito;
import br.senac.eco2you.modelo.entidade.endereco.Endereco;
import br.senac.eco2you.modelo.entidade.retirada.Retirada;
import br.senac.eco2you.modelo.entidade.usuario.empresa.Empresa;
import br.senac.eco2you.modelo.enumeracao.status.armazem.StatusArmazem;

@Entity
@Table(name = "armazem")
public class Armazem extends Empresa implements Serializable {
	
	private static final long serialVersionUID = -8488573033851194367L;

	@Column(name = "capacidade_armazenagem_armazem", nullable = false)
	private float capacidadeArmazenagem;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_armazem", nullable = true)
	private StatusArmazem statusArmazem;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "armazem_deposito", joinColumns = @JoinColumn(name = "id_armazem"), inverseJoinColumns = @JoinColumn(name = "id_deposito"))
	private List<Deposito> depositos;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "armazem", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Retirada> retiradas;
	
	public Armazem () {}
	
	public Armazem(String nome, String cnpj, String email, String senha) {
		super(nome, email, cnpj, senha);
		setStatusArmazem(statusArmazem);
		depositos = new ArrayList<>();
		retiradas = new ArrayList<>();
	}
	
	public Armazem(String nome, String cnpj, String email, String senha, float capacidadeArmazenagem, LocalTime horarioAbertura, LocalTime horarioFechamento, Endereco endereco) {
		super(nome, cnpj, horarioFechamento, horarioAbertura, endereco, email, senha);
		setCapacidadeArmazenagem(capacidadeArmazenagem);
		depositos = new ArrayList<>();
		retiradas = new ArrayList<>();
	}
	
	public Armazem(long id, String nome, String cnpj, String email, String senha, float capacidadeArmazenagem, LocalTime horarioAbertura, LocalTime horarioFechamento, Endereco endereco) {
		super(id, nome, cnpj, horarioFechamento, horarioAbertura, endereco, email, senha);
		setCapacidadeArmazenagem(capacidadeArmazenagem);
		depositos = new ArrayList<>();
		retiradas = new ArrayList<>();
	}
	
	public Armazem(String nome, String email, String senha, String descricao, Endereco endereco, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, float capacidadeArmazem, StatusArmazem statusArmazem) {
		super(nome, cnpj, horarioFechamento, horarioAbertura, endereco, descricao, email, senha);
		setCapacidadeArmazenagem(capacidadeArmazem);
		setStatusArmazem(statusArmazem);
		depositos = new ArrayList<>();
		retiradas = new ArrayList<>();
	}
	
	public Armazem(String nome, String email, String senha, String descricao, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, float capacidadeArmazem) {
		super(nome, cnpj, horarioFechamento, horarioAbertura, descricao, email, senha);
		setCapacidadeArmazenagem(capacidadeArmazem);
		depositos = new ArrayList<>();
		retiradas = new ArrayList<>();
	}
	
	public float getCapacidadeArmazenagem() {
		return capacidadeArmazenagem;
	}

	public void setCapacidadeArmazenagem(float capacidadeArmazenagem) {
		this.capacidadeArmazenagem = capacidadeArmazenagem;
	}

	public StatusArmazem getStatusArmazem() {
		return statusArmazem;
	}

	public void setStatusArmazem(StatusArmazem statusArmazem) {
		this.statusArmazem = statusArmazem;
	}

	public List<Deposito> getListaDepositos() {
		return depositos;
	}

	public boolean inserirDeposito(Deposito deposito) {
		return depositos.add(deposito);

	}

	public boolean removerDeposito(Deposito deposito) {
		return depositos.remove(deposito);

	}
	
	public List<Retirada> getListaRetiradas() {
		return retiradas;
	}

	public boolean inserirRetirada(Retirada retirada) {
		return retiradas.add(retirada);

	}

	public boolean removerRetirada(Retirada retirada) {
		return retiradas.remove(retirada);

	}

}
