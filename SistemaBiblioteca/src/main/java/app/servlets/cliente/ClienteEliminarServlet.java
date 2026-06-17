package app.servlets.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.ClienteDAO;

@WebServlet("/Inicio/Cliente/Eliminar")
public class ClienteEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteEliminarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminarPorDni(dni);
		response.sendRedirect(request.getContextPath() + "/Inicio/Cliente/Buscar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
