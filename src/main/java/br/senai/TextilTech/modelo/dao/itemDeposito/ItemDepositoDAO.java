package br.senai.TextilTech.modelo.dao.itemDeposito;

import java.util.List;

import br.senai.TextilTech.modelo.entidade.item.deposito.ItemDeposito;

public interface ItemDepositoDAO {

	void inserirItemDeposito(ItemDeposito itemDeposito);

	void deletarItemDeposito(ItemDeposito itemDeposito);

	void atualizarItemDeposito(ItemDeposito itemDeposito);

	List<ItemDeposito> buscarItensDeposito();
}
