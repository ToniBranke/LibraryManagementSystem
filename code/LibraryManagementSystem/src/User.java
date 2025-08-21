import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class User
{
    private final Connection conn;

    public User(Connection conn)
    {
        this.conn = conn;
    }

    public void Login()
    {
        try
        {

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
