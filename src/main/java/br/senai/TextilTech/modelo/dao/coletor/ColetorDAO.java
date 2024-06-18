package br.senai.TextilTech.modelo.dao.coletor;

import java.util.List;

import br.senai.TextilTech.modelo.entidade.deposito.Deposito;
import br.senai.TextilTech.modelo.entidade.usuario.pessoa.coletor.Coletor;

public interface ColetorDAO {
	

	void atualizarColetor(Coletor coletor);

	Coletor buscarColetorPeloNome(String nomeDoColetor);
	
	Coletor buscarColetorPeloId(Long id);
	
	List <Coletor> buscarListaColetorPeloNomeParcial(String nome);

	List<Coletor> buscarListaColetorPeloNome(String nome); 
	
	List<Coletor> buscarTop10Coletores();
	
	List<Coletor> buscarColetores();
	   
}
