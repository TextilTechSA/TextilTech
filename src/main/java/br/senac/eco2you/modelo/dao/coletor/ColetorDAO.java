package br.senac.eco2you.modelo.dao.coletor;

import java.util.List;

import br.senac.eco2you.modelo.entidade.deposito.Deposito;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor;

public interface ColetorDAO {
	

	void atualizarColetor(Coletor coletor);

	Coletor buscarColetorPeloNome(String nomeDoColetor);
	
	Coletor buscarColetorPeloId(Long id);
	
	List <Coletor> buscarListaColetorPeloNomeParcial(String nome);

	List<Coletor> buscarListaColetorPeloNome(String nome); 
	
	List<Coletor> buscarTop10Coletores();
	
	List<Coletor> buscarColetores();
	   
}
