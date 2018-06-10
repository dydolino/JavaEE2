import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryUpdate extends Connector {

    @Override
    public Connection connect() {
        return super.connect();
    }

    @Override
    public void close() {
        super.close();
    }

    public void update(Book book) {
        final String sql = "update books set title=?, author=?, year=?, isbn=? where id = ?";
        try {
            PreparedStatement prepStmt = connect().prepareStatement(sql);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getAuthor());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setString(4, book.getIsbn());
            prepStmt.setLong(5, book.getId());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record");
        }
    }
}