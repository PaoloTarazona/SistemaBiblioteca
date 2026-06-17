package app.servlets.libro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.LibroDAO;
import app.modelos.Libro;

@WebServlet("/Inicio/Libro/Registrar")
public class LibroRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDAO;
       
    public LibroRegistrarServlet() {
        super();
        libroDAO = new LibroDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaLibros", libroDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/libro/registrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaLibros", libroDAO.obtenerTodo());
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String categoria = request.getParameter("categoria");
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		Libro libro = new Libro(
				0, titulo, autor, categoria, stock
		);
		
		int mensajed = libroDAO.registrar(libro);
        boolean ok = mensajed > 0;
		request.setAttribute("ok", ok);
		request.setAttribute("nombre", ok ? "Libro Registrado" : "Error al Registrar");
		request.setAttribute("mensaje", ok ? "El libro fue registrado correctamente" : "Codigo dde error: 103");
		
		request.getRequestDispatcher("/WEB-INF/libro/registrar.jsp").forward(request, response);
	}

}
