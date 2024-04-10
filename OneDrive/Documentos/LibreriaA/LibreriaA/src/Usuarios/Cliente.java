package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;
public class Cliente extends Usuario {
    private LocalDate fechaRegistro;
    
    public Cliente(String nombre, String apellido){
        super(nombre, apellido, Rol.CLIENTE);
        this.fechaRegistro = LocalDate.now();
    }
    public LocalDate getFechaRegistro(){
        return fechaRegistro;
    }
    @Override
    public String toString(){
        return String.format("%s, Fecha de Registro: %s", super.toString(), fechaRegistro);
    }
}
