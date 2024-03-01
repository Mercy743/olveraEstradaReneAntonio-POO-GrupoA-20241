
package ejercicio;


public class Producto {
 private String name;
 private double precio; 
 private int stock;
 
 public String parameters(String name,double precio,int stock){
     setNombre(name);
     setPrecio(precio);
     setStock(stock);
      return String.format("Name: %s Precio: %f Stock: %d", name, precio, stock);
 }
public Producto(String name, double precio){
  stock=0;
   
   
}
public String getNombre(){
    return name;
}
public double getPrecio(){
    return precio;
}
public int getStock(){
    return stock;
}
  public void setNombre(String name) {
      if (name!=null){
      this.name=name;    
      }
    }

    public void setPrecio(double precio) {
    if (precio>=0){
        this.precio=precio;
    }   
    }

   public void setStock(int stock) {
     if (stock>=0) {
         this.stock=stock;
     }  
    }
   public void addStock(int cant){
       if (cant>0 && cant<=stock){
           stock -=cant;
       }
   }
}
