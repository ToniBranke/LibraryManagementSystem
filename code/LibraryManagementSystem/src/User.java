import java.util.Scanner;

public class User
{
    private String id;
    private String name;
    private String email;
    private String password;

    public User(String id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

    }

//    public boolean login()
//    {
//        Scanner sc = new Scanner(System.in);
//        if (sc.next().equals(password))
//        {
//            return true;
//        }
//        return false;
//    }
}
