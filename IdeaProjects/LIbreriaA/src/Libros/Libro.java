package Libros;

import Libros.constants.Genero;

import java.time.LocalDate;

public abstract class Libro {
    private static int CANTIDAD_LIBROS = 1;
    private int id;
    private String nombre;
    private String autor;
    private String editorial;
    private LocalDate fechaDePublicacion;
    private Genero genero;
    private double precio;
    private int stock;

    public Libro(String nombre, String autor, String editorial, LocalDate fechaDePublicacion, Genero genero, double precio, int stock) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.fechaDePublicacion = fechaDePublicacion;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;

    }

    protected abstract void filtrarPorPrecio(double precio);
    public double getPrecio() {
        return precio;
    }
    public String getNombre(){
        return nombre;
    }

}
