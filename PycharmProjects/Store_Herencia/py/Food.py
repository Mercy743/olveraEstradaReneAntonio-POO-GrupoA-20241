from Product import Product

class Food(Product):
    def __init__(self, name, price, import_date, stock, sell_by_date):
        super().__init__(name, price, import_date, stock)
        self.sell_by_date = sell_by_date

    def __str__(self):
        return super().get_data() + f", sell-by-date: {self.sell_by_date}"