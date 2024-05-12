package Libros;

import Biblioteca.Biblioteca;
import Libros.Utils.LibrosUtils;
import Libros.constants.Genero;
import Libros.constants.SubGeneroComedia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibroComedia extends Libro{
    private SubGeneroComedia subGeneroComedia;
    public LibroComedia(String nombre, String autor, String editorial, LocalDate fechaDePublicacion, double precio, int stock, SubGeneroComedia subGeneroComedia) {
        super(nombre, autor, editorial, fechaDePublicacion, Genero.Comedia, precio, stock);
        this.subGeneroComedia = subGeneroComedia;
    }
    public SubGeneroComedia getSubGeneroComedia() {
        return subGeneroComedia;
    }
    public static void registrarLibro(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.obtenerLibrosDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingresa el subgenre del libro: ");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Romántica");
        System.out.println("2. Trágica");

        int opcionSubgenero = sc.nextInt();
        SubGeneroComedia subGeneroInput = null;
        if(opcionSubgenero == 1){
            subGeneroInput = SubGeneroComedia.Romantica;
        }else{
            subGeneroInput = SubGeneroComedia.Tragica;
        }

       LibroComedia libroComedia = new LibroComedia(nombre,autor, editorial, fechaPublicacion, precio, stock, subGeneroInput);
        if (!Biblioteca.libros.containsKey(Genero.Comedia)) {
            Biblioteca.libros.put(Genero.Comedia, new ArrayList<>());
        }
        Biblioteca.libros.get(Genero.Comedia).add(libroComedia);
    }

    @Override
    public void filtrarPorPrecio(double precio) {
        System.out.println("Libros de comedia con precio mayor o igual a " + precio + ":");

        // Obtener la lista de libros de comedia
        ArrayList<Libro> librosComedia = Biblioteca.libros.get(Genero.Comedia);

        // Filtrar los libros con precio mayor o igual al precio especificado
        List<Libro> librosFiltrados = librosComedia.stream()
                .filter(libro -> libro.getPrecio() >= precio)
                .collect(Collectors.toList());

        // Imprimir los detalles de los libros filtrados
        librosFiltrados.forEach(libro -> System.out.println(libro.toString()));
    }

    public static void eliminarLibro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el subgénero que desea eliminar:");
        System.out.println("1. Romántica");
        System.out.println("2. Trágica");
        int opcionSubgenero = sc.nextInt();
        SubGeneroComedia subgeneroEliminar = (opcionSubgenero == 1) ? SubGeneroComedia.Romantica : SubGeneroComedia.Tragica;

        boolean libroEncontrado = false;

        // Verificamos si existe la lista de libros para el género Comedia
        if (Biblioteca.libros.containsKey(Genero.Comedia)) {
            // Recorremos los libros del género Comedia
            for (Libro libro : Biblioteca.libros.get(Genero.Comedia)) {
                // Verificamos si el libro es de la clase LibroComedia y su subgénero coincide con el proporcionado por el usuario
                if (libro instanceof LibroComedia && ((LibroComedia) libro).getSubGeneroComedia() == subgeneroEliminar) {
                    libroEncontrado = true;
                    System.out.println("Ingrese el nombre del libro que desea eliminar:");
                    String nombreLibroEliminar = sc.nextLine();

                    // Verificamos si el nombre del libro coincide con el proporcionado por el usuario
                    if (libro.getNombre().equalsIgnoreCase(nombreLibroEliminar)) {
                        // Eliminamos el libro de la lista
                        Biblioteca.libros.get(Genero.Comedia).remove(libro);
                        System.out.println("El libro se ha eliminado correctamente de la biblioteca.");
                        return; // Terminamos el método una vez que se encuentra y elimina el libro
                    }
                }
            }
        }

        if (!libroEncontrado) {
            System.out.println("No se encontró ningún libro del subgénero " + subgeneroEliminar + " en la biblioteca.");
        } else {
            System.out.println("No se encontró ningún libro con ese nombre en la biblioteca.");
        }
    }
}
