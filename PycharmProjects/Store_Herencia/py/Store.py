from Beauty import Beauty
from Cleaning import Cleaning
from Client import Client
from Employee import Employee
from Food import Food
from Householde_Appliance import Householde_Appliance

class Store:
    def __init__(self):
        self.cleaning_product = []
        self.food_product = []
        self.household_appliance_product = []
        self.beauty_product = []
        self.clients = []
        self.employees = []
        self.sc = input  # Simplemente se usa 'input' en lugar de 'Scanner(System.in)'

    def register_common_data(self):
        common_data = []

        print("Enter name: ")
        name = input()
        common_data.append(name)

        print("Enter price: ")
        price = float(input())
        common_data.append(str(price))

        print("Enter import date: ")
        import_date = input()
        common_data.append(import_date)

        print("Enter the stock: ")
        stock = int(input())
        common_data.append(str(stock))

        return common_data

    def register_cleaning_product(self):
        print("==================================")
        print("** Register cleaning product **")
        print("==================================")
        data = self.register_common_data()
        name = data[0]
        price = float(data[1])
        import_date = data[2]
        stock = int(data[3])

        print("Enter brand: ")
        brand = input()

        cleaning = Cleaning(name, price, import_date, stock, brand)
        self.cleaning_product.append(cleaning)

        print("\nSuccessfully registered.")

    def register_food_product(self):
        print("==================================")
        print("** Register Food product **")
        print("==================================")

        data = self.register_common_data()
        name = data[0]
        price = float(data[1])
        import_date = data[2]
        stock = int(data[3])

        print("Enter the expiration date: ")
        sell_by_date = input()

        food = Food(name, price, import_date, stock, sell_by_date)
        self.food_product.append(food)

        print("\nSuccessfully registered.")

    def register_beauty_product(self):
        print("==================================")
        print("** Register beauty product **")
        print("==================================")

        data = self.register_common_data()
        name = data[0]
        price = float(data[1])
        import_date = data[2]
        stock = int(data[3])

        print("Enter the type: ")
        type_ = input()

        beauty = Beauty(name, price, import_date, stock, type_)
        self.beauty_product.append(beauty)

        print("\nSuccessfully registered")

    def register_household_appliance_product(self):
        print("==================================")
        print("** Register Householde Appliance product **")
        print("==================================")

        data = self.register_common_data()
        name = data[0]
        price = float(data[1])
        import_date = data[2]
        stock = int(data[3])

        print("Enter model: ")
        model = input()

        household_appliance = Householde_Appliance(name, price, import_date, stock, model)
        self.household_appliance_product.append(household_appliance)

        print("\nSuccessfully registered.")

    def register_client(self):
        print("==================================")
        print("** Client Register **")
        print("==================================")

        name = input("Enter customer's name: ")
        last_name = input("Enter customer's last name: ")
        address = input("Enter customer's address: ")

        client = Client(name, last_name, address)
        self.clients.append(client)

    def register_employee(self):
        print("==================================")
        print("** Employee Register **")
        print("==================================")

        name = input("Enter employee's name: ")
        last_name = input("Enter employee's last name: ")
        address = input("Enter employee's address: ")
        role = input("Give the employee's role: ")

        employee = Employee(name, last_name, address, role)
        self.employees.append(employee)

    def show_all_products(self):
        print("==================================")
        print("** All Registered Products **")
        print("==================================")

        print("\nCleaning Products:")
        for cleaning in self.cleaning_product:
            print("Serial Number:", cleaning.get_serial_number())
            print(cleaning)

        print("\nFood Products:")
        for food in self.food_product:
            print("Serial Number:", food.get_serial_number())
            print(food)

        print("\nHousehold Appliance Products:")
        for appliance in self.household_appliance_product:
            print("Serial Number:", appliance.get_serial_number())
            print(appliance)

        print("\nBeauty Products:")
        for beauty in self.beauty_product:
            print("Serial Number:", beauty.get_serial_number())
            print(beauty)

    def show_all_clients(self):
        print("==================================")
        print("** All Registered Clients **")
        print("==================================")

        for client in self.clients:
            print("ID:", client.get_id(), ",", client)

    def remove_product_by_serial_number(self, serial_number):
        for cleaning in self.cleaning_product:
            if cleaning.get_serial_number() == serial_number:
                self.cleaning_product.remove(cleaning)
                print("Product removed successfully.")
                return True

        for food in self.food_product:
            if food.get_serial_number() == serial_number:
                self.food_product.remove(food)
                print("Product removed successfully.")
                return True

        for appliance in self.household_appliance_product:
            if appliance.get_serial_number() == serial_number:
                self.household_appliance_product.remove(appliance)
                print("Product removed successfully.")
                return True

        for beauty in self.beauty_product:
            if beauty.get_serial_number() == serial_number:
                self.beauty_product.remove(beauty)
                print("Product removed successfully.")
                return True

        print("No product found with the given serial number.")
        return False

    def find_product_by_serial_number(self, serial_number):
        for cleaning in self.cleaning_product:
            if cleaning.get_serial_number() == serial_number:
                return cleaning

        for food in self.food_product:
            if food.get_serial_number() == serial_number:
                return food

        for appliance in self.household_appliance_product:
            if appliance.get_serial_number() == serial_number:
                return appliance

        for beauty in self.beauty_product:
            if beauty.get_serial_number() == serial_number:
                return beauty

        return None

    def remove_client_by_id(self, client_id):
        client_to_remove = self.find_client_by_id(client_id)
        if client_to_remove is None:
            print("Client with the given ID not found.")
            return

        if client_to_remove.get_purchase_history():
            print("This customer has purchases.")
            return

        self.clients.remove(client_to_remove)
        print("Client removed successfully.")

    def find_client_by_id(self, client_id):
        for client in self.clients:
            if client.get_id() == client_id:
                return client
        return None

    def add_to_stock_by_serial_number(self, serial_number, quantity_to_add):
        product_to_update = self.find_product_by_serial_number(serial_number)
        if product_to_update:
            product_to_update.set_stock(product_to_update.get_stock() + quantity_to_add)
            print("Stock updated successfully.")
        else:
            print("Product with the given serial number not found.")

    def remove_from_stock_by_serial_number(self, serial_number, quantity_to_remove):
        product_to_update = self.find_product_by_serial_number(serial_number)
        if product_to_update:
            current_stock = product_to_update.get_stock()
            if current_stock >= quantity_to_remove:
                product_to_update.set_stock(current_stock - quantity_to_remove)
                print("Stock updated successfully.")
            else:
                print("Error: Cannot remove more items than available in stock.")
        else:
            print("Product with the given serial number not found.")

    def view_purchase_history(self):
        print("==================================")
        print("** All Purchase History **")
        print("==================================")
        if not self.clients:
            print("No customers available.")
            return
        print("Purchase History for all clients:")
        for client in self.clients:
            purchase_history = client.get_purchase_history()
            print(f"Purchase History for {client.get_name()} {client.get_last_name()}: ")
            for purchase_detail in purchase_history:
                print(purchase_detail)