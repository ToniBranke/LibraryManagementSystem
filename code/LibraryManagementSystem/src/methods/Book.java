package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Book
{
    private final Connection conn;

    public Book(Connection conn)
    {
        this.conn = conn;
    }

    public  void addBook()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ISBN:");
        String isbn = sc.nextLine();

        System.out.println("Title:");
        String title = sc.nextLine();

        System.out.println("Author:");
        String author = sc.nextLine();

        System.out.println("publisher:");
        String publisher = sc.nextLine();

        System.out.println("Genre:");
        String genre = sc.nextLine();

        System.out.println("publishing Date: (DD-MM-YYYY)");
        String publishingDate = sc.nextLine();

        System.out.println("language:");
        String language = sc.nextLine();

        System.out.println("format");
        String format = sc.nextLine();

        System.out.println("usk (0, 6, 12, 16, 18):");
        int usk = Integer.parseInt(sc.nextLine());

        System.out.println("price:");
        double price = Double.parseDouble(sc.nextLine());            //theoretically there should be a double (REAL) here

        System.out.println("Themes (divided by commas):");
        String themes = sc.nextLine();

        System.out.println("status:");
        String status = sc.nextLine();

        String sql = "INSERT INTO Books (ISBN, title, author, publisher, genre, publishingDate, language, format, usk, price, themes, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, publisher);
            pstmt.setString(5, genre);
            pstmt.setString(6, publishingDate);
            pstmt.setString(7, language);
            pstmt.setString(8, format);
            pstmt.setInt(9, usk);
            pstmt.setDouble(10, price);
            pstmt.setString(11, themes);
            pstmt.setString(12, status);

            pstmt.executeUpdate();
            System.out.println("Book added successfully!");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void deleteBook()
    {
        Scanner scDelete = new Scanner(System.in);

        System.out.println("Please enter the ISBN of the Book you  would like to delete");

        String isbnDelete = scDelete.nextLine();

        String sql = "DELETE FROM Books WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, isbnDelete);

            pstmt.executeUpdate();
            System.out.println("Book at"+ isbnDelete +"deleted successfully!");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void manipulateBook()
    {
        Scanner scManipulate = new Scanner(System.in);

        System.out.println("What would you like to manipulate?\n  1. ISBN\n  2. Title\n  3. Author\n  4. Publisher\n  5.Genre\n" +
                "  6. Publishing Date (DD-MM-YYYY)\n  7. Language\n  8. Format\n  9. USK\n  10. Price\n  11. Themes\n  12. Status\n" +
                "Please enter your chooice:");
        String manipulate = scManipulate.nextLine();

        switch (manipulate)
        {
            case "1":
                manipulateBook.manIsbn();
                break;
            case "2":
                manipulateBook.manTitle();
                break;
            case "3":
                manipulateBook.manAuthor();
                break;
            case "4":
                manipulateBook.manPubliisher();
                break;
            case "5":
                manipulateBook.manGenre();
                break;
            case "6":
                manipulateBook.manPubDate();
                break;
            case "7":
                manipulateBook.manLang();
                break;
            case "8":
                manipulateBook.manformat();
                break;
            case "9":
                manipulateBook.manUsk();
                break;
            case "10":
                manipulateBook.manPrice();
                break;
            case "11":
                manipulateBook.manThemes();
                break;
            case "12":
                manipulateBook.manStatus();
                break;
            default:
                System.out.println("Invalid input please enter a valid answer!");
                break;
        }
    }
}
