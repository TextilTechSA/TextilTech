package br.senac.eco2you.modelo.dao.armazem;

import java.util.List;

import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.enumeracao.status.armazem.StatusArmazem;

public interface ArmazemDAO {
	
	List<Armazem> buscarArmazensPorNome(String nome);

	List<Armazem> buscarArmazemPeloBairro(String bairro);

	List<Armazem> buscarArmazemPeloCidade(String cidade);
	
	List<Armazem> buscarArmazemPeloStatusArmazem(StatusArmazem statusDeArmazem);
	
	List<Armazem> buscarArmazens();
	
	List<Armazem> buscarPerfilArmazemPeloNomePelaCooperativa(String nome);
	
	Armazem buscarArmazemPorId(long id);
	
}