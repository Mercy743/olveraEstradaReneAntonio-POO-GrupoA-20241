package tarea_5_u2;


public class Employee {
   public double calculateSalary (double baseSalary){
       return  baseSalary;
   }
   public double calculateSalary(double baseSalary, double melioration){
       return baseSalary+melioration;
   }
   public double calculateSalary(double baseSalary, double melioration, int overtime){
       return baseSalary+melioration+(overtime*20);
   }
}
