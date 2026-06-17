package app.servlets.reserva;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import app.data.ReservaDAO;

@WebServlet("/Inicio/Reserva/Eliminar")
public class ReservaEliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservaEliminarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ReservaDAO reservaDAO = new ReservaDAO();
		reservaDAO.eliminarPorId(id);
		response.sendRedirect(request.getContextPath() + "/Inicio/Reserva/Buscar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
