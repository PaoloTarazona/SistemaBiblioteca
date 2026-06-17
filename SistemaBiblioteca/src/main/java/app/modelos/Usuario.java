package app.modelos;

public class Usuario {
	//Atributos
	private int id;
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String contrasena;
	private Rol rol;
	
	//Iniciador
	public Usuario() {
		id = 0;
		nombreUsuario = "";
		nombre = "";
		apellido = "";
		contrasena = "";
		rol = new Rol();
	}
	
	//Constructor
	public Usuario(int id, String nombreUsuario, String nombre, String apellido, String contrasena, Rol rol) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
		this.rol = rol;
	}
	
	//Metodos de acceso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString() {
		return "[" + id + "] " + nombre;
	}
	
	
	

}
