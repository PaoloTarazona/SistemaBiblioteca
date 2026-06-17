package app.servlets.inicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.modelos.Usuario;

@WebServlet("/Inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        
        if (usuario.getRol().getNombre().equals("admin")) {
            request.getRequestDispatcher("/WEB-INF/InicioAdmin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/InicioBibliotecario.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
