import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibraryRead extends Connector {

    @Override
    public Connection connect() {
        return super.connect();
    }

    @Override
    public void close() {
        super.close();
    }

    public Book read(long id) {
        final String sql = "select id, title, author, isbn, year from books where id = ?";
        try {
            PreparedStatement prepStmt = connect().prepareStatement(sql);
            prepStmt.setLong(1, id);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                Book book = new Book();
                book.setId(result.getLong("id"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                book.setYear(result.getInt("year"));
                book.setIsbn(result.getString("isbn"));
                System.out.println(book.toString());
            }
        } catch (SQLException e) {
            System.out.println("Could not get employee");
            e.printStackTrace();
        }
        return null;

    }
    public Book readAll() {
        ArrayList <Book> books = new ArrayList<Book>();

        final String sql = "select * from books ";
        try {
            PreparedStatement prepStmt = connect().prepareStatement(sql);
            ResultSet result = prepStmt.executeQuery();
            while (result.next()) {
                System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)); //gets the first column's rows.
            }


        } catch (SQLException e) {
            System.out.println("Could not get books");
            e.printStackTrace();
        }
        return null;

    }

}
