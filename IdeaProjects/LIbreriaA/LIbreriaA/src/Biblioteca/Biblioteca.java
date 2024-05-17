package Biblioteca;
import Libros.Libro;
import Libros.LibroAccion;
import Libros.LibroComedia;
import Libros.LibroTerror;
import Libros.constants.Genero;
import Libros.constants.SubGeneroAccion;
import Libros.constants.SubGeneroComedia;
import Libros.constants.SubGeneroTerror;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Serializers.UsuarioDeserializer;
import Usuarios.Serializers.UsuarioSerializer;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
public class Biblioteca {

    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

    public Biblioteca(boolean inizializarDatos) {
        inicializarHashMaps();
        Trabajador trabajador = new Trabajador("Juan", "Rivera", "Juan", "4433566678", "12", 15000, LocalDate.now());
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
        if (inizializarDatos){
            inizializarDatos();
        }
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
    private void inizializarDatos(){
        usuarios.put(Rol.TRABAJADOR, new ArrayList<>());
        usuarios.put(Rol.GERENTE, new ArrayList<>());
        usuarios.put(Rol.CLIENTE, new ArrayList<>());

        libros.put(Genero.Comedia, new ArrayList<>());
        libros.put(Genero.Accion, new ArrayList<>());
        libros.put(Genero.Terror, new ArrayList<>());

        usuarios.get(Rol.TRABAJADOR).add(new Trabajador("Carlos", "Rivera", "T1", "4434678134", "24", 15000, LocalDate.now()));
        usuarios.get(Rol.GERENTE).add(new Gerente("Juan", "Garcia", "G1", "5546789822", "34", 200000, LocalDate.now()));
        usuarios.get(Rol.CLIENTE).add(new Cliente("Pedro", "Ballesteros", "C1", "4433667700", "44", LocalDate.now()));

        libros.get(Genero.Comedia).add(new LibroComedia("¡Guía del autopista galáctico!", "Douglas Adams", "Anagrama", LocalDate.of(1979, 10, 12), 149.99, 300, SubGeneroComedia.Tragica));
        libros.get(Genero.Accion).add(new LibroAccion("Inferno", "Dam Brown", "Planeta", LocalDate.of(2013, 5, 14), 199.99, 150, SubGeneroAccion.Aventura));
        libros.get(Genero.Terror).add(new LibroTerror("IT", "Stephen King", "Plaza & janés", LocalDate.of(1986, 8, 15), 169.98, 1, SubGeneroTerror.Crimen));

    }
    public void guardarJSON(){
        UsuarioSerializer.serialize();
    }
    public void leerJSON(){
        UsuarioDeserializer.deserialize();
    }
}

