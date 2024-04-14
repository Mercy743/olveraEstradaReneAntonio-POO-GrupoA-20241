package store.herencia;

public class Householde_Appliance extends Product {
    private String model;
    public Householde_Appliance(String name, double price, String importDate, int stock, String model){
        super(name, price, importDate, stock);
        this.model = model;
    }
    
    @Override
    public String toString() {
        return super.getData() + String.format(", model: %s", model);
    }
}
