package org.financesystem.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

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
     * @param uuid     the uuid of the person.
     * @param email    the email of the person.
     * @param password the password of the person.
     */
    public void createPeople(UUID uuid, String email, String password) {
        String query = "INSERT INTO peoples (id_bin, name, email, birthday, password) VALUES " +
                "(unhex(replace(?,'-','')), ?, ?, ?, ?)";
        executeUpdate(query, uuid.toString(), null, email, null, password);
    }

    /**
     * Checks if a person with the specified email exists and returns the password if found.
     *
     * @param email the email to check.
     * @return the password of the person if found, null otherwise.
     */
    public String containsPeople(String email) {
        String query = "SELECT password FROM peoples WHERE email = ?";
        return executeQuery(query, email, "password");
    }

    /**
     * Gets the ID of a person by email.
     *
     * @param email the email to check.
     * @return the ID of the person if found, null otherwise.
     */
    public String getIdByEmail(String email) {
        String query = "SELECT id_text FROM peoples WHERE email = ?";
        return executeQuery(query, email, "id_text");
    }

    /**
     * Executes an SQL query that expects a single result.
     *
     * @param query      the SQL query.
     * @param email      the email parameter for the query.
     * @param columnName the name of the column to fetch from the result set.
     * @return the value of the specified column from the result set, or null if no result.
     */
    private @Nullable String executeQuery(String query, String email, String columnName) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString(columnName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query row in database.", e);
        }
        return null;
    }

    /**
     * Executes an SQL update query.
     *
     * @param query  the SQL query.
     * @param params the parameters for the query.
     */
    private void executeUpdate(String query, Object... params) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            int index = 1;
            for (Object param : params) {
                statement.setObject(index++, param);
            }

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute update row in database.", e);
        }
    }
}
