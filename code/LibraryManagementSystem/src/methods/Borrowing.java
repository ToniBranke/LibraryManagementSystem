package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Borrowing
{
    private final Connection conn;
    public Borrowing(Connection conn)
    {
        this.conn = conn;
    }
    public void Borrow()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the ISBN of the Book you want to borrow: ");
        String isbn = sc.nextLine();

        String sql = "UPDATE books SET status = 'not available'  WHERE isbn = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, isbn);
            pstmt.executeUpdate();
            System.out.println("Book Borrowed successfully");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the ISBN of the Book you want to return: ");
        String isbn = sc.nextLine();

        String sql = "UPDATE books SET status = 'available' WHERE isbn = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, isbn);
            stmt.executeUpdate();
            System.out.println("Book Returned successfully");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
