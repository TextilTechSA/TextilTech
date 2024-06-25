package br.senai.TextilTech.modelo.dao.funcionario;

import java.util.List;

import br.senai.TextilTech.modelo.entidade.usuario.funcionario.Funcionario;

public interface FuncionarioDAO {
	
	List<Funcionario> buscarFuncionariosPorNome(String nome);
	
	Funcionario buscarFuncionarioPorId(Long id);

}
