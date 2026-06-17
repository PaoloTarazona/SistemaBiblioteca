package app.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.config.MySQLConexion;
import app.data.interfaces.ILibro;
import app.modelos.Libro;

public class LibroDAO implements ILibro {

	@Override
	public int registrar(Libro libro) {
		int resultado = 0;
		String instruccionSQL = "INSERT INTO Libros (Titulo, Autor, Categoria, Stock) VALUES(?, ?, ?, ?)";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setString(3, libro.getCategoria());
			ps.setInt(4, libro.getStock());
			
			resultado = ps.executeUpdate();
			ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Libro buscarPorId(int id) {
		Libro buscarId = new Libro();
		String instruccionSQL = "SELECT * FROM Libros WHERE ID = (?)";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				buscarId = new Libro (
						rs.getInt("ID"),
						rs.getString("Titulo"),
						rs.getString("Autor"),
						rs.getString("Categoria"),
						rs.getInt("Stock")
				
				);
				
			}
			rs.close(); ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buscarId;
	}

	@Override
	public boolean actualizar(Libro libro) {
		boolean ok = false;
		String instruccionSQL = "UPDATE Libros SET Titulo = ?, Autor = ?, Categoria = ?, Stock = ? WHERE ID = ?";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, libro.getTitulo());
			ps.setString(2, libro.getAutor());
			ps.setString(3, libro.getCategoria());
			ps.setInt(4, libro.getStock());
			ps.setInt(5, libro.getId());
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
		String instruccionSQL = "DELETE FROM Libros WHERE ID = (?)";
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
	public List<Libro> obtenerTodo() {
		List<Libro> listaLibros = new ArrayList<Libro>();
		String instruccionSQL = "SELECT * FROM Libros";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ResultSet rs = ps.executeQuery();
			while  (rs.next()) {
				Libro libro = new Libro(
						rs.getInt("ID"),
						rs.getString("Titulo"),
						rs.getString("Autor"),
						rs.getString("Categoria"),
						rs.getInt("Stock")
			     );
				
				listaLibros.add(libro);
				
			}
			
			rs.close(); ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaLibros;
	}

	@Override
	public List<Libro> buscarPorTitulo(String titulo) {
		List<Libro> buscarPorTitulo= new ArrayList<Libro>();
		String instruccionSQL = "SELECT * FROM Libros WHERE Titulo LIKE ?";
		Connection cnx = MySQLConexion.obtenerConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(instruccionSQL);
			ps.setString(1, "%" + titulo  + "%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Libro libro = new Libro (
						rs.getInt("ID"),
						rs.getString("Titulo"),
						rs.getString("Autor"),
						rs.getString("Categoria"),
						rs.getInt("Stock")
				
				);
				
				buscarPorTitulo.add(libro);
				
			}
			rs.close(); ps.close(); cnx.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buscarPorTitulo;
	}

}
