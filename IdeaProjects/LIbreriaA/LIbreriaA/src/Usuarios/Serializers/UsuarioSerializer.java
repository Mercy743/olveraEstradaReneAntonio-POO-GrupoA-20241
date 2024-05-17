package Usuarios.Serializers;

import Biblioteca.Biblioteca;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public abstract class UsuarioSerializer {

    public static void serialize() {
        Gson json = new GsonBuilder()
                .setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.json"));
            json.toJson(Biblioteca.usuarios, writer);
            writer.close();
        } catch (Exception e) {
            System.out.println("Se produjo una 'exception' del tipo: " + e);
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Libros.json"));
            json.toJson(Biblioteca.libros, writer);
            writer.close();
        }catch (Exception e){
            System.out.println("Se produjo una 'exception' del tipo: " + e);
        }
    }
}