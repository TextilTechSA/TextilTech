package br.senai.TextilTech.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.TextilTech.modelo.dao.usuario.UsuarioDAO;
import br.senai.TextilTech.modelo.dao.usuario.UsuarioDAOImpl;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 8840029940617992062L;

	private UsuarioDAO usuarioDAO;


	public void init() {
		usuarioDAO = new UsuarioDAOImpl();

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

	

}