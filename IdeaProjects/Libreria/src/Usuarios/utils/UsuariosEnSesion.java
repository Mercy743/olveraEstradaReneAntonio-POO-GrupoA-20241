package Usuarios.utils;
import Usuarios.Usuario;
public class UsuariosEnSesion {

    private static UsuariosEnSesion instancia;
    private Usuario usuarioActual;

    public static UsuariosEnSesion getInstancia() {
        if (instancia == null) {
            instancia = new UsuariosEnSesion();
        }

        return instancia;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuario(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public boolean hayUsuarioEnSesion() {
        return usuarioActual != null;
    }

    public void cerrarSesion() {
        instancia = null;
        usuarioActual = null;
    }
}
