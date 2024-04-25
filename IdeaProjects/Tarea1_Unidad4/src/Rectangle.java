public class Rectangle extends Shape{
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (width + height);
    }

    @Override
    public double calcularArea() {
        return width * height;
    }
}
