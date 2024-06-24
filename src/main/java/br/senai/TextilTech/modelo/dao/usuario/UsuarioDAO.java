package br.senai.TextilTech.modelo.dao.usuario;

import java.util.List;

import br.senai.TextilTech.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	List<Usuario> buscarUsuariosPorNome(String nome);
	
	Usuario buscarUsuarioPorId(Long id);
	
	Usuario buscarUsuarioPorNome(String nome);
}