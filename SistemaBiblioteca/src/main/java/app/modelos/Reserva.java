package app.modelos;

import java.time.LocalDate;

public class Reserva {
	//Atributos
	private int id;
	private Cliente cliente;
	private Libro libro;
	private LocalDate fecha;
	private LocalDate fechaLimite;
	
	//Iniciador
	public Reserva() {
		id = 0;
		cliente = new Cliente();
		libro = new Libro();
		fecha = LocalDate.now();
		fechaLimite = LocalDate.now();
	}
	
	//Constructor
	public Reserva(int id, Cliente cliente, Libro libro, LocalDate fecha, LocalDate fechaLimite) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.libro = libro;
		this.fecha = fecha;
		this.fechaLimite = fechaLimite;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	
	
}
