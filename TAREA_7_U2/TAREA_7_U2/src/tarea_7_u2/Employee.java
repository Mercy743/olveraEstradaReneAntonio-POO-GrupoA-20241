package tarea_7_u2;
import java.util.Scanner;
import java.util.ArrayList;
import static tarea_7_u2.TAREA_7_U2.bank;
public class Employee {
    private String name;
    private String lastName;
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Employee> employees = new ArrayList<>();
    public Employee(String name, String lastName, long accountNumber, char type) {
        this.name = name;
        this.lastName = lastName;
        this.account = new BankAccount(accountNumber, type);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void addMoney(double amount) {
        account.addMoney(amount);
    }

    public void withdrawMoney(double amount) {
        account.withdrawMoney(amount);
    }
     public void addEmployeeAccount() {
        System.out.println("Enter employee's first name: ");
        String firstName = sc.next();
        System.out.println("Enter employee's last name: ");
        String lastName = sc.next();
        System.out.println("Enter employee's account number(Remeber this number is important to work with this program): ");
        long accountNumber = sc.nextLong();
        System.out.println("Enter employee's account type (A, B, or C): ");
        char type = sc.next().charAt(0);
        Employee employee = new Employee(firstName, lastName, accountNumber, type);
        employees.add(employee);
        bank.addAccount(employee.getAccount());
        System.out.println("Employee account added successfully");
    }

    public void addMoney() {
        System.out.println("Enter employee's account number: ");
        long accountNumber = sc.nextLong();
        System.out.println("Enter the amount to add: ");
        double amount = sc.nextDouble();
        Employee employee = findEmployee(accountNumber);
        if (employee != null) {
            employee.getAccount().addMoney(amount);
            System.out.println("Money added successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    public void withdrawMoney() {
        System.out.println("Enter employee's account number: ");
        long accountNumber = sc.nextLong();
        System.out.println("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        Employee employee = findEmployee(accountNumber);
        if (employee != null) {
            if (employee.getAccount().getAmount() >= amount) {
                employee.getAccount().withdrawMoney(amount);
                System.out.println("Money withdrawn successfully!");
            } else {
                System.out.println("Insufficient funds");
            }
        } else {
            System.out.println("Employee not found");
        }
    }

    public void showAccount() {
        System.out.println("Enter employee's account number: ");
        long accountNumber = sc.nextLong();
        Employee employee = findEmployee(accountNumber);
        if (employee != null) {
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Last Name: " + employee.getLastName());
            System.out.println("Account Number: " + employee.getAccount().getAccountNumber());
            System.out.println("Account Type: " + employee.getAccount().getType());
            System.out.println("Account Balance: " + employee.getAccount().getAmount());
        } else {
            System.out.println("Employee not found!");
        }
    }

    public void showAllEmployees() {
        for (Employee employee : employees) {
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Employee Last Name: " + employee.getLastName());
            System.out.println("Account Number: " + employee.getAccount().getAccountNumber());
            System.out.println("Account Type: " + employee.getAccount().getType());
            System.out.println("Account Balance: " + employee.getAccount().getAmount());
            System.out.println("-------------------------------");
        }
    }

    public Employee findEmployee(long accountNumber) {
        for (Employee employee : employees) {
            if (employee.getAccount().getAccountNumber() == accountNumber) {
                return employee;
            }
        }
        return null;
    }
}
