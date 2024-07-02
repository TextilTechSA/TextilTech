package br.senai.TextilTech;

import java.time.LocalDateTime;

import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAO;
import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAOImpl;
import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAO;
import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAOImpl;
import br.senai.TextilTech.modelo.entidade.funcao.Funcao;
import br.senai.TextilTech.modelo.entidade.maquina.Maquina;

public class Main {

	public static void main(String[] args) {
		
		Funcao func01 = new Funcao("funcao 01");
		
		FuncaoDAO funcaoDAO = new FuncaoDAOImpl();
		funcaoDAO.inserirFuncao(func01);
		
		 Maquina maquina = new Maquina("Máquina XYZ", "Tipo A", "Descrição da Máquina XYZ",
                 LocalDateTime.now(), LocalDateTime.now(), "Alta", "Alto");
		 MaquinaDAO maquinaDAO = new MaquinaDAOImpl();
		 maquinaDAO.inserirMaquina(maquina);
		

	}
}
