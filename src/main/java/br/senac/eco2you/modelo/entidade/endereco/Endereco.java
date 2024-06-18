package br.senac.eco2you.modelo.entidade.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

@Table(
	name = "endereco",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {
			"cidade_endereco",
			"bairro_endereco",
			"tipo_via_endereco",
			"logradouro_endereco",
			"numero_endereco"
			}
		)
	}
)
public class Endereco implements Serializable {

	private static final long serialVersionUID = -4670801511598712280L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;

	@Column(name = "cep_endereco", length = 9, nullable = true)
	private String cep;
	
	@Column(name = "cidade_endereco", length = 25, nullable = true)
	private String cidade;
	
	@Column(name = "bairro_endereco", length = 25, nullable = true)
	private String bairro;

	@Column(name = "tipo_via_endereco", length = 45, nullable = true)
	private String tipoVia;
	
	@Column(name = "logradouro_endereco", length = 45, nullable = true)
	private String logradouro;

	@Column(name = "numero_endereco", nullable = true)
	private String numeroEndereco;

	@Column(name = "complemento_endereco", length = 45, nullable = true)
	private String complemento;

	@Column(name = "telefone_endereco", length = 15)
	private String telefone;

	public Endereco(String cep, String cidade, String bairro, String tipoVia, String logradouro, String numeroEndereco, String complemento, String telefone) {
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.tipoVia = tipoVia;
		this.logradouro = logradouro;
		this.numeroEndereco = numeroEndereco;
		this.complemento = complemento;
		this.telefone = telefone;
	}

	public Endereco() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}