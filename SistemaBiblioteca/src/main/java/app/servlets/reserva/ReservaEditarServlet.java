package app.servlets.reserva;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.ClienteDAO;
import app.data.LibroDAO;
import app.data.ReservaDAO;
import app.modelos.Cliente;
import app.modelos.Libro;
import app.modelos.Reserva;

@WebServlet("/Inicio/Reserva/Editar")
public class ReservaEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservaDAO reservaDAO;
	private ClienteDAO clienteDAO;
	private LibroDAO libroDAO;
       
    public ReservaEditarServlet() {
        super();
        reservaDAO = new ReservaDAO();
        libroDAO = new LibroDAO();
        clienteDAO = new ClienteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("reserva", reservaDAO.buscarPorId(id));
		request.setAttribute("lsClientes", clienteDAO.obtenerTodo());
		request.setAttribute("lsLibros", libroDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/reserva/editar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("lsClientes", clienteDAO.obtenerTodo());
		request.setAttribute("lsLibros", libroDAO.obtenerTodo());
		
		int id = Integer.parseInt(request.getParameter("id"));
		String clienteDni = request.getParameter("clienteDni");
        int libroId = Integer.parseInt(request.getParameter("libroId"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        LocalDate fechaLimite = LocalDate.parse(request.getParameter("fechaLimite"));

        Reserva reserva = new Reserva(
            id,
            new Cliente(clienteDni, "", "", "", ""),
            new Libro(libroId, "", "", "", 0),
            fecha,
            fechaLimite
        );
        
        boolean ok = reservaDAO.actualizar(reserva);
		
		request.setAttribute("ok", ok);
		request.setAttribute("nombre", ok ? "Reserva Actualizada" : "Error al actualizar!");
		request.setAttribute("mensaje", ok ? "La Reserva se actualizo correctamente." : "Codigo de error: 103");
		
		request.setAttribute("reserva", reserva);
		request.setAttribute("listaReserva", reservaDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/reserva/editar.jsp").forward(request, response);
        
        
	}

}
