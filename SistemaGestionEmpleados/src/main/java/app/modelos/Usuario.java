package app.modelos;

public class Usuario {
	//Atributos
	private int id;
	private String nombre;
	private String contrasena;
	private Rol rol;
	
	//Iniciador
	public Usuario() {
		id = 0;
		nombre = "";
		contrasena = "";
		rol = new Rol();
	}
	
	//Constructor
	public Usuario(int id, String nombre, String contrasena, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
	
	

}
