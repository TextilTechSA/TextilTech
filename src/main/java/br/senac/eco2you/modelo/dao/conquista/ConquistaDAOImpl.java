package br.senac.eco2you.modelo.dao.conquista;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.conquista.Conquista;
import br.senac.eco2you.modelo.entidade.usuario.Usuario_;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem_;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor_;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class ConquistaDAOImpl implements ConquistaDAO {

	private ConexaoFactory fabrica;

	public ConquistaDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirConquista(Conquista conquista) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(conquista);

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

	public void deletarConquista(Conquista conquista) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(conquista);

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

	public void atualizarConquista(Conquista conquista) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(conquista);

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

	public List<Conquista> buscarListaConquistaPeloIdColetor(Long id) {
		Session sessao = null;
		List<Conquista> conquistas = null;
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Conquista> criteria = construtor.createQuery(Conquista.class);
			Root<Conquista> raizConquista = criteria.from(Conquista.class);

			criteria.select(raizConquista).where(construtor.equal(raizConquista.get(Coletor_.ID), id));

			conquistas = sessao.createQuery(criteria).getResultList();

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
		return conquistas;
	}

}