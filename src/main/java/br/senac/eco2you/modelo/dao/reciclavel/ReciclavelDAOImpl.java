package br.senac.eco2you.modelo.dao.reciclavel;
 
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.reciclavel.Reciclavel;
import br.senac.eco2you.modelo.entidade.reciclavel.Reciclavel_;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;
 
public class ReciclavelDAOImpl implements ReciclavelDAO {
 
	private ConexaoFactory fabrica;
	
	public ReciclavelDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirReciclavel(Reciclavel reciclavel) {
		Session sessao = null;
 
		try {
 
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
 
			sessao.save(reciclavel);
 
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
 
	public void deletarReciclavel(Reciclavel reciclavel) {
 
		Session sessao = null;
 
		try {
 
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
 
			sessao.delete(reciclavel);
 
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
 
	public void atualizarReciclavel(Reciclavel reciclavel) {
 
		Session sessao = null;
 
		try {
 
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
 
			sessao.update(reciclavel);
 
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
 
	public List<Reciclavel> buscarReciclavelPeloNome(String nome) {
 
		Session sessao = null;
 
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
 
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Reciclavel> criteria = construtor.createQuery(Reciclavel.class);
			Root<Reciclavel> raizReciclavel = criteria.from(Reciclavel.class);
 
			criteria.select(raizReciclavel).where(construtor.like(raizReciclavel.get("nome"), "%" + nome + "%"));
   
			return sessao.createQuery(criteria).getResultList();

			
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
 
		return Collections.emptyList();
	}
	
	public List<Reciclavel> buscarReciclaveis() {

		Session sessao = null;
		List<Reciclavel> reciclaveis = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Reciclavel> criteria = construtor.createQuery(Reciclavel.class);
			Root<Reciclavel> raizReciclavel = criteria.from(Reciclavel.class);

			criteria.select(raizReciclavel);

			reciclaveis = sessao.createQuery(criteria).getResultList();

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

		return reciclaveis;
	}
	
	public Reciclavel buscarReciclavelPorId(long id) {
		
		Session sessao = null;
		Reciclavel reciclavel = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Reciclavel> criteria = construtor.createQuery(Reciclavel.class);
			Root<Reciclavel> raizReciclavel = criteria.from(Reciclavel.class);

			criteria.select(raizReciclavel).where(construtor.equal(raizReciclavel.get(Reciclavel_.ID), id));

			reciclavel = sessao.createQuery(criteria).getSingleResult();

			return reciclavel;

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

		return reciclavel;
		
	}
 
}