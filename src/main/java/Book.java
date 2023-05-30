public class Book {
    //Book should contain name,author,year of publish and ISBN
    String name, author, publish;
    int year,ISBN;
    int num=0;

    public Book(String name, String author, String publish, int year, int ISBN) {
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.year = year;
        this.ISBN = ISBN;
    }

    public void updateBook(String name, String author, String publish, int year ){
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.year = year;
    }
}