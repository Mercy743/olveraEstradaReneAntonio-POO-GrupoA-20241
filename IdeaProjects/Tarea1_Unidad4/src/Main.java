import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        boolean band = true;
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");
        while(band){
            System.out.println("\n==========Calculadora de figuras Areas y Perimetros==========");
            System.out.println("Elegir la figura para calcular. ");
            System.out.println("1. Circulo. ");
            System.out.println("2. Cuadrado. ");
            System.out.println("3. Triangulo. ");
            System.out.println("4. Rectangulo");
            System.out.println("5. Apagar la calculadora");
            System.out.println("=============================================================");
            System.out.println("Ingresar su opción: ");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingresar el Radio del circulo: ");
                    double radius = sc.nextDouble();

                    Circle circle = new Circle(radius);
                    System.out.println();
                    System.out.println("Círculo - Perímetro: " + df.format(circle.calcularPerimetro()));
                    System.out.println("Círculo - Área: " + df.format(circle.calcularArea()));
                    break;
                case 2:
                    System.out.println("Ingresa uno de los lados del Cuadrado: ");
                    double lado = sc.nextDouble();

                    Square square = new Square(lado);

                    System.out.println("Cuadrado - Perímetro: "+ df.format(square.calcularPerimetro()));
                    System.out.println("Cuadrado - Área: " + df.format(square.calcularArea()));
                    break;
                case 3:
                    System.out.println("Ingresa el primer lado del triangulo: ");
                    double side1 = sc.nextDouble();
                    System.out.println("Ingresa el segundo lado del triangulo: ");
                    double side2 = sc.nextDouble();
                    System.out.println("Ingresa el tercer lado del triangulo: ");
                    double side3 = sc.nextDouble();

                    Triangle triangle = new Triangle(side1, side2, side3);

                    System.out.println("Triángulo - Perímetro: " + df.format(triangle.calcularPerimetro()));
                    System.out.println("Triángulo - Área: " + df.format(triangle.calcularArea()));
                    break;
                case 4:
                    System.out.println("Ingrese la altura del Rectangulo: ");
                    double height = sc.nextDouble();
                    System.out.println("Ingresa el ancho del Rectangulo: ");
                    double width = sc.nextDouble();

                    Rectangle rectangle = new Rectangle(height, width);

                    System.out.println("Rectangulo - Perimetro: " + df.format(rectangle.calcularPerimetro()));
                    System.out.println("Rectangulo - Area: " + df.format(rectangle.calcularArea()));
                    break;
                case 5:
                    System.out.println("---------OFF---------");
                    band = false;
                    break;
                default:
                    System.out.println("Opcion no valida. Ingresar una opción del 1 al 5. ");
            }

        }





    }
}
