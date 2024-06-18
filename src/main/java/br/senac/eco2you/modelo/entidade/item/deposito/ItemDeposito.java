package br.senac.eco2you.modelo.entidade.item.deposito;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.reciclavel.Reciclavel;

@Entity
@Table(name = "item_deposito")
public class ItemDeposito implements Serializable {

	private static final long serialVersionUID = -1259028898502823787L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_deposito")
	private Long id;

	@OneToOne
	@JoinColumn(name = "id_reciclavel")
	private Reciclavel reciclavel;

	@Column(name = "quantidade_reciclaveis")
	private int quantidadeReciclaveis;

	public ItemDeposito() {}
	
	public ItemDeposito(long id, Reciclavel reciclavel, int quantidadeReciclaveis) {
		setId(id);
		setQuantidadeReciclaveis(quantidadeReciclaveis);
		setReciclavel(reciclavel);
	}
	
	public ItemDeposito(Reciclavel reciclavel, int quantidadeReciclaveis) {
		setQuantidadeReciclaveis(quantidadeReciclaveis);
		setReciclavel(reciclavel);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Reciclavel getReciclavel() {
		return reciclavel;
	}
	
	public void setReciclavel(Reciclavel reciclavel) {
		this.reciclavel = reciclavel;
	}
	
	public int getQuantidadeReciclaveis() {
		return quantidadeReciclaveis;
	}

	public void setQuantidadeReciclaveis(int quantidadeReciclaveis) {
		this.quantidadeReciclaveis = quantidadeReciclaveis;
	}
}
