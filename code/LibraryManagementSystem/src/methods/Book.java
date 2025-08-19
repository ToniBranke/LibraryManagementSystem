package methods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book
{
    private final Connection conn;

    public Book(Connection conn)
    {
        this.conn = conn;
    }

    public void addBook()
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

        manipulateBook manipulator = new manipulateBook(conn);
        boolean running = true;

        while (running)
        {
            System.out.println("What would you like to manipulate?\n  1. ISBN\n  2. Title\n  3. Author\n  4. Publisher\n  5.Genre\n" +
                "  6. Publishing Date (DD-MM-YYYY)\n  7. Language\n  8. Format\n  9. USK\n  10. Price\n  11. Themes\n  12. Status\n  13. Exit\n" +
                "Please enter your chooice:");

            String manipulate = scManipulate.nextLine();

            switch (manipulate)
            {
                case "1":
                    manipulator.manIsbn();
                    break;
                case "2":
                    manipulator.manTitle();
                    break;
                case "3":
                    manipulator.manAuthor();
                    break;
                case "4":
                    manipulator.manPublisher();
                    break;
                case "5":
                    manipulator.manGenre();
                    break;
                case "6":
                    manipulator.manPubDate();
                    break;
                case "7":
                    manipulator.manLang();
                    break;
                case "8":
                    manipulator.manformat();
                    break;
                case "9":
                    manipulator.manUsk();
                    break;
                case "10":
                    manipulator.manPrice();
                    break;
                case "11":
                    manipulator.manThemes();
                    break;
                case "12":
                    manipulator.manStatus();
                    break;
                case "13":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input please enter a valid answer!");
                    break;
            }
        }
    }

    public void searchBook()
    {
        boolean running = true;
        while(running)
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("what would you like to display?\n  1. display everything\n  2. Title\n  3. Author\n  4. Publisher\n  5. Genre\n  6. Publishing Date\n  6. Language\n  7. Format\n" +
                    "  8. USK\n  9. Price\n  11. Themes\n  12. Status\n  13. Exit");
            String search = sc.nextLine();
            switch (search)
            {
                case "1":
                    System.out.println("Displaying all the books:");
                    String sql = "SELECT * FROM Books";

                    try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        ResultSet rs = pstmt.executeQuery();

                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();

                        List<String[]> rows = new ArrayList<>();
                        int[] maxWidth = new int[columnCount];

                        //displaying first the table head and the values afterward
                        for(int i = 1; i <= columnCount; i++)
                        {
                            String header = rsmd.getColumnLabel(i);
                            maxWidth[i-1] = header.length();
                        }

                        while (rs.next())
                        {
                            String[] row = new String[columnCount];
                            for (int i = 1; i <= columnCount; i++)
                            {
                                String value = rs.getString(i);

                                if (value == null) value= " ";
                                row[i-1] = value;
                                if (value.length() > maxWidth[i-1]) maxWidth[i-1] = value.length();
                            }
                            rows.add(row);
                        }
                        for (int i = 1; i <= columnCount; i++)
                        {
                            System.out.printf("%-"+(maxWidth[i-1]+2)+"s", rsmd.getColumnLabel(i));
                        }
                        System.out.println();

                        for(String[] row : rows)
                        {
                            for (int i = 0; i < columnCount; i++)
                            {
                                System.out.printf("%-"+(maxWidth[i]+2)+"s", row[i]);
                            }
                            System.out.println();
                        }
                    }
                    catch (SQLException e)
                    {
                        throw new RuntimeException(e);
                    }
                    break;

                case "2":
                    System.out.println("please enter the title you want to look for:");
                    String title = sc.nextLine();
                    System.out.println("Displaying all the books with the Title:" + title);

                    String sql = "SELECT  ";

                case "13":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input please enter a valid answer!");
                    break;

//                    System.out.println("Please enter the ISBN of the Book you search:");
//                    String isbnSearch = sc.nextLine();
//
//                    String sql = "SELECT ? FROM Books WHERE ISBN";
//                    try(PreparedStatement pstmt = conn.prepareStatement(sql))
//                    {
//                        pstmt.setString(1, isbnSearch);
//                        ResultSet rs = pstmt.executeQuery();
//                    }
//                    catch(SQLException e)
//                    {
//                        throw new RuntimeException(e);
//                    }
//                    break;
            }

        }

    }
}
