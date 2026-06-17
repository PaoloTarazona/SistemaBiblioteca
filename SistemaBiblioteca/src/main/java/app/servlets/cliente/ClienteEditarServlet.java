package app.servlets.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.ClienteDAO;
import app.modelos.Cliente;

@WebServlet("/Inicio/Cliente/Editar")
public class ClienteEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDAO clienteDAO;
       
    public ClienteEditarServlet() {
        super();
        clienteDAO = new ClienteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dni = request.getParameter("dni");
		request.setAttribute("cliente", clienteDAO.buscarPorDni(dni));
		request.setAttribute("listaCliente", clienteDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/cliente/editar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dni = request.getParameter("DNI");
		String nombre = request.getParameter("Nombre");
		String apellido = request.getParameter("Apellido");
		String correo = request.getParameter("Correo");
		String telefono = request.getParameter("Telefono");
		
		Cliente cliente = new Cliente(
				dni, nombre, apellido, correo, telefono
		);
		
		boolean ok = clienteDAO.actualizar(cliente);
		
		request.setAttribute("ok", ok);
		request.setAttribute("nombre", ok ? "Cliente Actualizado" : "Error al actualizar!");
		request.setAttribute("mensaje", ok ? "El Cliente se actualizo correctamente." : "Codigo de error: 103");
		
		request.setAttribute("cliente", cliente);
		request.setAttribute("listaCliente", clienteDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/cliente/editar.jsp").forward(request, response);
	}

}
