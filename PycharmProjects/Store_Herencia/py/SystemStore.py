


class SystemStore:
    secure_password = "thisisnotasecurepassword"

    def __init__(self):
        self.store = None

    def run_program(self):
        valid_password = False

        while not valid_password:
            print("\n*** WELCOME ***")
            password = input("Enter the password please: ")

            if password == self.secure_password:
                valid_password = True
                self.run_system_menu()
            else:
                print("\nIncorrect password, try again")

    def run_system_menu(self):
        opcion = 0
        while opcion != 11:
            print("\n** WELCOME TO THE SYSTEM **")
            print("1. Register Product")
            print("2. Register Client")
            print("3. Show Products")
            print("4. Show Clients")
            print("5. Delete Product")
            print("6. Delete Client")
            print("7. Add to Stock")
            print("8. Remove from Stock")
            print("9. Make Purchase")
            print("10. View Purchases")
            print("11. Exit")
            opcion = int(input("Select your option: "))

            if opcion == 1:
                print("\nYou selected register product")
                print("Enter the type of product to register")
                print("1. Cleaning")
                print("2. Food")
                print("3. Householde Appliance")
                print("4. Makeup")
                opcion_producto = int(input("Select your option: "))

                if opcion_producto == 1:
                    self.store.register_cleaning_product()
                elif opcion_producto == 2:
                    self.store.register_food_product()
                elif opcion_producto == 3:
                    self.store.register_household_appliance_product()
                elif opcion_producto == 4:
                    self.store.register_beauty_product()

            elif opcion == 2:
                self.store.register_client()

            elif opcion == 3:
                self.store.show_all_products()

            elif opcion == 4:
                self.store.show_all_clients()

            elif opcion == 5:
                serial_number = int(input("Enter the serial number: "))
                self.store.remove_product_by_serial_number(serial_number)

            elif opcion == 6:
                client_id = input("Enter the ID of the client to remove: ")
                self.store.remove_client_by_id(client_id)

            elif opcion == 7:
                serial_number = int(input("Enter the serial number of the product: "))
                quantity_to_add = int(input("Enter the quantity to add to the stock: "))
                self.store.add_to_stock_by_serial_number(serial_number, quantity_to_add)

            elif opcion == 8:
                serial_number = int(input("Enter the serial number of the product: "))
                quantity_to_remove = int(input("Enter the quantity to remove from the stock: "))
                self.store.remove_from_stock_by_serial_number(serial_number, quantity_to_remove)

            elif opcion == 9:
                client_id = input("Enter your client ID: ")
                client = self.store.find_client_by_id(client_id)
                if client is None:
                    print("Client with the given ID not found.")
                else:
                    self.store.purchase_product(client)

            elif opcion == 10:
                self.store.view_purchase_history()

        print("Leaving the store, good bye!")
