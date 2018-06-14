import Funcions.LibraryDelete;
import Funcions.LibraryRead;
import Funcions.LibrarySave;
import Funcions.LibraryUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDao {
    private static Connection connection=null;

    public static Connection getConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javalibrary?serverTimezone=UTC&useSSL=false&characterEncoding=utf8";
            String username = "root";
            String password = "dydolino96";
            connection = DriverManager.getConnection(url, username, password);
            if (connection!=null){
                System.out.println("Connection established");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {


       connection=getConnection();


        Scanner scan = new Scanner(System.in);
        String odp ="";

        while (!odp.equals("5")) {

            System.out.println("Wybierz opcję: \n " +
                    "1 - Dodaj nowy rekord \n " +
                    "2 - Wyświetl wszystkie książki \n " +
                    "3 - Aktualizacja \n " +
                    "4 - Usuwanie \n " +
                    "5 - Zakończ");
            odp = scan.nextLine();

            if (odp.equals("1")) {
                LibrarySave saveBook = new LibrarySave();
                saveBook.save(connection);
            }

            if (odp.equals("2")) {
                LibraryRead readLibrary = new LibraryRead();
                readLibrary.read(connection);

            }

            if (odp.equals("3")) {
                LibraryUpdate updateBook = new LibraryUpdate();
                updateBook.upDate(connection);
            }


            if (odp.equals("4")) {
                LibraryDelete deleteBook = new LibraryDelete();
                deleteBook.delete(connection);
            }
        }
        close();

    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
