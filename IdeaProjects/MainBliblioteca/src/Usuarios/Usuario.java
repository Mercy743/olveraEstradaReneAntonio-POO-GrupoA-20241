package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
   // private LocalDate fechaNacimiento;
    private String contraseña;
    private String nombreUsuario;
    private String numeroTelefono;
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public int getId() {
        return id;
    }

    public Rol getRol() {
        return rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Usuario(String nombre, String apellido, Rol rol, String nombreUsuario, String contraseña, String numeroTelefono) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        //this.fechaNacimiento = fechaNacimiento;
        this.contraseña = contraseña;
        this.nombreUsuario = nombreUsuario;
        this.numeroTelefono = numeroTelefono;
        CANTIDAD_USUARIOS++;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nombre completo: %s %s, rol: %s, numero teléfono: %s", id, nombre, apellido, rol, numeroTelefono);
    }
}