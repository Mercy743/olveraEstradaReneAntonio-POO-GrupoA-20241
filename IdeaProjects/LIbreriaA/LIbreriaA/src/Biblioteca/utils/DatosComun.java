package Biblioteca.utils;

import Biblioteca.Biblioteca;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class DatosComun {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        ArrayList<String> datosComun = new ArrayList();

        String rolActual = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";
        System.out.println(String.format("\nRegistrar %s ", rolActual));

        System.out.println("\nRegistrar CLiente");

        System.out.println("Escriba el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Escriba el apellido: ");
        String apellido = sc.nextLine();

        //System.out.println("Escriba su fecha de nacimiento unicamente con numeros: ");
        LocalDate fechaNacimiento = preguntarFecha();

        String nombreUsuario = obtenerNombreUsuario();

        String telefono = obtenrNumeroTelefono();

        System.out.println("Escibra su contraseña: ");
        String contraseña = sc.nextLine();

        Arrays.asList(nombre, apellido, nombreUsuario, telefono, contraseña).addAll(datosComun);
        return datosComun;
    }
    private static String obtenrNumeroTelefono(){
        boolean numeroExistente;
        String telefono;
        do {
            System.out.println("Ingresa el numero de Telefono: ");
            telefono = sc.nextLine();
            numeroExistente = false;
            for (ArrayList<Usuario> userList : Biblioteca.usuarios.values()) {
                for (Usuario usuario : userList) {
                    if (usuario.getNumeroTelefono().equals(telefono)) {
                        numeroExistente = true;
                        break;
                    }
                }
            }
            if(numeroExistente) {
                System.out.println("El numero ya existe, Intenta de nuevo.");
            }
        } while(numeroExistente);
        return telefono;
    }
    private static String obtenerNombreUsuario(){
        boolean nombreUsuarioExistente;
        String nombreUsuario;
        do {
            System.out.println("Ingresa el nombre de usuario: ");
            nombreUsuario = sc.nextLine();
            nombreUsuarioExistente = false;
            for (ArrayList<Usuario> userList : Biblioteca.usuarios.values()) {
                for (Usuario usuario : userList) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        break;
                    }
                }
            }
            if(nombreUsuarioExistente){
                System.out.println("El nombre de usuario ya existe, Intenta de nuevo.");
            }
        } while(nombreUsuarioExistente);
        return nombreUsuario;
    }
    public static LocalDate preguntarFecha() {
        while(true) {
            System.out.println("Mes: ");
            int mes = sc.nextInt();
            System.out.println("Dia: ");
            int dia = sc.nextInt();
            System.out.println("Año: ");
            int año = sc.nextInt();
            sc.nextLine();
            if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31) {
                return LocalDate.of(año, mes, dia);
            }
            System.out.println("Fecha de nacimiento mal ingresada.");
            System.out.println("Vuelva a ingresar la fecha de nacimiento.");
        }
    }
}
