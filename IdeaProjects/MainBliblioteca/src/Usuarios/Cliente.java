package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, String contraseña, String nombreUsuario, String numeroTelefono) {
        super(nombre, apellido, Rol.CLIENTE, contraseña, nombreUsuario, numeroTelefono);
        this.fechaRegistro = LocalDate.now();
    }

    public LocalDate getfechaRegistro() {
        return fechaRegistro;
    }

    public String toString() {
        return String.format("%s, Fecha de Registro: %s", super.toString(), this.getfechaRegistro());
    }
}
