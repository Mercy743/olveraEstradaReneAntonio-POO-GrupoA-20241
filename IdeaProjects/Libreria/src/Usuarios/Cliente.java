package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;

import static Biblioteca.utils.DatosComun.sc;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;
    private static Cliente cliente;

    public Cliente(String nombre, String apellidos, String nombreUsuario, String telefono, String contraseña, LocalDate fechaNacimiento) {
        super(nombre, apellidos, Rol.CLIENTE, contraseña, nombreUsuario, telefono, fechaNacimiento);
        this.fechaRegistro = LocalDate.now();
    }

    public LocalDate getfechaRegistro() {
        return fechaRegistro;
    }
    @Override
    public String toString() {
        return String.format("%s, Fecha de Registro: %s", super.toString(), this.getfechaRegistro());
    }

    public static void registrarCliente() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);

        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String nombreUsuario = datosComun.get(2);
        String telefono = datosComun.get(3);
        String contra = datosComun.get(4);
        LocalDate fechaNacimiento = DatosComun.preguntarFecha();
        Cliente cliente = new Cliente(nombre, apellidos, nombreUsuario, telefono, contra, fechaNacimiento);
        if (!Biblioteca.usuarios.containsKey(Rol.CLIENTE)) {
            Biblioteca.usuarios.put(Rol.CLIENTE, new ArrayList<>());
        }
        Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
    }

    public static void mostrarClientes() {
        System.out.printf("\nClientes en la biblioteca");
        for (Usuario usuario : Biblioteca.usuarios.get(Rol.CLIENTE)) {
            Cliente cliente = (Cliente) usuario;
            System.out.println(cliente.toString());
        }
    }

    public static void eliminarCliente(Usuario usuarioActual) {
        if (usuarioActual == null || (!Biblioteca.usuarios.containsKey(Rol.GERENTE) && !Biblioteca.usuarios.containsKey(Rol.TRABAJADOR))) {
            System.out.println("Acceso denegado. Debes iniciar sesión como Gerente o Trabajador.");
            return;
        }

        System.out.println("Lista de clientes:");
        mostrarClientes();

        System.out.println("Ingresar el nombre de usuario del cliente a eliminar:");
        String nombreUsuario = sc.nextLine();

        for (Usuario cliente : Biblioteca.usuarios.get(Rol.CLIENTE)) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                if (usuarioActual.getRol() == Rol.CLIENTE) {
                    System.out.println("Acceso denegado. Los clientes no tienen permiso para eliminar a otros clientes.");
                    return;
                }

                Biblioteca.usuarios.get(Rol.CLIENTE).remove(cliente);
                System.out.println("Cliente eliminado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún cliente con ese usuario.");
    }
}