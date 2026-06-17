package app.data.interfaces;

import java.util.List;

import app.modelos.Libro;

public interface ILibro {
	
	int registrar(Libro libro);
	Libro buscarPorId(int id);
	boolean actualizar(Libro libro);
	boolean eliminarPorId(int id);
	
	List<Libro> obtenerTodo();
	List<Libro> buscarPorTitulo(String titulo);
}
