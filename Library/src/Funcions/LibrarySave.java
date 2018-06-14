package Funcions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LibrarySave {
    public LibrarySave() {
    }

    public void save(Connection connection) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj tytuł :");
        String title = scan.nextLine();

        System.out.println("Podaj autora :");
        String author = scan.nextLine();

        System.out.println("Podaj rok :");
        String year = scan.nextLine();

        System.out.println("Podaj ISBN :");
        String isbn = scan.nextLine();

        String sql = "insert into books(title,author,year,isbn) values( ?, ?, ?,?)";

        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);

            prepStmt.setString(1, title);
            prepStmt.setString(2, author);
            prepStmt.setString(3, year);
            prepStmt.setString(4, isbn);
            prepStmt.executeUpdate();
            System.out.println("\n Zapisano nowa ksiazke \n");


        } catch (SQLException e) {
            System.out.println("Nie mozna zapisac");
            e.printStackTrace();
        }

    }
}
