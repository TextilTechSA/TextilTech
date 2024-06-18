package br.senac.eco2you.modelo.entidade.usuario;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.senac.eco2you.modelo.entidade.endereco.Endereco;

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

	@Column(name = "email_usuario", length = 65, nullable = false)
	private String email;

	@Column(name = "senha_usuario", length = 25, nullable = false)
	private String senha;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;
	
	public Usuario() {}
	
	public Usuario(String nome, String email, String senha) {
		setNome(nome);
		setEmail(email);
		setSenha(senha);
	}

	public Usuario(String nome, Endereco endereco, String email, String senha) {
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setEndereco(endereco);
	}
	
	public Usuario(long id, String nome, Endereco endereco, String email, String senha) {
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setEndereco(endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
