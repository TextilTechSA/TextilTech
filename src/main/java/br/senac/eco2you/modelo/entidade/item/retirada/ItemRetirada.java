package br.senac.eco2you.modelo.entidade.item.retirada;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.material.Material;
import br.senac.eco2you.modelo.entidade.retirada.Retirada;

@Entity
@Table(name = "item_retirada")
public class ItemRetirada implements Serializable {

	private static final long serialVersionUID = -2137699780453738023L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_retirada")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_material", foreignKey = @ForeignKey(name = "itemRetirada_material_FK"))
	private Material material;
	
	@Column(name = "peso_item_retirada", nullable = false)
	private float peso;
	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	private Retirada retirada;
		
	public ItemRetirada() {}

	public ItemRetirada(Material material, float peso, Retirada retirada) {
		setMaterial(material);
		setPeso(peso);
		//setRetirada(retirada);
	}
	
	public ItemRetirada(Material material, float peso) {
		setMaterial(material);
		setPeso(peso);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

//	public Retirada getRetirada() {
//		return retirada;
//	}
//
//	public void setRetirada(Retirada retirada) {
//		this.retirada = retirada;
//	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
}