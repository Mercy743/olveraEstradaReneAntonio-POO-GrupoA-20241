package Usuarios.Serializers;


import Biblioteca.Biblioteca;
import Libros.Libro;
import Libros.constants.Genero;
import Usuarios.Models.UsuarioModels;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class UsuarioDeserializer {

    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            Gson json = new Gson();
            UsuarioModels usuarioModels = json.fromJson(reader, UsuarioModels.class);

            ArrayList<Usuario> usuarios = new ArrayList<>(usuarioModels.getUsuarios());

            ArrayList<Libro> libros = new ArrayList<>(usuarioModels.getLibros());

            Biblioteca.usuarios.put(Rol.TRABAJADOR, usuarios);
            Biblioteca.usuarios.put(Rol.CLIENTE, usuarios);
            Biblioteca.usuarios.put(Rol.GERENTE, usuarios);

            Biblioteca.libros.put(Genero.Comedia, libros);
            Biblioteca.libros.put(Genero.Terror, libros);
            Biblioteca.libros.put(Genero.Accion, libros);

        }catch(Exception e) {
            System.out.println("Se ha producido un error del tipo: " + e);
        }

    }
}

