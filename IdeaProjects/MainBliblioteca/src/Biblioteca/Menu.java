package Biblioteca;

import Usuarios.Usuario;
import Usuarios.utils.UsuariosEnSesion;

import java.util.Scanner;

import static Usuarios.utils.Rol.CLIENTE;
import static Usuarios.utils.Rol.GERENTE;
import static Usuarios.utils.Rol.TRABAJADOR;

public class Menu {
    private Scanner sc;
    private Biblioteca biblioteca;

    public Menu() {
        this.sc = new Scanner(System.in);
        this.biblioteca = new Biblioteca();
    }

    public void iniciarSesion() {
        boolean datosCorrectos = false;

        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA");
            System.out.println("Inicia sesion para continuar");
            System.out.println("Ingresa el Usuario: ");
            String usuario = this.sc.nextLine();
            System.out.println("Ingresa la contraseña: ");
            String contraseña = this.sc.nextLine();
            Usuario usuarioActual = this.biblioteca.verificarInicioSesion(usuario, contraseña);
            if (usuarioActual != null) {
                datosCorrectos = true;
                seleccionarMenu(usuarioActual);
            }
        } while(!datosCorrectos);

    }

    private void seleccionarMenu(Usuario usuario) {
        switch (UsuariosEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case TRABAJADOR -> mostrarMenuTrabajador();
            case GERENTE -> mostrarMenuGerente();
        }

    }

    private void mostrarMenuCliente() {
        boolean bandera = true;

        while(bandera) {
            System.out.println("MENU CLIENTE");
            System.out.println("1. Realizar compra.");
            System.out.println("2. Ver compra compras.");
            System.out.println("3. Ver libros disponibles.");
            System.out.println("4. Cerrar sesion.");
            int opcCLiente = sc.nextInt();
            switch (opcCLiente) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("Cerrando sesion. . .");
                    iniciarSesion();
                default:
                    System.out.println("Opcion no valida.");
                    break;

            }
        }

    }

    private void mostrarMenuTrabajador() {
        boolean bandera = true;

        while(bandera) {
            System.out.println("========MENU TRABAJADOR========");
            System.out.println("1. Registrar Cliente.");
            System.out.println("2. Eliminar Cliente.");
            System.out.println("3. Actualizar Clientes.");
            System.out.println("4. Añadir Libros.");
            System.out.println("5. Eliminar Libro.");
            System.out.println("6. Actualizar Libros.");
            System.out.println("7. Cerrar sesion.");
            System.out.println("===============================");
            int opcTrabajador = sc.nextInt();
            switch (opcTrabajador) {
                case 1:
                    biblioteca.registrarCliente();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("Cerrando sesion. . .");
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

    }

    private void mostrarMenuGerente() {
        boolean bandera = true;

        while(bandera) {
            System.out.println("========MENU GERENTE========");
            System.out.println("1. Registrar Cliente.");
            System.out.println("2. Eliminar Cliente.");
            System.out.println("3. Actualizar Clientes.");
            System.out.println("4. Añadir Libros.");
            System.out.println("5. Eliminar Libro.");
            System.out.println("6. Actualizar Libros.");
            System.out.println("7. Añadir Trabajador.");
            System.out.println("8. Eliminar Trabajador.");
            System.out.println("9. Ver Trabajadores.");
            System.out.println("10. Cerrar sesion.");
            System.out.println("===============================");
            int opcTrabajador = this.sc.nextInt();
            switch (opcTrabajador) {
                case 1:
                    biblioteca.registrarCliente();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    biblioteca.registrarTrabajador();
                    break;
                case 8:
                case 9:
                    biblioteca.mostrarTrabajadores();
                case 10:
                    System.out.println("Cerrando sesion. . .");
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }

    }

    public void ejecutarMenu() {
        boolean bandera = true;

        do {
            System.out.println("\n BIENVENIDOS A LA BIBLIOTECA");
            System.out.println("1. Iniciar sesion: ");
            System.out.println("2. Crear cuenta nueva: ");
            System.out.println("3. Salir del menu: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    iniciarSesion();
                case 2:

                    break;
                case 3:
                    System.out.println("Saliendo del Menu...");
                    bandera = false;
                    break;
                default:
                    System.out.println("Esa no es una opcion valida. Ingrese de nuevo.");
            }
        } while(bandera);

    }
}
