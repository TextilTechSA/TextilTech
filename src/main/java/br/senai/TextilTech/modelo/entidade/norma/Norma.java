package br.senai.TextilTech.modelo.entidade.norma;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "norma")
public abstract class Norma implements Serializable {

	private static final long serialVersionUID = -7244330435651934315L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "desc_maquina", length = 65, nullable = false)
	private String tipo;

	private String descricao;

	private LocalDate dataAberturaNorma;

	private LocalDate dataEdicaoNorma;

	private LocalDate dataRevisaoNorma;

	private String homologacao;

	public Norma(Long id, String tipo, String descricao, LocalDate dataAberturaNorma, LocalDate dataEdicaoNorma,
			LocalDate dataRevisaoNorma, String homologacao) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataAberturaNorma = dataAberturaNorma;
		this.dataEdicaoNorma = dataEdicaoNorma;
		this.dataRevisaoNorma = dataRevisaoNorma;
		this.homologacao = homologacao;
	}

	public Norma(String tipo, String descricao, LocalDate dataAberturaNorma, LocalDate dataEdicaoNorma,
			LocalDate dataRevisaoNorma, String homologacao) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataAberturaNorma = dataAberturaNorma;
		this.dataEdicaoNorma = dataEdicaoNorma;
		this.dataRevisaoNorma = dataRevisaoNorma;
		this.homologacao = homologacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataAberturaNorma() {
		return dataAberturaNorma;
	}

	public void setDataAberturaNorma(LocalDate dataAberturaNorma) {
		this.dataAberturaNorma = dataAberturaNorma;
	}

	public LocalDate getDataEdicaoNorma() {
		return dataEdicaoNorma;
	}

	public void setDataEdicaoNorma(LocalDate dataEdicaoNorma) {
		this.dataEdicaoNorma = dataEdicaoNorma;
	}

	public LocalDate getDataRevisaoNorma() {
		return dataRevisaoNorma;
	}

	public void setDataRevisaoNorma(LocalDate dataRevisaoNorma) {
		this.dataRevisaoNorma = dataRevisaoNorma;
	}

	public String getHomologacao() {
		return homologacao;
	}

	public void setHomologacao(String homologacao) {
		this.homologacao = homologacao;
	}

}