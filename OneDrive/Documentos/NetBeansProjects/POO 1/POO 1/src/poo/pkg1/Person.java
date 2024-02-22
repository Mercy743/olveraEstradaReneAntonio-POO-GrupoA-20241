package poo.pkg1;
import java.text.DecimalFormat;

public class Person {
    /*
    Tipos de Atributos
    public
    protected
    private
    */
    public String name="James";
    public int age=20;
    public char gender='M';
    public double weight=70.5;
    public double height=1.70;
   
    Person(String name, int age, char gender, double weight,double height){
         DecimalFormat f=new DecimalFormat("#.00");
         this.name=name;
         this.age=age;
         this.gender=gender;
         this.weight=weight;
         this.height=height;
    
         
         
     }
     String getPersonInfo(){
         return String.format("Name: %s Age: %d Gender: %b weight: %f height: %f", name, age, gender, weight, height);
     }
}
