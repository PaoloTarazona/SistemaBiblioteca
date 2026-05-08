package app.modelos;

public class Empleado {
    //Atributos
    private int id;
    private String nombres;
    private String apellidos;
    private String cargo;
    private int salario;
    private String correo;
    private Usuario usuario;

    //Iniciador
    public Empleado() {
        id = 0;
        nombres = "";
        apellidos = "";
        cargo = "";
        salario = 0;
        correo = "";
        usuario = new Usuario();
    }

    //Constructor
    public Empleado(int id, String nombres, String apellidos, String cargo, int salario, String correo,
            Usuario usuario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.salario = salario;
        this.correo = correo;
        this.usuario = usuario;
    }

    //__Metodos de acceso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}