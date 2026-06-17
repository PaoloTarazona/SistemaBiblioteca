package app.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.config.MySQLConexion;
import app.data.interfaces.IReserva;
import app.modelos.Cliente;
import app.modelos.Libro;
import app.modelos.Reserva;

public class ReservaDAO implements IReserva {

	@Override
	public int registrar(Reserva reserva) {
		int resultado = 0;
		String instruccionSQL = "INSERT INTO Reservas (Cliente_dni, Libro_id, Fecha, Fecha_limite) VALUES(?, ?, ?, ?)";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, reserva.getCliente().getDni());
			ps.setInt(2, reserva.getLibro().getId());
			ps.setDate(3, Date.valueOf(reserva.getFecha()));
			ps.setDate(4,  Date.valueOf(reserva.getFechaLimite()));
			
			resultado = ps.executeUpdate();
			ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Reserva buscarPorId(int id) {
		Reserva reservaBuscado = new Reserva();
		String instruccionSQL = "{CALL ObtenerReservaPorID(?)}";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			CallableStatement cs = cnx.prepareCall(instruccionSQL);
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				reservaBuscado = new Reserva(
						rs.getInt("ID"),
						new Cliente(rs.getString("DniCLiente"), rs.getString("NombreCliente"), rs.getString("ApellidoCliente"), "", ""),
						new Libro(rs.getInt("LibroID"), rs.getString("LibroTitulo"), "", "", 0),
						rs.getDate("Fecha").toLocalDate(),
						rs.getDate("FechaLimite").toLocalDate()
				);
			}
			rs.close(); cs.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return reservaBuscado;
	}

	@Override
	public boolean actualizar(Reserva reserva) {
		boolean ok = false;
		String instruccionSQL = "UPDATE Reservas SET Cliente_dni=?, Libro_id=?, Fecha=?, Fecha_limite=? WHERE ID=?";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, reserva.getCliente().getDni());
			ps.setInt(2, reserva.getLibro().getId());
			ps.setDate(3, Date.valueOf(reserva.getFecha()));
			ps.setDate(4,  Date.valueOf(reserva.getFechaLimite()));
			ps.setInt(5, reserva.getId());
			ok = ps.executeUpdate() == 1;
			ps.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean eliminarPorId(int id) {
		boolean delete = false;
		 String instruccionSQL = "DELETE FROM Reservas WHERE ID = (?)";
		 Connection cnx = MySQLConexion.obtenerConexion();
		 try {
		      PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
		      ps.setInt(1, id);
		      delete = ps.executeUpdate() == 1;

		      ps.close(); cnx.close();

		  } 
		 catch (SQLException e) {  
		   e.printStackTrace();
		   }

		 return delete;
	}

	@Override
	public List<Reserva> obtenerTodo() {
		List<Reserva> listaReservas = new ArrayList<Reserva>();
		String instruccionSQL = "{CALL ObtenerReservas()}";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			CallableStatement cs = cnx.prepareCall(instruccionSQL);
			ResultSet rs = cs.executeQuery();
			while  (rs.next()) {
				Reserva reserva = new Reserva(
						rs.getInt("ID"),
						new Cliente(rs.getString("DniCliente"), rs.getString("NombreCliente"), rs.getString("ApellidoCliente"), "", ""),
						new Libro(rs.getInt("LibroID"), rs.getString("LibroTitulo"), "", "", 0),
						rs.getDate("Fecha").toLocalDate(),
						rs.getDate("FechaLimite").toLocalDate()
			     );
				
				listaReservas.add(reserva);
				
			}
			
			rs.close(); cs.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaReservas;
	}

	@Override
	public List<Reserva> buscarPorDni(String dni) {
		List<Reserva> reservaBuscado = new ArrayList<Reserva>();
		String instruccionSQL = "{CALL ObtenerReservasPorDNI(?)}";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			CallableStatement cs = cnx.prepareCall(instruccionSQL);
			cs.setString(1, dni);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva(
						rs.getInt("ID"),
						new Cliente(rs.getString("DniCLiente"), rs.getString("NombreCliente"), rs.getString("ApellidoCliente"), "", ""),
						new Libro(rs.getInt("LibroID"), rs.getString("LibroTitulo"), "", "", 0),
						rs.getDate("Fecha").toLocalDate(),
						rs.getDate("FechaLimite").toLocalDate()
				);
				reservaBuscado.add(reserva);
			}
			rs.close(); cs.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return reservaBuscado;
	}

}
