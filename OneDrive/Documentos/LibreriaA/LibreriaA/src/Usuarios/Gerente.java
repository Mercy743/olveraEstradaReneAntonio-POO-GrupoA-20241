package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario{
    private LocalDate fechaRegistro;
    public Gerente(String nombre, String apellido){
        super(nombre, apellido, Rol.GERENTE);
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

