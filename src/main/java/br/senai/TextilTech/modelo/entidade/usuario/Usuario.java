package br.senai.TextilTech.modelo.entidade.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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
	
	public Usuario() {}

	public Usuario(String nome, String senha) {
		setNome(nome);
		setSenha(senha);
	}
	
	public Usuario(long id, String nome, String senha) {
		setNome(nome);
		setSenha(senha);
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

}
