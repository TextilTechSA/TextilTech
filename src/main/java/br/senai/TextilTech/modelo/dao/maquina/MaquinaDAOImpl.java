package br.senai.TextilTech.modelo.dao.maquina;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.TextilTech.modelo.entidade.maquina.Maquina;
import br.senai.TextilTech.modelo.entidade.maquina.Maquina_;
import br.senai.TextilTech.modelo.factory.conexao.ConexaoFactory;

public class MaquinaDAOImpl implements MaquinaDAO{
	
	private ConexaoFactory fabrica;

	public MaquinaDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirMaquina(Maquina maquina) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(maquina);

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

	public void deletarMaquina(Maquina maquina) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(maquina);

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

	public void atualizarMaquina(Maquina maquina) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(maquina);

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

	public List<Maquina> buscarMaquinasPorNome(String nome) {
		Session sessao = null;
		List<Maquina> maquinas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Maquina> criteria = construtor.createQuery(Maquina.class);
			Root<Maquina> raizMaquina = criteria.from(Maquina.class);

			criteria.select(raizMaquina).where(construtor.like(raizMaquina.get("nome"), "%" + nome + "%"));

			maquinas = sessao.createQuery(criteria).getResultList();

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
		return maquinas;

	}

	public Maquina buscarMaquinaPorId(Long id) {

		Session sessao = null;
		Maquina Maquina = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Maquina> criteria = construtor.createQuery(Maquina.class);
			Root<Maquina> raizMaquina = criteria.from(Maquina.class);
			
			criteria.select(raizMaquina).where(construtor.equal(raizMaquina.get(Maquina_.ID), id));

			Maquina = sessao.createQuery(criteria).getSingleResult();

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

		return Maquina;

	}

}
