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

@WebServlet("/Inicio/Reserva/Registrar")
public class ReservaRegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservaDAO reservaDAO;
	private ClienteDAO clienteDAO;
	private LibroDAO libroDAO;
       
    public ReservaRegistrarServlet() {
        super();
        reservaDAO = new ReservaDAO();
        libroDAO = new LibroDAO();
        clienteDAO = new ClienteDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lsClientes", clienteDAO.obtenerTodo());
		request.setAttribute("lsLibros", libroDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/reserva/registrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lsClientes", clienteDAO.obtenerTodo());
		request.setAttribute("lsLibros", libroDAO.obtenerTodo());	
        
        String clienteDni = request.getParameter("clienteDni");
        int libroId = Integer.parseInt(request.getParameter("libroId"));
        LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
        LocalDate fechaLimite = LocalDate.parse(request.getParameter("fechaLimite"));

        Reserva reserva = new Reserva(
        	0, 
            new Cliente(clienteDni, "", "", "", ""),
            new Libro(libroId, "", "", "", 0),
            fecha,
            fechaLimite
        );

        int mensajed = reservaDAO.registrar(reserva);
        boolean ok = mensajed > 0;
		request.setAttribute("ok", ok);
		request.setAttribute("nombre", ok ? "Reserva Registrada" : "Error al Registrar");
		request.setAttribute("mensaje", ok ? "la reserva fue registrado correctamente" : "Codigo dde error: 103");
		
        request.getRequestDispatcher("/WEB-INF/reserva/registrar.jsp").forward(request, response);
	}

}
