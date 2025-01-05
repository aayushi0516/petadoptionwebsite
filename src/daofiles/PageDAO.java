import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PageDAO extends BaseDAO {
    public List<Page> getAllPages() throws SQLException {
        List<Page> pages = new ArrayList<>();
        String query = "SELECT * FROM pages";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Page page = new Page();
                page.setId(rs.getInt("id"));
                page.setTitle(rs.getString("title"));
                page.setContent(rs.getString("content"));
                pages.add(page);
            }
        }
        return pages;
    }
}

