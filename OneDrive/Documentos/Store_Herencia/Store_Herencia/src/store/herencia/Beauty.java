package store.herencia;
public class Beauty extends Product {
    private String type;
    public Beauty (String name, double price, String importDate, int stock, String type){
        super(name, price, importDate, stock);
        this.type = type;
    }
    @Override
    public String toString() {
        return super.getData() + String.format(", Type: %s", type);
    }
}
