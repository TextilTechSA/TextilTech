package br.senai.TextilTech.modelo.dao.funcao;

import java.util.List;

import br.senai.TextilTech.modelo.entidade.funcao.Funcao;

public interface FuncaoDAO {

	void inserirFuncao(Funcao funcao);

	void deletarFuncao(Funcao funcao);

	void atualizarFuncao(Funcao funcao);

	List<Funcao> buscarNormasPorNome(String nome);

	Funcao buscarNormaPorId(Long id);
}
