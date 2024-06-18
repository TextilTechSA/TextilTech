package br.senai.TextilTech.modelo.dao.cooperativa;

import java.util.List;

import br.senai.TextilTech.modelo.entidade.usuario.empresa.cooperativa.Cooperativa;

public interface CooperativaDAO {

	List<Cooperativa> buscarCooperativaPorNome(String nome);

	List<Cooperativa> buscarCooperativasPeloBairro(String nome);
	
	List<Cooperativa> buscarCooperativasPelaCidade(String cidade);
	
	Cooperativa exibirPerfilCooperativa(String nomeDaCooperativa);

	List<Cooperativa> buscarPerfilCooperativaPeloNome(String nome);

	Cooperativa recuperarCooperativaPeloId(Long id);
	
	
}
