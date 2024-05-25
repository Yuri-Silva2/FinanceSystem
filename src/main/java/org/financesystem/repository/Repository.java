package org.financesystem.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Repository {

    private final HikariDataSource dataSource;

    public Repository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Executes an SQL query that expects a single result.
     *
     * @param query      the SQL query.
     * @param uuid      the uuid parameter for the query.
     * @param columnName the name of the column to fetch from the result set.
     * @return the value of the specified column from the result set, or 0.0 if no result.
     */
    public double executeQuery(String query, UUID uuid, String columnName) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, uuid.toString());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble(columnName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query row in database.", e);
        }
        return 0.0;
    }

    /**
     * Executes an SQL query that expects a single result.
     *
     * @param query      the SQL query.
     * @param email      the email parameter for the query.
     * @param columnName the name of the column to fetch from the result set.
     * @return the value of the specified column from the result set, or null if no result.
     */
    public @Nullable String executeQuery(String query, String email, String columnName) {
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
    public void executeUpdate(String query, Object... params) {
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
