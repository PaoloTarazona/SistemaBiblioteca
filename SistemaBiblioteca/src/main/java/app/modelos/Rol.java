package app.modelos;

public class Rol {
	//Atributos
	private int id;
	private String nombre;
	
	//Iniciador
	public Rol () {
		id = 0;
		nombre = "";
	}
	
	//Constructor
	public Rol(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	//Metodos de acceso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "[" + id + "] " + nombre;
	}
	
}
