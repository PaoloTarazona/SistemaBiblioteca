package app.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.config.MySQLConexion;
import app.data.interfaces.IUsuario;
import app.modelos.Rol;
import app.modelos.Usuario;

public class UsuarioDAO implements IUsuario {

	@Override
	public int registrar(Usuario usuario) {
		int resultado = 0;
		String instruccionSQL = "INSERT INTO Usuario (Nombre_usuario, Nombre, Apellido, Contrasena, Rol_id) VALUES(?, ?, ?, ?, ?)";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, usuario.getNombreUsuario());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellido());
			ps.setString(4, usuario.getContrasena());
			ps.setInt(5, usuario.getRol().getId());
			
			resultado = ps.executeUpdate();
			ps.close(); cnx.close();
		}
		
		catch (SQLException e){
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Usuario buscarPorId(int id) {
		Usuario usuarioBuscado = new Usuario();
		String instruccionSQL = "{CALL ObtenerUsuarioPorID(?)}";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			CallableStatement cs = cnx.prepareCall(instruccionSQL);
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				usuarioBuscado = new Usuario(
					rs.getInt("ID"),
					rs.getString("Nombre_usuario"),
					rs.getString("Nombre"),
					rs.getString("Apellido"),
					rs.getString("Contrasena"),
					new Rol(rs.getInt("RolID"), rs.getString("RolNombre"))
				);

			}
			rs.close(); cs.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioBuscado;
	}

	@Override
	public boolean actualizar(Usuario usuario) {
		boolean ok = false;
		String instruccionSQL = "UPDATE Usuario SET Nombre_usuario = ?, Nombre = ?, Apellido = ?, Contrasena = ?, Rol_id = ? WHERE ID = ?";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, usuario.getNombreUsuario());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellido());
			ps.setString(4, usuario.getContrasena());
			ps.setInt(5, usuario.getRol().getId());
			ps.setInt(6, usuario.getId());
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
	    String instruccionSQL = "DELETE FROM Usuario WHERE ID = ?";
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
	public List<Usuario> obtenerTodo() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String instruccionSQL = "{CALL ObtenerUsuarios()}";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			CallableStatement cs = cnx.prepareCall(instruccionSQL);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(
					rs.getInt("ID"),
					rs.getString("Nombre_usuario"),
					rs.getString("Nombre"),
					rs.getString("Apellido"),
					rs.getString("Contrasena"),
					new Rol(rs.getInt("RolID"), rs.getString("RolNombre"))
				);
				listaUsuarios.add(usuario);
			}
			rs.close(); cs.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	@Override
	public List<Usuario> buscarPorRol(String rol) {
		List<Usuario> usuarioBuscado = new ArrayList<Usuario>();
		String instruccionSQL = "{CALL ObtenerUsuariosPorRol(?)}";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			CallableStatement cs = cnx.prepareCall(instruccionSQL);
			cs.setString(1, rol);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario(
						rs.getInt("ID"),
						rs.getString("Nombre_usuario"),
						rs.getString("Nombre"),
						rs.getString("Apellido"),
						rs.getString("Contrasena"),
						new Rol(rs.getInt("RolID"), rs.getString("RolNombre"))
					);
				usuarioBuscado.add(usuario);
			}
			rs.close(); cs.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioBuscado;
	}

	@Override
	public Usuario validar(String nombreUsuario, String contrasena) {
	    Usuario usuario = null;
	    String instruccionSQL = "{CALL ValidarUsuario(?, ?)}";
	    Connection cnx = MySQLConexion.obtenerConexion();
	    try {
	        CallableStatement cs = cnx.prepareCall(instruccionSQL);
	        cs.setString(1, nombreUsuario);
	        cs.setString(2, contrasena);
	        ResultSet rs = cs.executeQuery();
	        if (rs.next()) {
	            usuario = new Usuario(
	                rs.getInt("ID"),
	                rs.getString("Nombre_usuario"),
	                rs.getString("Nombre"),
	                rs.getString("Apellido"),
	                rs.getString("Contrasena"),
	                new Rol(rs.getInt("RolID"), rs.getString("RolNombre"))
	            );
	        }
	        rs.close(); cs.close(); cnx.close();
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return usuario;
	}

}
