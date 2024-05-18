package Usuarios.Serializers;

import Biblioteca.Biblioteca;
import Usuarios.Models.LibrosModels;
import Usuarios.Models.UsuarioModels;
import Usuarios.Usuario;
import Libros.Libro;
import Libros.constants.Genero;
import Usuarios.utils.Rol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class UsuarioDeserializer {

    public static void deserialize() {
        Gson json = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Usuarios.json"));
            UsuarioModels usuarioModels = json.fromJson(reader, UsuarioModels.class);

            if (usuarioModels != null && usuarioModels.getUsuarios() != null) {

                ArrayList<Usuario> usuarios = new ArrayList<>(usuarioModels.getUsuarios());

                if (!usuarios.isEmpty()) {
                    Biblioteca.usuarios.put(Rol.TRABAJADOR, usuarios);
                    Biblioteca.usuarios.put(Rol.CLIENTE, usuarios);
                    Biblioteca.usuarios.put(Rol.GERENTE, usuarios);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Se ha producido un error durante la deserialización de usuarios: " + e);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Libros.json"));
            LibrosModels librosModels = json.fromJson(reader, LibrosModels.class);


            if (librosModels != null && librosModels.getLibros() != null) {

                ArrayList<Libro> libros = new ArrayList<>(librosModels.getLibros());


                if (!libros.isEmpty()) {
                    Biblioteca.libros.put(Genero.Terror, libros);
                    Biblioteca.libros.put(Genero.Accion, libros);
                    Biblioteca.libros.put(Genero.Comedia, libros);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Se ha producido un error durante la deserialización de libros: " + e);
        }
    }
}
