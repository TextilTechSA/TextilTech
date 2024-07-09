package br.senai.TextilTech.modelo.entidade.maquina;

import java.io.Serializable;
import java.time.LocalTime;
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

import br.senai.TextilTech.modelo.entidade.norma.Norma;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "maquina")
public class Maquina implements Serializable {

	private static final long serialVersionUID = 9067404675648538358L;

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
	
	@Column(name = "funcionamento_maquina", length = 65, nullable = false)
	private String funcionamento;

	@Column(name = "horario_inicio_operacao", length = 65, nullable = true)
	private LocalTime horarioInicioOperacao;

	@Column(name = "horario_fechamento_operacao", length = 65, nullable = true)
	private LocalTime horarioFechamentoOperacao;

	@Column(name = "capacidade_operacao", length = 65, nullable = true)
	private String capacidadeOperacao;
	
	@Column(name = "nivel_perigo", length = 65, nullable = true)
	private String nivelPerigo;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "maquina_has_norma", joinColumns = @JoinColumn(name = "id_maquina"), inverseJoinColumns = @JoinColumn(name = "id_norma"))
	List<Norma> normas;
	
	public Maquina() {}

	public Maquina(Long id, String nome, String tipo, String descricao, String funcionamento, LocalTime horarioInicioOperacao,
			LocalTime horarioFechamentoOperacao, String capacidadeOperacao, String nivelPericulosidade) {
	
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.funcionamento = funcionamento;
		this.horarioInicioOperacao = horarioInicioOperacao;
		this.horarioFechamentoOperacao = horarioFechamentoOperacao;
		this.capacidadeOperacao = capacidadeOperacao;
		this.nivelPerigo = nivelPericulosidade;
		normas = new ArrayList<Norma>();
	}

	public Maquina(String nome, String tipo, String descricao, String funcionamento, LocalTime horarioInicioOperacao,  LocalTime horarioFechamentoOperacao, String capacidadeOperacao, String nivelPericulosidade) {
		
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.funcionamento = funcionamento;
		this.horarioInicioOperacao = horarioInicioOperacao;
		this.horarioFechamentoOperacao = horarioFechamentoOperacao;
		this.capacidadeOperacao = capacidadeOperacao;
		this.nivelPerigo = nivelPericulosidade;
		normas = new ArrayList<Norma>();
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

	public String getFuncionamento() {
		return funcionamento;
	}

	public void setFuncionamento(String funcionamento) {
		this.funcionamento = funcionamento;
	}

	public LocalTime getHorarioInicioOperacao() {
		return horarioInicioOperacao;
	}

	public void setHorarioInicioOperacao(LocalTime horarioInicioOperacao) {
		this.horarioInicioOperacao = horarioInicioOperacao;
	}

	public LocalTime getHorarioFechamentoOperacao() {
		return horarioFechamentoOperacao;
	}

	public void setHorarioFechamentoOperacao(LocalTime horarioFechamentoOperacao) {
		this.horarioFechamentoOperacao = horarioFechamentoOperacao;
	}

	public String getCapacidadeOperacao() {
		return capacidadeOperacao;
	}

	public void setCapacidadeOperacao(String capacidadeOperacao) {
		this.capacidadeOperacao = capacidadeOperacao;
	}

	public String getNivelPerigo() {
		return nivelPerigo;
	}

	public void setNivelPerigo(String nivelPerigo) {
		this.nivelPerigo = nivelPerigo;
	}

	public void setNormas(List<Norma> normas) {
		this.normas = normas;
	}

	public List<Norma> getNormas() {
		return normas;
	}
	
	public void inserirNorma(Norma norma) {
        if (normas == null) {
            normas = new ArrayList<>();
        }
        normas.add(norma);
    }
	
	public boolean removerNorma(Norma norma) {
		return normas.remove(norma);
	}

}
