public class CalculadoraRectangulo {
    public static double calcularAreaRectangulo(double base, double altura) {
        if (base < 0 || altura < 0) {
            throw new IllegalArgumentException("La base y la altura deben ser valores positivos");
        }
        return base * altura;
    }
}