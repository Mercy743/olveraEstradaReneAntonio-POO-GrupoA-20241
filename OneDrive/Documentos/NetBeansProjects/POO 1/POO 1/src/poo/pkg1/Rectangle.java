
package poo.pkg1;


public class Rectangle {
public int heigth;
public int width;


Rectangle (int h, int w){
    this.heigth=h;
    this.width=w;
}
public double getArea() {
        return  width*heigth;
    }

public double getPerimeter() {
        return 2 * (width*heigth);
    }
    String getRectangleInfo(){
 return String.format("Heigth:%s Width:%s",heigth, width);    
    }
}

