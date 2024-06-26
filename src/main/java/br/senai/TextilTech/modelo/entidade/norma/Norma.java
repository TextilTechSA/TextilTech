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
public class Norma implements Serializable {

	private static final long serialVersionUID = -7244330435651934315L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "tipo_norma", length = 65, nullable = false)
	private String tipo;
	
	@Column(name = "desc_norma", length = 65, nullable = false)
	private String descricao;

	@Column(name = "data_abertura_norma", nullable = false)
	private LocalDate dataAberturaNorma;

	@Column(name = "data_edicao_norma", nullable = false)
	private LocalDate dataEdicaoNorma;

	@Column(name = "data_revisao_norma", nullable = false)
	private LocalDate dataRevisaoNorma;

	@Column(name = "homologacao_norma", length = 65, nullable = false)
	private String homologacao;

	public Norma(Long id, String tipo, String descricao, LocalDate dataAberturaNorma, LocalDate dataEdicaoNorma,
			LocalDate dataRevisaoNorma, String homologacao) {

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