import java.util.Scanner;

public class User
{
    private String id;
    private String name;
    private String email;
    private String password;

    public boolean login()
    {
        Scanner sc = new Scanner(System.in);
        if (sc.next().equals(password))
        {
            return true;
        }
        return false;
    }
}
