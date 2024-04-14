package store.herencia;

import java.util.Scanner;

public class SystemStore {
    private final String secure_password = "thisisnotasecurepassword";
    private Scanner sc = new Scanner(System.in);
    private Store store = new Store();

    public void runProgram() {
        boolean validPassword = false;

        do {
            System.out.println("\n*** WELCOME ***");
            System.out.println("Enter the password please: ");
            String password = sc.nextLine();

            if (password.equals(secure_password)) {
                validPassword = true;
                runSystemMenu();
            } else {
                System.out.println("\nIncorrect password, try again");
            }
        } while (!validPassword);
    }

    private void runSystemMenu() {
        int opcion = 0;
        do {
            System.out.println("\n** WELCOME TO THE SYSTEM **");
            System.out.println("1. Register Product");
            System.out.println("2. Register Client");
            System.out.println("3. Show Products");
            System.out.println("4. Show Clients");
            System.out.println("5. Delete Product");
            System.out.println("6. Delete Client");
            System.out.println("7. Add to Stock");
            System.out.println("8. Remove from Stock");
            System.out.println("9. Make Purchase");
            System.out.println("10. View Purchases");
            System.out.println("11. Exit");
            System.out.println("Select your option: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("\nYou selected register product");
                    System.out.println("Enter the type of product to register");
                    System.out.println("1. Cleaning");
                    System.out.println("2. Food");
                    System.out.println("3. Householde Appliance");
                    System.out.println("4. Makeup");
                    System.out.println("Select your option: ");
                    int opcionProcucto = sc.nextInt();
                    
                    switch (opcionProcucto) {
                        case 1:
                        store.registerCleaningProduct();
                            break;
                        case 2:
                        store.registerFoodProduct();
                            break;
                        case 3:
                        store.registerHouseholdApplianceProduct();
                            break;
                        case 4:
                        store.registerBeautyProduct();
                    }
                    break;
                case 2:
                    store.registerClient();
                    break;
                case 3: 
                    store.showAllProducts();
                    break;
                case 4:
                    store.showAllClients();
                    break;
                case 5:
                    System.out.println("Enter the serial number: ");
                    int serialNumber1 = sc.nextInt();
                    store.removeProductBySerialNumber(serialNumber1);
                    break;
                case 6:
                   System.out.println("Enter the ID of the client to remove:");
                   String clientId = sc.nextLine();
                   store.removeClientById(clientId);
                break;
                case 7:
                System.out.println("Enter the serial number of the product:");
                int serialNumber2 = sc.nextInt();
                sc.nextLine(); 
               
                System.out.println("Enter the quantity to add to the stock:");
                int quantityToAdd = sc.nextInt();
                sc.nextLine(); 
                
                store.addToStockBySerialNumber(serialNumber2, quantityToAdd);
                break;
                case 8: 
                System.out.println("Enter the serial number of the product:");
                int serialNumber3 = sc.nextInt();
                sc.nextLine(); 
               
                System.out.println("Enter the quantity to add to the stock:");
                int quantityToRemove = sc.nextInt();
                sc.nextLine(); 
                store.removeFromStockBySerialNumber(serialNumber3, quantityToRemove);
                break;
                case 9:
                System.out.println("Enter your client ID:");
                String clientId2 = sc.nextLine();

                Client client = store.findClientByID(clientId2);
                if (client == null) {
                    System.out.println("Client with the given ID not found.");
                    break;
                }

                store.purchaseProduct(client);
                break;
                case 10:
                store.viewPurchaseHistory();
                break;
            }
        } while(opcion != 11);
        System.out.println("Leaving the store, good bye!");
    }
}
