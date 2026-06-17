package app.data.interfaces;

import java.util.List;

import app.modelos.Cliente;

public interface ICliente {
	
	int registrar(Cliente cliente);
	Cliente buscarPorDni(String dni);
	boolean actualizar(Cliente cliente);
	boolean eliminarPorDni(String dni);
	
	List<Cliente> obtenerTodo();
	List<Cliente> buscarPorApellido(String apellido);

}
