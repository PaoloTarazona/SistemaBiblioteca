package app.servlets.libro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.LibroDAO;

@WebServlet("/Inicio/Libro/Eliminar")
public class LibroEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LibroEliminarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		LibroDAO libroDAO = new LibroDAO();
		libroDAO.eliminarPorId(id);
		response.sendRedirect(request.getContextPath() + "/Inicio/Libro/Buscar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
