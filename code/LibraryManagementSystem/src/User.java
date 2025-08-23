import java.sql.Connection;
import java.util.Scanner;

public class User
{
    private final Connection conn;

    public User(Connection conn)
    {
        this.conn = conn;
    }

    public void login()
    {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter surname: ");
        String surname = sc.nextLine();
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter your role: ");
        String role = sc.nextLine();
        

        try
        {

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
