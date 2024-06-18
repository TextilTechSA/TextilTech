package br.senac.eco2you.modelo.dao.reciclavel;

import java.util.List;

import br.senac.eco2you.modelo.entidade.reciclavel.Reciclavel;

public interface ReciclavelDAO {

	void inserirReciclavel(Reciclavel reciclavel);

	void deletarReciclavel(Reciclavel reciclavel);

	void atualizarReciclavel(Reciclavel reciclavel);
	
	List<Reciclavel> buscarReciclaveis();

	List<Reciclavel> buscarReciclavelPeloNome(String nome);
	
	Reciclavel buscarReciclavelPorId(long id);
}