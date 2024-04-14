package store.herencia;
import java.util.Scanner;
import java.util.ArrayList;
public class Store {
    private ArrayList<Cleaning> cleaningProduct = new ArrayList<>();
    private ArrayList<Food> foodProduct = new ArrayList<>();
    private ArrayList<Householde_Appliance> householde_applianceProduct = new ArrayList<>();
    private ArrayList<Beauty> beautyProduct = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private ArrayList<String> registerCommonData() {
        ArrayList<String> commonData = new ArrayList<>();

        System.out.println("Enter name: ");
        String name = sc.nextLine();
        commonData.add(name);

        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        commonData.add(String.valueOf(price));

        System.out.println("Enter import date: ");
        String importDate = sc.nextLine();
        commonData.add(importDate);

        System.out.println("Enter the stock: ");
        int stock = sc.nextInt();
        commonData.add(String.valueOf(stock));

        return commonData;
    }

     public void registerCleaningProduct() {
        System.out.println("==================================");
        System.out.println("** Register cleaning product **");
        System.out.println("==================================");
        ArrayList<String> data = registerCommonData();
        String name = data.get(0);
        double price = Double.parseDouble(data.get(1));
        String importDate = data.get(2);
        int stock = Integer.parseInt(data.get(3));
        sc.nextLine();
        
        System.out.println("Enter brand: ");
        String brand = sc.nextLine();

        Cleaning cleaning = new Cleaning(name, price, importDate, stock, brand);
        cleaningProduct.add(cleaning);

        System.out.println("\nSuccessfully registered.");
    }

    public void registerFoodProduct() { 
        System.out.println("==================================");
        System.out.println("** Register Food product **");
        System.out.println("==================================");

        ArrayList<String> data = registerCommonData();
        String name = data.get(0);
        double price = Double.parseDouble(data.get(1));
        String importDate = data.get(2);
        int stock = Integer.parseInt(data.get(3));
        sc.nextLine();

       System.out.println("Enter the expiration date: ");
       String sell_by_date = sc.nextLine();

       Food food = new Food(name, price, importDate, stock, sell_by_date);
       foodProduct.add(food);

         System.out.println("\nSuccessfully registered.");
    }
    public void registerBeautyProduct() { 
        System.out.println("==================================");
        System.out.println("** Register beauty product **");
        System.out.println("==================================");

        ArrayList<String> data = registerCommonData();
        String name = data.get(0);
        double price = Double.parseDouble(data.get(1));
        String importDate = data.get(2);
        int stock = Integer.parseInt(data.get(3));
        sc.nextLine();
        
        System.out.println("Enter the type: ");
        String type = sc.nextLine();

       Beauty beauty = new Beauty(name, price, importDate, stock, type);
       beautyProduct.add(beauty);

        System.out.println("\nSuccessfully registered");
    }
    public void registerHouseholdApplianceProduct() { 
        System.out.println("==================================");
        System.out.println("** Register Householde Appliance product **");
        System.out.println("==================================");

        ArrayList<String> data = registerCommonData();
        String name = data.get(0);
        double price = Double.parseDouble(data.get(1));
        String importDate = data.get(2);
        int stock = Integer.parseInt(data.get(3));
        sc.nextLine();
        
        System.out.println("Enter model: ");
        String model = sc.nextLine();

       Householde_Appliance household_appliance = new Householde_Appliance(name, price, importDate, stock, model);
       householde_applianceProduct.add(household_appliance);

        System.out.println("\nSuccessfully registered.");
    }
    public void registerClient(){
       System.out.println("==================================");
       System.out.println("** Client Register **");
       System.out.println("==================================");
       
        System.out.println("Enter customer's name: ");
        String name = sc.nextLine();
        System.out.println("Enter  customer's last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter  customer's address: ");
        String address = sc.nextLine();
        
        Client client = new Client(name, lastName, address);
        clients.add(client);
    }
    public void registerEmloyee(){
       System.out.println("==================================");
       System.out.println("** Employee Register **");
       System.out.println("==================================");
        
        System.out.println("Enter employee's name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee's last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter employee's address: ");
        String address = sc.nextLine();
        System.out.println("Give the employee's role: ");
        String rol = sc.nextLine();
        
        Employee employee = new Employee(name, lastName, address, rol);
        employees.add(employee);
    }
    public void showAllProducts() {
    System.out.println("==================================");
    System.out.println("** All Registered Products **");
    System.out.println("==================================");

    System.out.println("\nCleaning Products:");
    for (Cleaning cleaning : cleaningProduct) {
        System.out.println("Serial Number: " + cleaning.getSerialNumber());
        System.out.println(cleaning);
    }

    System.out.println("\nFood Products:");
    for (Food food : foodProduct) {
        System.out.println("Serial Number: " + food.getSerialNumber());
        System.out.println(food);
    }

    System.out.println("\nHousehold Appliance Products:");
    for (Householde_Appliance appliance : householde_applianceProduct) {
        System.out.println("Serial Number: " + appliance.getSerialNumber());
        System.out.println(appliance);
    }

    System.out.println("\nBeauty Products:");
    for (Beauty beauty : beautyProduct) {
        System.out.println("Serial Number: " + beauty.getSerialNumber());
        System.out.println(beauty);
    }
}
    public void showAllClients() {
    System.out.println("==================================");
    System.out.println("** All Registered Clients **");
    System.out.println("==================================");

    for (Client client : clients) {
        System.out.println("ID: " + client.getID() + ", " + client);
    }
}
    public boolean removeProductBySerialNumber(int serialNumber) {
    for (Cleaning cleaning : cleaningProduct) {
        if (cleaning.getSerialNumber() == serialNumber) {
            cleaningProduct.remove(cleaning);
            System.out.println("Product removed successfully.");
            return true;
        }
    }

    for (Food food : foodProduct) {
        if (food.getSerialNumber() == serialNumber) {
            foodProduct.remove(food);
            System.out.println("Product removed successfully.");
            return true;
        }
    }

    for (Householde_Appliance appliance : householde_applianceProduct) {
        if (appliance.getSerialNumber() == serialNumber) {
           householde_applianceProduct.remove(appliance);
           System.out.println("Product removed successfully.");
           return true;
        }
    }

    for (Beauty beauty : beautyProduct) {
        if (beauty.getSerialNumber() == serialNumber) {
            beautyProduct.remove(beauty);
            System.out.println("Product removed successfully.");
            return true;
        }
    }
    System.out.println("No product found with the given serial number.");
    return false;
}
    public void purchaseProduct(Client client) {
        
        showAllProducts();
        System.out.println("Enter the serial number of the product you want to purchase:");
        int serialNumber = sc.nextInt();

        Product productToPurchase = findProductBySerialNumber(serialNumber);
        if (productToPurchase == null) {
            System.out.println("Product with the given serial number not found.");
            return;
        }

        System.out.println("Enter the quantity you want to purchase:");
        int quantityToPurchase = sc.nextInt();

        if (quantityToPurchase > productToPurchase.getStock()) {
            System.out.println("Not enough stock available.");
            return;
        }
        double totalPrice = quantityToPurchase * productToPurchase.getPrice();
        int newStock = productToPurchase.getStock() - quantityToPurchase;
        productToPurchase.setStock(newStock);

       
        System.out.println("Purchase details:");
        System.out.println("Product: " + productToPurchase.getName());
        System.out.println("Quantity: " + quantityToPurchase);
        System.out.println("Total Price: " + totalPrice);
        client.addToPurchaseHistory(productToPurchase, quantityToPurchase);
    }
    private Product findProductBySerialNumber(int serialNumber) {
    for (Cleaning cleaning : cleaningProduct) {
        if (cleaning.getSerialNumber() == serialNumber) {
            return cleaning;
        }
    }
    for (Food food : foodProduct) {
        if (food.getSerialNumber() == serialNumber) {
            return food;
        }
    }
    for (Householde_Appliance appliance : householde_applianceProduct) {
        if (appliance.getSerialNumber() == serialNumber) {
            return appliance;
        }
    }
    for (Beauty beauty : beautyProduct) {
        if (beauty.getSerialNumber() == serialNumber) {
            return beauty;
        }
    }
    return null;
}
     public void removeClientById(String clientID) {
        Client clientToRemove = findClientByID(clientID);
        if (clientToRemove == null) {
            System.out.println("Client with the given ID not found.");
            return;
        }
        if (!clientToRemove.getPurchaseHistory().isEmpty()) {
            System.out.println("This customer has purchases.");
            return;
        }

        clients.remove(clientToRemove);
        System.out.println("Client removed successfully.");
    }

    public Client findClientByID(String clientId) {
        for (Client client : clients) {
            if (client.getID().equals(clientId)) {
                return client;
            }
        }
        return null;
    }
    public void addToStockBySerialNumber(int serialNumber, int quantityToAdd) {
    Product productToUpdate = findProductBySerialNumber(serialNumber);
    if (productToUpdate != null) {
        productToUpdate.setStock(productToUpdate.getStock() + quantityToAdd);
        System.out.println("Stock updated successfully.");
    } else {
        System.out.println("Product with the given serial number not found.");
    }
}
    public void removeFromStockBySerialNumber(int serialNumber, int quantityToRemove) {
    Product productToUpdate = findProductBySerialNumber(serialNumber);
    if (productToUpdate != null) {
        int currentStock = productToUpdate.getStock();
        if (currentStock >= quantityToRemove) {
            productToUpdate.setStock(currentStock - quantityToRemove);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Error: Cannot remove more items than available in stock.");
        }
    } else {
        System.out.println("Product with the given serial number not found.");
    }
}
   public void viewPurchaseHistory() {
        System.out.println("==================================");
        System.out.println("** All Purchase History **");
        System.out.println("==================================");
        if (clients.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }
        System.out.println("Purchase History for all clients:");
        for (Client client : clients) {
            ArrayList<String> purchaseHistory = client.getPurchaseHistory();
            
            System.out.println("Purchase History for " + client.getName() + client.getLastName() + ": ");
            for (String purchaseDetail : purchaseHistory) {
                System.out.println(purchaseDetail);
            }
        }
    }
}

