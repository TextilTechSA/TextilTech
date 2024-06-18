package br.senac.eco2you.modelo.dao.cooperativa;

import java.util.List;

import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa;

public interface CooperativaDAO {

	List<Cooperativa> buscarCooperativaPorNome(String nome);

	List<Cooperativa> buscarCooperativasPeloBairro(String nome);
	
	List<Cooperativa> buscarCooperativasPelaCidade(String cidade);
	
	Cooperativa exibirPerfilCooperativa(String nomeDaCooperativa);

	List<Cooperativa> buscarPerfilCooperativaPeloNome(String nome);

	Cooperativa recuperarCooperativaPeloId(Long id);
	
	
}
