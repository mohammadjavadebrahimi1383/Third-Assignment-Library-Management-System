import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        runMenu();
    }
    public static void runMenu() {

        Scanner in = new Scanner(System.in);
        Library library1 = new Library();

        while (true) {
            System.out.print("1.User\n2.Librarian\n3.exit\n->");
            int order = in.nextInt();
            in.nextLine();

            //user
            if (order == 1) {
                System.out.print("Enter username\n->");
                String username = in.nextLine();
                if (library1.doesUserExist(username)) {
                    library1.Usermenu(username);
                }
                else System.out.println("Wrong username!");
            }

            //librarian
            else if (order == 2) {

                System.out.print("Enter username\n->");
                String username = in.nextLine();
                if (library1.doesLibrarianExist(username)) {
                    library1.librarianMenu(username);
                }
                else System.out.println("Wrong username!");
            }

            //exit
            else if (order == 3) System.exit(0);
            else System.out.print("wrong order!\n->");
        }

    }
}
