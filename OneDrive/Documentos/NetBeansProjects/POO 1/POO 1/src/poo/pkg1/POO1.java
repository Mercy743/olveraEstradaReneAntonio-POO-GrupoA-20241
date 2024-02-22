package poo.pkg1;


public class POO1 {

   
    public static void main(String[] args) {
    System.out.println("*---------------------*");
    System.out.println("PERSON DATA");
     System.out.println("*---------------------*");
        Person firstPerson=new Person("Peter", 20 , 'M', 70.6 , 1.70);
        System.out.println(firstPerson.getPersonInfo());
      
    System.out.println("*---------------------*");
        
        Person secondPerson=new Person("Sofia", 10, 'F', 25.40, 1.35);
        System.out.println(secondPerson.getPersonInfo());
    
   System.out.println("*---------------------*");
         
          Person thirdPerson=new Person("Alberto", 80,'M', 80.3, 1.80);
          System.out.println(thirdPerson.getPersonInfo());
     System.out.println("*---------------------*");
          Person fourthPerson=new Person("Erandi",21,'F',60.7, 1.60);
          System.out.println(fourthPerson.getPersonInfo());
    System.out.println("*---------------------*");
    System.out.println("BOOK DATA");
     System.out.println("*---------------------*");
          Book firstBook=new Book();
          System.out.println(firstBook.getBookInfo());
    System.out.println("*---------------------*");
          Book secondBook=new Book();
          secondBook.heading="Chronicles";
          secondBook.author="Richtofen";
          secondBook.publication_date=1945;
          secondBook.genre="Adventure and Action";
          secondBook.language="Germany";
          System.out.println("Heading: "+secondBook.heading
                  +" Author: "+secondBook.author
                  +" Publication Date: "+secondBook.publication_date
                  +" Genre: "+secondBook.genre+
                  " Language: "+secondBook.language);
    System.out.println("*---------------------*");
         Book thirdBook=new Book();
         thirdBook.heading="Halo The Flood";
         thirdBook.author="343 Industries";
         thirdBook.publication_date=2003;
         thirdBook.genre="Horror and Action";
         thirdBook.language="English";
          System.out.println("Heading: "+thirdBook.heading
                  +" Author: "+thirdBook.author
                  +" Publication Date: "+thirdBook.publication_date
                  +" Genre: "+thirdBook.genre
                  +" Language: "+thirdBook.language);
    System.out.println("*---------------------*");
    Book fourthdBook=new Book();
         fourthdBook.heading="Jujutsu Kaisen";
         fourthdBook.author="Gege Akutami";
         fourthdBook.publication_date=2003;
         fourthdBook.genre="Shonen";
         fourthdBook.language="Japanese";
          System.out.println("Heading: "+fourthdBook.heading
                  +" Author: "+fourthdBook.author
                  +" Publication Date: "+ fourthdBook.publication_date
                  +" Genre: "+fourthdBook.genre
                  +" Language: "+fourthdBook.language);
    System.out.println("*---------------------*");
    System.out.println("RECTANGLE INFORMATION");
   System.out.println("*---------------------*");
    Rectangle firstInfo=new Rectangle(6 , 4);
    System.out.println(firstInfo.getRectangleInfo()+" Area:"+firstInfo.getArea()+" Perimeter:"+firstInfo.getPerimeter());
     System.out.println("*---------------------*");
    Rectangle secondInfo=new Rectangle(7 , 2);
    System.out.println(secondInfo.getRectangleInfo()+" Area:"+secondInfo.getArea()+" Perimeter:"+secondInfo.getPerimeter());
     System.out.println("*---------------------*");
    Rectangle thirdInfo=new Rectangle(8 , 5);
    System.out.println(thirdInfo.getRectangleInfo()+" Area:"+thirdInfo.getArea()+" Perimeter:"+thirdInfo.getPerimeter());
     System.out.println("*---------------------*");
    Rectangle fourthInfo=new Rectangle(3 , 9);
    System.out.println(fourthInfo.getRectangleInfo()+" Area:"+fourthInfo.getArea()+" Perimeter:"+fourthInfo.getPerimeter());
     System.out.println("*---------------------*");
    
    }
    
}
