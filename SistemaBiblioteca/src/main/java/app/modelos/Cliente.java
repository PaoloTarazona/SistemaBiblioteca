package app.modelos;

public class Cliente {
	//Atributos
	private int id;
	private String nombre;
	private String apellido;
	private String correo;
	
	//Iniciador
	public Cliente() {
		id = 0;
		nombre = "";
		apellido = "";
		correo = "";
	}
	
	//Constructor
	public Cliente(int id, String nombre, String apellido, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
