package app.modelos;

public class Libro {
	//Atributos
	private int id;
	private String titulo;
	private String autor;
	private String categoria;
	private int stock;
	
	//Iniciador
	public Libro() {
		id = 0;
		titulo = "";
		autor = "";
		categoria = "";
		stock = 0;
	}
		
	//Constructor
	public Libro(int id, String titulo, String autor, String categoria, int stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.stock = stock;
	}
	
	
	//Metodos de acceso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
		
	
}
