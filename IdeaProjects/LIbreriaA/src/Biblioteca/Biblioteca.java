package Biblioteca;
import Libros.Libro;
import Libros.constants.Genero;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
public class Biblioteca {

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap();
    public Biblioteca() {
        inicializarHashMaps();
        Trabajador trabajador = new Trabajador("Juan", "Rivera", "Juan", "4433566678", "12", 15000, LocalDate.now());
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
    }



    public Usuario verificarInicioSesion(String usuario, String contraseña){
        for (ArrayList<Usuario> userList : usuarios.values()) {
            for (Usuario usuarioActual : userList) {
                if (usuarioActual.getNombreUsuario().equals(usuario) && usuarioActual.getContraseña().equals(contraseña)) {
                    return usuarioActual;
                }
            }
        }
        return null;
    }
    private void inicializarHashMaps(){
        libros.put(Genero.Comedia, new ArrayList<>());
        libros.put(Genero.Terror, new ArrayList<>());
        libros.put(Genero.Accion, new ArrayList<>());

        usuarios.put(Rol.GERENTE, new ArrayList<>());
        usuarios.put(Rol.CLIENTE, new ArrayList<>());
        usuarios.put(Rol.TRABAJADOR, new ArrayList<>());

    }
}

