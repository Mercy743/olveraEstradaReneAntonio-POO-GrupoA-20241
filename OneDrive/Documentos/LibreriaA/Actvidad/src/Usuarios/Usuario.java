package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;


public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimiento;
    private String contraseña;
    private String nombreUsuario;
    

    public Usuario(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento, String nombreUsuario, String contraseña) {
        this.id =  CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
        CANTIDAD_USUARIOS++;
    }
    @Override
    public String toString(){
        return String.format("ID: %d, Nombre Completo: %s %s, Rol: %s", id, nombre, apellido, rol);
    }
}
