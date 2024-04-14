from Person import Person

class Employee(Person):
    def __init__(self, name, last_name, address, rol):
        super().__init__(name, last_name, address)
        self.rol = rol

    def show_info_with_rol(self):
        return f"{super().show_info()}rol: {self.rol}"
