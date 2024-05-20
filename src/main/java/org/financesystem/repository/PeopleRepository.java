package org.financesystem.repository;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Repository class for accessing 'People' data from the database.
 */
public class PeopleRepository {

    private final HikariDataSource dataSource;

    /**
     * Constructs a PeopleRepository with the specified data source.
     *
     * @param dataSource The data source to be used for database connections.
     */
    public PeopleRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Creates a new record in the 'peoples' table.
     *
     * @param email the email of the person.
     * @param password the password of the person.
     */
    public void createPeople(String email, String password) {
        String query = "INSERT INTO peoples (name, email, birthday, password) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, null);
            statement.setString(2, email);
            statement.setString(3, null);
            statement.setString(4, password);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a person with the specified email exists and returns the password if found.
     *
     * @param email the email to check.
     * @return the password of the person if found, null otherwise.
     */
    public String containsPeople(String email) {
        String query = "SELECT password FROM peoples WHERE email = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("password");
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }
}
