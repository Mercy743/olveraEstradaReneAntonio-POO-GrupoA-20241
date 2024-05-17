package Usuarios.Models;

import Libros.Libro;
import Usuarios.Usuario;
import java.util.ArrayList;

public class UsuarioModels {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> libros;
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    public ArrayList<Libro> getLibros(){
        return libros;
    }
}