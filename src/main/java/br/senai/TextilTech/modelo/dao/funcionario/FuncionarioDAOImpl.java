package br.senai.TextilTech.modelo.dao.funcionario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.TextilTech.modelo.entidade.usuario.funcionario.Funcionario;
import br.senai.TextilTech.modelo.entidade.usuario.funcionario.Funcionario_;
import br.senai.TextilTech.modelo.factory.conexao.ConexaoFactory;

public class FuncionarioDAOImpl implements FuncionarioDAO {
	
	private ConexaoFactory fabrica;

	public FuncionarioDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public List<Funcionario> buscarFuncionariosPorNome(String nome) {
		Session sessao = null;
		List<Funcionario> funcionarios = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Funcionario> criteria = construtor.createQuery(Funcionario.class);
			Root<Funcionario> raizFuncionario = criteria.from(Funcionario.class);

			criteria.select(raizFuncionario).where(construtor.like(raizFuncionario.get("nome"), "%" + nome + "%"));

			funcionarios = sessao.createQuery(criteria).getResultList();

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
		return funcionarios;

	}

	public Funcionario buscarFuncionarioPorId(Long id) {

		Session sessao = null;
		Funcionario funcionario = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Funcionario> criteria = construtor.createQuery(Funcionario.class);
			Root<Funcionario> raizNorma = criteria.from(Funcionario.class);

			criteria.select(raizNorma).where(construtor.equal(raizNorma.get(Funcionario_.ID), id));

			funcionario = sessao.createQuery(criteria).getSingleResult();

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

		return funcionario;

	}

}
