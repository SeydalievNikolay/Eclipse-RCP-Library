package libraryforcft;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс BookService предоставляет сервисные методы для работы с книгами в библиотеке.
 * Он включает в себя операции добавления, обновления, удаления и поиска книг.
 */
public class BookService {
	public void addBook(String title, String authors, int yearPublished) {
        String sql = "INSERT INTO Books (title, authors, year_published) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, authors);
            pstmt.setInt(3, yearPublished);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	 public List<Book> getAllBooks() {
	        List<Book> books = new ArrayList<>();
	        String sql = "SELECT * FROM Books";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {

	            while (rs.next()) {
	                Book book = new Book();
	                book.setId(rs.getInt("id"));
	                book.setTitle(rs.getString("title"));
	                book.setAuthors(rs.getString("authors"));
	                book.setYearPublished(rs.getInt("year_published"));
	                books.add(book);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return books;
	    }
	 
	 public void updateBook(int id, String title, String authors, int yearPublished) {
	        String sql = "UPDATE Books SET title = ?, authors = ?, year_published = ? WHERE id = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, title);
	            pstmt.setString(2, authors);
	            pstmt.setInt(3, yearPublished);
	            pstmt.setInt(4, id);

	            pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void deleteBook(int id) {
	        String sql = "DELETE FROM Books WHERE id = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setInt(1, id);

	            pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
