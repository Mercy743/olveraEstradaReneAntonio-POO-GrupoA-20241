package library;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Users {
    private ArrayList<Books> rentedBooks = new ArrayList<>();
    private String name;
    private String lastName;
    private int age;
    private String ID;
    private Scanner sc = new Scanner(System.in);
    private Random r = new Random();
    private int rentCounter;

    public Users(String name, String lastName, int age){
        this.name = name;
        this.lastName =  lastName;
        this.age = age;
        this.ID = generateUserID();
    }
    public String userID(){
    return ID;
}
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
     
 public int getRentCounter(){
        return rentCounter;
    }

    public void increaseCounter(){
        rentCounter++;
    }

    public ArrayList<Books>getRentedBooks(){
        return rentedBooks;
    }
     public void rentBook(Books book){
        rentedBooks.add(book);
        rentCounter++;
    }

    public void returnBook(Books book){
        rentedBooks.remove(book);
    }
    private String generateUserID(){
        String character = "abcdefghijklmnopqrstuvwxyz0123456789";
        String combination = "";
        for (int i = 0; i < 6; i++) {
            combination += character.charAt(r.nextInt(character.length()));
        }

        return combination;
    }
}
