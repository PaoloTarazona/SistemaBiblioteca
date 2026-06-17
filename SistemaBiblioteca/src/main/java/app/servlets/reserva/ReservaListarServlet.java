package app.servlets.reserva;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.data.ReservaDAO;

@WebServlet("/Inicio/Reserva/Listar")
public class ReservaListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservaDAO reservaDAO;
       
    public ReservaListarServlet() {
        super();
        reservaDAO = new ReservaDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaReservas", reservaDAO.obtenerTodo());
		request.getRequestDispatcher("/WEB-INF/reserva/listar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
