package Usuarios;

import Biblioteca.Biblioteca;
import Biblioteca.utils.DatosComun;
import Usuarios.utils.EmpleadosUtils;
import Usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Usuario implements EmpleadosUtils {
    private static Gerente gerente;
    private LocalDate fechaRegistro;
    private double sueldo;
    private static Scanner sc = new Scanner(System.in);

    public Gerente(String nombre, String apellidos, String nombreUsuario, String telefono, String contraseña, double sueldo, LocalDate fechaNacimiento) {
        super(nombre, apellidos, Rol.GERENTE, nombreUsuario, contraseña, telefono, fechaNacimiento);
        this.sueldo = sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public LocalDate getfechaRegistro() {
        return fechaRegistro;
    }
    @Override
    public String toString() {
        return String.format("%s, Fecha de regustro: %s", super.toString(), this.fechaRegistro);
    }
    public static void registrarGerente(){
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.GERENTE);

        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String nombreUsuario = datosComun.get(2);
        String telefono = datosComun.get(3);
        String contraseña = datosComun.get(4);
        LocalDate fechaNacimiento = DatosComun.preguntarFecha();
        System.out.println("Ingresar el sueldo del Gerente ");
        double sueldo = sc.nextDouble();

        Gerente gerente = new Gerente(nombre, apellidos, nombreUsuario, telefono, contraseña, sueldo, fechaNacimiento);
        if(!Biblioteca.usuarios.containsKey(Rol.GERENTE)){
           Biblioteca.usuarios.put(Rol.GERENTE, new ArrayList<>());
        }
       Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
    }

    public static void mostrarGerentes(){
        System.out.println("\nGerentes administrando el sistema");
        for (Usuario usuario : Biblioteca.usuarios.get(Rol.GERENTE)){
            Gerente gerente = (Gerente) usuario;
            System.out.println(gerente.toString());
        }
    }
    public static void eliminarGerente(Gerente gerente) {
        if (gerente == null || !Biblioteca.usuarios.containsKey(Rol.GERENTE) || !Biblioteca.usuarios.get(Rol.GERENTE).contains(gerente)) {
            System.out.println("Acceso denegado debes iniciar sesion como Gerente.");
            return;

        }
        mostrarGerentes();
        System.out.println("Ingresar el nombre de usuario del Gerente a eliminar. ");
        String nombreUsuario = sc.nextLine();

        for (Usuario usuario : Biblioteca.usuarios.get(Rol.GERENTE)) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {

                Biblioteca.usuarios.get(Rol.GERENTE).remove(usuario);
                System.out.println("Gerente eliminado exitosamente.");
                return;
            }
            System.out.println("No se encontro a ningún Trabajador con ese usurio. ");
        }
    }

    public static void modificarGerente(Gerente gerente) {
        if (gerente.getRol() != Rol.GERENTE) {
            System.out.println("Acceso denegado debe usted tener una cuenta con el rol de Gerente. ");
        }

        mostrarGerentes();
        System.out.println("Ingresar el nombre de usuario del Gerente que deseas modificar. ");
        String nombreUsuario = sc.nextLine();
        sc.nextLine();
        for (Usuario trabajador : Biblioteca.usuarios.get(Rol.GERENTE)) {
            if (trabajador.getNombreUsuario().equals(nombreUsuario)) {
            }
        }
        System.out.println("Información actual del Gerente:");
        System.out.println(gerente.toString());

        System.out.println("Desea hacer modificaciones completeas del Gerente(si/no): ");
        String opcion = sc.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            ArrayList<String> datosNuevosComun = DatosComun.obtenerDatosComun(Rol.GERENTE);

            String nuevoNombre = datosNuevosComun.get(0);
            gerente.setNombreUsuario(nuevoNombre);
            String nuevoApellido = datosNuevosComun.get(1);
            gerente.setApellido(nuevoApellido);
            String nuevoNombreUsuario = datosNuevosComun.get(2);
            gerente.setNombreUsuario(nuevoNombreUsuario);
            String nuevoTelefono = datosNuevosComun.get(3);
            gerente.setNumeroTelefono(nuevoTelefono);
            String nuevaContraseña = datosNuevosComun.get(4);
            gerente.setContraseña(nuevaContraseña);
            LocalDate nuevaFechaNacimiento = DatosComun.preguntarFecha();
            gerente.setFechaNacimiento(nuevaFechaNacimiento);
            System.out.println("Ingresar el nuevo sueldo del Gerente");
            double nuevoSueldo = sc.nextDouble();
            gerente.setSueldo(nuevoSueldo);

            System.out.println("Información del Gerente modificada exitosamente. ");

        }else{
            System.out.println("¿Qué datos del Gerente deseas modificar individualmente?");
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
                    System.out.println("Ingresa el nuevo Nombre del Gerente: ");
                    String nuevoNombre = sc.nextLine();
                    gerente.setNombreUsuario(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingresa el nuevo Apellido del Gerente: ");
                    String nuevoApellido = sc.nextLine();
                    gerente.setApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingresa la nueva contraseña: ");
                    String nuevaContraseña = sc.nextLine();
                    gerente.setContraseña(nuevaContraseña);
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
                    gerente.setNumeroTelefono(nuevoTelefono);
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

                    gerente.setNombreUsuario(nuevoNombreUsuario);
                    System.out.println("Nombre de usuario actualizado correctamente.");
                    break;
                case 6:
                    LocalDate nuevaFechaNacimiento = DatosComun.preguntarFecha();
                    gerente.setFechaNacimiento(nuevaFechaNacimiento);
                    System.out.println("Fecha de Nacimiento actualizada correctamente.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }

    }
    @Override
    public void checarEntrada(){
        System.out.println("Checar entrada de correo.");
    }
    @Override
    public void checarSalida(){
        System.out.println("Checar salida de correo.");
    }
}


