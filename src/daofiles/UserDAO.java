import java.sql.*;

public class UserDAO extends BaseDAO {
    public User getUserById(int id) throws SQLException {
        User user = null;
        String query = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        }
        return user;
    }
}
