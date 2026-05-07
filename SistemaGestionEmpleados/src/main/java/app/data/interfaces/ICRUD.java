package app.data.interfaces;

import java.util.List;

public interface ICRUD<T, ID> {
	ID registrar(T t);
	T buscarPorId(ID id);
	boolean actualizar(T t);
	boolean eliminar(ID id);
	
	List<T> obtenerTodos();
}
