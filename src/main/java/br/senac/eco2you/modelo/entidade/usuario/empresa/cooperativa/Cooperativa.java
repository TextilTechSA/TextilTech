package br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.endereco.Endereco;
import br.senac.eco2you.modelo.entidade.retirada.Retirada;
import br.senac.eco2you.modelo.entidade.usuario.empresa.Empresa;

@Entity
@Table(name = "cooperativa")
public class Cooperativa extends Empresa implements Serializable {

	private static final long serialVersionUID = 465965115724800581L;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "cooperativa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Retirada> retiradas;
	
	public Cooperativa () {}
	
	public Cooperativa(String nome, String cnpj, String email, String senha) {
		super(nome, cnpj, email, senha);
		retiradas = new ArrayList<>();
	}
	
	public Cooperativa(String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, Endereco endereco, String email, String senha) {
		super(nome, cnpj, horarioAbertura, horarioFechamento, endereco,  email, senha);
		retiradas = new ArrayList<>();
	}
	
	public Cooperativa(long id, String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, Endereco endereco, String email, String senha) {
		super(id, nome, cnpj, horarioFechamento, horarioAbertura, endereco,  email, senha);
		retiradas = new ArrayList<>();
	}
	
	public Cooperativa(String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, Endereco endereco, String descricao, String email, String senha) {
		super(nome, cnpj, horarioFechamento, horarioAbertura, endereco, descricao, email, senha);
		retiradas = new ArrayList<>();
	}
	
	public Cooperativa(String nome, String cnpj, LocalTime horarioFechamento, LocalTime horarioAbertura, String descricao, String email, String senha) {
		super(nome, cnpj, horarioAbertura, horarioFechamento, descricao, email, senha);
		retiradas = new ArrayList<>();
	}

	public List<Retirada> getListaRetiradas() {
		return retiradas;
	}

	public void inserirRetirada(Retirada retirada) {
		this.retiradas.add(retirada);

	}

	public void removerRetirada(Retirada retirada) {
		this.retiradas.remove(retirada);

	}

}
