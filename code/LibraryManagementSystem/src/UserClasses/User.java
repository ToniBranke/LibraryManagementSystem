package UserClasses;

import methods.Hash;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User
{
    private final Connection conn;
    public User(Connection conn)
    {
        this.conn = conn;
    }

    public void createUser()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter surname: ");
        String firstName = sc.nextLine();
        System.out.println("Enter first name: ");
        String name = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("please repeat your password: ");
        String password2 = sc.nextLine();
        System.out.println("Enter your role: ");
        String role = sc.nextLine();
        if (password.equals(password2))
        {
            try
            {
                byte[] hashBytes = Hash.getSha(password);
                String hashedPassword = Hash.shaHash(hashBytes);
                System.out.println(hashedPassword);

                String sql = "INSERT INTO Users (name, firstName, email, passwordHash, role) VALUES (?, ?, ?, ?, ?)";

                try(PreparedStatement pstmt = conn.prepareStatement(sql))
                {
                    pstmt.setString(1, firstName);
                    pstmt.setString(2, name);
                    pstmt.setString(3, email);
                    pstmt.setString(4, hashedPassword);
                    pstmt.setString(5, role);
                    pstmt.executeUpdate();
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            catch (NoSuchAlgorithmException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    public void deleteUser()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the email address and Password of the User you want to delete: \n email: ");
        String email = sc.nextLine();
        System.out.println("password: ");
        String password = sc.nextLine();

        String sql1 = "SELECT passwordHash FROM Users WHERE email = ?";
        String hashedPassword = null;
        String dbHash = null;

        try(PreparedStatement pstmt = conn.prepareStatement(sql1))
        {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            dbHash = rs.getString("passwordHash");
            System.out.println(dbHash);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            byte[] hashBytes = Hash.getSha(password);
            hashedPassword = Hash.shaHash(hashBytes);
            System.out.println(hashedPassword);
        }
        catch(NoSuchAlgorithmException e)
        {
            System.out.println(e.getMessage());
        }

        if (dbHash.equals(hashedPassword))
        {
            String sql = "DELETE FROM Users WHERE email = ? ";
            System.out.println(sql + "passwords match");
            try (PreparedStatement pstmt = conn.prepareStatement(sql))
            {
                pstmt.setString(1, email);
//              pstmt.setString(2, password);
                pstmt.executeUpdate();
                System.out.println("User deleted successfully");
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
