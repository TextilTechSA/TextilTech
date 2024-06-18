package br.senac.eco2you.modelo.dao.coletor;

import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.conquista.Conquista;
import br.senac.eco2you.modelo.entidade.deposito.Deposito;
import br.senac.eco2you.modelo.entidade.deposito.Deposito_;
import br.senac.eco2you.modelo.entidade.usuario.Usuario_;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor_;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class ColetorDAOImpl implements ColetorDAO {

	private ConexaoFactory fabrica;

	public ColetorDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void atualizarColetor(Coletor coletor) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(coletor);

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

	public Coletor buscarColetorPeloNome(String nome) {

		Session sessao = null;
		Coletor coletor = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Coletor> criteria = construtor.createQuery(Coletor.class);
			Root<Coletor> raizColetor = criteria.from(Coletor.class);

			criteria.select(raizColetor).where(construtor.equal(raizColetor.get(Coletor_.NOME), nome));

			coletor = sessao.createQuery(criteria).uniqueResult();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		return coletor;
	}
	
	public Coletor buscarColetorPeloId(Long id) {

		Session sessao = null;
		Coletor coletor = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Coletor> criteria = construtor.createQuery(Coletor.class);
			Root<Coletor> raizColetor = criteria.from(Coletor.class);

			criteria.select(raizColetor).where(construtor.equal(raizColetor.get(Coletor_.ID), id));

			coletor = sessao.createQuery(criteria).uniqueResult();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		return coletor;
	}
	
	public List<Coletor> buscarListaColetorPeloNomeParcial(String nome) {
		
		Session sessao = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Coletor> criteria = construtor.createQuery(Coletor.class);
			Root<Coletor> raizUsuario = criteria.from(Coletor.class);
			
			criteria.select(raizUsuario).where(construtor.like(raizUsuario.get("nome"), "%" + nome + "%"));
			
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

	public List<Coletor> buscarListaColetorPeloNome(String nome) {

		Session sessao = null;
		List<Coletor> coletores = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Coletor> criteria = construtor.createQuery(Coletor.class);
			Root<Coletor> raizColetor = criteria.from(Coletor.class);
			Join<Coletor, Deposito> juncaoDeposito = raizColetor.join(Coletor_.DEPOSITOS);
			Join<Deposito, Armazem> juncaoArmazem = juncaoDeposito.join(Deposito_.ARMAZEM);
			ParameterExpression<String> nomeColetorExpression = construtor.parameter(String.class);
			
			criteria.where(construtor.equal(juncaoArmazem.get(Coletor_.NOME), nomeColetorExpression));
			
			coletores = sessao.createQuery(criteria).setParameter(nomeColetorExpression, nome).getResultList();

			sessao.getTransaction().commit();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		return coletores;
	}
	
	public List<Coletor> buscarTop10Coletores() {
		
		Session sessao = null;
		List<Coletor> coletores = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Coletor> criteria = construtor.createQuery(Coletor.class);
			Root<Coletor> raizColetor = criteria.from(Coletor.class);

			criteria.select(raizColetor);
			
			criteria.orderBy(construtor.desc(raizColetor.get("pontos")));

			coletores = sessao.createQuery(criteria).setMaxResults(10).getResultList();

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

		return coletores;
	}
	
	public List<Coletor> buscarColetores() {
		
		Session sessao = null;
		List<Coletor> coletores = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Coletor> criteria = construtor.createQuery(Coletor.class);
			Root<Coletor> raizColetor = criteria.from(Coletor.class);

			criteria.select(raizColetor);

			coletores = sessao.createQuery(criteria).getResultList();

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

		return coletores;
	}
}
