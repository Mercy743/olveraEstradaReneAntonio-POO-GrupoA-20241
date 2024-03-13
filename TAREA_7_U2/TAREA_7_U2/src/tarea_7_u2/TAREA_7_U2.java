package tarea_7_u2;

import java.util.Scanner;

public class TAREA_7_U2 {
       static Bank bank = new Bank();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee(" ", " ", 132, ' ');
        Boolean flag=true;
        while (flag) {
            System.out.println("===============================================================");
            System.out.println("1. Add Acoount of Employee");
            System.out.println("2. Add Money");
            System.out.println("3. Withdrawals");
            System.out.println("4. Show Account of Usser");
            System.out.println("5. Show all Employees");
            System.out.println("6. Show all Accounts");
            System.out.println("7. Exit");
            System.out.println("Select your option: ");
            System.out.println("===============================================================");
            char option = sc.next().charAt(0);
            switch (option) {
                case '1':
                    employee.addEmployeeAccount();
                    break;
                case '2':
                    employee.addMoney();
                    break;
                case '3':
                    employee.withdrawMoney();
                    break;
                case '4':
                    employee.showAccount();
                    break;
                case '5':
                    employee.showAllEmployees();
                    break;
                case '6':
                    bank.showAllBankAccounts();
                    break;
                case '7':
                    System.out.println("Finishing all Tasks.");
                    flag = false;
                    break;
                default:
                    System.out.println("Not an option. Enter a number from 1 to 4.");
                    break;
            }
}}}

    

/*
public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("Juan", "Rivera", 101010, 'A');

        System.out.println(employee.getName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getAccount().getAccountNumber());
        System.out.println(employee.getAccount().getType());
        System.out.println(employee.getAccount().getAmount());

        System.out.println("*********");

        employee.getAccount().agregarDinero(10000);
        System.out.println(employee.getAccount().getAmount());

        System.out.println("*********");

        employee.getAccount().agregarDinero(50000);
        System.out.println(employee.getAccount().getAmount());
    }
}
*/