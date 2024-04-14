from Product import Product

class Beauty(Product):
    def __init__(self, name, price, import_date, stock, type):
        super().__init__(name, price, import_date, stock)
        self.type = type

    def __str__(self):
        return super().get_data() + f"type: {self.type}"
