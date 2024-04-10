package Usuarios;
import Usuarios.utils.Rol;


public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;

    public Usuario(String nombre, String apellido, Rol rol) {
        this.id =  CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        CANTIDAD_USUARIOS++;
    }
    @Override
    public String toString(){
        return String.format("ID: %d, Nombre Completo: %s %s, Rol: %s", id, nombre, apellido, rol);
    }
}
