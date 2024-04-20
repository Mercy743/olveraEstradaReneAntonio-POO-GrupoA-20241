package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario {
    private LocalDate fechaRegistro;
    private double sueldo;

    public Gerente(String nombre, String apellidos, String nombreUsuario, String contraseña, double sueldo, String numeroTelefono) {
        super(nombre, apellidos, Rol.GERENTE, nombreUsuario, contraseña, numeroTelefono);
        this.sueldo = sueldo;
    }

    public LocalDate getfechaRegistro() {
        return fechaRegistro;
    }

    public String toString() {
        return String.format("%s, Fecha de regustro: %s", super.toString(), this.fechaRegistro);
    }
}
