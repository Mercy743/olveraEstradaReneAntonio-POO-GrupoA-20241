
package store.herencia;

public class Cleaning extends Product {
    private String brand;
    public Cleaning(String name, double price, String importDate, int stock, String brand) {
        super(name, price, importDate, stock);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return super.getData() + String.format(", brand: %s", brand);
    }
}
