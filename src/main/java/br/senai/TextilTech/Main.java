package br.senai.TextilTech;

import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAO;
import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAOImpl;
import br.senai.TextilTech.modelo.entidade.funcao.Funcao;

public class Main {

	public static void main(String[] args) {
		
		Funcao func01 = new Funcao("funcao 01");
		
		FuncaoDAO funcaoDAO = new FuncaoDAOImpl();
		funcaoDAO.inserirFuncao(func01);
		

	}
}
