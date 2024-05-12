package Libros;

import Biblioteca.Biblioteca;
import Libros.Utils.LibrosUtils;
import Libros.constants.Genero;
import Libros.constants.SubGeneroAccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroAccion extends Libro {
    private SubGeneroAccion subgenero;

    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaDePublicacion, double precio, int stock, SubGeneroAccion subgenero) {
        super(nombre, autor, editorial, fechaDePublicacion, Genero.Accion, precio, stock);
        this.subgenero = subgenero;
    }
    public SubGeneroAccion getSubgenero() {
        return this.subgenero;
    }

    public static void registrarLibro() {
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
        System.out.println("1. Aventura");
        System.out.println("2. Ciencia ficcion");

        int opcionSubgenero = sc.nextInt();
        SubGeneroAccion subGeneroInput = null;
        if (opcionSubgenero == 1) {
            subGeneroInput = SubGeneroAccion.Aventura;
        } else {
            subGeneroInput = SubGeneroAccion.Ficcion;
        }

        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fechaPublicacion, precio, stock, subGeneroInput);
        if (!Biblioteca.libros.containsKey(Genero.Accion)) {
            Biblioteca.libros.put(Genero.Accion, new ArrayList<>());
        }
        Biblioteca.libros.get(Genero.Accion).add(libroAccion);
    }

    @Override
    public void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.Accion)
                .stream().filter(libro -> libro.getPrecio() >= precio)
                .forEach(libro -> System.out.println(libro.toString()));

    }

    public static void eliminarLibro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el subgénero que desea eliminar:");
        System.out.println("1. Aventura");
        System.out.println("2. Ficción");
        int opcionSubgenero = sc.nextInt();
        SubGeneroAccion subgeneroEliminar = (opcionSubgenero == 1) ? SubGeneroAccion.Aventura : SubGeneroAccion.Ficcion;

        boolean libroEncontrado = false;

        // Recorremos todos los libros en la biblioteca
        for (Genero genero : Biblioteca.libros.keySet()) {
            // Verificamos si el género es de acción
            if (genero == Genero.Accion) {
                for (Libro libro : Biblioteca.libros.get(genero)) {
                    // Verificamos si el libro es del subgénero proporcionado
                    if (libro instanceof LibroAccion && ((LibroAccion) libro).getSubgenero() == subgeneroEliminar) {
                        libroEncontrado = true;
                        System.out.println("Ingrese el nombre del libro que desea eliminar:");
                        String nombreLibroEliminar = sc.nextLine();

                        // Verificamos si el nombre del libro coincide con el proporcionado por el usuario
                        if (libro.getNombre().equalsIgnoreCase(nombreLibroEliminar)) {
                            // Eliminamos el libro de la lista
                            Biblioteca.libros.get(genero).remove(libro);
                            System.out.println("El libro se ha eliminado correctamente de la biblioteca.");
                            return; // Terminamos el método una vez que se encuentra y el

                        }
                    }
                }
            }
        }
    }
}

