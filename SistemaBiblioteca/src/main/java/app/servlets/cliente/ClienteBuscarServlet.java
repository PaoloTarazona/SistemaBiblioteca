package app.servlets.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import app.modelos.Cliente;
import app.data.ClienteDAO;

@WebServlet("/Inicio/Cliente/Buscar")
public class ClienteBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
       
    public ClienteBuscarServlet() {
        super();
        clienteDAO = new ClienteDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cliente", new ArrayList<Cliente>());
		request.getRequestDispatcher("/WEB-INF/cliente/buscar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clienteBuscar = request.getParameter("txtCliente");
		
		List<Cliente> resultado = new ArrayList<>();
		resultado.addAll(clienteDAO.buscarPorApellido(clienteBuscar));
		Cliente c = clienteDAO.buscarPorDni(clienteBuscar);
		if (c.getDni() != null && !c.getDni().isEmpty()) resultado.add(c);
		
		request.setAttribute("cliente", resultado);
		request.setAttribute("clienteBuscar", clienteBuscar);
		request.getRequestDispatcher("/WEB-INF/cliente/buscar.jsp").forward(request, response);
	}

}
