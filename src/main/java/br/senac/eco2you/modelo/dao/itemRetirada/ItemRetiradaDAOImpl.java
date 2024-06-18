package br.senac.eco2you.modelo.dao.itemRetirada;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.item.retirada.ItemRetirada;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class ItemRetiradaDAOImpl implements ItemRetiradaDAO {
	
	private ConexaoFactory fabrica;
	
	public ItemRetiradaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	public void inserirItemRetirada(ItemRetirada itemRetirada) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(itemRetirada);

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

	public void deletarItemRetirada(ItemRetirada itemRetirada) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(itemRetirada);

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

	public void atualizarItemRetirada (ItemRetirada itemRetirada) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(itemRetirada);

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

	public List<ItemRetirada> buscarItensRetirada() {

		Session sessao = null;
		List<ItemRetirada> clientes = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<ItemRetirada> criteria = construtor.createQuery(ItemRetirada.class);
			Root<ItemRetirada> raizCliente = criteria.from(ItemRetirada.class);

			criteria.select(raizCliente);

			clientes = sessao.createQuery(criteria).getResultList();

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

		return clientes;
	}

}
