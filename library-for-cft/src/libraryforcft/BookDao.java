package libraryforcft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс BookDAO предоставляет методы для взаимодействия с таблицей книг в базе данных.
 * Это включает в себя добавление новых книг, получение списка всех книг, обновление информации о книгах,
 * удаление книг и поиск книг по заданным критериям.
 */

public class BookDao {
    private Connection connection;
    
    /**
     * Конструктор класса BookDAO.
     * Инициализирует соединение с базой данных.
     */

    public BookDao() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * Добавляет новую книгу в базу данных.
     * @param title Название книги.
     * @param author Автор книги.
     * @param year Год публикации книги.
     */
    public void addBook(String title, String author, int year) {
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, year);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает список всех книг из базы данных.
     * @return ResultSet с результатами запроса.
     */
    public ResultSet getAllBooks() {
        String sql = "SELECT * FROM books";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Обновляет информацию о книге в базе данных.
     * @param id Идентификатор книги.
     * @param title Новое название книги.
     * @param author Новой автор книги.
     * @param year Новый год публикации книги.
     */
    public void updateBook(int id, String title, String author, int year) {
        String sql = "UPDATE books SET title = ?, author = ?, year = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, year);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Удаляет книгу из базы данных по ее идентификатору.
     * @param id Идентификатор книги.
     */
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Поиск книг по заданным критериям.
     * @param query Строка поиска.
     * @return ResultSet с результатами поиска.
     */
    public ResultSet searchBooks(String query) {
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + query + "%");
            statement.setString(2, "%" + query + "%");
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}