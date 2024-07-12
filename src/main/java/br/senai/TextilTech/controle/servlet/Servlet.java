package br.senai.TextilTech.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAO;
import br.senai.TextilTech.modelo.dao.funcao.FuncaoDAOImpl;
import br.senai.TextilTech.modelo.dao.funcionario.FuncionarioDAO;
import br.senai.TextilTech.modelo.dao.funcionario.FuncionarioDAOImpl;
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

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 4085698799982778747L;

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

	private UsuarioDAO usuarioDAO;
	private FuncaoDAO funcaoDAO;
	private FuncionarioDAO funcionarioDAO;
	private MaquinaDAO maquinaDAO;
	private NormaDAO normaDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		funcaoDAO = new FuncaoDAOImpl();
		funcionarioDAO = new FuncionarioDAOImpl();
		maquinaDAO = new MaquinaDAOImpl();
		normaDAO = new NormaDAOImpl();

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

			case "/home":
				mostrarHome(request, response);
				break;
				
			case "/home2":
				mostrarHome2(request, response);
				break;

			case "/cadastro-norma":
				mostrarCadastroNorma(request, response);
				break;

			case "/cadastro-maquina":
				mostrarCadastroMaquina(request, response);
				break;

			case "/cadastro-funcionario":
				mostrarCadastroFuncionario(request, response);
				break;

			case "/maquinas":
				mostrarMaquinas(request, response);
				break;
				
			case "/perfil-maquina":
				mostrarPerfilMaquina(request, response);
				break;

			case "/normas":
				mostrarNormas(request, response);
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

			case "/inserir-funcionario":
				inserirFuncionario(request, response);
				break;

			case "/inserir-funcao":
				inserirFuncao(request, response);
				break;

			case "/inserir-norma":
				inserirNorma(request, response);
				break;

			case "/inserir-maquina":
				inserirMaquina(request, response);
				break;
				
			case "/resultado-pesquisa-maquina":
				mostrarResultadoPesquisaMaquina(request, response);
				break;

			default:
				mostrarHome(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void mostrarHome(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/home.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarHome2(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/home2.html");
		dispatcher.forward(request, response);
	}

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/login.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroNorma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Maquina> maquinas = maquinaDAO.buscarMaquinas();
		request.setAttribute("maquinas", maquinas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/cadastro-norma.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPerfilMaquina(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Maquina maquina = maquinaDAO.buscarMaquinaPorId(Long.parseLong(request.getParameter("id")));
		request.setAttribute("maquina", maquina);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/perfil-maquina.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroMaquina(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/cadastro-maquina.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/");
		dispatcher.forward(request, response);
	}

	private void mostrarMaquinas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Maquina> maquinas = maquinaDAO.buscarMaquinas();
		request.setAttribute("maquinas", maquinas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/visualizar-maquinas.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarNormas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Norma> normas = normaDAO.buscarNormas();
		request.setAttribute("normas", normas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/visualizar-normas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarResultadoPesquisaMaquina(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Maquina> maquinas = maquinaDAO.buscarMaquinasPorNome(request.getParameter("nome"));
		request.setAttribute("maquinas", maquinas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/resultado-busca-maquinas.jsp");
		dispatcher.forward(request, response);
	}

	private void logar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		HttpSession sessao = request.getSession();
//		Usuario usuario = usuarioDAO.buscarUsuarioPorEmailESenha(email, senha);
//		sessao.setAttribute("usuario", usuario);

	}

	private void deslogar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		sessao.invalidate();
		response.sendRedirect("");
	}

	private void inserirFuncionario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String cargo = request.getParameter("cargo");
		String departamento = request.getParameter("departamento");
		Double salario = Double.parseDouble(request.getParameter("salario"));
		String horarioFuncionamento = request.getParameter("horarioFuncionamento");
		String senha = request.getParameter("senha");

		usuarioDAO.inserirUsuario(new Funcionario(nome, senha, cargo, departamento, salario, horarioFuncionamento));

		response.sendRedirect("");

	}

//	private void atualizarFuncionario(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//
//		String nome = request.getParameter("nome");
//		String cargo = request.getParameter("cargo");
//		String departamento = request.getParameter("departamento");
//		Double salario = Double.parseDouble(request.getParameter("salario"));
//		String horarioFuncionamento = request.getParameter("horarioFuncionamento");
//		String senha = request.getParameter("senha");
//
//		usuarioDAO.inserirUsuario(new Funcionario(nome, senha, cargo, departamento, salario, horarioFuncionamento));
//
//		response.sendRedirect("");
//
//	}

	private void inserirNorma(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		String descricao = request.getParameter("descricao");
		String homologacao = request.getParameter("homologacao");
		LocalDate dataAberturaNorma = LocalDate.now();

		Norma norma = new Norma(nome, tipo, descricao, dataAberturaNorma, homologacao);
		
		normaDAO.inserirNorma(norma);
		
		Maquina maquina = maquinaDAO.buscarMaquinaPorId(Long.parseLong(request.getParameter("id_maquina")));
		
		maquina.inserirNorma(norma);
		
		maquinaDAO.atualizarMaquina(maquina);

		response.sendRedirect("normas");

	}

	private void inserirMaquina(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		String descricao = request.getParameter("descricao");
		String funcionamento = request.getParameter("funcionamento");

		// Formato de tempo esperado
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		// Parse para LocalTime 
		LocalTime horarioInicioOperacao = LocalTime.parse(request.getParameter("horarioInicioOperacao"), formatter);
		LocalTime horarioFechamentoOperacao = LocalTime.parse(request.getParameter("horarioFechamentoOperacao"),
				formatter);

		String capacidadeOperacao = request.getParameter("capacidadeOperacao");
		String nivelPerigo = request.getParameter("nivelPerigo");

		// insere no banco de dados
		maquinaDAO.inserirMaquina(new Maquina(nome, tipo, descricao, funcionamento, horarioInicioOperacao, horarioFechamentoOperacao,
				capacidadeOperacao, nivelPerigo));

		response.sendRedirect("maquinas");
	}

	private void inserirFuncao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String descricao = request.getParameter("descricao");

		funcaoDAO.inserirFuncao(new Funcao(descricao));

		response.sendRedirect("");

	}
}