package br.senac.eco2you.modelo.dao.usuario;

import java.util.List;

import br.senac.eco2you.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);

	List<Usuario> buscarUsuariosPorNome(String nome);

	Usuario buscarUsuarioPorEmailESenha(String email, String senha);
	
	Usuario buscarUsuarioPorEmail(String email);
	
	Usuario buscarUsuarioPorId(Long id);

	Usuario recuperarUsuarioComEnderecoPorId(Long id);
	
	Usuario buscarUsuarioPorNome(String nome);
}