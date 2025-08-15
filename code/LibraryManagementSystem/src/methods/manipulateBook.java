package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class manipulateBook
{
    private final Connection conn;

    public manipulateBook(Connection conn)
    {
        this.conn = conn;
    }

    public void manIsbn()     //later change this to a search for a less specific search
    {
        Scanner scIsbn = new Scanner(System.in);
        System.out.println("=== change the ISBN Number of which Book? ===\n please enter the name of the book you want to change:");
        String input = scIsbn.nextLine();


        String sql = "UPDATE books SET ISBN = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {

        }
        catch()
        {

        }


    }

    public static void manTitle()
    {

    }

    public static void manAuthor()
    {

    }

    public static void manPubliisher()
    {

    }
    public static void manGenre()
    {

    }

    public static void manPubDate()
    {

    }

    public static void manLang()
    {

    }

    public static void manformat()
    {

    }

    public static void manUsk()
    {

    }

    public static void manPrice()
    {

    }

    public static void manThemes()
    {

    }

    public static void manStatus()
    {

    }
}
