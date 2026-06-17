package app.servlets.usuario;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.data.UsuarioDAO;
import app.modelos.Usuario;

@WebServlet("/Inicio/Usuario/Buscar")
public class UsuarioBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
       
    public UsuarioBuscarServlet() {
        super();
        usuarioDAO = new UsuarioDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("usuario", new ArrayList<Usuario>());
		request.getRequestDispatcher("/WEB-INF/usuario/buscar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioBuscar = request.getParameter("txtUsuario");
		request.setAttribute("usuarios", usuarioDAO.buscarPorRol(usuarioBuscar));
		request.setAttribute("usuarioBuscar", usuarioBuscar);
		request.getRequestDispatcher("/WEB-INF/usuario/buscar.jsp").forward(request, response);
	}

}
