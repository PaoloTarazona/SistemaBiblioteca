package app.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.config.MySQLConexion;
import app.data.interfaces.IRol;
import app.modelos.Rol;

public class RolDAO implements IRol {

	@Override
	public int registrar(Rol rol) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rol buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Rol rol) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarPorId(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Rol> obtenerTodo() {
		List<Rol> listaRol = new ArrayList<Rol>();
		String instruccionSQL = "SELECT * FROM Rol";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				Rol rol = new Rol(
						rs.getInt("ID"),
						rs.getString("Nombre")
			     );
				
				listaRol.add(rol);
				
			}
			
			rs.close(); ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaRol;
	}

}
