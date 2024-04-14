from Person import Person
import random
class Client(Person):
    def __init__(self, name, lastName, address):
        super().__init__(name, lastName, address)
        self.ID = self.generate_client_id()

    def generate_client_id(self):
        characters = "abcdefghijklmnopqrstuvwxyz0123456789"
        client_id = "".join(random.choice(characters) for _ in range(6))
        return client_id

    def get_id(self):
        return self.ID

    def add_to_purchase_history(self, product, quantity):
        purchase_detail = f"Product: {product.get_name()}, Quantity: {quantity}"
        self.purchase_history.append(purchase_detail)

    def view_purchase_history(self):
        if not self.purchase_history:
            print("No purchase history available.")
            return

        print("Purchase History for all Clients:")
        for purchase_detail in self.purchase_history:
            print(purchase_detail)