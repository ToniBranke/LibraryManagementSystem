package UserClasses;

import methods.Hash;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            System.out.println(password + " , " + password2);
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

}
