package app.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.config.MySQLConexion;
import app.data.interfaces.ICliente;
import app.modelos.Cliente;

public class ClienteDAO implements ICliente {

	@Override
	public int registrar(Cliente cliente) {
		int resultado = 0;
		String instruccionSQL = "INSERT INTO Clientes (DNI, Nombre, Apellido, Correo, Telefono) VALUES(?, ?, ?, ?, ?)";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellido());
			ps.setString(4, cliente.getCorreo());
			ps.setString(5, cliente.getTelefono());
			
			resultado = ps.executeUpdate();
			ps.close(); cnx.close();
		}
		
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Cliente buscarPorDni(String dni) {
		Cliente buscarDni = new Cliente();
		String instruccionSQL = "SELECT * FROM Clientes WHERE DNI = (?)";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				buscarDni = new Cliente(
						rs.getString("DNI"),
						rs.getString("Nombre"),
						rs.getString("Apellido"),
						rs.getString("Correo"),
						rs.getString("Telefono")
			     );
				
			}
			
			rs.close(); ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buscarDni;
	}

	@Override
	public boolean actualizar(Cliente cliente) {
		boolean ok = false;
		String instruccionSQL = "UPDATE Clientes SET Nombre = ?, Apellido = ?, Correo = ?, Telefono  = ? WHERE DNI = ?";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getCorreo());
			ps.setString(4, cliente.getTelefono());
			ps.setString(5, cliente.getDni());
			ok = ps.executeUpdate() == 1;
			ps.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean eliminarPorDni(String dni) {
		boolean delete = false;
		String instruccionSQL = "DELETE FROM Clientes WHERE DNI = (?)";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, dni);
			delete = ps.executeUpdate() == 1;
			ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return delete;
	}

	@Override
	public List<Cliente> obtenerTodo() {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		String instruccionSQL = "SELECT * FROM Clientes";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				Cliente cliente = new Cliente(
						rs.getString("DNI"),
						rs.getString("Nombre"),
						rs.getString("Apellido"),
						rs.getString("Correo"),
						rs.getString("Telefono")
			     );
				
				listaCliente.add(cliente);
				
			}
			
			rs.close(); ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaCliente;
	}

	@Override
	public List<Cliente> buscarPorApellido(String apellido) {
		List<Cliente> buscarPorApellido = new ArrayList<Cliente>();
		String instruccionSQL = "SELECT * FROM Clientes WHERE Apellido LIKE ?";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, "%" + apellido  + "%");
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				Cliente cliente = new Cliente(
						rs.getString("DNI"),
						rs.getString("Nombre"),
						rs.getString("Apellido"),
						rs.getString("Correo"),
						rs.getString("Telefono")
			     );
				
				buscarPorApellido.add(cliente);
				
			}
			
			rs.close(); ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buscarPorApellido;
	}

}
