package app.servlets.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.RolDAO;
import app.data.UsuarioDAO;
import app.modelos.Rol;
import app.modelos.Usuario;

@WebServlet("/Inicio/Usuario/Registrar")
public class UsuarioRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private RolDAO rolDAO;
       
    public UsuarioRegistrarServlet() {
        super();
        usuarioDAO = new UsuarioDAO();
        rolDAO = new RolDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lsRol", rolDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/usuario/registrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lsRol", rolDAO.obtenerTodo());
		
		String nombreUsuario = request.getParameter("nombreUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String contrasena = request.getParameter("contrasena");
		int rolId = Integer.parseInt(request.getParameter("rolId"));

        Usuario usuario = new Usuario(
        	0, nombreUsuario, nombre, apellido, contrasena,
        	new Rol(rolId, "")
        );
        
        int mensajed = usuarioDAO.registrar(usuario);
        boolean ok = mensajed > 0;
		request.setAttribute("ok", ok);
		request.setAttribute("nombre", ok ? "Usuario Registrado" : "Error al Registrar");
		request.setAttribute("mensaje", ok ? "el usuario fue registrado correctamente" : "Codigo dde error: 103");
		
        
        request.getRequestDispatcher("/WEB-INF/usuario/registrar.jsp").forward(request, response);
	}

}
