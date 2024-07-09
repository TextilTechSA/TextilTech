package br.senai.TextilTech;

import java.util.List;

import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAO;
import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAOImpl;
import br.senai.TextilTech.modelo.entidade.maquina.Maquina;

public class Main {

	public static void main(String[] args) {
		MaquinaDAO maquinaDAO = new MaquinaDAOImpl();

		List<Maquina> maquinas = maquinaDAO.buscarMaquinasPorNome("maquina01");
		
		for (Maquina maquina : maquinas) {
			
			System.out.println("Nome:" + maquina.getNome());
			
		}

	}
}
