package br.senac.eco2you.modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.retirada.Retirada;
import br.senac.eco2you.modelo.entidade.usuario.Usuario;
import br.senac.eco2you.modelo.entidade.usuario.Usuario_;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private ConexaoFactory fabrica;

	public UsuarioDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void deletarUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void atualizarUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public List<Usuario> buscarUsuariosPorNome(String nome) {
		Session sessao = null;
		List<Usuario> usuarios = null;

			
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.like(raizUsuario.get("nome"), "%" + nome + "%"));

			usuarios = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		return usuarios;

	}

	public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {

		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.EMAIL), email),
					construtor.equal(raizUsuario.get(Usuario_.SENHA), senha));

			Predicate predicateUsuarioSenha = construtor.equal(raizUsuario.get(Usuario_.SENHA), senha);
			Predicate predicateUsuarioEmail = construtor.equal(raizUsuario.get(Usuario_.EMAIL), email);
			Predicate predicateUsuarioLogin = construtor.and(predicateUsuarioSenha, predicateUsuarioEmail);

			criteria.where(predicateUsuarioLogin);

			usuario = sessao.createQuery(criteria).getSingleResult();

			sessao.getTransaction().commit();

			 
		} catch (Exception sqlException) {
			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}

		return usuario;
	}

	public Usuario buscarUsuarioPorEmail(String email) {
		
		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.EMAIL), email));

			usuario = sessao.createQuery(criteria).getSingleResult();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {
			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}

		return usuario;
		
	}
	
	public Usuario buscarUsuarioPorId(Long id) {
		
		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.ID), id));

			usuario = sessao.createQuery(criteria).getSingleResult();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {
			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}

		return usuario;
		
	}
	
	public Usuario recuperarUsuarioComEnderecoPorId(Long id) {
	    Session sessao = null;
	    Usuario usuario = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);

	       
	        raizUsuario.fetch("endereco", JoinType.LEFT);

	        criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get("id"), id));


	        usuario = sessao.createQuery(criteria).uniqueResult();

	        sessao.getTransaction().commit();

	    } catch (Exception sqlException) {
	        sqlException.printStackTrace();

	        if (sessao.getTransaction() != null && sessao.getTransaction().isActive()) {
	            sessao.getTransaction().rollback();
	        }

	    } finally {
	        if (sessao != null) {
	            sessao.close();
	        }
	    }

	    return usuario;
	}public Usuario buscarUsuarioPorNome(String nome) {
	    Session sessao = null;
	    Usuario usuario = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);

	        criteria.select(raizUsuario)
	                .where(construtor.like(raizUsuario.get(Usuario_.NOME), "%" + nome + "%"));
	        
	        usuario = sessao.createQuery(criteria).uniqueResult();

	        sessao.getTransaction().commit();

	    } catch (Exception sqlException) {
	        sqlException.printStackTrace();
	        if (sessao.getTransaction() != null) {
	            sessao.getTransaction().rollback();
	        }
	    } finally {
	        if (sessao != null) {
	            sessao.close();
	        }
	    }
	    return usuario;
	}

}
