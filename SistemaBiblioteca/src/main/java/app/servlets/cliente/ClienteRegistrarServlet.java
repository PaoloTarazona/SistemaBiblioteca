package app.servlets.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.ClienteDAO;
import app.modelos.Cliente;

@WebServlet("/Inicio/Cliente/Registrar")
public class ClienteRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
       
    public ClienteRegistrarServlet() {
        super();
        clienteDAO = new ClienteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaClientes", clienteDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/cliente/registrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listaCliente", clienteDAO.obtenerTodo());	
        
        String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		
		Cliente cliente = new Cliente(
				dni, nombre, apellido, correo,
				telefono
		);
		
		int mensajed = clienteDAO.registrar(cliente);
        boolean ok = mensajed > 0;
		request.setAttribute("ok", ok);
		request.setAttribute("nombre", ok ? "Cliente Registrado" : "Error al Registrar");
		request.setAttribute("mensaje", ok ? "El cliente fue registrado correctamente" : "Codigo dde error: 103");
		
		request.getRequestDispatcher("/WEB-INF/cliente/registrar.jsp").forward(request, response);
	}

}
