package tarea_5_u2;
import java.util.Scanner;

public class Tarea_5_U2 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /*
        System.out.println("---------------------------");
        System.out.println("     Type your height: ");
        System.out.println("---------------------------");
        double width = sc.nextDouble();
        System.out.println("---------------------------");
        System.out.println("     Type your widht: ");
        System.out.println("---------------------------");
        double heigth = sc.nextDouble();
       Rectangle result=new Rectangle(width, heigth);
       double area = result.getArea();
       double perimeter = result.getPerimeter();
       System.out.println("1---------------------------1");
       System.out.println(result.getRectangleInfo()+" Area: "+ String.format("%.2f", area)+" Perimeter"+ String.format("%.2f", perimeter));
       System.out.println("1---------------------------1");
       
      
        Employee empleado=new Employee();
        System.out.println("---------------------------");
        System.out.print("       Type Base Salary: ");
        System.out.println("---------------------------");
        double baseSalary = sc.nextDouble();
        System.out.println("---------------------------");
        System.out.print("       Type Melioration: ");
        System.out.println("---------------------------");
        double melioration = sc.nextDouble();
        System.out.println("---------------------------");
        System.out.print("       Type Overtime: ");
        System.out.println("---------------------------");
        int overtime = sc.nextInt();

       
        double salary = empleado.calculateSalary(baseSalary,melioration, overtime);
        System.out.println("2---------------------------2");
        System.out.println("Total Salary is: " + salary);
        System.out.println("2---------------------------2");
        */
       Taxes calculator = new Taxes();
       System.out.println("---------------------------");
        System.out.println("Please provide your information");
        System.out.println("---------------------------");
        System.out.println("        Earnings: ");
        System.out.println("---------------------------");
        int earnings = sc.nextInt();
        System.out.println("---------------------------");
        System.out.println("        Sales: ");
        System.out.println("---------------------------");
        double sales = sc.nextDouble();
        System.out.println("---------------------------");
        System.out.println("      Tax Percentage: ");
        System.out.println("---------------------------");
        double taxPercentage = sc.nextDouble();
        System.out.println("---------------------------");
        System.out.println("        Dividends: ");
        System.out.println("---------------------------");
        double dividends = sc.nextDouble();
        System.out.println("---------------------------");
        System.out.println("        Dispensary: ");
        System.out.println("---------------------------");
        double dispensary = sc.nextDouble();
      
        
        double taxEarnings = calculator .taxCalculator(earnings);
        double taxSales = calculator .taxCalculator(sales, taxPercentage);
        double taxDividends = calculator .taxCalculator(dividends, taxPercentage, dispensary );
        System.out.println("3---------------------------3");
        System.out.println("Taxes with only earnings: " + taxEarnings);
        System.out.println("Taxes with sales and pecentage of taxes: " + taxSales);
        System.out.println("Taxes with dividends, percentage of taxes and dispensary: %.2f" + taxDividends);
        System.out.println("3---------------------------3");
         
    }
    
}
