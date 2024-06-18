package br.senac.eco2you.modelo.entidade.deposito;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.item.deposito.ItemDeposito;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor;
import br.senac.eco2you.modelo.enumeracao.status.deposito.StatusDeposito;

@Entity
@Table(name = "deposito")
public class Deposito implements Serializable{
	
	private static final long serialVersionUID = -6676369981205101107L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_deposito")
	private Long id;
	
	@Column(name = "data_deposito", nullable = false)
	private LocalDate data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_armazem")
	private Armazem armazem;;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_coletor")
	private Coletor coletor;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "deposito_item_deposito", joinColumns = @JoinColumn(name = "id_deposito"), inverseJoinColumns = @JoinColumn(name = "id_item_deposito"))	
	private List<ItemDeposito> itensDeposito;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status_deposito", nullable = true)
	private StatusDeposito statusDeDeposito;
	
	public Deposito() {}
	
	public Deposito(long id, Armazem armazem, Coletor coletor, StatusDeposito statusDeDeposito, LocalDate data) {
		setId(id);
		setArmazem(armazem);
		setColetor(coletor);
		setStatusDeDeposito(statusDeDeposito);
		setData(data);
		itensDeposito = new ArrayList<>();
	}
	
	public Deposito(Armazem armazem, Coletor coletor, StatusDeposito statusDeDeposito, LocalDate data) {
		setArmazem(armazem);
		setColetor(coletor);
		setStatusDeDeposito(statusDeDeposito);
		setData(data);
		itensDeposito = new ArrayList<>();
	}
	
	public Deposito( LocalDate data, Armazem armazem, Coletor coletor) {
		setArmazem(armazem);
		setColetor(coletor);
		setStatusDeDeposito(statusDeDeposito);
		setData(data);
		itensDeposito = new ArrayList<>();
	}
	
	public Deposito(Long id, LocalDate data, Armazem armazem, Coletor coletor) {
		setId(id);
		setArmazem(armazem);
		setColetor(coletor);
		setStatusDeDeposito(statusDeDeposito);
		setData(data);
		itensDeposito = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Coletor getColetor() {
		return coletor;
	}
	
	public void setColetor(Coletor coletor) {
		this.coletor = coletor;
	}
	
	public Armazem getArmazem() {
		return armazem;
	}
	
	public void setArmazem(Armazem armazem) {
		this.armazem = armazem;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public List<ItemDeposito> getItensDeposito() {
		return itensDeposito;
	}
	
	public boolean inserirItemDeposito(ItemDeposito itemDeposito) {
		return itensDeposito.add(itemDeposito);
	}
	
	public boolean removerDeposito(ItemDeposito itemDeposito) {
		return itensDeposito.remove(itemDeposito);
	}
	
	public StatusDeposito getStatusDeDeposito() {
		return statusDeDeposito;
	}
	
	public void setStatusDeDeposito(StatusDeposito statusDeDeposito) {
		this.statusDeDeposito = statusDeDeposito;
	}
}