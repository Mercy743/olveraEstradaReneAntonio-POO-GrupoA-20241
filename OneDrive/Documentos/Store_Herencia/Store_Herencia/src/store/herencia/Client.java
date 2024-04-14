package store.herencia;

import java.util.ArrayList;
import java.util.Random;
public class Client extends Person{
    private String ID;
    private Random r = new Random();
    private ArrayList<String> purchaseHistory = new ArrayList<>();
    public Client (String name, String lastName, String address){
        super(name, lastName, address);
        ID = generateClientID();
    }
    private String generateClientID(){
        String caractares = "abcdefghijklmnopqrstuvwxyz0123456789";
        String com = "";
        for (int i = 0; i < 6 ;i++){
            com = com += caractares.charAt(r.nextInt(caractares.length()));
        }
        return com;
    }

    public String getID() {
        return ID;
    }
    @Override
    public String toString() {
    return "Name: " + name + ", Last Name: " + lastName + ", Address: " + address;
}
    public void addToPurchaseHistory(Product product, int quantity) {
        String purchaseDetail = "Product: " + product.getName() + ", Quantity: " + quantity;
        purchaseHistory.add(purchaseDetail);
    }

    public ArrayList<String> getPurchaseHistory() {
        return purchaseHistory;
    }
    public void viewPurchaseHistory() {
    if (purchaseHistory.isEmpty()) {
        System.out.println("No purchase history available.");
        return;
    }

    System.out.println("Purchase History for all Clients:");
    for (String purchaseDetail : purchaseHistory) {
        System.out.println(purchaseDetail);
    }
}
}
