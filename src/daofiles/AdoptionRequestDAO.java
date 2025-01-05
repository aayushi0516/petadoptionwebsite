import java.sql.*;

public class AdoptionRequestDAO extends BaseDAO {
    public void saveRequest(AdoptionRequest request) throws SQLException {
        String query = "INSERT INTO adoption_requests (user_id, pet_id, status) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, request.getUserId());
            stmt.setInt(2, request.getPetId());
            stmt.setString(3, request.getStatus());
            stmt.executeUpdate();
        }
    }
}
