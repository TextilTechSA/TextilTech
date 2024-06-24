package br.senai.TextilTech.modelo.entidade.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.senai.TextilTech.modelo.entidade.maquina.Maquina;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 580102791024779122L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_usuario", length = 25, nullable = false)
	private String nome;

	@Column(name = "senha_usuario", length = 25, nullable = false)
	private String senha;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuario_has_maquina", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_maquina"))
	List<Maquina> maquinas;
	
	public Usuario() {}
	
	public Usuario(String nome, String email, String senha) {
		setNome(nome);
		setSenha(senha);
		maquinas = new ArrayList<>();
	}

	public Usuario(String nome, String senha) {
		setNome(nome);
		setSenha(senha);
		maquinas = new ArrayList<>();
	}
	
	public Usuario(long id, String nome, String senha) {
		setNome(nome);
		setSenha(senha);
		maquinas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Maquina> getMaquinas() {
		return maquinas;
	}
	
	public boolean inserirMaquina(Maquina maquina) {
		return maquinas.add(maquina);
	}
	
	public boolean removerMaquina(Maquina maquina) {
		return maquinas.remove(maquina);
	}

}
