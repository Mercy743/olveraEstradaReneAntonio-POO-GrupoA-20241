package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;
public class Cliente extends Usuario {
    private LocalDate fechaRegistro;
    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, String contraseña, String nombreUsuario){
        super(nombre, apellido, Rol.CLIENTE, fechaNacimiento, contraseña, nombreUsuario);

    }

    public LocalDate getfechaRegistro(){
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s, Fecha de Registro: %s", super.toString(),getfechaRegistro());
    }
}