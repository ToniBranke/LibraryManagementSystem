import methods.Hash;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
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

        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("please repeat your password: ");
        String password2 = sc.nextLine();
//        System.out.println("Enter email: ");
//        String email = sc.nextLine();
//        System.out.println("Enter name: ");
//        String name = sc.nextLine();
//        System.out.println("Enter surname: ");
//        String surname = sc.nextLine();
//        System.out.println("Enter username: ");
//        String username = sc.nextLine();
//        System.out.println("Enter your role: ");
//        String role = sc.nextLine();

        if (password.equals(password2))
        {
            System.out.println(password + " , " + password2);
            try
            {
                byte[] hashBytes = Hash.getSha(password);
                String hashedPassword = new String(hashBytes);
                System.out.println(hashedPassword);
            }
            catch (NoSuchAlgorithmException e)
            {
                throw new RuntimeException(e);
            }
        }

        try
        {

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
