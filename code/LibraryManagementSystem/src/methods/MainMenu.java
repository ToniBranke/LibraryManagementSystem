package methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import UserClasses.*;

public class MainMenu
{
    public void AdminMainMenu()
    {
        var urlEmployees = "jdbc:sqlite:DB/mitarbeiter.db";
        var urlBooks = "jdbc:sqlite:DB/Books.db";

        try
        (Connection connBooks = DriverManager.getConnection(urlBooks);
         Connection connEmployees = DriverManager.getConnection(urlEmployees))
        {
            System.out.println("Book Database connected at URL: " + connBooks.getMetaData().getURL());
            System.out.println("Customer Database connected at URL: " + connEmployees.getMetaData().getURL());

            User user = new User(connEmployees);

            Scanner UserInput = new Scanner(System.in);
            boolean running = true;
            Book book = new Book(connBooks);
            Borrowing borrowing = new Borrowing(connBooks);

            while (running)
            {
                System.out.println("=== main menu ===\n  1. add Book\n  2. delete a Book\n  3. change books \n  4. search for books\n  5. create user\n  6. delete User \n  7. display Customer Accounts\n  8. create Bill \n  9. Borrow Books\n" +
                        "  10. return Book\n  11. send payment reminder\n  12. display book history\n  13. display statistics\n  14. exit \nplease enter your choice:");
                String input = UserInput.nextLine();
                switch (input)
                {
                    case "1":
                        book.addBook();
                        break;
                    case "2":
                        book.deleteBook();
                        break;
                    case "3":
                        book.manipulateBook();
                        break;
                    case "4":
                        book.searchBook();
                        break;
                    case "5":
                        user.createUser();
                        break;
                    case "6":
                        user.deleteUser();
                        break;
                    case "7":
                        System.out.println("not yet implemented");
                        break;
                    case "8":
                        System.out.println("not yet implemented");
                        break;
                    case "9":
                        borrowing.Borrow();
                        break;
                    case "10":
                        borrowing.returnBook();
                        break;
                    case "11":
                        System.out.println("not yet implemented");
                        break;
                    case "12":
                        System.out.println("not yet implemented");
                        break;
                    case "13":
                        System.out.println("not yet implemented");
                        break;
                    case "14":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again!");
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void customerMenu()              //needs to be completed with
    {
        var urlBooks = "jdbc:sqlite:DB/Books.db";
        try
        (Connection connBooks = DriverManager.getConnection(urlBooks))
        {
            Scanner UserInput = new Scanner(System.in);
            boolean running = true;
            Book book = new Book(connBooks);
            while (running)
            {
                System.out.println("=== main menu ===\n  1. display Books\n  2. display borrowed books\n  3. display bills\n  4. exit\nplease enter your choice:");
                String input = UserInput.nextLine();
                switch (input) {
                    case "1":
                        book.searchBook();
                        break;
                    case "2":
                        System.out.println("not yet implemented");
                        break;
                    case "3":
                        System.out.println("not yet implemented");
                        break;
                        case "4":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again!");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void cashierMenu()           //same thing here needs to be completed with methods
    {
        var urlEmployees = "jdbc:sqlite:DB/mitarbeiter.db";
        var urlBooks = "jdbc:sqlite:DB/Books.db";
        try(Connection connBooks = DriverManager.getConnection(urlBooks); Connection connEmployees = DriverManager.getConnection(urlEmployees)) {
            Scanner UserInput = new Scanner(System.in);
            boolean running = true;
            Book book = new Book(connBooks);
            Borrowing borrowing = new Borrowing(connBooks);
            while (running)
            {
                System.out.println("=== Main menu ===\n  1. display Books\n  2. display Customer Accounts\n  3. create Bills\n  4. borrow Books\n  5. return Books\n  5. send Payment Reminder\n  6. exit\nplease enter your choice: ");
                String input = UserInput.nextLine();
                switch (input)
                {
                    case "1":
                        book.searchBook();
                        break;
                    case "2":
                        System.out.println("not yet implemented");
                        break;
                    case "3":
                        System.out.println("not yet implemented");
                        break;
                    case "4":
                        borrowing.Borrow();
                        break;
                    case "5":
                        borrowing.returnBook();
                        break;
                    case "6":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again!");

                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void librarianMenu()
    {
        var urlEmployees = "jdbc:sqlite:DB/mitarbeiter.db";
        var urlBooks = "jdbc:sqlite:DB/Books.db";
        try(Connection connBooks = DriverManager.getConnection(urlBooks))
        {
            Scanner UserInput = new Scanner(System.in);
            boolean running = true;
            Book book = new Book(connBooks);
            while(running)
            {
                System.out.println("=== Main menu ===\n  1. display Books\n  2. display Customer Accounts\n  3. manipulate Books\n  4. add Books\n  5. delete Books\n  6. display Book history\n please enter your choice:");
                String input = UserInput.nextLine();
                switch (input)
                {
                    case "1":
                        book.searchBook();
                        break;
                    case "2":
                        System.out.println("not yet implemented");
                        break;
                    case "3":
                        book.manipulateBook();
                        break;
                    case "4":
                        book.addBook();
                        break;
                    case "5":
                        book.deleteBook();
                        break;
                    case "6":
                        System.out.println("not yet implemented");
                        break;
                    case "7":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again!");
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

