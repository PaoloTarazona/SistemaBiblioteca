package app.modelos;

import java.time.LocalDate;

public class Reserva {
	//Atributos
	private int id;
	private Cliente cliente;
	private Libro libro;
	private Empleado empleado;
	private LocalDate fecha;
	
	//Iniciador
	public Reserva() {
		id = 0;
		cliente = new Cliente();
		libro = new Libro();
		empleado = new Empleado();
		fecha = LocalDate.now();
	}
	
	//Constructor
	public Reserva(int id, Cliente cliente, Libro libro, Empleado empleado, LocalDate fecha) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.libro = libro;
		this.empleado = empleado;
		this.fecha = fecha;
	}
	
	//Metodos de acceso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
