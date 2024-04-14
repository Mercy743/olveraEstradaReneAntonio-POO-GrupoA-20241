package store.herencia;


public class Employee extends Person {
    private String rol;
    
    public Employee(String name, String lastName, String address, String rol) {
        super(name, lastName, address);
        this.rol = rol;
    }

    public String showInfowWithRol() {
        return super.showInfo() + "rol: " + rol;
    }
    
}

