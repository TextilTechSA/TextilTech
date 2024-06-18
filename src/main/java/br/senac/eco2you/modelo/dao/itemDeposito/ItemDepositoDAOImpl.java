package br.senac.eco2you.modelo.dao.itemDeposito;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.item.deposito.ItemDeposito;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class ItemDepositoDAOImpl implements ItemDepositoDAO {
	
	private ConexaoFactory fabrica;

	public ItemDepositoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirItemDeposito(ItemDeposito itemDeposito) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(itemDeposito);

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

	public void deletarItemDeposito(ItemDeposito itemDeposito) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(itemDeposito);

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

	public void atualizarItemDeposito(ItemDeposito itemDeposito) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(itemDeposito);

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

	public List<ItemDeposito> buscarItensDeposito() {

		Session sessao = null;
		List<ItemDeposito> itensDeposito = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<ItemDeposito> criteria = construtor.createQuery(ItemDeposito.class);
			Root<ItemDeposito> raizItemDeposito = criteria.from(ItemDeposito.class);

			criteria.select(raizItemDeposito);

			itensDeposito = sessao.createQuery(criteria).getResultList();

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

		return itensDeposito;
	}

}
