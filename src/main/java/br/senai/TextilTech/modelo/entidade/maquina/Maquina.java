package br.senai.TextilTech.modelo.entidade.maquina;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Maquina implements Serializable {

	private static final long serialVersionUID = 6253238070568300304L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_maquina")
	private Long id;

	@Column(name = "nome_maquina", length = 65, nullable = false)
	private String nome;

	@Column(name = "tipo_maquina", length = 65, nullable = false)
	private String tipo;

	@Column(name = "desc_maquina", length = 65, nullable = false)
	private String descricao;

	@Column(name = "horario_inicio_operacao", length = 65, nullable = true)
	private LocalDateTime horarioInicioOperacao;

	@Column(name = "horario_fechamento_operacao", length = 65, nullable = true)
	private LocalDateTime horarioFechamentoOperacao;

	@Column(name = "capacidade_operacao", length = 65, nullable = true)
	private String capacidadeOperacao;
	
	@Column(name = "nivel_perigo", length = 65, nullable = true)
	private String nivelPerigo;

	public Maquina(Long id, String nome, String tipo, String descricao, LocalDateTime horarioInicioOperacao,
			LocalDateTime horarioFechamentoOperacao, String capacidadeOperacao, String nivelPericulosidade) {
	
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.horarioInicioOperacao = horarioInicioOperacao;
		this.horarioFechamentoOperacao = horarioFechamentoOperacao;
		this.capacidadeOperacao = capacidadeOperacao;
		this.nivelPerigo = nivelPericulosidade;
	}

	public Maquina(String nome, String tipo, String descricao, String capacidadeOperacao, String nivelPericulosidade) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.capacidadeOperacao = capacidadeOperacao;
		this.nivelPerigo = nivelPericulosidade;
	}

	public LocalDateTime getHorarioInicioOperacao() {
		return horarioInicioOperacao;
	}

	public void setHorarioInicioOperacao(LocalDateTime horarioInicioOperacao) {
		this.horarioInicioOperacao = horarioInicioOperacao;
	}

	public LocalDateTime getHorarioFechamentoOperacao() {
		return horarioFechamentoOperacao;
	}

	public void setHorarioFechamentoOperacao(LocalDateTime horarioFechamentoOperacao) {
		this.horarioFechamentoOperacao = horarioFechamentoOperacao;
	}

	public String getCapacidadeOperacao() {
		return capacidadeOperacao;
	}

	public void setCapacidadeOperacao(String capacidadeOperacao) {
		this.capacidadeOperacao = capacidadeOperacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNivelPericulosidade() {
		return nivelPerigo;
	}

	public void setNivelPericulosidade(String nivelPericulosidade) {
		this.nivelPerigo = nivelPericulosidade;
	}

}
