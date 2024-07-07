package br.senai.TextilTech.modelo.dao.norma;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.TextilTech.modelo.entidade.norma.Norma;
import br.senai.TextilTech.modelo.entidade.norma.Norma_;
import br.senai.TextilTech.modelo.factory.conexao.ConexaoFactory;

public class NormaDAOImpl implements NormaDAO {

	private ConexaoFactory fabrica;

	public NormaDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirNorma(Norma norma) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(norma);

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

	public void deletarNorma(Norma norma) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(norma);

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

	public void atualizarNorma(Norma norma) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(norma);

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

	public List<Norma> buscarNormasPorNome(String nome) {
		Session sessao = null;
		List<Norma> normas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Norma> criteria = construtor.createQuery(Norma.class);
			Root<Norma> raizNorma = criteria.from(Norma.class);

			criteria.select(raizNorma).where(construtor.like(raizNorma.get("nome"), "%" + nome + "%"));

			normas = sessao.createQuery(criteria).getResultList();

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
		return normas;

	}

	public Norma buscarNormaPorId(Long id) {

		Session sessao = null;
		Norma norma = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Norma> criteria = construtor.createQuery(Norma.class);
			Root<Norma> raizNorma = criteria.from(Norma.class);

			criteria.select(raizNorma).where(construtor.equal(raizNorma.get(Norma_.ID), id));

			norma = sessao.createQuery(criteria).getSingleResult();

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

		return norma;

	}
	
	public List<Norma> buscarNormas() {

		Session sessao = null;
		List<Norma> normas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Norma> criteria = construtor.createQuery(Norma.class);
			Root<Norma> raizNorma = criteria.from(Norma.class);

			criteria.select(raizNorma);

			normas = sessao.createQuery(criteria).getResultList();

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

		return normas;
	}
}
