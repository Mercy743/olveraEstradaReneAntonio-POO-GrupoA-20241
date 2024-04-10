package libreriaa;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

public class LibreriaA {
    public static void main(String[] args) {
      Usuario usuario = new Usuario("Carlos", "Martinez", Rol.TRABAJADOR);
      Cliente cliente = new Cliente("Juan", "Pérez");
      Gerente gerente = new Gerente("Eduardo", "Torres");
      Trabajador trabajador = new Trabajador("Peter", "Griffin");
        System.out.println(cliente.toString());
        System.out.println(usuario.toString());
        System.out.println(gerente.toString());
        System.out.println(trabajador.toString());
    }
    
}
