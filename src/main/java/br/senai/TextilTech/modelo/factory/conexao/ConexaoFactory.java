package br.senai.TextilTech.modelo.factory.conexao;
 
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class ConexaoFactory {
 
	public SessionFactory getConexao() {
 
		Configuration configuracao = new Configuration();
 
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.deposito.Deposito.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.endereco.Endereco.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.item.deposito.ItemDeposito.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.item.retirada.ItemRetirada.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.reciclavel.Reciclavel.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.retirada.Retirada.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.conquista.Conquista.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.usuario.empresa.Empresa.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.usuario.empresa.armazem.Armazem.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.usuario.empresa.cooperativa.Cooperativa.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.usuario.pessoa.Pessoa.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.usuario.pessoa.coletor.Coletor.class);
		configuracao.addAnnotatedClass(br.senai.TextilTech.modelo.entidade.material.Material.class);
		
		configuracao.configure("hibernate.cfg.xml");
 
		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);
 
		return fabricaSessao;
	}
}