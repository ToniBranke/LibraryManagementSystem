package methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import UserClasses.*;


public class MainMenu
{
    public static void mainMenu()
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
            Login login = new Login(connEmployees);

            Scanner UserInput = new Scanner(System.in);
            boolean running = true;
            Book book = new Book(connBooks);

            while(running)
            {
                System.out.println("=== main menu ===\n  1. add Book\n  2. delete a Book\n  3. change books \n  4. search for books\n  5. create user\n  6. exit \nplease enter your choice:");
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
}

