package br.senac.eco2you.modelo.dao.material;

import java.util.List;

import br.senac.eco2you.modelo.entidade.material.Material;

public interface MaterialDAO {

	void inserirMaterial(Material material);

	void deletarMaterial(Material material);

	void atualizarMaterial(Material material);
	
	List<Material> buscarMateriais();
	
	Material buscarMaterialPorId(long id);
}
