package br.senac.eco2you.modelo.entidade.conquista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor;

@Entity
@Table(name = "conquista")
public class Conquista implements Serializable {

	private static final long serialVersionUID = -2658698851963417185L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conquista")
	private Long id;
	
	@Column(name = "nome_conquista", nullable = false)
	private String nome;
	
	@Column(name = "pontos_conquista", nullable = false)
	private int pontosConquista;
	
	@Column(name = "descricao_conquista", nullable = false)
	private String descricao;
		
	@ManyToMany(mappedBy = "conquistas") private List<Coletor> coletores = new
	ArrayList<Coletor>();
	 
	public Conquista() {
	}
	
	public Conquista(String nome, int pontosConquista, String descricao) {
		setPontosConquista(pontosConquista);
		setDescricao(descricao);
		setNome(nome);
		
	}
	
	public Conquista(String descricao, String nome) {
		setDescricao(descricao);
		setNome(nome);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getPontosConquista() {
		return pontosConquista;
	}
	
	public void setPontosConquista(int pontosConquista) {
		this.pontosConquista = pontosConquista;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


  public List<Coletor> getListaColetores() { return coletores; }
  
  public void inserirColetor(Coletor coletor) { this.coletores.add(coletor); }
  
  public void removerColetor(Coletor coletor) { this.coletores.remove(coletor);
	  }
	 
}
