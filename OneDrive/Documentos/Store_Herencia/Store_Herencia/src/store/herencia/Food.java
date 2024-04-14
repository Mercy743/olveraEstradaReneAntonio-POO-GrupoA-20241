package store.herencia;


public class Food extends Product{
    private String sell_by_date;
    public Food(String name, double price, String importDate, int stock, String sell_by_date) {
        super(name, price, importDate, stock);
        this.sell_by_date = sell_by_date;
    }

   @Override
    public String toString() {
        return super.getData() + String.format(", sell-by-date: %s", sell_by_date);
    }
}

