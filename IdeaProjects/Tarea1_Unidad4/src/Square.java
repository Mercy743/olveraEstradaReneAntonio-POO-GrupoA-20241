public class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double calcularPerimetro() {
            return 4 * side;
        }

        @Override
        public double calcularArea() {
            return side * side;
        }
    }

