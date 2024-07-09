package br.senai.TextilTech;

import java.util.List;
import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAO;
import br.senai.TextilTech.modelo.dao.maquina.MaquinaDAOImpl;
import br.senai.TextilTech.modelo.entidade.maquina.Maquina;

public class Main {

    public static void main(String[] args) {
        MaquinaDAO maquinaDAO = new MaquinaDAOImpl();
        List<Maquina> maquinas = maquinaDAO.buscarMaquinas();

        // Exibindo no console
        for (Maquina maquina : maquinas) {
            System.out.println("Nome: " + maquina.getNome());
            System.out.println("Tipo: " + maquina.getTipo());
            System.out.println("Descrição: " + maquina.getDescricao());
            System.out.println("Horário Início Operação: " + maquina.getHorarioInicioOperacao());
            System.out.println("Horário Fechamento Operação: " + maquina.getHorarioFechamentoOperacao());
            System.out.println("Capacidade Operação: " + maquina.getCapacidadeOperacao());
            System.out.println("Nível Perigo: " + maquina.getNivelPerigo());
            System.out.println();
        }
    }
}

