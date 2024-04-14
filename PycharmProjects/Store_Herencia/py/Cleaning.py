from Product import Product

class Cleaning(Product):
    def __init__(self, name, price, import_date, stock, brand):
        super().__init__(name, price, import_date, stock)
        self.brand = brand

    def __str__(self):
        return f"{super().get_data()}, brand: {self.brand}"
