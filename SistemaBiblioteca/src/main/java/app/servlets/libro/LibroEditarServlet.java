package app.servlets.libro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.LibroDAO;
import app.modelos.Libro;

@WebServlet("/Inicio/Libro/Editar")
public class LibroEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDAO;
       
    public LibroEditarServlet() {
        super();
        libroDAO = new LibroDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("libro", libroDAO.buscarPorId(id));
		request.setAttribute("listaLibro", libroDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/libro/editar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String categoria = request.getParameter("categoria");
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		Libro libro = new Libro(
				id, titulo, autor, categoria, stock
		);
		
		boolean ok = libroDAO.actualizar(libro);
		
		request.setAttribute("ok", ok);
		request.setAttribute("titulo", ok ? "Libro Actualizado" : "Error al actualizar!");
		request.setAttribute("mensaje", ok ? "El Libro se actualizo correctamente." : "Codigo de error: 103");
		
		request.setAttribute("libro", libro);
		request.setAttribute("listaLibro", libroDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/libro/editar.jsp").forward(request, response);
	}

}
