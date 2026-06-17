package app.data.interfaces;

import java.util.List;

import app.modelos.Rol;

public interface IRol {
	int registrar(Rol rol);
	Rol buscarPorId(int id);
	boolean actualizar(Rol rol);
	boolean eliminarPorId(int id);
	
	List<Rol> obtenerTodo();
}
