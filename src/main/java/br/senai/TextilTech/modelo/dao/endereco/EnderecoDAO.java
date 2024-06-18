package br.senai.TextilTech.modelo.dao.endereco;

import br.senai.TextilTech.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {

	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void atualizarEndereco(Endereco endereco);
	
}
