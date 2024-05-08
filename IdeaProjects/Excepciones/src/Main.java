import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//Ejemplon de una excepcion en java
        //1.- tamaño de una cadena nula
        String cadena = null;

        try {
            int tamaño = cadena.length();
        } catch (NullPointerException e) {
            System.out.println("\nError es una cadena " + e.getMessage());
        }
        //2.- El index fuera del rango de un array
        int[] array = {1, 2, 3};
        int index = 5;

        try {
            int value = array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nEL valor del indice esta fuera del rango del array");
        }
        //3.- Division entre 0
        int dividendo = 10;
        int divisor = 0;

        try {
            int operacion = dividendo / divisor;
        } catch (ArithmeticException e) {
            System.out.println("\nSe produjo un error al dividir " + dividendo + e.getMessage());
        }
        //4.- Transformar una cadena en un numero entero no compatible
        String numeroString = "abc";
        try {
            int numero = Integer.parseInt(numeroString);
        } catch (NumberFormatException e) {
            System.out.println("\nSe produjo un error al intentar parsear la cadena debido a un " + e.getMessage());
        }
        //5. Abrir un archivo que no existe
        try {
            File archivo = new File("Archivo.txt");
            Scanner sc = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            System.out.println("\nArchivo no encontrado");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre de la clase a cargar:");
        String nombreClase = sc.nextLine();
        //6 Buscar una clase que no existe
        try {
            Class<?> clase = Class.forName(nombreClase);
            System.out.println("\nLa clase " + nombreClase + " ha sido cargada exitosamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("\nError: La clase " + nombreClase + " no pudo ser encontrada.");
        }
        //7.- Error de argumento ilegal
        System.out.println("Ingrese la base: ");
        double base = sc.nextDouble();
        System.out.println("Ingrese la altura: ");
        double altura = sc.nextDouble(); // Intentamos usar un valor negativo para la altura

        try {
            double area = CalculadoraRectangulo.calcularAreaRectangulo(base, altura);
            System.out.println("\nEl área del rectángulo es: " + area);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
        //8.- Error al utilizar la funcionalidad de un objeto
        Contador contador = new Contador();

        // Intentamos incrementar el contador sin inicializarlo primero
        try {
            contador.incrementar();
        } catch (IllegalStateException e) {
            System.out.println("\nError: " + e.getMessage());
        }
        // Inicializamos el contador
        contador.inicializar();
        // Ahora incrementamos el contador
        contador.incrementar();
        System.out.println("El valor del contador es: " + contador.obtenerValor()); // Salida: El valor del contador es: 1
        //9.- Operaciones no soportadas por la estructura logica.
        List<String> listaInmutable = Arrays.asList("Manzana", "Banana", "Cereza");

        // Intentamos invertir el orden de la lista inmutable
        try {
            Collections.reverse(listaInmutable); // Esto lanzará UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("\nError: " + e.getMessage());
        }
        //10.- Castear una instancia de una clase a otra.
        Animal animal = new Animal();

        try {
            // Intentamos convertir la instancia de Animal en una instancia de Perro
            Perro perro = (Perro) animal; // Esto lanzará ClassCastException
            // Llamamos al método de hacerSonido del perro
            perro.hacerSonido();
        } catch (ClassCastException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
