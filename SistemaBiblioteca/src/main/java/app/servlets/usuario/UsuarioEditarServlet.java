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

@WebServlet("/Inicio/Usuario/Editar")
public class UsuarioEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	private RolDAO rolDAO;
       
    public UsuarioEditarServlet() {
        super();
        usuarioDAO = new UsuarioDAO();
        rolDAO = new RolDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("usuario", usuarioDAO.buscarPorId(id));
		request.setAttribute("lsRol", rolDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/usuario/editar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lsRol", rolDAO.obtenerTodo());
        
		int id = Integer.parseInt(request.getParameter("id"));
        String nombreUsuario = request.getParameter("nombreUsuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String contrasena = request.getParameter("contrasena");
		int rolId = Integer.parseInt(request.getParameter("rolId"));

        Usuario usuario = new Usuario(
        	id, nombreUsuario, nombre, apellido, contrasena,
        	new Rol(rolId, "")
        );
        
        boolean ok = usuarioDAO.actualizar(usuario);
		
		request.setAttribute("ok", ok);
		request.setAttribute("titulo", ok ? "Usuario Actualizado" : "Error al actualizar!");
		request.setAttribute("mensaje", ok ? "El Usuario se actualizo correctamente." : "Codigo de error: 103");

		request.setAttribute("usuario", usuario);
		request.setAttribute("listaUsuario", usuarioDAO.obtenerTodo());
        request.getRequestDispatcher("/WEB-INF/usuario/editar.jsp").forward(request, response);
	}

}
