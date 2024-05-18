package Biblioteca.utils;

import java.util.Scanner;

public class Tools {
    private static Scanner sc = new Scanner(System.in);

    public static int nextInt() {
        while (true) {
            String numero = sc.nextLine();
            try {
                int respuesta = Integer.parseInt(numero);
                return respuesta;
            } catch (Exception var3) {
                System.out.println("Por favor ingrese un número.");
            }
        }
    }
}
