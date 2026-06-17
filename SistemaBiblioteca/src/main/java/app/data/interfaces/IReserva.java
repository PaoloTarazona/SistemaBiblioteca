package app.data.interfaces;

import java.util.List;

import app.modelos.Reserva;

public interface IReserva {
	
	int registrar(Reserva reserva);
	Reserva buscarPorId(int id);
	boolean actualizar(Reserva reserva);
	boolean eliminarPorId(int id);
	
	List<Reserva> obtenerTodo();
	List<Reserva> buscarPorDni(String dni);
}
