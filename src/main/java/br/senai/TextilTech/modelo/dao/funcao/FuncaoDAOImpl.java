package br.senai.TextilTech.modelo.dao.funcao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.TextilTech.modelo.entidade.funcao.Funcao;
import br.senai.TextilTech.modelo.entidade.norma.Norma_;
import br.senai.TextilTech.modelo.factory.conexao.ConexaoFactory;

public class FuncaoDAOImpl {
	
	private ConexaoFactory fabrica;

	public FuncaoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirFuncao(Funcao funcao) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(funcao);

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

	public void deletarFuncao(Funcao funcao) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(funcao);

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

	public void atualizarFuncao(Funcao funcao) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(funcao);

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

	public List<Funcao> buscarFuncoesPorNome(String nome) {
		Session sessao = null;
		List<Funcao> funcoes = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Funcao> criteria = construtor.createQuery(Funcao.class);
			Root<Funcao> raizFuncao = criteria.from(Funcao.class);

			criteria.select(raizFuncao).where(construtor.like(raizFuncao.get("nome"), "%" + nome + "%"));

			funcoes = sessao.createQuery(criteria).getResultList();

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
		return funcoes;

	}

	public Funcao buscarFuncaoPorId(Long id) {

		Session sessao = null;
		Funcao funcao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Funcao> criteria = construtor.createQuery(Funcao.class);
			Root<Funcao> raizFuncao = criteria.from(Funcao.class);

			criteria.select(raizFuncao).where(construtor.equal(raizFuncao.get(Norma_.ID), id));

			funcao = sessao.createQuery(criteria).getSingleResult();

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

		return funcao;

	}

}
