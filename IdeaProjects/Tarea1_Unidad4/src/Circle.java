public class Circle implements Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double calcularArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radius;
    }
}
