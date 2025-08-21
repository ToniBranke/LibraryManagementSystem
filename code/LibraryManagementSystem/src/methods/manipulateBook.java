package methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        System.out.println("=== change the ISBN Number of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldIsbn = scIsbn.nextLine();

        System.out.println("please enter the new ISBN:");
        String newIsbn = scIsbn.nextLine();

        String sql = "UPDATE books SET ISBN = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newIsbn);
            pstmt.setString(2, oldIsbn);
            pstmt.executeUpdate();
            System.out.println("The ISBN number has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manTitle()
    {
        Scanner scTitle = new Scanner(System.in);
        System.out.println("=== change the Title Number of which Book? ===\n please enter the Title of the book you want to change:");
        String oldTitle = scTitle.nextLine();

        System.out.println("please enter the new Title:");
        String newTitle = scTitle.nextLine();

        String sql = "UPDATE books SET TITLE = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newTitle);
            pstmt.setString(2, oldTitle);
            pstmt.executeUpdate();
            System.out.println("The Title has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manAuthor()
    {
        Scanner scAuth = new Scanner(System.in);
        System.out.println("=== change the Author of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldAuth = scAuth.nextLine();

        System.out.println("please enter the new Author:");
        String newAuth = scAuth.nextLine();

        String sql = "UPDATE books SET AUTHOR = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newAuth);
            pstmt.setString(2, oldAuth);
            pstmt.executeUpdate();
            System.out.println("The Author has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manPublisher()
    {
        Scanner scPub = new Scanner(System.in);
        System.out.println("=== change the Publisher of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldPub = scPub.nextLine();

        System.out.println("please enter the new Publisher:");
        String newPub = scPub.nextLine();

        String sql = "UPDATE books SET PUBLISHER = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newPub);
            pstmt.setString(2, oldPub);
            pstmt.executeUpdate();
            System.out.println("The Publisher has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }
    public void manGenre()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the Genre of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldGenre = sc.nextLine();

        System.out.println("please enter the new Publisher:");
        String newGenre = sc.nextLine();

        String sql = "UPDATE books SET GENRE = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newGenre);
            pstmt.setString(2, oldGenre);
            pstmt.executeUpdate();
            System.out.println("The Genre has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manPubDate()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the Publishing date of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldLanguage = sc.nextLine();

        System.out.println("please enter the new Publishing date:");
        String newLanguage = sc.nextLine();

        String sql = "UPDATE books SET PUBLISHINGDATE = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newLanguage);
            pstmt.setString(2, oldLanguage);
            pstmt.executeUpdate();
            System.out.println("The Language has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manLang()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the Language of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldLang = sc.nextLine();

        System.out.println("please enter the new Language:");
        String newLang = sc.nextLine();

        String sql = "UPDATE books SET LANGUAGE = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newLang);
            pstmt.setString(2, oldLang);
            pstmt.executeUpdate();
            System.out.println("The Language has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manformat()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the format of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldFormat = sc.nextLine();

        System.out.println("please enter the new Format:");
        String newFormat = sc.nextLine();

        String sql = "UPDATE books SET FORMAT = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newFormat);
            pstmt.setString(2, oldFormat);
            pstmt.executeUpdate();
            System.out.println("The Format has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manUsk()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the USK-Rating of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldUsk = sc.nextLine();

        System.out.println("please enter the new USK-Rating:");
        String newUsk = sc.nextLine();

        String sql = "UPDATE books SET USK = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newUsk);
            pstmt.setString(2, oldUsk);
            pstmt.executeUpdate();
            System.out.println("The USK-Rating has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manPrice()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the Price of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldPrice = sc.nextLine();

        System.out.println("please enter the new Price:");
        String newPrice = sc.nextLine();

        String sql = "UPDATE books SET PRICE = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newPrice);
            pstmt.setString(2, oldPrice);
            pstmt.executeUpdate();
            System.out.println("The Price has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manThemes()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the Theme of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldThemes = sc.nextLine();

        System.out.println("please enter the new Theme:");
        String newThemes = sc.nextLine();

        String sql = "UPDATE books SET THEMES = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newThemes);
            pstmt.setString(2, oldThemes);
            pstmt.executeUpdate();
            System.out.println("The Theme has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }

    public void manStatus()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== change the Status of which Book? ===\n please enter the ISBN of the book you want to change:");
        String oldStatus = sc.nextLine();

        System.out.println("please enter the new Status:");
        String newStatus = sc.nextLine();

        String sql = "UPDATE books SET STATUS = ? WHERE ISBN = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, newStatus);
            pstmt.setString(2, oldStatus);
            pstmt.executeUpdate();
            System.out.println("The Status has been successfully changed!");
        }
        catch(SQLException e)
        {
            throw new RuntimeException(sql);
        }
    }
}
