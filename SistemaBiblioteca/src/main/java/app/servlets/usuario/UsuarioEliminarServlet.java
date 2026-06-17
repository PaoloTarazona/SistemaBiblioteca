package app.servlets.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.UsuarioDAO;

@WebServlet("/Inicio/Usuario/Eliminar")
public class UsuarioEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UsuarioEliminarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.eliminarPorId(id);
		response.sendRedirect(request.getContextPath() + "/Inicio/Usuario/Buscar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
