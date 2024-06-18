package br.senac.eco2you.modelo.dao.armazem;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senac.eco2you.modelo.entidade.endereco.Endereco;
import br.senac.eco2you.modelo.entidade.endereco.Endereco_;
import br.senac.eco2you.modelo.entidade.retirada.Retirada;
import br.senac.eco2you.modelo.entidade.retirada.Retirada_;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem_;
import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa;
import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa_;
import br.senac.eco2you.modelo.enumeracao.status.armazem.StatusArmazem;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class ArmazemDAOImpl implements ArmazemDAO {
	private ConexaoFactory fabrica;

	public ArmazemDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public List<Armazem> buscarArmazensPorNome(String nome) {
		
		Session sessao = null;
		List<Armazem> armazens = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Armazem> criteria = construtor.createQuery(Armazem.class);
			Root<Armazem> raizArmazem = criteria.from(Armazem.class);

			criteria.select(raizArmazem).where(construtor.like(raizArmazem.get(Armazem_.NOME), "%" + nome + "%"));
			armazens = sessao.createQuery(criteria).getResultList();

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
		return armazens;

	}

	public List<Armazem> buscarArmazemPeloBairro(String bairro) {
		
		Session sessao = null;
		List<Armazem> armazens = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Armazem> criteria = construtor.createQuery(Armazem.class);
			Root<Armazem> raizArmazem = criteria.from(Armazem.class);

			Join<Armazem, Endereco> juncaoEndereco = raizArmazem.join(Armazem_.endereco);
			ParameterExpression<String> bairroEndereco = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoEndereco.get(Endereco_.BAIRRO), bairroEndereco));
			armazens = sessao.createQuery(criteria).setParameter(bairroEndereco, bairro).getResultList();

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

		return armazens;

	}

	public List<Armazem> buscarArmazemPeloCidade(String cidade) {
		
		Session sessao = null;
		List<Armazem> armazens = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Armazem> criteria = construtor.createQuery(Armazem.class);
			Root<Armazem> raizArmazem = criteria.from(Armazem.class);

			Join<Armazem, Endereco> juncaoEndereco = raizArmazem.join(Armazem_.endereco);
			ParameterExpression<String> cidadeEndereco = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoEndereco.get(Endereco_.CIDADE), cidadeEndereco));
			armazens = sessao.createQuery(criteria).setParameter(cidadeEndereco, cidade).getResultList();

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

		return armazens;

	}

	public List<Armazem> buscarArmazemPeloStatusArmazem(StatusArmazem statusArmazem) {

		Session sessao = null;
		List<Armazem> armazens = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Armazem> criteria = construtor.createQuery(Armazem.class);
			Root<Armazem> raizArmazem = criteria.from(Armazem.class);
			ParameterExpression<StatusArmazem> statusDeArmazem = construtor.parameter(StatusArmazem.class);

			criteria.select(raizArmazem)
					.where(construtor.equal(raizArmazem.get(Armazem_.STATUS_ARMAZEM), statusDeArmazem));
			armazens = sessao.createQuery(criteria).setParameter(statusDeArmazem, statusArmazem).getResultList();

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

		return armazens;
	}

	public List<Armazem> buscarArmazens() {
		
		Session sessao = null;
		List<Armazem> armazens = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Armazem> criteria = construtor.createQuery(Armazem.class);
			Root<Armazem> raizArmazem = criteria.from(Armazem.class);

			criteria.select(raizArmazem);

			armazens = sessao.createQuery(criteria).getResultList();

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

		return armazens;
	}

	public Armazem buscarArmazemPorId(long id) {
		
		Session sessao = null;
		Armazem armazem = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Armazem> criteria = construtor.createQuery(Armazem.class);
			Root<Armazem> raizArmazem = criteria.from(Armazem.class);

			criteria.select(raizArmazem).where(construtor.equal(raizArmazem.get(Armazem_.ID), id));

			armazem = sessao.createQuery(criteria).getSingleResult();

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

		return armazem;
	
	}
	//Essa consulta não estava retornando nada, entao fiz por innerJoin, porém ainda precisa ser testada.
	public List<Armazem> buscarPerfilArmazemPeloNomePelaCooperativa(String nome) {
		
		Session sessao = null;
		List<Armazem> armazens = null;
		
		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Armazem> criteria = construtor.createQuery(Armazem.class);
			Root<Armazem> raizArmazem = criteria.from(Armazem.class);

			Join<Armazem, Retirada> juncaoDeposito = raizArmazem.join(Armazem_.RETIRADAS, JoinType.INNER);
			Join<Retirada, Cooperativa> juncaoCooperativa = juncaoDeposito.join(Retirada_.COOPERATIVA);

			ParameterExpression<String> nomeArmazemExpression = construtor.parameter(String.class);

			criteria.where(construtor.equal(juncaoCooperativa.get(Cooperativa_.NOME), nomeArmazemExpression));

			armazens = sessao.createQuery(criteria).setParameter(nomeArmazemExpression, nome).getResultList();
			
			sessao.getTransaction().commit();
			
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}		}
		
		return armazens; 

	}
	
}
