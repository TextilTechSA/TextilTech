package br.senai.TextilTech;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAO;
import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAOImpl;
import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAO;
import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAOImpl;
import br.senai.TextilTech.modelo.dao.norma.NormaDAO;
import br.senai.TextilTech.modelo.dao.norma.NormaDAOImpl;
import br.senai.TextilTech.modelo.dao.usuario.UsuarioDAO;
import br.senai.TextilTech.modelo.dao.usuario.UsuarioDAOImpl;
import br.senai.TextilTech.modelo.entidade.funcao.Funcao;
import br.senai.TextilTech.modelo.entidade.maquina.Maquina;
import br.senai.TextilTech.modelo.entidade.norma.Norma;
import br.senai.TextilTech.modelo.entidade.usuario.funcionario.Funcionario;

public class Main {

	public static void main(String[] args) {

		Funcao func01 = new Funcao("funcao 01");

		FuncaoDAO funcaoDAO = new FuncaoDAOImpl();
		funcaoDAO.inserirFuncao(func01);

		Norma norma = new Norma("Regulamento Interno", "Normas internas da empresa", LocalDate.of(2022, 1, 1),
				LocalDate.of(2022, 6, 1), LocalDate.of(2023, 1, 1), "Homologado");
		NormaDAO normaDAO = new NormaDAOImpl();
		normaDAO.inserirNorma(norma);
		
		Maquina maquina = new Maquina("Máquina XYZ", "Tipo A", "Descrição da Máquina XYZ", LocalDateTime.now(),
				LocalDateTime.now(), "Alta", "Alto");
		MaquinaDAO maquinaDAO = new MaquinaDAOImpl();
		maquinaDAO.inserirMaquina(maquina);
		maquina.inserirNorma(norma);

		Funcionario funcionario = new Funcionario("João Silva", "senha123", "Gerente de Projetos", "TI", 8500.00,
				"08:00 - 17:00");
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.inserirUsuario(funcionario);
		funcionario.inserirMaquina(maquina);

	}
}
