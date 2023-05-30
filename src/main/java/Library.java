import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private HashMap<Integer,Book> books;
    private HashMap<String,User> users;
    private HashMap<String,Librarian> librarians;
    static Scanner in = new Scanner(System.in);

    public Library() {
        books = new HashMap<>();
        users= new HashMap<>();
        librarians = new HashMap<>();
        Librarian librarian = new Librarian("admin","admin");
        librarians.put("admin",librarian);

    }

    //book related functions
    public void addBook(Book book,int ISBN){
        books.put(ISBN,book);
    }

    public void removeBook(int ISBN){
        books.remove(ISBN);
    }


    public void updateBook(int ISBN, String name,String auther, String publish, int year){
        books.get(ISBN).updateBook(name,auther,publish,year);
    }

    public boolean doesBookExist(int ISBN){
        return books.containsKey(ISBN);
    }


    //user related functions

    public void addUser(String username,String pass){
        User user=new User(username,pass);
        users.put(username,user);
    }
    public void removeUser(String username){
        users.remove(username);
    }

    public void updateUser(String username, String newpass){
        users.get(username).changepass(newpass);
    }

    public boolean doesUserExist(String username){
        return users.containsKey(username);
    }

    public void Usermenu(String username){

        boolean flag =true;
        for (int i=2; i>=0 && flag; i--){
            System.out.print("Enter user password\n->");
            String pass = in.nextLine();
            if (users.get(username).userPassCheck(pass)){

                while (true){
                    System.out.println("----------------------Hi "+username+"----------------------");
                    System.out.print("1.borrow book\n2.return book\n3.Print ISBN book\n4.logout\n->");
                    int order= in.nextInt();
                    in.nextLine();

                    ///borrow
                    if (order==1){
                        System.out.print("Enter ISBN of book\n->");
                        int ISBN = in.nextInt();
                        in.nextLine();
                        if (doesBookExist(ISBN)){
                            users.get(username).addBook(books.get(ISBN));
                        }
                        else System.out.println("Library doesn't have this ISBN");
                    }

                    //return
                    else if (order == 2) {
                        System.out.print("Enter ISBN of book\n->");
                        int ISBN = in.nextInt();
                        in.nextLine();
                        if (users.get(username).doesUserBookExist(books.get(ISBN))){
                            users.get(username).removeUserBook(books.get(ISBN));
                        }
                        else System.out.println(username+" don't have this book");
                    }
                    else if(order==3){
                        users.get(username).printBook();
                    }
                    else if(order== 4){
                        flag= false;
                        break;
                    }
                    else System.out.println("Wrong order!");
                }

            }
            else System.out.println("Wrong password. You can enter "+(i)+" more");
        }

    }


    //librarian related functions
    public void addLibrarian(String username, String pass){
        Librarian librarian = new Librarian(pass,username);
        librarians.put(username,librarian);
    }

    public void removeLibrarian(String username){
        librarians.remove(username);
    }
    public void updateLibrarian(String username, String newpass){
        librarians.get(username).changepass(newpass);
    }

    public boolean doesLibrarianExist(String username){
        return librarians.containsKey(username);
    }

    public void librarianMenu(String username){
        boolean flag =true;
        for (int i=2; i>=0 && flag ; i--){
            System.out.print("Enter user password\n->");
            String pass = in.nextLine();
            if (librarians.get(username).librarianPassCheck(pass)){

                while (true){
                    System.out.println("----------------------Hi "+username+"----------------------");
                    System.out.print("1.Add Librarian\n2.Remove librarian\n3.Update librarian\n4.Add user\n5.Remove user\n6.Update user\n7.Add book\n8.Remove book\n9.Update book\n10.Print all of data\n11.logout\n->");
                    int order= in.nextInt();
                    in.nextLine();

                    //add librarian
                    if (order==1){
                        System.out.print("Enter username\n->");
                        String newUsername = in.nextLine();
                        if (librarians.containsKey(newUsername)){
                            System.out.println("This username already have gotten.");
                        }
                        else {
                            System.out.print("Enter password\n->");
                            String newPassword = in.nextLine();
                            addLibrarian(newUsername,newPassword);
                        }
                    }

                    //remove librarian
                    else if (order == 2) {
                        System.out.print("Enter username\n->");
                        String UsernameInput = in.nextLine();
                        if (librarians.containsKey(UsernameInput)){
                            removeLibrarian(UsernameInput);
                        }
                        else {
                            System.out.println("We don't have a librarian with this username.");
                        }
                    }

                    //update librarian
                    else if(order==3){
                        System.out.print("Enter username\n->");
                        String UsernameInput = in.nextLine();
                        if (librarians.containsKey(UsernameInput)){
                            System.out.print("Enter new password\n->");
                            String passInput = in.nextLine();
                            updateLibrarian(UsernameInput,passInput);
                        }
                        else {
                            System.out.println("We don't have a librarian with this username.");
                        }
                    }

                    //add user
                    else if (order==4){
                        System.out.print("Enter username\n->");
                        String newUsername = in.nextLine();
                        if (users.containsKey(newUsername)){
                            System.out.println("This username already have gotten.");
                        }
                        else {
                            System.out.print("Enter password\n->");
                            String newPassword = in.nextLine();
                            addUser(newUsername,newPassword);
                        }
                    }

                    //remove user
                    else if (order == 5) {
                        System.out.print("Enter username\n->");
                        String UsernameInput = in.nextLine();
                        if (users.containsKey(UsernameInput)){
                            removeUser(UsernameInput);
                        }
                        else {
                            System.out.println("We don't have a user with this username.");
                        }
                    }

                    //update user
                    else if(order==6){
                        System.out.print("Enter username\n->");
                        String UsernameInput = in.nextLine();
                        if (users.containsKey(UsernameInput)){
                            System.out.print("Enter new password\n->");
                            String passInput = in.nextLine();
                            updateUser(UsernameInput,passInput);
                        }
                        else {
                            System.out.println("We don't have a user with this username.");
                        }
                    }

                    //add book
                    else if (order==7){
                        System.out.print("Enter ISBN\n->");
                        int ISBN = in.nextInt();
                        in.nextLine();
                        if (books.containsKey(ISBN)){
                            books.get(ISBN).num++;
                        }
                        else {
                            System.out.print("Enter name of book\n->");
                            String name = in.nextLine();

                            System.out.print("Enter auther\n->");
                            String auther = in.nextLine();

                            System.out.print("Enter publish\n->");
                            String publish = in.nextLine();

                            System.out.print("Enter year\n->");
                            int year = in.nextInt();
                            in.nextLine();

                            Book book = new Book(name,auther,publish,year,ISBN);
                            addBook(book,ISBN);
                        }
                    }

                    //remove book
                    else if (order == 8) {
                        System.out.print("Enter ISBN\n->");
                        int ISBN = in.nextInt();
                        in.nextLine();

                        if (books.containsKey(ISBN)){
                            removeBook(ISBN);
                        }
                        else {
                            System.out.println("We don't have a boook with this ISBN.");
                        }
                    }

                    //update book
                    else if (order==9){
                        System.out.print("Enter ISBN\n->");
                        int ISBN = in.nextInt();
                        in.nextLine();
                        if (books.containsKey(ISBN)){
                            System.out.print("Enter new name of book\n->");
                            String name = in.nextLine();

                            System.out.print("Enter new auther\n->");
                            String auther = in.nextLine();

                            System.out.print("Enter new publish\n->");
                            String publish = in.nextLine();

                            System.out.print("Enter new year\n->");
                            int year = in.nextInt();
                            in.nextLine();
                            updateBook(ISBN, name,auther,publish,year);
                        }
                        else {
                            System.out.println("We don't have a boook with this ISBN.");
                        }
                    }

                    else if (order==10){
                        System.out.println("Users "+users);
                        System.out.println("Librarians "+librarians);
                        System.out.println("Books"+books);
                    }

                    else if(order== 11){
                        flag =false;
                        break;
                    }
                    else System.out.println("Wrong order!");
                }

            }
            else System.out.println("Wrong password. You can enter "+(i)+" more");
        }

    }
}