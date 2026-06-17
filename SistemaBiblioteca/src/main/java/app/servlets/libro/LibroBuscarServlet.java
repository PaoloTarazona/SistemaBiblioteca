package app.servlets.libro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.LibroDAO;
import app.modelos.Libro;
@WebServlet("/Inicio/Libro/Buscar")
public class LibroBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroDAO libroDAO;
       
    public LibroBuscarServlet() {
        super();
        libroDAO = new LibroDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("libro", new ArrayList<Libro>());
		request.getRequestDispatcher("/WEB-INF/libro/buscar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libroBuscar = request.getParameter("txtLibro");
		
		List<Libro> resultado = new ArrayList<>();
		try {
			int id = Integer.parseInt(libroBuscar);
			Libro l = libroDAO.buscarPorId(id);
			if (l.getId() > 0) resultado.add(l);
		}
		catch (Exception e)
		{
			resultado.addAll(libroDAO.buscarPorTitulo(libroBuscar));
		}
		
		
		request.setAttribute("libro", resultado);
		request.setAttribute("libroBuscar", libroBuscar);
		request.getRequestDispatcher("/WEB-INF/libro/buscar.jsp").forward(request, response);
	}

}
