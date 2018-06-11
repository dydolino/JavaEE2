import java.sql.*;

public class Connector {
    private static final String URL = "jdbc:mysql://localhost:3306/library?characterEncoding=utf8&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "dydolino96";
    private Connection connection;

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






}

