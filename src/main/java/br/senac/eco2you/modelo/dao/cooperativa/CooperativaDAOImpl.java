package br.senac.eco2you.modelo.dao.cooperativa;

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
import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa;
import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa_;
import br.senac.eco2you.modelo.factory.conexao.ConexaoFactory;

public class CooperativaDAOImpl implements CooperativaDAO {

	private ConexaoFactory fabrica;

	public CooperativaDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public List<Cooperativa> buscarCooperativaPorNome(String nome) {
		Session sessao = null;
		List<Cooperativa> cooperativas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Cooperativa> criteria = construtor.createQuery(Cooperativa.class);
			Root<Cooperativa> raizCooperativa = criteria.from(Cooperativa.class);

			criteria.select(raizCooperativa)
					.where(construtor.like(raizCooperativa.get(Cooperativa_.NOME), "%" + nome + "%"));

			cooperativas = sessao.createQuery(criteria).getResultList();

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

		return cooperativas;
	}

	public List<Cooperativa> buscarCooperativasPeloBairro(String bairro) {
		Session sessao = null;
		List<Cooperativa> cooperativas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Cooperativa> criteria = construtor.createQuery(Cooperativa.class);
			Root<Cooperativa> raizCooperativa = criteria.from(Cooperativa.class);

			Join<Cooperativa, Endereco> juncaoEndereco = raizCooperativa.join(Cooperativa_.endereco);

			ParameterExpression<String> bairroEndereco = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoEndereco.get(Endereco_.BAIRRO), bairroEndereco));

			cooperativas = sessao.createQuery(criteria).setParameter(bairroEndereco, bairro).getResultList();

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

		return cooperativas;

	}

	public List<Cooperativa> buscarCooperativasPelaCidade(String cidade) {
		Session sessao = null;
		List<Cooperativa> cooperativas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Cooperativa> criteria = construtor.createQuery(Cooperativa.class);
			Root<Cooperativa> raizCooperativa = criteria.from(Cooperativa.class);

			Join<Cooperativa, Endereco> juncaoEndereco = raizCooperativa.join(Cooperativa_.endereco);

			ParameterExpression<String> cidadeEndereco = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoEndereco.get(Endereco_.CIDADE), cidadeEndereco));

			cooperativas = sessao.createQuery(criteria).setParameter(cidadeEndereco, cidade).getResultList();

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

		return cooperativas;
	}

	public Cooperativa exibirPerfilCooperativa(String nomeDaCooperativa) {
		Cooperativa cooperativa = null;
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Cooperativa> criteria = construtor.createQuery(Cooperativa.class);
			Root<Cooperativa> raizCooperativa = criteria.from(Cooperativa.class);

			criteria.select(raizCooperativa)
					.where(construtor.equal(raizCooperativa.get(Cooperativa_.NOME), nomeDaCooperativa));

			cooperativa = sessao.createQuery(criteria).uniqueResult();

			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return cooperativa;
	}

	public List<Cooperativa> buscarPerfilCooperativaPeloNome(String nome) {
		List<Cooperativa> cooperativas = null;
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Cooperativa> criteria = construtor.createQuery(Cooperativa.class);
			Root<Cooperativa> raizCooperativa = criteria.from(Cooperativa.class);

			Join<Cooperativa, Retirada> juncaoDeposito = raizCooperativa.join(Cooperativa_.RETIRADAS, JoinType.INNER);
			Join<Retirada, Armazem> juncaoArmazem = juncaoDeposito.join(Retirada_.ARMAZEM);

			ParameterExpression<String> nomeCooperativaExpression = construtor.parameter(String.class);

			criteria.where(construtor.equal(juncaoArmazem.get(Cooperativa_.NOME), nomeCooperativaExpression));

			cooperativas = sessao.createQuery(criteria).setParameter(nomeCooperativaExpression, nome).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return cooperativas;
		}
		return cooperativas;
	}

	public Cooperativa recuperarCooperativaPeloId(Long id) {
		Session sessao = null;
		Cooperativa cooperativa = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Cooperativa> criteria = construtor.createQuery(Cooperativa.class);
			Root<Cooperativa> raizCooperativa = criteria.from(Cooperativa.class);

			criteria.select(raizCooperativa).where(construtor.equal(raizCooperativa.get(Cooperativa_.ID), id));

			cooperativa = sessao.createQuery(criteria).getSingleResult();

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

		return cooperativa;
	}
}