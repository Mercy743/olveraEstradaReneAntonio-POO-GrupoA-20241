from Product import Product

class Householde_Appliance(Product):
    def __init__(self, name, price, import_date, stock, model):
        super().__init__(name, price, import_date, stock)
        self.model = model

    def __str__(self):
        return super().get_data() + f"Model: {self.model}"