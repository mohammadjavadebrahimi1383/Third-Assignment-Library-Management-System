import java.sql.SQLOutput;
import java.util.ArrayList;

public class User{
    //User should have a list of books
    //User should have a username and a password
    private String pass, username;
    private ArrayList<Book> booksOfUser;

    public User(String username, String pass) {
        this.pass = pass;
        this.username = username;
        this.booksOfUser = new ArrayList<>();
    }

    public boolean userPassCheck(String passInput){
        return pass.equals(passInput);
    }

    public void rentBook(Book book){
        if (booksOfUser.contains(book)) book.num++;
        else booksOfUser.add(book);
    }

    public void returnBook(Book book){
        if (booksOfUser.contains(book))
        {
            if(book.num>0) book.num--;
            else booksOfUser.remove(book);
        }
        else System.out.println("We don't have this book.");
    }
    public void addBook(Book book){
        booksOfUser.add(book);
    }
    public boolean doesUserBookExist (Book book){
        return booksOfUser.contains(book);
    }

    public void removeUserBook (Book book){
        booksOfUser.remove(book);
    }

    public void changepass(String newpass){
        pass=newpass;
    }

    public void printBook(){
        System.out.println(booksOfUser);
    }

}