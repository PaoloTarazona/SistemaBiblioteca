package app.servlets.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.ClienteDAO;

@WebServlet("/Inicio/Cliente/Listar")
public class ClienteListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
       
    public ClienteListarServlet() {
        super();
        clienteDAO = new ClienteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaClientes", clienteDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/cliente/listar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
