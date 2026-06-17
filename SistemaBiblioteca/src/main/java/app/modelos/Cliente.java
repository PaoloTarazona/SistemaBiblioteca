package app.modelos;

public class Cliente {
	//Atributos
	private String dni;
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	
	//Iniciador
	public Cliente() {
		dni = "";
		nombre = "";
		apellido = "";
		correo = "";
		telefono = "";
	}
	
	//Constructor
	public Cliente(String dni, String nombre, String apellido, String correo, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
	}
	
	//Metodos de acceso
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "[" + dni + "] " + nombre;
	}
	
	
}
