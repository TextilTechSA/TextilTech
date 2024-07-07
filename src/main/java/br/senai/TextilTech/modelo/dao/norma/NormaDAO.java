package br.senai.TextilTech.modelo.dao.norma;

import java.util.List;

import br.senai.TextilTech.modelo.entidade.norma.Norma;

public interface NormaDAO {
	
	void inserirNorma(Norma norma);

	void deletarNorma(Norma norma);

	void atualizarNorma(Norma norma);

	List<Norma> buscarNormasPorNome(String nome);
	
	Norma buscarNormaPorId(Long id);
	
	public List<Norma> buscarNormas();

}
