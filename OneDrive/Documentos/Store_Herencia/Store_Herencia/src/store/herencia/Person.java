package store.herencia;


public class Person {
    public String name;
    public String lastName;
    public String address;

    public Person(String name, String lastName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public String showInfo() {
        return String.format("Nombre completo: %s %s", name, lastName);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}