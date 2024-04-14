package store.herencia;

public class Product{
    private static int CANTIDAD_PRODUCTOS = 0;
    private int serialNumber;
    private String name;
    private double price;
    private String importDate;
    private int stock;

    public Product(String name, double price, String importDate, int stock) {
        this.serialNumber = CANTIDAD_PRODUCTOS++;
        this.name = name;
        this.price = price;
        this.importDate = importDate;
        this.stock = stock;
        CANTIDAD_PRODUCTOS++;
    }

    protected String getData() {
        return String.format("Nombre: %s, precio %f, fecha de importación: %s, stock: %d",
                name, price, importDate, stock);
    }
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    } 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}