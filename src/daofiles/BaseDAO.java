import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    protected Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pet_adoption";
        String user = "root";
        String password = "password"; // Replace with your DB password
        return DriverManager.getConnection(url, user, password);
    }
}

