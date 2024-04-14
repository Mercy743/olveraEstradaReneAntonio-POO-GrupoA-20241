class Product:
    CANTIDAD_PRODUCTOS = 0

    def __init__(self, name, price, import_date, stock):
        Product.CANTIDAD_PRODUCTOS += 1
        self.serial_number = Product.CANTIDAD_PRODUCTOS
        self.name = name
        self.price = price
        self.import_date = import_date
        self.stock = stock

    def get_data(self):
        return f"Nombre: {self.name}, precio: {self.price}, fecha de importación: {self.import_date}, stock: {self.stock}"

    def get_serial_number(self):
        return self.serial_number

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_price(self):
        return self.price

    def set_price(self, price):
        self.price = price

    def get_import_date(self):
        return self.import_date

    def set_import_date(self, import_date):
        self.import_date = import_date

    def get_stock(self):
        return self.stock

    def set_stock(self, stock):
        self.stock = stock
