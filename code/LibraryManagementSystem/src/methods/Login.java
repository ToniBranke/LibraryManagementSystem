package methods;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static methods.MainMenu.mainMenu;

public class Login
{
    private final Connection conn;
    public Login(Connection conn)
    {
        this.conn = conn;
    }

    public void login() {
        Scanner input = new Scanner(System.in);

        String sql = "SELECT passwordHash FROM users WHERE email = ?";
        String hashedPassword = null;

        boolean loggedIn = false;

        while(!loggedIn)
        {
            System.out.println("=== Login ===");
            System.out.println("  please enter your email address: ");
            String email = input.nextLine();
            System.out.println("  please enter your password: ");
            String password = input.nextLine();

            try
            {
                byte[] hashBytes = Hash.getSha(password);
                hashedPassword = Hash.shaHash(hashBytes);
            }
            catch (NoSuchAlgorithmException e)
            {
                throw new  RuntimeException(e);
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, email);
                ResultSet rs = pstmt.executeQuery();
                String dbHash = rs.getString("passwordHash");

                if (hashedPassword.equals(dbHash)) {
                    System.out.println("You logged in as " + email);
                    loggedIn = true;
                } else {
                    System.out.println("Incorrect password or email address please try again");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(loggedIn)
        {
            mainMenu();
        }
    }
}
