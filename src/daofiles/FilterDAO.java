import java.sql.*;

public class FilterDAO extends BaseDAO {
    public Filter getFilterById(int id) throws SQLException {
        Filter filter = null;
        String query = "SELECT * FROM filters WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                filter = new Filter();
                filter.setId(rs.getInt("id"));
                filter.setAnimalType(rs.getString("animal_type"));
                filter.setAgeGroup(rs.getString("age_group"));
                filter.setSize(rs.getString("size"));
            }
        }
        return filter;
    }
}
