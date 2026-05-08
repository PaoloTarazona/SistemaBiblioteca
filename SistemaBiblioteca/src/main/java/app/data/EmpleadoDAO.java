package app.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import app.config.MySQLConexion;
import app.data.interfaces.IEmpleado;
import app.modelos.Empleado;
import app.modelos.Rol;
import app.modelos.Usuario;

public class EmpleadoDAO implements IEmpleado {

	@Override
	public Integer registrar(Empleado t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(Empleado t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Empleado> obtenerTodo() {
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		String SQL = "{CALL SP_ObtenerEmpleadoConUsuario()}";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			CallableStatement cs = cnx.prepareCall(SQL);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				Empleado empleado = new Empleado(
						rs.getInt("ID"),
						rs.getString("Nombre"),
						rs.getString("Apellido"),
						rs.getString("Cargo"),
						rs.getInt("Salario"),
						rs.getString("Correo"),
						new Usuario(rs.getInt("UsuarioID"), rs.getString("UsuarioNombre"), "", new Rol())
				);
				listaEmpleados.add(empleado);
						
			}
			rs.close(); cs.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEmpleados;
	}

}