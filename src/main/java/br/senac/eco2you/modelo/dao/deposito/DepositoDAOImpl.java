package br.senac.eco2you.modelo.dao.deposito;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.deposito.Deposito;
import br.senac.eco2you.modelo.entidade.deposito.Deposito_;
import br.senac.eco2you.modelo.entidade.usuario.Usuario_;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem_;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor_;
import br.senac.eco2you.modelo.enumeracao.status.deposito.StatusDeposito;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class DepositoDAOImpl implements DepositoDAO {

	private ConexaoFactory fabrica;

	public DepositoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirDeposito(Deposito deposito) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(deposito);

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

	public void deletarDeposito(Deposito deposito) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(deposito);

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

	public void atualizarDeposito(Deposito deposito) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(deposito);

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

	public List<Deposito> buscarDepositos() {
		
		Session sessao = null;
		List<Deposito> depositos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizCliente = criteria.from(Deposito.class);

			criteria.select(raizCliente);

			depositos = sessao.createQuery(criteria).getResultList();

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

		return depositos;
	}

	public List<Deposito> buscarDepositoPeloStatusDeposito(StatusDeposito statusDeposito) {

		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			ParameterExpression<StatusDeposito> statusDeDeposito = construtor.parameter(StatusDeposito.class);

			criteria.select(raizDeposito)
					.where(construtor.equal(raizDeposito.get(Deposito_.STATUS_DE_DEPOSITO), statusDeDeposito));
			depositos = sessao.createQuery(criteria).setParameter(statusDeDeposito, statusDeposito).getResultList();

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

		return depositos;
	}

	public List<Deposito> buscarDepositoPelaData(LocalDate data) {

		Session sessao = null;
		List<Deposito> depositos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			ParameterExpression<LocalDate> dataDeposito = construtor.parameter(LocalDate.class);

			criteria.select(raizDeposito).where(construtor.equal(raizDeposito, dataDeposito));

			depositos = sessao.createQuery(criteria).getResultList();

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

		return depositos;

	}

	public Deposito buscarDepositoPeloId(Long id) {
		
		Session sessao = null;
		Deposito deposito = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizUsuario = criteria.from(Deposito.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.ID), id));

			deposito = sessao.createQuery(criteria).getSingleResult();

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

		return deposito;

	}

	public List<Deposito> buscarDepositoPeloArmazem(String nome) {

		Session sessao = null;
		List<Deposito> depositos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizArmazem = criteria.from(Deposito.class);
			Join<Deposito, Armazem> juncaoRetiradaArmazem = raizArmazem.join(Deposito_.armazem);
			ParameterExpression<String> nomeArmazem = construtor.parameter(String.class);

			criteria.select(raizArmazem).where(construtor.equal(juncaoRetiradaArmazem.get(Armazem_.NOME), nomeArmazem));

			depositos = sessao.createQuery(criteria).setParameter(nomeArmazem, nome).getResultList();

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

		return depositos;

	}

	public List<Deposito> buscarDepositoPeloArmazem(Armazem armazem) {

		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);

			criteria.select(raizDeposito)

					.where(construtor.equal(raizDeposito.get(Deposito_.ARMAZEM), armazem));

			depositos = sessao.createQuery(criteria).getResultList();


			sessao.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public List<Deposito> buscarDepositoPeloArmazemEColetor(String nomeDoArmazem, String nomeDoColetor) {

		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			Join<Deposito, Coletor> juncaoColetor = raizDeposito.join(Deposito_.coletor);

			criteria.select(raizDeposito)
					.where(construtor.and(construtor.equal(raizDeposito.get(Deposito_.ARMAZEM), nomeDoArmazem),
							construtor.equal(juncaoColetor.get(Coletor_.NOME), nomeDoColetor)));

			depositos = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public List<Deposito> buscarDepositoPeloArmazemEColetorEStatus(String nomeDoArmazem, String nomeDoColetor,
			StatusDeposito status) {
		
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			Join<Deposito, Coletor> juncaoColetor = raizDeposito.join(Deposito_.coletor);

			criteria.select(raizDeposito)
					.where(construtor.and(construtor.equal(raizDeposito.get(Deposito_.ARMAZEM), nomeDoArmazem),
							construtor.equal(juncaoColetor.get(Coletor_.NOME), nomeDoColetor),
							construtor.equal(raizDeposito.get(Deposito_.STATUS_DE_DEPOSITO), status)));

			depositos = sessao.createQuery(criteria).getResultList();
		
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public List<Deposito> buscarDepositoPeloArmazemEColetorEData(String nomeDoColetor, String nomeDoArmazem,
			LocalDate data) {
		
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			Join<Deposito, Coletor> juncaoColetor = raizDeposito.join(Deposito_.coletor);

			criteria.select(raizDeposito)
					.where(construtor.and(construtor.equal(raizDeposito.get(Deposito_.ARMAZEM), nomeDoArmazem),
							construtor.equal(juncaoColetor.get(Coletor_.NOME), nomeDoColetor),
							construtor.equal(raizDeposito.get(Deposito_.DATA), data)));

			depositos = sessao.createQuery(criteria).getResultList();
		
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public List<Deposito> buscarDepositoPeloColetor(Coletor coletor) {
		
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);

			criteria.select(raizDeposito)

					.where(construtor.equal(raizDeposito.get(Deposito_.COLETOR), coletor));

			depositos = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public List<Deposito> buscarDepositoPeloColetorEArmazem(String nomeDoColetor, String nomeDoArmazem) {
		
		Session sessao = null;
		List<Deposito> depositos = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			Join<Deposito, Armazem> juncaoArmazem = raizDeposito.join(Deposito_.armazem);

			criteria.select(raizDeposito)
					.where(construtor.and(construtor.equal(raizDeposito.get(Deposito_.COLETOR), nomeDoColetor),
							construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem)));

			depositos = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public List<Deposito> buscarDepositoPeloColetorEArmazemEStatus(String nomeDoColetor, String nomeDoArmazem,
			StatusDeposito status) {
	
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			Join<Deposito, Armazem> juncaoArmazem = raizDeposito.join(Deposito_.armazem);

			criteria.select(raizDeposito)
					.where(construtor.and(construtor.equal(raizDeposito.get(Deposito_.COLETOR), nomeDoColetor),
							construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem),
							construtor.equal(raizDeposito.get(Deposito_.STATUS_DE_DEPOSITO), status)));

			depositos = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}

	public List<Deposito> buscarDepositoPeloColetorEArmazemEData(String nomeDoColetor, String nomeDoArmazem,
			LocalDate data) {
	
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
			Join<Deposito, Armazem> juncaoArmazem = raizDeposito.join(Deposito_.armazem);

			criteria.select(raizDeposito)
					.where(construtor.and(construtor.equal(raizDeposito.get(Deposito_.COLETOR), nomeDoColetor),
							construtor.equal(juncaoArmazem.get(Armazem_.NOME), nomeDoArmazem),
							construtor.equal(raizDeposito.get(Deposito_.DATA), data)));

			depositos = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;
	}
	
	public Deposito buscarDepositoComItemDepositoPorId(Long id) {
	   
		Session sessao = null;
	    Deposito deposito = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
	        Root<Deposito> raizDeposito= criteria.from(Deposito.class);
	       
	        raizDeposito.fetch(Deposito_.ITENS_DEPOSITO, JoinType.LEFT);

	        criteria.select(raizDeposito).where(construtor.equal(raizDeposito.get("id"), id));


	        deposito = sessao.createQuery(criteria).uniqueResult();
	        
			sessao.getTransaction().commit();

	    } catch (Exception e) {
			e.printStackTrace();
		}
		return deposito;

	}

	public List<Deposito> buscarProximosDepositos(StatusDeposito statusDeposito, LocalDate data, Long id) {
		
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
		    sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);

				
			criteria.where(
				    construtor.equal(raizDeposito.get(Deposito_.STATUS_DE_DEPOSITO), statusDeposito),
				    construtor.equal(raizDeposito.get(Deposito_.COLETOR), id),				    
				    construtor.greaterThan(raizDeposito.get(Deposito_.DATA), data));

			criteria.orderBy(construtor.asc(raizDeposito.get(Deposito_.DATA)));
			
			depositos = sessao.createQuery(criteria).setMaxResults(3).getResultList();
	
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;

	}
	
	public List<Deposito> buscarDepositosPeloStatusEColetor(StatusDeposito statusDeposito, Long id) {
		
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
		    sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
				
			criteria.where(
				    construtor.equal(raizDeposito.get(Deposito_.STATUS_DE_DEPOSITO), statusDeposito),
				    construtor.equal(raizDeposito.get(Deposito_.COLETOR), id));

			criteria.orderBy(construtor.asc(raizDeposito.get(Deposito_.DATA)));
			
			depositos = sessao.createQuery(criteria).getResultList();
	
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;

	}
	
	public List<Deposito> buscarDepositosPeloStatusEArmazem(StatusDeposito statusDeposito, Long id) {
		
		Session sessao = null;
		List<Deposito> depositos = null;

		try {
			sessao = fabrica.getConexao().openSession();
		    sessao.beginTransaction();
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
			Root<Deposito> raizDeposito = criteria.from(Deposito.class);
				
			criteria.where(
				    construtor.equal(raizDeposito.get(Deposito_.STATUS_DE_DEPOSITO), statusDeposito),
				    construtor.equal(raizDeposito.get(Deposito_.ARMAZEM), id));

			criteria.orderBy(construtor.asc(raizDeposito.get(Deposito_.DATA)));
			
			depositos = sessao.createQuery(criteria).getResultList();
	
			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return depositos;

	}

	public Deposito buscarDepositoComItemDepositoPorIdEStatusDeposito(Long id, StatusDeposito statusDeposito) {
		   
		Session sessao = null;
	    Deposito deposito = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();
	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Deposito> criteria = construtor.createQuery(Deposito.class);
	        Root<Deposito> raizDeposito= criteria.from(Deposito.class);
	       
	        raizDeposito.fetch(Deposito_.ITENS_DEPOSITO, JoinType.LEFT);

	        criteria.where(
	        		construtor.equal(raizDeposito.get("id"), id),
	        		construtor.equal(raizDeposito.get(Deposito_.STATUS_DE_DEPOSITO), statusDeposito));

	        deposito = sessao.createQuery(criteria).uniqueResult();
	        
			sessao.getTransaction().commit();

	    } catch (Exception e) {
			e.printStackTrace();
		}
		return deposito;

	}
	
}
