package libraryforcft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс ReaderDAO предоставляет методы для взаимодействия с таблицей читателей в базе данных.
 * Это включает в себя добавление новых читателей, получение списка всех читателей, обновление информации о читателях,
 * удаление читателей и поиск читателей по заданным критериям.
 */
public class ReaderDao {
    private Connection connection;

    /**
     * Конструктор класса ReaderDAO.
     * Инициализирует соединение с базой данных.
     */
    public ReaderDao() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Добавляет нового читателя в базу данных.
     * @param name Имя читателя.
     * @param gender Пол читателя.
     * @param age Возраст читателя.
     */
    public void addReader(String name, String gender, int age) {
        String sql = "INSERT INTO readers (name, gender, age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, gender);
            statement.setInt(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Возвращает список всех читателей из базы данных.
     * @return ResultSet с результатами запроса.
     */
    public ResultSet getAllReaders() {
        String sql = "SELECT * FROM readers";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Обновляет информацию о читателе в базе данных.
     * @param id Идентификатор читателя.
     * @param name Новое имя читателя.
     * @param gender Новый пол читателя.
     * @param age Новый возраст читателя.
     */
    public void updateReader(int id, String name, String gender, int age) {
        String sql = "UPDATE readers SET name = ?, gender = ?, age = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, gender);
            statement.setInt(3, age);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Удаляет читателя из базы данных по его идентификатору.
     * @param id Идентификатор читателя.
     */
    public void deleteReader(int id) {
        String sql = "DELETE FROM readers WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Поиск читателей по заданным критериям.
     * @param query Строка поиска.
     * @return ResultSet с результатами поиска.
     */
    public ResultSet searchReaders(String query) {
        String sql = "SELECT * FROM readers WHERE name LIKE ? OR gender LIKE ?";
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