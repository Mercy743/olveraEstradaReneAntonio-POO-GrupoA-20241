package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario{
    private LocalDate fechaRegistro;
    private double sueldo;
    public Gerente(String nombre, String apellido, LocalDate fechaNacimiento, String contraseña, String nombreUsuario, double sueldo){
        super(nombre, apellido, Rol.GERENTE, fechaNacimiento, contraseña, nombreUsuario);
        this.sueldo = sueldo;
        this.fechaRegistro = LocalDate.now();

    }
    public LocalDate getfechaRegistro(){
        return fechaRegistro;
    }

    @Override
    public String toString(){
        return String.format("%s, Fecha de regustro: %s", super.toString(), fechaRegistro);
    }
}

