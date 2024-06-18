package br.senac.eco2you.modelo.dao.retirada;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.deposito.Deposito;
import br.senac.eco2you.modelo.entidade.deposito.Deposito_;
import br.senac.eco2you.modelo.entidade.retirada.Retirada;
import br.senac.eco2you.modelo.entidade.retirada.Retirada_;
import br.senac.eco2you.modelo.entidade.usuario.Usuario_;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem_;
import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa;
import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa_;
import br.senac.eco2you.modelo.enumeracao.status.deposito.StatusDeposito;
import br.senac.eco2you.modelo.enumeracao.status.retirada.StatusRetirada;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class RetiradaDAOImpl implements RetiradaDAO {

	private ConexaoFactory fabrica;

	public RetiradaDAOImpl() {

		fabrica = new ConexaoFactory();

	}

	public void inserirRetirada(Retirada retirada) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.save(retirada);

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

	public void deletarRetirada(Retirada retirada) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.delete(retirada);

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

	public void atualizarRetirada(Retirada retirada) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			sessao.update(retirada);

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
	
	public Retirada buscarRetiradaPeloId(Long id) {

		Session sessao = null;
		Retirada retirada = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizUsuario = criteria.from(Retirada.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.ID), id));

			retirada = sessao.createQuery(criteria).getSingleResult();

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

		return retirada;

	}

	public List<Retirada> buscarRetiradaPelaData(LocalDate data) {

		Session sessao = null;
		List<Retirada> retiradas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			ParameterExpression<LocalDate> dataRetirada = construtor.parameter(LocalDate.class);
			criteria.where(construtor.equal(raizRetirada.get(Retirada_.data), dataRetirada));

			criteria.select(raizRetirada);

			retiradas = sessao.createQuery(criteria).setParameter(dataRetirada, data).getResultList();

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

		return retiradas;

	}

	public List<Retirada> buscarRetiradaPelaCooperativa(String nome) {

		Session sessao = null;

		List<Retirada> retiradas = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);

			Root<Retirada> raizRetirada = criteria.from(Retirada.class);

			Join<Retirada, Cooperativa> juncaoRetiradaCooperativa = raizRetirada.join(Retirada_.cooperativa);

			ParameterExpression<String> nomeCooperativa = construtor.parameter(String.class);

			criteria.select(raizRetirada)
					.where(construtor.like(juncaoRetiradaCooperativa.get(Cooperativa_.nome), nomeCooperativa));

			retiradas = sessao.createQuery(criteria).setParameter(nomeCooperativa, nome).getResultList();

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

		return retiradas;

	}

	public List<Retirada> buscarRetiradasPelaCooperativa(Cooperativa cooperativa) {

		Session sessao = null;
		List<Retirada> retiradas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);

			criteria.select(raizRetirada)
					.where(construtor.equal(raizRetirada.get(Retirada_.COOPERATIVA), cooperativa));

			retiradas = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retiradas;
	}

	public List<Retirada> buscarRetiradaPeloArmazem(String nome) {

		Session sessao = null;

		List<Retirada> retiradas = null;

		try {

			sessao = fabrica.getConexao().openSession();

			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);

			Root<Retirada> raizArmazem = criteria.from(Retirada.class);

			Join<Retirada, Armazem> juncaoRetiradaArmazem = raizArmazem.join(Retirada_.armazem);

			ParameterExpression<String> nomeArmazem = construtor.parameter(String.class);

			criteria.select(raizArmazem).where(construtor.equal(juncaoRetiradaArmazem.get(Armazem_.NOME), nomeArmazem));

			retiradas = sessao.createQuery(criteria).setParameter(nomeArmazem, nome).getResultList();

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

		return retiradas;

	}

	public List<Retirada> buscarRetiradasPeloArmazem(Armazem armazem) {

		Session sessao = null;
		List<Retirada> retiradas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizDeposito = criteria.from(Retirada.class);

			criteria.select(raizDeposito)

					.where(construtor.equal(raizDeposito.get(Retirada_.ARMAZEM), armazem));

			retiradas = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retiradas;
	}

	public List<Retirada> buscarRetiradaPeloStatusRetirada(StatusRetirada statusRetirada) {

		Session sessao = null;
		List<Retirada> retiradas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			ParameterExpression<StatusRetirada> statusDeRetirada = construtor.parameter(StatusRetirada.class);

			criteria.select(raizRetirada)
					.where(construtor.equal(raizRetirada.get(Retirada_.STATUS_DE_RETIRADA), statusDeRetirada));
			retiradas = sessao.createQuery(criteria).setParameter(statusDeRetirada, statusRetirada).getResultList();

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

		return retiradas;
	}

	public List<Retirada> buscarRetiradaPeloArmazemECooperativa(String nomeDoArmazem, String nomeDaCooperativa) {
		Session sessao = null;
		List<Retirada> retiradas = null;	
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
		
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			Join<Retirada, Armazem> juncaoArmazem = raizRetirada.join(Retirada_.armazem);
			Join<Retirada, Cooperativa> juncaoCooperativa = raizRetirada.join(Retirada_.cooperativa);

			criteria.select(raizRetirada)
					.where(construtor.and(construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem),
							construtor.equal(juncaoCooperativa.get(Cooperativa_.NOME), nomeDaCooperativa)));

			retiradas = sessao.createQuery(criteria).getResultList();
		
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	return retiradas;
	}

	public List<Retirada> buscarRetiradaPeloArmazemECooperativaEStatus(String nomeDoArmazem, String nomeDaCooperativa,
			StatusRetirada status) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
		
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			Join<Retirada, Armazem> juncaoArmazem = raizRetirada.join(Retirada_.armazem);
			Join<Retirada, Cooperativa> juncaoCooperativa = raizRetirada.join(Retirada_.cooperativa);

			criteria.select(raizRetirada)
					.where(construtor.and(construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem),
							construtor.equal(juncaoCooperativa.get(Cooperativa_.NOME), nomeDaCooperativa),
							construtor.equal(raizRetirada.get(Retirada_.STATUS_DE_RETIRADA), status)));

			retiradas = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	return retiradas;
	}

	public List<Retirada> buscarRetiradaPeloArmazemECooperativaEData(String nomeDoArmazem, String nomeDaCooperativa,
			LocalDate data) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			Join<Retirada, Armazem> juncaoArmazem = raizRetirada.join(Retirada_.armazem);
			Join<Retirada, Cooperativa> juncaoCooperativa = raizRetirada.join(Retirada_.cooperativa);

			criteria.select(raizRetirada)
					.where(construtor.and(construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem),
							construtor.equal(juncaoCooperativa.get(Cooperativa_.NOME), nomeDaCooperativa),
							construtor.equal(raizRetirada.get(Retirada_.DATA), data)));

			retiradas = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();	
		}
	return retiradas;
	}

	public List<Retirada> buscarRetiradaPelaCooperativaEArmazem(String nomeDaCooperativa, String nomeDoArmazem) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			Join<Retirada, Cooperativa> juncaoCooperativa = raizRetirada.join(Retirada_.cooperativa);
			Join<Retirada, Armazem> juncaoArmazem = raizRetirada.join(Retirada_.armazem);

			criteria.select(raizRetirada)
					.where(construtor.and(construtor.equal(juncaoCooperativa.get(Cooperativa_.NOME), nomeDaCooperativa),
							construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem)));

			retiradas = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	return retiradas;
	}

	public List<Retirada> buscarRetiradaPelaCooperativaEArmazemEStatus(String nomeDaCooperativa, String nomeDoArmazem,
			StatusRetirada status) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			Join<Retirada, Cooperativa> juncaoCooperativa = raizRetirada.join(Retirada_.cooperativa);
			Join<Retirada, Armazem> juncaoArmazem = raizRetirada.join(Retirada_.armazem);

			criteria.select(raizRetirada)
					.where(construtor.and(construtor.equal(juncaoCooperativa.get(Cooperativa_.NOME), nomeDaCooperativa),
							construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem),
							construtor.equal(raizRetirada.get(Retirada_.STATUS_DE_RETIRADA), status)));

			retiradas = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	return retiradas;
	}

	public List<Retirada> buscarRetiradaPelaCooperativaEArmazemEData(String nomeDaCooperativa, String nomeDoArmazem,
			LocalDate data) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizRetirada = criteria.from(Retirada.class);
			Join<Retirada, Cooperativa> juncaoCooperativa = raizRetirada.join(Retirada_.cooperativa);
			Join<Retirada, Armazem> juncaoArmazem = raizRetirada.join(Retirada_.armazem);

			criteria.select(raizRetirada)
					.where(construtor.and(construtor.equal(juncaoCooperativa.get(Cooperativa_.NOME), nomeDaCooperativa),
							construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem),
							construtor.equal(raizRetirada.get(Retirada_.DATA), data)));

			retiradas = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	return retiradas;
	}

	public List<Retirada> recuperarRetiradas() {
		Session sessao = null;
		List<Retirada> retiradas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizCliente = criteria.from(Retirada.class);

			criteria.select(raizCliente);

			retiradas = sessao.createQuery(criteria).getResultList();

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

		return retiradas;
	}
	
	public List<Retirada> buscarProximasRetiradas(StatusRetirada statusRetirada, LocalDate data, Long id) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;

		try {
			sessao = fabrica.getConexao().openSession();
		    sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizDeposito = criteria.from(Retirada.class);

				
			criteria.where(
				    construtor.equal(raizDeposito.get(Retirada_.STATUS_DE_RETIRADA), statusRetirada),
				    construtor.equal(raizDeposito.get(Retirada_.COOPERATIVA), id),				    
				    construtor.greaterThan(raizDeposito.get(Deposito_.DATA), data));

			criteria.orderBy(construtor.asc(raizDeposito.get(Deposito_.DATA)));
			
			retiradas = sessao.createQuery(criteria).setMaxResults(2).getResultList();
	
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retiradas;

	}
	
	public List<Retirada> buscarRetiradasPeloStatusECooperativa(StatusRetirada statusRetirada, Long id) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;

		try {
			sessao = fabrica.getConexao().openSession();
		    sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizDeposito = criteria.from(Retirada.class);
				
			criteria.where(
				    construtor.equal(raizDeposito.get(Retirada_.STATUS_DE_RETIRADA), statusRetirada),
				    construtor.equal(raizDeposito.get(Retirada_.COOPERATIVA), id));

			criteria.orderBy(construtor.asc(raizDeposito.get(Deposito_.DATA)));
			
			retiradas = sessao.createQuery(criteria).getResultList();
	
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retiradas;

	}
	
	public List<Retirada> buscarRetiradasPeloStatusEArmazem(StatusRetirada statusRetirada, Long id) {
		
		Session sessao = null;
		List<Retirada> retiradas = null;

		try {
			sessao = fabrica.getConexao().openSession();
		    sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Retirada> criteria = construtor.createQuery(Retirada.class);
			Root<Retirada> raizDeposito = criteria.from(Retirada.class);
				
			criteria.where(
				    construtor.equal(raizDeposito.get(Retirada_.STATUS_DE_RETIRADA), statusRetirada),
				    construtor.equal(raizDeposito.get(Retirada_.ARMAZEM), id));

			criteria.orderBy(construtor.asc(raizDeposito.get(Deposito_.DATA)));
			
			retiradas = sessao.createQuery(criteria).getResultList();
	
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retiradas;

	}

}
