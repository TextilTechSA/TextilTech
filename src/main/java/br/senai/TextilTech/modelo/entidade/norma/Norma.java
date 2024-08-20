package br.senai.TextilTech.modelo.entidade.norma;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
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
	
	@Column(name = "nome_norma", length = 65, nullable = false)
	private String nome;

	@Column(name = "tipo_norma", length = 65, nullable = false)
	private String tipo;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name = "desc_norma", nullable = false)
	private String descricao;

	@Column(name = "data_abertura_norma", nullable = false)
	private LocalDate dataAbertura;

	@Column(name = "data_edicao_norma", nullable = true)
	private LocalDate dataEdicao;

	@Column(name = "data_revisao_norma", nullable = true)
	private LocalDate dataRevisao;

	@Column(name = "homologacao_norma", length = 65, nullable = false)
	private String homologacao;
	
	public Norma() {}

	public Norma(Long id, String nome, String tipo, String descricao, LocalDate dataAberturaNorma, LocalDate dataEdicaoNorma,
			LocalDate dataRevisaoNorma, String homologacao) {

		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataAbertura = dataAberturaNorma;
		this.dataEdicao = dataEdicaoNorma;
		this.dataRevisao = dataRevisaoNorma;
		this.homologacao = homologacao;
	}

	public Norma(String nome, String tipo, String descricao, LocalDate dataAberturaNorma, LocalDate dataEdicaoNorma,
			LocalDate dataRevisaoNorma, String homologacao) {

		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataAbertura = dataAberturaNorma;
		this.dataEdicao = dataEdicaoNorma;
		this.dataRevisao = dataRevisaoNorma;
		this.homologacao = homologacao;
	}
	
	public Norma(String nome, String tipo, String descricao, LocalDate dataAberturaNorma, String homologacao) {

		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.dataAbertura = dataAberturaNorma;
		this.homologacao = homologacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return dataAbertura;
	}

	public void setDataAberturaNorma(LocalDate dataAberturaNorma) {
		this.dataAbertura = dataAberturaNorma;
	}

	public LocalDate getDataEdicaoNorma() {
		return dataEdicao;
	}

	public void setDataEdicaoNorma(LocalDate dataEdicaoNorma) {
		this.dataEdicao = dataEdicaoNorma;
	}

	public LocalDate getDataRevisaoNorma() {
		return dataRevisao;
	}

	public void setDataRevisaoNorma(LocalDate dataRevisaoNorma) {
		this.dataRevisao = dataRevisaoNorma;
	}

	public String getHomologacao() {
		return homologacao;
	}

	public void setHomologacao(String homologacao) {
		this.homologacao = homologacao;
	}

}