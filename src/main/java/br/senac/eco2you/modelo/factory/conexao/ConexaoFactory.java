package br.senac.eco2you.modelo.factory.conexao;
 
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class ConexaoFactory {
 
	public SessionFactory getConexao() {
 
		Configuration configuracao = new Configuration();
 
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.deposito.Deposito.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.endereco.Endereco.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.item.deposito.ItemDeposito.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.item.retirada.ItemRetirada.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.reciclavel.Reciclavel.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.retirada.Retirada.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.conquista.Conquista.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.usuario.empresa.Empresa.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.usuario.pessoa.Pessoa.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor.class);
		configuracao.addAnnotatedClass(br.senac.eco2you.modelo.entidade.material.Material.class);
		
		configuracao.configure("hibernate.cfg.xml");
 
		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);
 
		return fabricaSessao;
	}
}