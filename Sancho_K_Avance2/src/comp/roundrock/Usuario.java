package comp.roundrock;

public class Usuario {

    private int identificacion;

    private String nombre;

    private String apellidos;

    private String correo;

    private int telefono;

    private String login;

    private String contrasena;

    private boolean Admin;


    public Usuario() {this(0);}

    public Usuario(int identificacion) {this(identificacion, "N/A", "N/A", "N/A", 0, "N/A", "N/A", false );}

    public Usuario(int identificacion, String nombre, String apellidos, String correo, int telefono, String login, String contrasena, boolean admin) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.login = login;
        this.contrasena = contrasena;
        Admin = admin;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "identificacion=" + identificacion +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono=" + telefono +
                ", login='" + login + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", Admin=" + Admin +
                '}';
    }
}
