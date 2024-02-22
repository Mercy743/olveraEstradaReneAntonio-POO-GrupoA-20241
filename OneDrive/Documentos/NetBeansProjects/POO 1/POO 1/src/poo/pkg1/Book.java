
package poo.pkg1;


public class Book {
public String heading="Cthulhu";
public String author="HP Lovecraft";
public int publication_date=1928;
public String genre="Horror";
public String language="Spanish";



 String getBookInfo(){
         return String.format("Heading: %s Author: %s Publication date: %d genre: %s language: %s", heading, author, publication_date , genre , language);
}
}
    

