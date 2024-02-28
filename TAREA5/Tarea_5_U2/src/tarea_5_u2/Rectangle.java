
package tarea_5_u2;


public class Rectangle {
public double width;
public double heigth;
public Rectangle(double width, double heigth) {
        this.width = width;
        this.heigth = heigth;
}
    public double getArea(){
        return  width*heigth;
    }
public double getPerimeter(){
        return 2 * (width*heigth);
    }
public int getArea(int width, int heigth) {
        return  width*heigth;
    }

public int getPerimeter(int width, int height) {
        return 2 * (width*height);
    }
    String getRectangleInfo(){
 return String.format("Heigth:%s Width:%s",heigth, width); 
    
}
}