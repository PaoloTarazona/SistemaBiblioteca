package app.data.interfaces;

import java.util.List;

import app.modelos.Usuario;

public interface IUsuario {
	
	int registrar(Usuario usuario);
	Usuario buscarPorId(int id);
	boolean actualizar(Usuario usuario);
	boolean eliminarPorId(int id);
	
	List<Usuario> obtenerTodo();
	List<Usuario> buscarPorRol(String rol);
	Usuario validar(String nombre, String clave);
}
