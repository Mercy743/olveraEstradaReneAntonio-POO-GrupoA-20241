package Biblioteca;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    //Cliente
    //Ver sus rentas, su info, ver libros disponibles
    
    //Trabajar
    //Registrar clientes y libros (CRUD)
    //C - Create
    //R - Read
    //U - Update
    //D - Delete
    
    //Gerente
    //
    public static void ejecutarMenu(){
       boolean bandera = true;
       do{
           System.out.println("\n BIENVENIDOS A LA BIBLIOTECA");
           System.out.println("1. Registrar Producto");
           System.out.println("2. Registrar Cliente");
           System.out.println("3. Mostrar Productos");
           System.out.println("4. Mostrar Clientes");
           System.out.println("5. Eliminar Producto");
           System.out.println("6. Eliminar Cliente");
           System.out.println("7. Añadir a stock");
           System.out.println("8. Eliminar del stock");
           System.out.println("9. Realizar compra");
           System.out.println("10. Ver compra");
           System.out.println("11. Salir");
           System.out.println("Proporcione una opción del menu: ");
           int opcion = sc.nextInt();
           switch (opcion){
               case 1:
                   
                   break;
               case 2:
                   
                   break;
               case 3:
               
               break;
                case 4:
                   
                   break;
               case 5:
                   
                   break;
               case 6:
               
               break;
                case 7:
                   
                   break;
               case 8:
                   
                   break;
               case 9:
               
               break;
                case 10:
                   
                   break;
               case 11:
                   System.out.println("Saliendo del Menu...");
                   bandera = false;
                   break;
               default:
                   System.out.println("Esa no es una opcion valida. Ingrese de nuevo.");
           }
       }while(bandera);
    }
}
