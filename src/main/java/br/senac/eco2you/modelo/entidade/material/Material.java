package br.senac.eco2you.modelo.entidade.material;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class Material implements Serializable {

	private static final long serialVersionUID = 1923621854497536546L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_material")
	private Long id;

	@Column(name = "nome_material", length = 25, nullable = false)
	private String nome;
	
	public Material(long id, String nome) {
		setId(id);
		setNome(nome);
	}

	public Material(String nome) {
		setNome(nome);
	}

	public Material() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
