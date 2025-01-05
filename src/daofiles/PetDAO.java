import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO extends BaseDAO {
    public List<Pet> getAvailablePets() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT * FROM pets";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setName(rs.getString("name"));
                pet.setType(rs.getString("type"));
                pet.setAge(rs.getInt("age"));
                pet.setSize(rs.getString("size"));
                pet.setDescription(rs.getString("description"));
                pets.add(pet);
            }
        }
        return pets;
    }
}
