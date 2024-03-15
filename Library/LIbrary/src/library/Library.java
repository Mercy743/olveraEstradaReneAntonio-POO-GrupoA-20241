package library;
import java.util.*;
class Library {
    private ArrayList<Books> availableBooks = new ArrayList<>();
    private ArrayList<Users> users = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public Library(){
        
    }
     public  void showActiveUsers(){
        if(users.isEmpty()){
            System.out.println("There are no registered books");
        }
        else{
            System.out.println("These users own at least one rented book.");
            for (Users users : users) {
                if(users.getRentCounter() > 0){
                   System.out.println("|User Name: |" + users.getName() 
                    + "| User Last Name: |" + users.getLastName() 
                    + "| User Age: |" + users.getAge() 
                    + "| User ID: |" + users.userID());
                }
            }
        }
    }
    public  void activeBooks(){
        if(availableBooks.isEmpty()){
            System.out.println("There are no registered books");
        }
        else{
            for (Books book : availableBooks) {
                if(book.getRentCounter() > 0){
                    System.out.printf("| TITLE: |" + book.getTitle() + "| NUMBER OF RENTS: | " + book.getRentCounter());
                    if(!book.isRented()){
                        System.out.print(" -Without Owner- ");
                    }
                    else{
                        System.out.printf(" | OWNER: | " + book.getOwner().getName());
                    }
                    System.out.println();
                }
            }
        }
    }

    public  void inactiveBooks(){
        if(availableBooks.isEmpty()){
            System.out.println("There are no registered books");
        }
        else{
            System.out.println("These books have not been rented");
            for (Books book : availableBooks) {
                if(book.getRentCounter() == 0){
                    System.out.printf("| TITLE: |" + book.getTitle() + "| RENT NUMBER: | " + book.getRentCounter());
                }
            }
        }
    }

     public void addUser(Users user) {
         users.add(user);
      }
    
    public void showAllUsers(){
          for (Users users : users){
            System.out.println("-------------------------------");
            System.out.println("|User Name: |" + users.getName() 
                    + "| User Last Name: |" + users.getLastName() 
                    + "| User Age: |" + users.getAge() 
                    + "| User ID: |" + users.userID());
            System.out.println("-------------------------------");;
                if(users.getRentedBooks().isEmpty()){
                    System.out.println("This user has not rented any books");
                }
                else{
                    System.out.println("_____________Rented Books_____________");
                    for (Books book : users.getRentedBooks()) {
                        System.out.printf("| TITULO: |", book.getTitle());
                    }
                }
          }
      }

    public void rentBook() {
      if(users.isEmpty() || availableBooks.isEmpty()){
            System.out.println("No users or books to rent");
        }
        else{
            int i = getBookIndex();
            if(validBookIndex(i)){
                if (!availableBooks.get(i).isRented()){
                    int j = getUserIndex();
                    if(validUserIndex(j)){
                        availableBooks.get(i).rentBook(users.get(j));
                         users.get(j).rentBook(availableBooks.get(i));
                    }
                    else{
                        System.out.println("User not found");
                    }
                }
                else{
                    System.out.println("Already rented by: " + availableBooks.get(i).getOwner().getName());
                }
            }
            else{
                System.out.println("Book not found");
            }
        }
    }
    public void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of the book to add: ");
        String title = sc.nextLine();
        Books book = new Books(title);
        availableBooks.add(book);
        System.out.println("Book added succesfully.");
    }

   
    public void returnBook(){
        if(availableBooks.isEmpty()){
            System.out.println("There are no registered books");
        }
        else{
            int i = getUserIndex();
            if(validUserIndex(i)){
                if(!users.get(i).getRentedBooks().isEmpty()){
                    int n = getBookIndex(i);
                    if(validBookIndex(n)){
                        users.get(i).returnBook(availableBooks.get(n));
                        availableBooks.get(n).returnBook();
                        System.out.println("The book has been returned to the bookstore");
                    }
                    else{
                        System.out.println("The book was not found");
                    }
                }
                else{
                    System.out.println("This user has not rented anything");
                }
            }
            else{
                System.out.println("User not found");
            }
        }  
    }
     private  void showUserNames(){
        System.out.println("These are the available IDs");
        System.out.println("----------------------------------");
        for (Users user : users) {
            System.out.printf(" | NAME: |" + user.getName() + " | ID: |" + user.userID());
            System.out.println();

        }
    }
     private int getUserIndex(){
        int verification = -1;
        showUserNames();
        System.out.println("Enter the user ID: ");
        String ID = sc.next();

        for (int i = 0; i < users.size(); i++) {
            if(ID.equals(users.get(i).userID())){
                verification = i;
                break;
            }
        }
        return verification;
    }
 private boolean validUserIndex(int valid){
        if(valid == -1){
            return false;
        }
        else{
            return true;
        }
    }
  private void showBookTitles(){
        System.out.println("These are the available IDs");
        System.out.println("----------------------------------");
        for (Books book : availableBooks) {
            System.out.printf(" | TITLE: | " + book.getTitle() + " | Book ID: " + book.getID());
        }
    }
  private void showBookTitles(int i){
        System.out.printf("These are the IDs available to the user: %s", users.get(i).getName());
        System.out.println("----------------------------------");
        for (Books book : users.get(i).getRentedBooks()) {
           System.out.printf(" | TITLE: | " + book.getTitle() + " | Book ID: " + book.getID());
        }
    }

    private int getBookIndex(){
        int verification = -1;
        showBookTitles();
        System.out.println("Enter the book ID");
        String ID = sc.next();
        for (int i = 0; i < availableBooks.size(); i++) {
            if(ID.equals(availableBooks.get(i).getID())){
                verification = i;
                break;
            }
        }
        return verification;
    }

    private int getBookIndex(int i){
        int verification = -1;
        showBookTitles(i);
        System.out.println("Enter the book ID");
        String ID = sc.next();

        for (int j = 0; j < availableBooks.size(); j++) {
            if(ID.equals(users.get(i).getRentedBooks().get(j).getID())){
                verification= j;
                break;
            }
        }
        return verification;
    }

    private boolean validBookIndex(int valid){
        if(valid == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public void showUserData(){
        if(users.isEmpty()){
            System.out.println("");
        }
        else{
            int i = getUserIndex();
            if(validUserIndex(i)){
               System.out.println("0============= USER INFORMATION =============0");
               System.out.println("|User Name: |" + users.get(i).getName() 
                    + "| User Last Name: |" + users.get(i).getLastName() 
                    + "| User Age: |" + users.get(i).getAge() 
                    + "| User ID: |" + users.get(i).userID());
                if(users.get(i).getRentedBooks().isEmpty()){
                   System.out.println("This user has not rented any books");
                }
                else{
                    System.out.println("_____________Rented Books_____________ ");
                    for (Books book : users.get(i).getRentedBooks()) {
                        System.out.printf(" | TITLE: " + book.getTitle());
                        System.out.println();
                    }
                }
                System.out.println();
            }
            else{
                System.out.println("User not found");
            }

        }
    }
    public void showAvailableBooks(){
       if(availableBooks.isEmpty()){
            System.out.println("No hay libros registrados");
        }
        else{
            System.out.println(" ------------AVAILABLE BOOKS------------");
            for (Books book : availableBooks) {
                System.out.printf("| TITLE: |" + book.getTitle() + "| NUMBER OF RENTS: | " +  book.getRentCounter());
                if(!book.isRented()){
                    System.out.print(" | Without Owner | ");
                }
                else{
                    System.out.printf(" | OWNER: | " + book.getOwner().getName());
                }
            }
        }
}
}


