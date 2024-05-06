package Biblioteca;

import Usuarios.Cliente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Usuarios.Gerente;
public class Biblioteca {
    private Scanner sc;
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap();
    public Biblioteca() {
        sc = new Scanner(System.in);
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
}

