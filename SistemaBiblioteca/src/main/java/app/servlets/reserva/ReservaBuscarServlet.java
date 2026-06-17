package app.servlets.reserva;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.ReservaDAO;
import app.modelos.Reserva;

@WebServlet("/Inicio/Reserva/Buscar")
public class ReservaBuscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservaDAO reservaDAO;
       
    public ReservaBuscarServlet() {
        super();
        reservaDAO = new ReservaDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("reserva", new ArrayList<Reserva>());
		request.getRequestDispatcher("/WEB-INF/reserva/buscar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dniBuscar = request.getParameter("txtDni");
		request.setAttribute("reserva", reservaDAO.buscarPorDni(dniBuscar));
		request.setAttribute("dniBuscado", dniBuscar);
		request.getRequestDispatcher("/WEB-INF/reserva/buscar.jsp").forward(request, response);
	}

}
