package library;
import java.util.Random;
public class Books {
 private String title;
 private boolean isRented;
 private Random r = new Random();
 private String ID;
  private int rentCounter;
  private Users owner;
    public Books(String title) {
        this.title = title;
        this.isRented = false;
        ID = generateBookID();
    }
    public void setRented(boolean isRented){
        this.isRented=isRented;
    }
    public String getTitle() {
        return title;
    }

    public boolean isRented() {
        return isRented;
    }
    public String getID(){
        return ID;
    }
     public int getRentCounter(){
        return rentCounter;
    }
   
    public void increaseCounter(){
        rentCounter++;
    }

    public void setOwner(Users owner){
        this.owner=owner;
    }

    public Users getOwner(){
        return this.owner;
    }

   public void rentBook(Users owner){
        setOwner(owner);
        setRented(true);
        rentCounter++;
        System.out.println("El libro ha sido rentado correctamente");
    }

    public void returnBook(){
        setOwner(null);
        setRented(false);
    }
    private String generateBookID(){
        String car = "abcdefghijklmnopqrstuvwxyz0123456789";
        String com = "";
        for (int i = 0; i < 6; i++) {
            com += car.charAt(r.nextInt(car.length()));
        }

        return com;
    }

   
}