package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.EmpleadosUtils;
import Usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Trabajador extends Usuario implements EmpleadosUtils {
    private static Trabajador trabajador;
    private double sueldo;
    private static Scanner sc = new Scanner(System.in);
    private LocalDate fechaRegistro = LocalDate.now();

    public Trabajador(String nombre, String apellidos, String nombreUsuario, String telefono, String contraseña, double sueldo, LocalDate fechaNacimiento) {
        super(nombre, apellidos, Rol.TRABAJADOR, telefono, contraseña, nombreUsuario, fechaNacimiento);
        this.sueldo = sueldo;
    }


    public LocalDate getfechaRegistro() {
        return fechaRegistro;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String toString() {
        return String.format("%s, Fecha de regustro: %s", super.toString(), this.fechaRegistro);
    }

    public static void registrarTrabajador() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.TRABAJADOR);

        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String nombreUsuario = datosComun.get(2);
        String telefono = datosComun.get(3);
        String contraseña = datosComun.get(4);
        LocalDate fechaNacimiento = DatosComun.preguntarFecha();
        System.out.println("Ingresar el sueldo del Trabajador");
        double sueldo = sc.nextDouble();

        Trabajador trabajador = new Trabajador(nombre, apellidos, nombreUsuario, telefono, contraseña, sueldo, fechaNacimiento);
        if (!Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            Biblioteca.usuarios.put(Rol.TRABAJADOR, new ArrayList<>());
        }
        Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
    }

    public static void mostrarTrabajadores() {
        System.out.println("\nTrabajadors en la biblioteca");
        for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
            Trabajador trabajador = (Trabajador) usuario;
            System.out.println(trabajador.toString());
        }
    }

    public static void eliminarTrabajador(Gerente gerente) {
        if (gerente == null || !Biblioteca.usuarios.containsKey(Rol.GERENTE) || !Biblioteca.usuarios.get(Rol.GERENTE).contains(gerente)) {
            System.out.println("Acceso denegado debes iniciar sesion como Gerente.");
            return;

        }
        mostrarTrabajadores();
        System.out.println("Ingresar el nombre de usuario del trabajador a eliminar. ");
        String nombreUsuario = sc.nextLine();

        for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {

                Biblioteca.usuarios.get(Rol.TRABAJADOR).remove(usuario);
                System.out.println("Trabajador eliminado exitosamente.");
                return;
            }
            System.out.println("No se encontro a ningún Trabajador con ese usurio. ");
        }
    }

    public static void modificarTrabajador(Usuario usuario) {
        if (usuario == null || (usuario.getRol() != Rol.GERENTE && usuario.getRol() != Rol.TRABAJADOR)) {
            System.out.println("Acceso denegado debe usted tener una cuenta de Trabajador o Gerente. ");
        }

        mostrarTrabajadores();
        System.out.println("Ingresar el nombre de usuario del trabajador que deseas modificar. ");
        String nombreUsuario = sc.nextLine();

        for (Usuario trabajador : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
            if (trabajador.getNombreUsuario().equals(nombreUsuario)) {
            }
        }
        System.out.println("Información actual del trabajador:");
        System.out.println(trabajador.toString());

        System.out.println("Desea hacer modificaciones completeas del trabajador(si/no): ");
        String opcion = sc.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            ArrayList<String> datosNuevosComun = DatosComun.obtenerDatosComun(Rol.TRABAJADOR);

            String nuevoNombre = datosNuevosComun.get(0);
            trabajador.setNombreUsuario(nuevoNombre);
            String nuevoApellido = datosNuevosComun.get(1);
            trabajador.setApellido(nuevoApellido);
            String nuevoNombreUsuario = datosNuevosComun.get(2);
            trabajador.setNombreUsuario(nuevoNombreUsuario);
            String nuevoTelefono = datosNuevosComun.get(3);
            trabajador.setNumeroTelefono(nuevoTelefono);
            String nuevaContraseña = datosNuevosComun.get(4);
            trabajador.setContraseña(nuevaContraseña);
            LocalDate nuevaFechaNacimiento = DatosComun.preguntarFecha();
            trabajador.setFechaNacimiento(nuevaFechaNacimiento);
            System.out.println("Ingresar el sueldo del Trabajador");
            double nuevoSueldo = sc.nextDouble();
            trabajador.setSueldo(nuevoSueldo);

            System.out.println("Información del trabajador modificada exitosamente. ");

        }else{
            System.out.println("¿Qué datos del trabajador deseas modificar individualmente?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Telefono");
            System.out.println("4. Contraseña");
            System.out.println("5. Nombre de usuario");
            System.out.println("6. Fecha de Nacimiento");

            int opcionDada = sc.nextInt();
            sc.nextLine();

            switch (opcionDada) {
                case 1:
                    System.out.println("Ingresa el nuevo Nombre del trabajador: ");
                    String nuevoNombre = sc.nextLine();
                    trabajador.setNombreUsuario(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingresa el nuevo Apellido del trabajador: ");
                    String nuevoApellido = sc.nextLine();
                    trabajador.setApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingresa la nueva contraseña: ");
                    String nuevaContraseña = sc.nextLine();
                    trabajador.setContraseña(nuevaContraseña);
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo número de teléfono:");
                    String nuevoTelefono = sc.nextLine();

                    if (!nuevoTelefono.matches("\\d{10}")) {
                        System.out.println("El número de teléfono debe tener 10 dígitos.");
                        break;
                    }

                    if (nuevoTelefono.length() != 10) {
                        System.out.println("El número de teléfono debe tener exactamente 10 dígitos.");
                        break;
                    }

                    boolean numeroExistente = false;
                    for (ArrayList<Usuario> userList : Biblioteca.usuarios.values()) {
                        for (Usuario telefonoUsuario : userList) {
                            if (telefonoUsuario .getNumeroTelefono().equals(nuevoTelefono)) {
                                numeroExistente = true;
                                break;
                            }
                        }
                    }
                    if (numeroExistente) {
                        System.out.println("El número de teléfono ya existe en el sistema.");
                        break;
                    }
                    trabajador.setNumeroTelefono(nuevoTelefono);
                    System.out.println("Número de teléfono actualizado correctamente.");
                    break;
                case 5:
                    System.out.println("Ingrese el nuevo nombre de usuario:");
                    String nuevoNombreUsuario = sc.nextLine();

                    boolean nombreUsuarioExistente = false;
                    for (ArrayList<Usuario> userList : Biblioteca.usuarios.values()) {
                        for (Usuario u : userList) {
                            if (u.getNombreUsuario().equals(nuevoNombreUsuario)) {
                                nombreUsuarioExistente = true;
                                break;
                            }
                        }
                    }
                    if (nombreUsuarioExistente) {
                        System.out.println("El nombre de usuario ya está en uso.");
                        break;
                    }
                    if (nuevoNombreUsuario.isEmpty()) {
                        System.out.println("El nombre de usuario no puede estar vacío.");
                        break;
                    }
                    trabajador.setNombreUsuario(nuevoNombreUsuario);
                    System.out.println("Nombre de usuario actualizado correctamente.");
                    break;
                case 6:
                   LocalDate nuevaFechaNacimiento = DatosComun.preguntarFecha();
                   trabajador.setFechaNacimiento(nuevaFechaNacimiento);
                   System.out.println("La fecha de nacimiento fue correctamente actualizada.");
                   break;
                default:
                    System.out.println("Opcion no valida.");

            }
        }

    }
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada por correo.");
}
    @Override
    public void checarSalida(){
        System.out.println("Checar salida por correo.");
    }
}
