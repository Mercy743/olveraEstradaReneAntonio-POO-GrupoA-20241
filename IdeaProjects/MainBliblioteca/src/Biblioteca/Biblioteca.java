package Biblioteca;

import Usuarios.Cliente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.util.Arrays;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Usuarios.Gerente;
public class Biblioteca {
    private Scanner sc;
    HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap();
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

    public LocalDate preguntarFecha() {
        while(true) {
            System.out.println("Mes: ");
            int mes = this.sc.nextInt();
            System.out.println("Dia: ");
            int dia = this.sc.nextInt();
            System.out.println("Año: ");
            int año = this.sc.nextInt();
            this.sc.nextLine();
            if (mes >= 1 && mes <= 12 && dia >= 1 && dia <= 31) {
                LocalDate date = LocalDate.of(año, mes, dia);
                return date;
            }
            System.out.println("Fecha de nacimiento mal ingresada.");
            System.out.println("Vuelva a ingresar la fecha de nacimiento.");
        }
    }
    private ArrayList<String> obtenerDatosComun(Rol rol) {
        ArrayList<String> datosComun = new ArrayList();

        String rolActual = rol == Rol.CLIENTE ? "Cliente" : rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";
        System.out.println(String.format("\nRegistrar %s ", rolActual));

        System.out.println("\nRegistrar CLiente");

        System.out.println("Escriba el nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Escriba el apellido: ");
        String apellido = sc.nextLine();

        //System.out.println("Escriba su fecha de nacimiento unicamente con numeros: ");
        //LocalDate fechaNacimiento = preguntarFecha();

        String nombreUsuario = obtenerNombreUsuario();

        String telefono = obtenrNumeroTelefono();

        System.out.println("Escibra su contraseña: ");
        String contraseña = sc.nextLine();

        Arrays.asList(nombre, apellido, nombreUsuario, telefono, contraseña).addAll(datosComun);
        return datosComun;
    }
    public void registrarCliente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);

        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String nombreUsuario = datosComun.get(2);
        String telefono = datosComun.get(3);
        String contra = datosComun.get(4);

        Cliente cliente = new Cliente(nombre, apellidos, nombreUsuario, telefono, contra);
        if(!usuarios.containsKey(Rol.CLIENTE)){
            usuarios.put(Rol.CLIENTE, new ArrayList<>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);
    }
    public void registrarTrabajador(){
        ArrayList<String> datosComun = obtenerDatosComun(Rol.TRABAJADOR);

        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String nombreUsuario = datosComun.get(2);
        String telefono = datosComun.get(3);
        String contraseña = datosComun.get(4);

        System.out.println("Ingresar el sueldo del Trabajador");
        double sueldo = sc.nextDouble();

        Trabajador trabajador = new Trabajador(nombre, apellidos, nombreUsuario, telefono, contraseña, sueldo);
        if(!usuarios.containsKey(Rol.TRABAJADOR)){
            usuarios.put(Rol.TRABAJADOR, new ArrayList<>());
        }
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
    }
    public void registrarGerente(){
        ArrayList<String> datosComun = obtenerDatosComun(Rol.GERENTE);

        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String nombreUsuario = datosComun.get(2);
        String telefono = datosComun.get(3);
        String contraseña = datosComun.get(4);
        System.out.println("Ingresar el sueldo del Gerente ");
        double sueldo = sc.nextDouble();

        Gerente gerente = new Gerente(nombre, apellidos, nombreUsuario, telefono, sueldo, contraseña);
        if(!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE, new ArrayList<>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
    }
    private String obtenerNombreUsuario(){
        boolean nombreUsuarioExistente;
        String nombreUsuario;
        do {
            System.out.println("Ingresa el nombre de usuario: ");
            nombreUsuario = sc.nextLine();
            nombreUsuarioExistente = false;
            for (ArrayList<Usuario> userList : usuarios.values()) {
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
    private String obtenrNumeroTelefono(){
        boolean numeroExistente;
        String telefono;
        do {
            System.out.println("Ingresa el numero de Telefono: ");
            telefono = sc.nextLine();
            numeroExistente = false;
            for (ArrayList<Usuario> userList : usuarios.values()) {
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


    public void mostrarClientes(){
        System.out.printf("\nClientes en la biblioteca");
        for (Usuario usuario : usuarios.get(Rol.CLIENTE)){
            Cliente cliente = (Cliente) usuario;
            System.out.println(cliente.toString());
            }
        }
    public void mostrarTrabajadores(){
        System.out.println("\nTrabajadors en la biblioteca");
        for(Usuario usuario : usuarios.get(Rol.TRABAJADOR)){
            Trabajador trabajador = (Trabajador) usuario;
            System.out.println(trabajador.toString());
        }
    }
    public void mostrarGerentes(){
        System.out.println("\nGerentes administrando el sistema");
        for (Usuario usuario :  usuarios.get(Rol.GERENTE)){
            Gerente gerente = (Gerente) usuario;
            System.out.println(gerente.toString());
        }
    }
    }

