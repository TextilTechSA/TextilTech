package br.senac.eco2you.modelo.dao.deposito;

import java.time.LocalDate;
import java.util.List;

import br.senac.eco2you.modelo.entidade.deposito.Deposito;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor;
import br.senac.eco2you.modelo.enumeracao.status.deposito.StatusDeposito;

public interface DepositoDAO {

	void inserirDeposito(Deposito deposito);
 
    void deletarDeposito(Deposito deposito);
 
    void atualizarDeposito(Deposito deposito);
 
    List<Deposito> buscarDepositos();
 
    List<Deposito> buscarDepositoPeloStatusDeposito(StatusDeposito statusDeDeposito);
 
    List<Deposito> buscarDepositoPelaData(LocalDate data);
    
    Deposito buscarDepositoPeloId(Long id);
 
    List<Deposito> buscarDepositoPeloArmazem(String nome);
    
    List<Deposito> buscarDepositoPeloArmazem(Armazem armazem);
 
    List<Deposito> buscarDepositoPeloArmazemEColetor(String nomeDoArmazem, String nomeDoColetor);

	List<Deposito> buscarDepositoPeloArmazemEColetorEStatus(String nomeDoArmazem, String nomeDoColetor, StatusDeposito status);

	List<Deposito> buscarDepositoPeloArmazemEColetorEData(String nomeDoColetor, String nomeDoArmazem, LocalDate data);
  
    List<Deposito> buscarDepositoPeloColetor(Coletor coletor);
    
    List<Deposito> buscarDepositoPeloColetorEArmazem(String nomeDoColetor, String nomeDoArmazem);
 
    List<Deposito> buscarDepositoPeloColetorEArmazemEStatus(String nomeDoColetor, String nomeDoArmazem, StatusDeposito status);
    
    List<Deposito> buscarDepositoPeloColetorEArmazemEData(String nomeDoColetor, String nomeDoArmazem, LocalDate data);
    
    List<Deposito> buscarProximosDepositos(StatusDeposito statusDeposito, LocalDate data, Long id);
    
    List<Deposito> buscarDepositosPeloStatusEColetor(StatusDeposito statusDeposito, Long id);
    
    List<Deposito> buscarDepositosPeloStatusEArmazem(StatusDeposito statusDeposito, Long id);

	Deposito buscarDepositoComItemDepositoPorId(Long id);
	
	Deposito buscarDepositoComItemDepositoPorIdEStatusDeposito(Long id, StatusDeposito statusDeposito);


}
