package Libros.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LibrosUtils {
    public static ArrayList<String> obtenerLibrosDatosComun() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = new ArrayList<>();

        System.out.println("Ingresa el nombre del libro: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingresa el autor libro: ");
        String autor = scanner.nextLine();

        System.out.println("Ingresa el editorial del libro: ");
        String editorial = scanner.nextLine();

        LocalDate fechaPublicacion = preguntarFecha();

        System.out.println("Ingresa el precio del libro: ");
        double precio = scanner.nextDouble();

        System.out.println("Ingresa el stock del libro: ");
        int stock = scanner.nextInt();

        datosComun.addAll(Arrays.asList(nombre, autor, editorial, String.valueOf(fechaPublicacion), String.valueOf(precio), String.valueOf(stock)));
        return datosComun;
    }
public static LocalDate preguntarFecha() {
    while(true) {
        Scanner sc = new Scanner(System.in);
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
