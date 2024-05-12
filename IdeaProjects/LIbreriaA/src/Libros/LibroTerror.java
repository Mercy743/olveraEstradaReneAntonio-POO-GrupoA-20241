package Libros;

import Biblioteca.Biblioteca;
import Libros.Utils.LibrosUtils;
import Libros.constants.Genero;
import Libros.constants.SubGeneroTerror;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class LibroTerror extends Libro{
    private SubGeneroTerror subgenero;
    public LibroTerror(String nombre, String autor, String editorial, LocalDate fechaDePublicacion, double precio, int stock, SubGeneroTerror subgenero){
        super(nombre, autor, editorial, fechaDePublicacion, Genero.Terror, precio, stock);
        this.subgenero = subgenero;
    }
    public SubGeneroTerror getSubgenero() {
        return subgenero;
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
        System.out.println("1. Psicologico");
        System.out.println("2. Crimen");

        int opcionSubgenero = sc.nextInt();
        SubGeneroTerror subGeneroInput = null;
        if(opcionSubgenero == 1){
            subGeneroInput = SubGeneroTerror.Psicologico;
        }else{
            subGeneroInput = SubGeneroTerror.Crimen;
        }

        LibroTerror libroTerror = new LibroTerror(nombre,autor, editorial, fechaPublicacion, precio, stock, subGeneroInput);
        if (!Biblioteca.libros.containsKey(Genero.Terror)) {
            Biblioteca.libros.put(Genero.Terror, new ArrayList<>());
        }
        Biblioteca.libros.get(Genero.Terror).add(libroTerror);
    }
    @Override
    public void filtrarPorPrecio(double precio) {
        System.out.println("Libros de terror con precio mayor o igual a " + precio + ":");

        ArrayList<Libro> librosTerror = Biblioteca.libros.get(Genero.Terror);

        for (Libro libro : librosTerror) {
            if (libro.getPrecio() >= precio) {
                System.out.println(libro.toString());
            }
        }
    }
    public static void eliminarLibro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione el subgénero que desea eliminar:");
        System.out.println("1. Psicológico");
        System.out.println("2. Crimen");
        int opcionSubgenero = sc.nextInt();
        SubGeneroTerror subgeneroEliminar = (opcionSubgenero == 1) ? SubGeneroTerror.Psicologico : SubGeneroTerror.Crimen;

        boolean libroEncontrado = false;

        // Verificamos si existe la lista de libros para el género Terror
        if (Biblioteca.libros.containsKey(Genero.Terror)) {
            // Recorremos los libros del género Terror
            for (Libro libro : Biblioteca.libros.get(Genero.Terror)) {
                // Verificamos si el libro es de la clase LibroTerror y su subgénero coincide con el proporcionado por el usuario
                if (libro instanceof LibroTerror && ((LibroTerror) libro).getSubgenero() == subgeneroEliminar) {
                    libroEncontrado = true;
                    System.out.println("Ingrese el nombre del libro que desea eliminar:");
                    String nombreLibroEliminar = sc.nextLine();

                    // Verificamos si el nombre del libro coincide con el proporcionado por el usuario
                    if (libro.getNombre().equalsIgnoreCase(nombreLibroEliminar)) {
                        // Eliminamos el libro de la lista
                        Biblioteca.libros.get(Genero.Terror).remove(libro);
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
