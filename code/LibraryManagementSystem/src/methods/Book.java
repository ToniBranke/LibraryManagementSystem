package methods;

import java.util.Scanner;

public class Book
{
    public static void addBook()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter ISBN:");
        String isbn = sc.nextLine();

        System.out.println("Title:");
        String title = sc.nextLine();

        System.out.println("Author:");
        String author = sc.nextLine();

        System.out.println("publisher:");
        String publisher = sc.nextLine();

        System.out.println("Genre:");
        String genre = sc.nextLine();

        System.out.println("publishing Date: (DD-MM-YYYY)");
        String publishingDate = sc.nextLine();

        System.out.println("language:");
        String language = sc.nextLine();

        System.out.println("ISBN:");
    }
}
