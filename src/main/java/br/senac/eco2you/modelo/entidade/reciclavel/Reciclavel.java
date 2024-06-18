package br.senac.eco2you.modelo.entidade.reciclavel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.senac.eco2you.modelo.entidade.material.Material;

@Entity
@Table(name = "reciclavel")
public class Reciclavel implements Serializable {

	private static final long serialVersionUID = -390400605209105761L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reciclavel")
	private Long id;

	@Column(name = "nome_reciclavel", length = 25, nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_material")
	private Material material;

	@Column(name = "pontos_carbono_reciclavel", nullable = false)
	private int pontosCarbono;

	@Column(name = "peso_reciclavel", nullable = false)
	private double peso;

	@Column(name = "volume_reciclavel", nullable = false)
	private double volume;

	@Column(name = "instrucao_reciclavel", length = 200, nullable = false)
	private String instrucaoReciclavel;

	public Reciclavel(String nome, Material material, int pontosCarbono, double peso, double volume,
			String instrucaoReciclavel) {
		this.nome = nome;
		this.material = material;
		this.pontosCarbono = pontosCarbono;
		this.peso = peso;
		this.volume = volume;
		this.instrucaoReciclavel = instrucaoReciclavel;
	}
	
	public Reciclavel(Long id, String nome, Material material, int pontosCarbono, float peso, float volume,
			String instrucaoReciclavel) {
		
		this.id = id;
		this.nome = nome;
		this.material = material;
		this.pontosCarbono = pontosCarbono;
		this.peso = peso;
		this.volume = volume;
		this.instrucaoReciclavel = instrucaoReciclavel;
	}
	
	public Reciclavel() {
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

	public String getInstrucaoReciclavel() {
		return instrucaoReciclavel;
	}

	public void setInstrucaoReciclavel(String instrucaoReciclavel) {
		this.instrucaoReciclavel = instrucaoReciclavel;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getPontosCarbono() {
		return pontosCarbono;
	}

	public void setPontosCarbono(int pontosCarbono) {
		this.pontosCarbono = pontosCarbono;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

}