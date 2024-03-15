package library;
import java.util.Scanner;

public class Main {

   
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Boolean flag=true;
     Library library = new Library();
      while(flag){
          System.out.println("0=====================================0");
          System.out.println("        WELCOME TO THE LIBRARY         ");
          System.out.println("1. Add User");
          System.out.println("2. Show all Users in System");
          System.out.println("3. Show all Books rented by one user");
          System.out.println("4. Rent a Book");
          System.out.println("5. Add any Book");
          System.out.println("6. Return any book");
          System.out.println("7. Show all books in Library");
          System.out.println("8. Query all active users");
          System.out.println("9. View active books");
          System.out.println("10. View inactive books");
          System.out.println("11. Exit Library");
          System.out.println("0==================================0");
         int option = sc.nextInt();
          switch (option){
              case 1:
                    System.out.println("Enter usser's first name: ");
                    String name = sc.next();
                    System.out.println("Enter usser's last name: ");
                    String lastName = sc.next();
                    System.out.println("Enter age: ");
                    int age = sc.nextInt();
                    Users user = new Users(name, lastName, age);
                    library.addUser(user);
                  break;
              case 2:
                  library.showAllUsers();
                  break;
              case 3:
                  library.showUserData();
                  break;
              case 4:
                  library.rentBook();
                  break;
              case 5:
                  library.addBook();
                  break;
              case 6:
                  library.returnBook();
                  break;
              case 7:
                  library.showAvailableBooks();
                  break;
              case 8:
                  library.showActiveUsers();
                  break;
              case 9: 
                  library.inactiveBooks();
                  break;
              case 10:
                   library.activeBooks();
                   break;
              case 11:
                  System.out.println("Closing the Library");
                  flag=false;
                  break;
              default:
                  System.out.println("(!)NOT AN OPTION(!)");
          }
    }
     
    }
}

