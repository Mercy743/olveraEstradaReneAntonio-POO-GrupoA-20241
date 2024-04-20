package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Trabajador extends Usuario {
    private double sueldo;
    private LocalDate fechaRegistro = LocalDate.now();
    public Trabajador(String nombre, String apellidos, String nombreUsuario, String telefono, String contraseña, double sueldo) {
        super(nombre, apellidos, Rol.TRABAJADOR, telefono, contraseña, nombreUsuario);
        this.sueldo = sueldo;
    }

    public LocalDate getfechaRegistro() {
        return fechaRegistro;
    }

    public String toString() {
        return String.format("%s, Fecha de regustro: %s", super.toString(), this.fechaRegistro);
    }
}
