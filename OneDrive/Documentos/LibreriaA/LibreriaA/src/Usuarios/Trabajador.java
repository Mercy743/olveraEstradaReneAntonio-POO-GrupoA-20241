package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;


public class Trabajador extends Usuario{
    private LocalDate fechaRegistro;
    public Trabajador(String nombre, String apellido){
        super(nombre, apellido, Rol.TRABAJADOR);
        this.fechaRegistro = LocalDate.now();
    }
    public LocalDate getfechaRegistro(){
         return fechaRegistro;
    }
    @Override
    public String toString(){
        return String.format("%s, Fecha de Registro: %s", super.toString(), fechaRegistro);
    }
}
