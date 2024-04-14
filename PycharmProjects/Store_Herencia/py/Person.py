class Person:
    def __init__(self, name, last_name, address):
        self.name = name
        self.last_name = last_name
        self.address = address

    def show_info(self):
        return f"Nombre completo: {self.name} {self.last_name}"

    def get_name(self):
        return self.name

    def get_last_name(self):
        return self.last_name

    def get_address(self):
        return self.address
