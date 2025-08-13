import methods.Book;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class Main
{
//    public static void connectBooks()
//    {
//        var urlBooks = "jdbc:sqlite:DB/Books.db";
//
//
//        try (var conn = DriverManager.getConnection(urlBooks))
//        {
//            System.out.println("Connection to the BookDB has been successfully established.");
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }
//    public static void connectEmployees()
//    {
//        var urlEmployees = "jdbc:sqlite:DB/mitarbeiter.db";
//
//        try (var connE = DriverManager.getConnection(urlEmployees))
//        {
//            System.out.println("Connection to the EmployeeDB has been successfully established.");
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args)
    {
//        connectBooks();
//        connectEmployees();

        var urlEmployees = "jdbc:sqlite:DB/mitarbeiter.db";
        var urlBooks = "jdbc:sqlite:DB/Books.db";

        try
        (   Connection connBooks = DriverManager.getConnection(urlBooks);
            Connection connEmployees = DriverManager.getConnection(urlEmployees))
        {
            System.out.println("Books-DB-URL: " + connBooks.getMetaData().getURL());
            System.out.println("Connection to the Databases has been Successfully established!");

            Scanner UserInput = new Scanner(System.in);
            boolean running = true;
            Book book = new Book(connBooks);

            while(running)
            {
                System.out.println("=== main menu ===\n 1. add Book\n 2. end \n please enter your choice");
                String input = UserInput.nextLine();
                switch (input)
                {
                    case "1":
                        book.addBook();
                        break;
                    case "2":
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