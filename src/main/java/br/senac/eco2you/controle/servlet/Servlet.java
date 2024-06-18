package br.senac.eco2you.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senac.eco2you.modelo.dao.armazem.ArmazemDAO;
import br.senac.eco2you.modelo.dao.armazem.ArmazemDAOImpl;
import br.senac.eco2you.modelo.dao.coletor.ColetorDAO;
import br.senac.eco2you.modelo.dao.coletor.ColetorDAOImpl;
import br.senac.eco2you.modelo.dao.conquista.ConquistaDAO;
import br.senac.eco2you.modelo.dao.conquista.ConquistaDAOImpl;
import br.senac.eco2you.modelo.dao.deposito.DepositoDAO;
import br.senac.eco2you.modelo.dao.deposito.DepositoDAOImpl;
import br.senac.eco2you.modelo.dao.endereco.EnderecoDAO;
import br.senac.eco2you.modelo.dao.endereco.EnderecoDAOImpl;
import br.senac.eco2you.modelo.dao.itemDeposito.ItemDepositoDAO;
import br.senac.eco2you.modelo.dao.itemDeposito.ItemDepositoDAOImpl;
import br.senac.eco2you.modelo.dao.itemRetirada.ItemRetiradaDAO;
import br.senac.eco2you.modelo.dao.itemRetirada.ItemRetiradaDAOImpl;
import br.senac.eco2you.modelo.dao.material.MaterialDAO;
import br.senac.eco2you.modelo.dao.material.MaterialDAOImpl;
import br.senac.eco2you.modelo.dao.reciclavel.ReciclavelDAO;
import br.senac.eco2you.modelo.dao.reciclavel.ReciclavelDAOImpl;
import br.senac.eco2you.modelo.dao.retirada.RetiradaDAO;
import br.senac.eco2you.modelo.dao.retirada.RetiradaDAOImpl;
import br.senac.eco2you.modelo.dao.usuario.UsuarioDAO;
import br.senac.eco2you.modelo.dao.usuario.UsuarioDAOImpl;
import br.senac.eco2you.modelo.entidade.conquista.Conquista;
import br.senac.eco2you.modelo.entidade.deposito.Deposito;
import br.senac.eco2you.modelo.entidade.endereco.Endereco;
import br.senac.eco2you.modelo.entidade.item.deposito.ItemDeposito;
import br.senac.eco2you.modelo.entidade.item.retirada.ItemRetirada;
import br.senac.eco2you.modelo.entidade.material.Material;
import br.senac.eco2you.modelo.entidade.reciclavel.Reciclavel;
import br.senac.eco2you.modelo.entidade.retirada.Retirada;
import br.senac.eco2you.modelo.entidade.usuario.Usuario;
import br.senac.eco2you.modelo.entidade.usuario.empresa.armazem.Armazem;
import br.senac.eco2you.modelo.entidade.usuario.empresa.cooperativa.Cooperativa;
import br.senac.eco2you.modelo.entidade.usuario.pessoa.coletor.Coletor;
import br.senac.eco2you.modelo.enumeracao.status.deposito.StatusDeposito;
import br.senac.eco2you.modelo.enumeracao.status.retirada.StatusRetirada;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 8840029940617992062L;

	private UsuarioDAO usuarioDAO;
	private EnderecoDAO enderecoDAO;
	private MaterialDAO materialDAO;
	private ReciclavelDAO reciclavelDAO;
	private ItemDepositoDAO itemDepositoDAO;
	private DepositoDAO depositoDAO;
	private ConquistaDAO conquistaDAO;
	private ArmazemDAO armazemDAO;
	private RetiradaDAO retiradaDAO;
	private ItemRetiradaDAO itemRetiradaDAO;
	private ColetorDAO coletorDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		materialDAO = new MaterialDAOImpl();
		reciclavelDAO = new ReciclavelDAOImpl();
		itemDepositoDAO = new ItemDepositoDAOImpl();
		depositoDAO = new DepositoDAOImpl();
		conquistaDAO = new ConquistaDAOImpl();
		armazemDAO = new ArmazemDAOImpl();
		retiradaDAO = new RetiradaDAOImpl();
		itemRetiradaDAO = new ItemRetiradaDAOImpl();
		coletorDAO = new ColetorDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {

			switch (action) {

			case "/landing-page":
				mostrarLandingPage(request, response);
				break;

			case "/login":
				mostrarLogin(request, response);
				break;

			case "/logar":
				logar(request, response);
				break;

			case "/deslogar":
				deslogar(request, response);
				break;

			case "/cadastro-coletor":
				mostrarCadastroColetor(request, response);
				break;
				
			case "/cadastro-armazem":
				mostrarCadastroArmazem(request, response);
				break;
			
			case "/cadastro-cooperativa":
				mostrarCadastroCooperativa(request, response);
				break;
				
			case "/inserir-coletor":
				inserirColetor(request, response);
				break;
				
			case "/inserir-armazem":
				inserirArmazem(request, response);
				break;
				
			case "/inserir-cooperativa":
				inserirCooperativa(request, response);
				break;
				
			case "/atualizar-coletor":
				atualizarColetor(request, response);
				break;

			case "/atualizar-armazem":
				atualizarArmazem(request, response);
				break;
				
			case "/atualizar-cooperativa":
				atualizarCooperativa(request, response);
				break;
				
			case "/deletar-coletor":
				deletarColetor(request, response);
				break;

			case "/deletar-armazem":
				deletarArmazem(request, response);
				break;
				
			case "/deletar-cooperativa":
				deletarCooperativa(request, response);
				break;

			case "/perfil-coletor":
				mostrarPerfilColetor(request, response);
				break;

			case "/perfil-armazem":
				mostrarPerfilArmazem(request, response);
				break;

			case "/perfil-cooperativa":
				mostrarPerfilCooperativa(request, response);
				break;
				
			case "/inserir-deposito":
				inserirDeposito(request, response);
				break;
				
			case "/inserir-retirada":
				inserirRetirada(request, response);
				break;
				
			case "/inserir-material":
				inserirMaterial(request, response);
				break;
				
			case "/inserir-reciclavel":
				inserirReciclavel(request, response);
				break;

			case "/atualizar-deposito":
				atualizarStatusDeposito(request, response);
				break;
				
			case "/atualizar-informacoes-deposito":
				atualizarDeposito(request, response);
				break;
				
			case "/atualizar-retirada":
				atualizarStatusRetirada(request, response);
				break;
			
			case "/atualizar-material":
				atualizarMaterial(request, response);
				break;
				
			case "/atualizar-reciclavel":
				atualizarReciclavel(request, response);
				break;

			case "/deletar-deposito":
				deletarDeposito(request, response);
				break;	
				
			case "/deletar-retirada":
				deletarRetirada(request, response);
				break;	
				
			case "/deletar-material":
				deletarMaterial(request, response);
				break;
		
//			case "/deletar-reciclavel":
//				deletarReciclavel(request, response);
//				break;

			case "/historico-depositos-coletor":
				mostrarHistoricoDepositosColetor(request, response);
				break;

			case "/historico-depositos-armazem":
				mostrarHistoricoDepositosArmazem(request, response);
				break;

			case "/historico-retiradas-armazem":
				mostrarHistoricoRetiradasArmazem(request, response);
				break;

			case "/historico-retiradas-cooperativa":
				mostrarHistoricoRetiradasCooperativa(request, response);
				break;

			case "/depositos-pendentes-coletor":
				mostrarDepositosPendentesColetor(request, response);
				break;

			case "/depositos-pendentes-armazem":
				mostrarDepositosPendentesArmazem(request, response);
				break;

			case "/editar-deposito":
				mostrarEditarDeposito(request, response);
				break;

			case "/retiradas-pendentes-armazem":
				mostrarRetiradasPendentesArmazem(request, response);
				break;

			case "/retiradas-pendentes-cooperativa":
				mostrarRetiradasPendentesCooperativa(request, response);
				break;

			case "/editar-perfil-coletor":
				mostrarEditarPerfilColetor(request, response);
				break;

			case "/editar-perfil-armazem":
				mostrarEditarPerfilArmazem(request, response);
				break;

			case "/editar-perfil-cooperativa":
				mostrarEditarPerfilCooperativa(request, response);
				break;

			case "/cadastro-material":
				mostrarCadastroMaterial(request, response);
				break;
				
			case "/cadastro-reciclavel":
				mostrarCadastroReciclavel(request, response);
				break;

			case "/cadastro-item-deposito":
				mostrarCadastroItemDeposito(request, response);
				break;

			case "/cadastro-deposito":
				mostrarCadastroDeposito(request, response);
				break;

			case "/cadastro-retirada":
				mostrarCadastroRetirada(request, response);
				break;
		
			case "/informacoes-retirada":
				mostrarInformacoesRetirada(request, response);
				break;

			case "/cadastro-conquista":
				mostrarCadastroConquista(request, response);
				break;

			case "/inserir-conquista":
				inserirConquista(request, response);
				break;

			case "/recuperar-senha":
				mostrarRecuperarSenha(request, response);
				break;

			case "/procurar-armazem":
				mostrarProcurarArmazemColetor(request, response);
				break;

			case "/procurar-armazem-cooperativa":
				mostrarProcurarArmazemCooperativa(request, response);
				break;	
				
			case "/resultado-procurar-armazem":
				resultadoProcurarArmazem(request, response);
				break;

			case "/procurar-coletor":
				mostrarProcurarColetor(request, response);
				break;

			case "/resultado-procurar-coletor":
				resultadoProcurarColetor(request, response);
				break;

			case "/perfil-externo-coletor":
				mostrarPerfilExternoColetor(request, response);
				break;

			case "/perfil-externo-armazem":
				mostrarPerfilExternoArmazem(request, response);
				break;

			default:
				mostrarLandingPage(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarLandingPage(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/landing-page.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/cadastro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Coletor) {

			Coletor coletor = (Coletor) sessao.getAttribute("usuario");
			request.setAttribute("coletor", coletor);
			
			List<Deposito> deposito = depositoDAO.buscarProximosDepositos(StatusDeposito.AGENDADO, LocalDate.now(), coletor.getId());
			request.setAttribute("deposito", deposito);
			
			List<Coletor> coletores = coletorDAO.buscarTop10Coletores();
			request.setAttribute("coletores", coletores);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/perfil.jsp");
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void mostrarHistoricoDepositosColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();

		Coletor coletor = (Coletor) sessao.getAttribute("usuario");
		request.setAttribute("coletor", coletor);

		List<Deposito> depositos = depositoDAO.buscarDepositosPeloStatusEColetor(StatusDeposito.CONCLUIDO, coletor.getId());
		request.setAttribute("depositos", depositos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/historico-depositos.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarEditarDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Deposito deposito = depositoDAO.buscarDepositoComItemDepositoPorIdEStatusDeposito(Long.parseLong(request.getParameter("id")), StatusDeposito.PENDENTE);
		request.setAttribute("deposito", deposito);
		
		List<Armazem> armazens = armazemDAO.buscarArmazens();
		request.setAttribute("armazens", armazens);

		List<Reciclavel> reciclaveis = reciclavelDAO.buscarReciclaveis();
		request.setAttribute("reciclaveis", reciclaveis);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/informacoes-deposito.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarInformacoesRetirada(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Deposito deposito = depositoDAO
				.buscarDepositoComItemDepositoPorId((Long.parseLong(request.getAttribute("id").toString())));
		request.setAttribute("deposito", deposito);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/informacoes-deposito.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarHistoricoDepositosArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Armazem armazem = (Armazem) sessao.getAttribute("usuario");
		
		List<Deposito> depositos= depositoDAO.buscarDepositosPeloStatusEArmazem(StatusDeposito.CONCLUIDO, armazem.getId());
		request.setAttribute("depositos", depositos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/armazem/historico-deposito.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarHistoricoRetiradasArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/armazem/historico-retirada.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarHistoricoRetiradasCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Cooperativa cooperativa = (Cooperativa) sessao.getAttribute("usuario");
		
		List<Retirada> retiradas= retiradaDAO.buscarRetiradasPeloStatusECooperativa(StatusRetirada.CONCLUIDO, cooperativa.getId());
		request.setAttribute("retiradas", retiradas);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/cooperativa/historico-retiradas.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarDepositosPendentesColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Coletor) {

			Coletor coletor = (Coletor) sessao.getAttribute("usuario");
			request.setAttribute("coletor", coletor);
			
			List<Deposito> depositosAgendados= depositoDAO.buscarDepositosPeloStatusEColetor(StatusDeposito.AGENDADO, coletor.getId());
			request.setAttribute("depositosAgendados", depositosAgendados);
			
			List<Deposito> depositosPendentes = depositoDAO.buscarDepositosPeloStatusEColetor(StatusDeposito.PENDENTE, coletor.getId());
			request.setAttribute("depositosPendentes", depositosPendentes);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/depositos-pendentes.jsp");
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void mostrarRetiradasPendentesCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Cooperativa) {

			Cooperativa cooperativa = (Cooperativa) sessao.getAttribute("usuario");
			request.setAttribute("cooperativa", cooperativa);
			
			List<Retirada> retiradasAgendadas= retiradaDAO.buscarRetiradasPeloStatusECooperativa(StatusRetirada.AGENDADO, cooperativa.getId());
			request.setAttribute("retiradasAgendadas", retiradasAgendadas);
			
			List<Retirada> retiradasPendentes = retiradaDAO.buscarRetiradasPeloStatusECooperativa(StatusRetirada.PENDENTE, cooperativa.getId());
			request.setAttribute("retiradasPendentes", retiradasPendentes);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cooperativa/retiradas-pendentes.jsp");
			dispatcher.forward(request, response);

		} else {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);
		
		}
	}

	private void mostrarDepositosPendentesArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Armazem) {

			Armazem armazem = (Armazem) sessao.getAttribute("usuario");
			request.setAttribute("armazem", armazem);
			
			List<Deposito> depositosAgendados= depositoDAO.buscarDepositosPeloStatusEArmazem(StatusDeposito.AGENDADO, armazem.getId());
			request.setAttribute("depositosAgendados", depositosAgendados);
			
			List<Deposito> depositosPendentes = depositoDAO.buscarDepositosPeloStatusEArmazem(StatusDeposito.PENDENTE, armazem.getId());
			request.setAttribute("depositosPendentes", depositosPendentes);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/armazem/depositos-pendentes.jsp");
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void mostrarRetiradasPendentesArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Armazem) {

			Armazem armazem = (Armazem) sessao.getAttribute("usuario");
			request.setAttribute("armazem", armazem);
			
			List<Retirada> retiradasAgendadas= retiradaDAO.buscarRetiradasPeloStatusEArmazem(StatusRetirada.AGENDADO, armazem.getId());
			request.setAttribute("retiradasAgendadas", retiradasAgendadas);
			
			List<Retirada> retiradasPendentes = retiradaDAO.buscarRetiradasPeloStatusEArmazem(StatusRetirada.PENDENTE, armazem.getId());
			request.setAttribute("retiradasPendentes", retiradasPendentes);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/armazem/retiradas-pendentes.jsp");
			dispatcher.forward(request, response);

		} else {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);
		
		}

	}

	private void mostrarEditarPerfilColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Coletor coletor = (Coletor) sessao.getAttribute("usuario");
		request.setAttribute("coletor", coletor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/editar-perfil.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarEditarPerfilArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Armazem armazem = (Armazem) sessao.getAttribute("usuario");
		request.setAttribute("armazem", armazem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/armazem/editar-perfil.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarEditarPerfilCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Cooperativa cooperativa = (Cooperativa) sessao.getAttribute("usuario");
		request.setAttribute("cooperativa", cooperativa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cooperativa/editar-perfil.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/armazem/cadastro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();

		Armazem armazem = (Armazem) sessao.getAttribute("usuario");
		request.setAttribute("armazem", armazem);

		List<Deposito> depositos = depositoDAO.buscarProximosDepositos(StatusDeposito.AGENDADO , LocalDate.now(), armazem.getId());
		request.setAttribute("depositos", depositos);

		List<Retirada> retiradas = retiradaDAO.buscarProximasRetiradas(StatusRetirada.AGENDADO, LocalDate.now(), armazem.getId());
		request.setAttribute("retiradas", retiradas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/armazem/perfil.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cooperativa/cadastro.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (usuario instanceof Cooperativa) {

			Cooperativa cooperativa = (Cooperativa) sessao.getAttribute("usuario");
			request.setAttribute("cooperativa", cooperativa);
			
			List<Retirada> retirada = retiradaDAO.buscarProximasRetiradas(StatusRetirada.AGENDADO, LocalDate.now(), cooperativa.getId());
			request.setAttribute("retirada", retirada);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cooperativa/perfil.jsp");
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void mostrarCadastroMaterial(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/administrador/cadastro-material.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroReciclavel(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Material> materiais = materialDAO.buscarMateriais();
		request.setAttribute("materiais", materiais);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/administrador/cadastro-reciclavel.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroItemDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Reciclavel> reciclaveis = reciclavelDAO.buscarReciclaveis();
		request.setAttribute("reciclaveis", reciclaveis);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-item-deposito.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao != null && usuario instanceof Coletor) {
			
			Long id = (Long) sessao.getAttribute("id");
				
			Armazem armazem = (Armazem) usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));
			request.setAttribute("armazem", armazem);
	
			Armazem armazemId = (Armazem) usuarioDAO.buscarUsuarioPorId(id);
			request.setAttribute("armazemId", armazemId);

			List<Reciclavel> reciclaveis = reciclavelDAO.buscarReciclaveis();
			request.setAttribute("reciclaveis", reciclaveis);

			List<Armazem> armazens = armazemDAO.buscarArmazens();
			request.setAttribute("armazens", armazens);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/cadastro-deposito.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void mostrarCadastroRetirada(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		if (sessao != null && usuario instanceof Cooperativa) {

			List<Armazem> armazens = armazemDAO.buscarArmazens();
			request.setAttribute("armazens", armazens);
			
			List<Material> materiais = materialDAO.buscarMateriais();
			request.setAttribute("materiais", materiais);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cooperativa/cadastro-retirada.jsp");
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void mostrarCadastroConquista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/administrador/cadastro-conquista.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarRecuperarSenha(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/recuperar-senha.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarProcurarArmazemColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Coletor coletor = (Coletor) sessao.getAttribute("usuario");
		request.setAttribute("coletor", coletor);
		
		List<Armazem> armazens = armazemDAO.buscarArmazens();
		request.setAttribute("armazens", armazens);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/procurar-armazem.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarProcurarArmazemCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Cooperativa cooperativa = (Cooperativa) sessao.getAttribute("usuario");
		request.setAttribute("cooperativa", cooperativa);

		List<Armazem> armazens = armazemDAO.buscarArmazens();
		request.setAttribute("armazens", armazens);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cooperativa/procurar-armazem.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarProcurarColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Coletor> coletores = coletorDAO.buscarColetores();
		request.setAttribute("coletores", coletores);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/procurar-coletor.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilExternoColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Coletor coletor = (Coletor) usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));
		request.setAttribute("coletor", coletor);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/coletor/perfil-externo-coletor.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarPerfilExternoArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Armazem armazem = (Armazem) usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));
		request.setAttribute("armazem", armazem);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/coletor/perfil-externo-armazem.jsp");
		dispatcher.forward(request, response);
	}

	private void logar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		HttpSession sessao = request.getSession();
		Usuario usuario = usuarioDAO.buscarUsuarioPorEmailESenha(email, senha);
		sessao.setAttribute("usuario", usuario);

		if (usuario instanceof Coletor) {
			Coletor coletor = (Coletor) usuarioDAO.recuperarUsuarioComEnderecoPorId(usuario.getId());
			response.sendRedirect("/eCO2You/perfil-coletor");
			request.setAttribute("coletor", coletor);

		} else if (usuario instanceof Armazem) {
			Armazem armazem = (Armazem) usuarioDAO.recuperarUsuarioComEnderecoPorId(usuario.getId());
			response.sendRedirect("/eCO2You/perfil-armazem");
			request.setAttribute("armazem", armazem);

		} else if (usuario instanceof Cooperativa) {
			Cooperativa cooperativa = (Cooperativa) usuarioDAO.recuperarUsuarioComEnderecoPorId(usuario.getId());
			response.sendRedirect("/eCO2You/perfil-cooperativa");
			request.setAttribute("cooperativa", cooperativa);

		} else {
			response.sendRedirect("/eCO2You/login");

		}
	}

	private void deslogar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		sessao.invalidate();
		response.sendRedirect("/eCO2You/landing-page");
	}

	private void inserirColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("dataNascimento"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String tipoVia = request.getParameter("tipoVia");
		String logradouro = request.getParameter("logradouro");
		String numeroEndereco = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Endereco endereco = new Endereco(cep, cidade, bairro, tipoVia, logradouro, numeroEndereco, complemento, telefone);
		enderecoDAO.inserirEndereco(endereco);
		usuarioDAO.inserirUsuario(new Coletor(nome, sobrenome, cpf, dataNascimento, email, senha, endereco, 0));

		response.sendRedirect("/eCO2You/login");

	}

	private void atualizarColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();

		Coletor coletor = (Coletor) request.getSession().getAttribute("usuario");
		Long id = coletor.getId();
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		LocalDate dataNascimento = LocalDate.of(2000, 4, 12);
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String tipoVia = request.getParameter("tipoVia");
		String logradouro = request.getParameter("logradouro");
		String numeroEndereco = request.getParameter("numeroEndereco");
		String complemento = request.getParameter("complemento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		int pontos = 0;
		Endereco endereco = new Endereco(cep, cidade, bairro, tipoVia, logradouro, numeroEndereco, complemento,
				telefone);
		enderecoDAO.atualizarEndereco(endereco);
		usuarioDAO.atualizarUsuario(new Coletor(id, nome, sobrenome, cpf, dataNascimento, email, senha, endereco, pontos));

		Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
		sessao.setAttribute("usuario", usuario);

		response.sendRedirect("/eCO2You/perfil-coletor");
	}

	private void deletarColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Coletor coletor = (Coletor) request.getSession().getAttribute("usuario");
		Long id = coletor.getId();
		Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
		usuarioDAO.deletarUsuario(usuario);
		response.sendRedirect("eCO2You/");

	}

	private void inserirArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		float capacidadeArmazenagem = Float.parseFloat(request.getParameter("capacidadeArmazenagem"));
		LocalTime horarioAbertura = LocalTime.parse(request.getParameter("horarioAbertura"));
		LocalTime horarioFechamento = LocalTime.parse(request.getParameter("horarioFechamento"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String tipoVia = request.getParameter("tipoVia");
		String logradouro = request.getParameter("logradouro");
		String numeroEndereco = request.getParameter("numeroEndereco");
		String complemento = request.getParameter("complemento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Endereco endereco = new Endereco(cep, cidade, bairro, tipoVia, logradouro, numeroEndereco, complemento,
				telefone);
		enderecoDAO.inserirEndereco(endereco);
		usuarioDAO.inserirUsuario(new Armazem(nome, cnpj, email, senha, capacidadeArmazenagem, horarioAbertura,
				horarioFechamento, endereco));

		response.sendRedirect("/eCO2You/login");
	}

	private void atualizarArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();

		Armazem armazem = (Armazem) request.getSession().getAttribute("usuario");
		Long id = armazem.getId();
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		float capacidadeArmazenagem = Float.parseFloat(request.getParameter("capacidadeArmazenagem"));
		LocalTime horarioAbertura = LocalTime.parse(request.getParameter("horarioAbertura"));
		LocalTime horarioFechamento = LocalTime.parse(request.getParameter("horarioFechamento"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String tipoVia = request.getParameter("tipoVia");
		String logradouro = request.getParameter("logradouro");
		String numeroEndereco = request.getParameter("numeroEndereco");
		String complemento = request.getParameter("complemento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Endereco endereco = new Endereco(cep, cidade, bairro, tipoVia, logradouro, numeroEndereco, complemento,
				telefone);
		enderecoDAO.atualizarEndereco(endereco);
		usuarioDAO.atualizarUsuario(new Armazem(id, nome, cnpj, email, senha, capacidadeArmazenagem, horarioAbertura,
				horarioFechamento, endereco));

		Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
		sessao.setAttribute("usuario", usuario);

		response.sendRedirect("/eCO2You/home-armazem");
	}

	private void deletarArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Armazem armazem = (Armazem) request.getSession().getAttribute("usuario");
		Long id = armazem.getId();
		Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
		usuarioDAO.deletarUsuario(usuario);
		response.sendRedirect("eCO2You/");

	}

	private void inserirCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		LocalTime horarioAbertura = LocalTime.parse(request.getParameter("horarioAbertura"));
		LocalTime horarioFechamento = LocalTime.parse(request.getParameter("horarioFechamento"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String tipoVia = request.getParameter("tipoVia");
		String logradouro = request.getParameter("logradouro");
		String numeroEndereco = request.getParameter("numeroEndereco");
		String complemento = request.getParameter("complemento");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Endereco endereco = new Endereco(cep, cidade, bairro, tipoVia, logradouro, numeroEndereco, complemento,
				telefone);
		enderecoDAO.inserirEndereco(endereco);
		usuarioDAO.inserirUsuario(
				new Cooperativa(nome, cnpj, horarioFechamento, horarioAbertura, endereco, email, senha));

		response.sendRedirect("/eCO2You/login");
	}

	private void atualizarCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();

		Cooperativa cooperativa = (Cooperativa) request.getSession().getAttribute("usuario");
		Long id = cooperativa.getId();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cnpj = request.getParameter("cnpj");
		String senha = request.getParameter("senha");
		LocalTime horarioAbertura = LocalTime.parse(request.getParameter("horarioAbertura"));
		LocalTime horarioFechamento = LocalTime.parse(request.getParameter("horarioFechamento"));
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String tipoVia = request.getParameter("tipoVia");
		String logradouro = request.getParameter("logradouro");
		String numeroEndereco = request.getParameter("numeroEndereco");
		String complemento = request.getParameter("complemento");
		String telefone = request.getParameter("telefone");
		Endereco endereco = new Endereco(cep, cidade, bairro, tipoVia, logradouro, numeroEndereco, complemento,
				telefone);
		enderecoDAO.atualizarEndereco(endereco);
		usuarioDAO.atualizarUsuario(
				new Cooperativa(id, nome, cnpj, horarioAbertura, horarioFechamento, endereco, email, senha));

		Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
		sessao.setAttribute("usuario", usuario);

		response.sendRedirect("/eCO2You/perfil-cooperativa");
	}

	private void deletarCooperativa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		Cooperativa cooperativa = (Cooperativa) request.getSession().getAttribute("usuario");
		Long id = cooperativa.getId();
		Usuario usuario = usuarioDAO.buscarUsuarioPorId(id);
		usuarioDAO.deletarUsuario(usuario);
		response.sendRedirect("eCO2You/");

	}

	private void inserirMaterial(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		materialDAO.inserirMaterial(new Material(nome));
		response.sendRedirect("landing-page");
	}

	private void atualizarMaterial(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		materialDAO.atualizarMaterial(new Material(id, nome));
		response.sendRedirect("/home");
	}

	private void deletarMaterial(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Material material = materialDAO.buscarMaterialPorId(id);
		materialDAO.deletarMaterial(material);
		response.sendRedirect("/home");

	}

	private void inserirReciclavel(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		Material material = materialDAO.buscarMaterialPorId(Long.parseLong(request.getParameter("material")));
		int pontosCarbono = Integer.parseInt(request.getParameter("pontos-carbono"));
		float peso = Float.parseFloat(request.getParameter("peso"));
		float volume = Float.parseFloat(request.getParameter("volume"));
		String instrucaoReciclavel = request.getParameter("instrucao-reciclavel");
		reciclavelDAO
				.inserirReciclavel(new Reciclavel(nome, material, pontosCarbono, peso, volume, instrucaoReciclavel));
		response.sendRedirect("landing-page");
	}

	private void atualizarReciclavel(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		Material material = materialDAO.buscarMaterialPorId(Long.parseLong(request.getParameter("material")));
		int pontosCarbono = Integer.parseInt(request.getParameter("pontosCarbono"));
		float peso = Float.parseFloat(request.getParameter("peso"));
		float volume = Float.parseFloat(request.getParameter("volume"));
		String instrucaoReciclavel = request.getParameter("instrucaoReciclavel");
		reciclavelDAO.atualizarReciclavel(
				new Reciclavel(id, nome, material, pontosCarbono, peso, volume, instrucaoReciclavel));

	}

	private void inserirDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Coletor coletor = (Coletor) request.getSession().getAttribute("usuario");

		Reciclavel reciclavel = reciclavelDAO.buscarReciclavelPorId(Long.parseLong(request.getParameter("reciclavel")));

		Armazem armazem = (Armazem) usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));

		LocalDate data = LocalDate.parse(request.getParameter("data"));
		Deposito deposito = new Deposito(armazem, coletor, StatusDeposito.PENDENTE, data);
		depositoDAO.inserirDeposito(deposito);

		int quantidadeReciclavel = Integer.parseInt(request.getParameter("quantidade-reciclavel"));
		itemDepositoDAO.inserirItemDeposito(new ItemDeposito(reciclavel, quantidadeReciclavel));
		deposito.inserirItemDeposito(new ItemDeposito(reciclavel, quantidadeReciclavel));
		response.sendRedirect("perfil-coletor");

	}
	
	private void atualizarDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();

		Long id = Long.parseLong(request.getParameter("id"));
		
		Coletor coletor = (Coletor) sessao.getAttribute("usuario");
		
		LocalDate data = LocalDate.parse(request.getParameter("data"));
		
		Armazem armazem = armazemDAO.buscarArmazemPorId(Long.parseLong(request.getParameter("idArmazem")));
		
		Reciclavel reciclavel = reciclavelDAO.buscarReciclavelPorId(Long.parseLong(request.getParameter("idReciclavel")));
		
		int quantidadeReciclaveis = Integer.parseInt(request.getParameter("quantidadeReciclaveis"));
		
		Deposito deposito = new Deposito (id, armazem, coletor, StatusDeposito.PENDENTE, data );
		
		response.sendRedirect("depositos-pendentes-armazem");
	}

	private void atualizarStatusDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		Coletor coletor = coletorDAO.buscarColetorPeloId(Long.parseLong(request.getParameter("coletor_id")));

		StatusDeposito status = StatusDeposito.valueOf(request.getParameter("status"));
		
		int pontos = coletor.getPontos();
		
		if (StatusDeposito.CONCLUIDO.equals(status)) {			
			pontos += 1;			
		}
		
		coletor.setPontos(pontos);
		usuarioDAO.atualizarUsuario(coletor);
		
		Deposito deposito = depositoDAO.buscarDepositoPeloId(Long.parseLong(request.getParameter("id")));		
		deposito.setStatusDeDeposito(status);
		depositoDAO.atualizarDeposito(deposito);
		
		response.sendRedirect("depositos-pendentes-armazem");

	}

	private void deletarDeposito(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Deposito deposito = depositoDAO.buscarDepositoPeloId(id);
		depositoDAO.deletarDeposito(deposito);
		response.sendRedirect("depositos-pendentes-armazem");

	}
	
	private void deletarRetirada(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		long id = Long.parseLong(request.getParameter("id"));
		Retirada retirada = retiradaDAO.buscarRetiradaPeloId(id);
		retiradaDAO.deletarRetirada(retirada);
		response.sendRedirect("retiradas-pendentes-armazem");

	}

	private void inserirRetirada(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Cooperativa cooperativa = (Cooperativa) request.getSession().getAttribute("usuario");
		LocalDate data = LocalDate.parse(request.getParameter("data"));
		Armazem armazem = (Armazem) usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));
		
		Material material = materialDAO.buscarMaterialPorId(Long.parseLong(request.getParameter("material")));
		float peso = Float.parseFloat(request.getParameter("peso"));
		
		ItemRetirada itemRetirada = new ItemRetirada(material, peso);
		itemRetiradaDAO.inserirItemRetirada(itemRetirada);
		retiradaDAO.inserirRetirada(new Retirada(data, cooperativa, armazem, StatusRetirada.PENDENTE, itemRetirada));

		response.sendRedirect("perfil-cooperativa");

	}

	private void atualizarStatusRetirada(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Retirada retirada = retiradaDAO.buscarRetiradaPeloId(Long.parseLong(request.getParameter("id")));
		StatusRetirada status = StatusRetirada.valueOf(request.getParameter("status"));
		retirada.setStatusDeRetirada(status);
		retiradaDAO.atualizarRetirada(retirada);
		
		response.sendRedirect("retiradas-pendentes-armazem");
	}

	private void inserirConquista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		int pontos = Integer.parseInt(request.getParameter("pontos"));
		String descricao = request.getParameter("descricao");
		conquistaDAO.inserirConquista(new Conquista(nome, pontos, descricao));
		response.sendRedirect("landing-page");
	}

	public void resultadoProcurarArmazem(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Armazem> armazens = armazemDAO.buscarArmazensPorNome(request.getParameter("pesquisar"));
		request.setAttribute("armazens", armazens);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/procurar-armazem.jsp");
		dispatcher.forward(request, response);

	}

	public void resultadoProcurarColetor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Coletor> coletores = coletorDAO.buscarListaColetorPeloNomeParcial(request.getParameter("pesquisar"));
		request.setAttribute("coletores", coletores);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/coletor/procurar-coletor.jsp");
		dispatcher.forward(request, response);

	}

}