package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Trabajador extends Usuario{
    private double sueldo;
    private LocalDate fechaRegistro;
    public Trabajador(String nombre, String apellido, LocalDate fechaNacimiento, String contraseña, String nombreUsuario, LocalDate fechaRegistro, double sueldo){
        super(nombre, apellido, Rol.TRABAJADOR,fechaNacimiento,contraseña, nombreUsuario);
        this.fechaRegistro = LocalDate.now();
        this.sueldo = sueldo;
    }
    public LocalDate getfechaRegistro(){
        return fechaRegistro;
    }
    
   @Override
    public String toString(){
        return String.format("%s, Fecha de regustro: %s", super.toString(), fechaRegistro);
    }
}
