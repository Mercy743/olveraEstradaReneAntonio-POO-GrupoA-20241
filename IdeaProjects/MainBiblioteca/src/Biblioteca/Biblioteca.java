package Biblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import Usuarios.Cliente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
public class Biblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Cliente> cilientes = new ArrayList<Cliente>();
    private ArrayList<Trabajador> trabajadores = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public Usuario verificarInicioSesion(String usuario, String contraseña){
        for (Usuario usuarioActual : usuarios){
            if (usuarioActual.getNombreUsuario().equals(usuario)){
                if (usuarioActual.getContraseña().equals(contraseña)){
                    return usuarioActual;
                }
                return null;
            }
        }
        return null;
    }
    public LocalDate preguntarFecha(){
        int mes, dia, año;
        while (true){
            System.out.println("Mes: ");
            mes = sc.nextInt();
            System.out.println("Dia: ");
            dia = sc.nextInt();
            System.out.println("Año: ");
            año = sc.nextInt();
            sc.nextLine();
            if (mes<1 || mes>12 || dia<1 || dia>31){
                System.out.println("Fecha de nacimiento mal ingresada.");
                System.out.println("Vuelva a ingresar la fecha de nacimiento.");
            }else {
                break;
            }
        }
        LocalDate date = LocalDate.of(año, mes, dia);
        return date;
    }
    public void addCliente(){
        LocalDate fechaNacimiento;
        System.out.println("Escriba el nombre");
        String nombre = sc.nextLine();
        System.out.println("Escriba el apellido");
        String apellido = sc.nextLine();
        System.out.println("Escriba su fecha de nacimiento unicamente con numeros: ");
        fechaNacimiento = preguntarFecha();
    }
}
