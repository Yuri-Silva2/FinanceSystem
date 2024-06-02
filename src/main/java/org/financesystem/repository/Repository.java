package org.financesystem.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.financesystem.model.Color;
import org.financesystem.model.Institution;
import org.financesystem.model.account.AccountDTO;
import org.financesystem.model.account.AccountType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

/**
 * The Repository class handles database operations using a HikariDataSource.
 * It provides methods to execute both queries and updates.
 */
public class Repository {

    private final HikariDataSource dataSource;

    /**
     * Constructs a Repository with the specified HikariDataSource.
     *
     * @param dataSource the HikariDataSource to be used for database connections
     */
    public Repository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Executes a query and returns a double result.
     *
     * @param query      the SQL query
     * @param uuid       the UUID parameter for the query
     * @param accountType the AccountType parameter for the query
     * @param columnName the name of the column to retrieve the result from
     * @return the double result from the specified column
     */
    public double executeQuery(String query, UUID uuid, AccountType accountType, String columnName) {
        return executeQuery(query, rs -> {
            try {
                return rs.getDouble(columnName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, uuid.toString(), accountType.toString());
    }

    public List<AccountDTO> executeQuery(String query, UUID uuid) {
        return executeQuery(query, rs -> {
            List<AccountDTO> results = new ArrayList<>();
            try {
                do {
                    Institution institution = Institution.valueOf(rs.getString("institution"));
                    AccountType accountType = AccountType.valueOf(rs.getString("type"));
                    boolean quick = rs.getBoolean("quick");
                    boolean homeScreen = rs.getBoolean("home_screen");
                    String description = rs.getString("description");
                    double value = rs.getDouble("value");
                    Color color = Color.fromHexCode(rs.getString("color"));

                    AccountDTO account = new AccountDTO(uuid, institution, accountType, quick,
                            homeScreen, description, value, color);
                    results.add(account);
                } while (rs.next());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return results;
        }, uuid.toString());
    }

    /**
     * Executes a query and returns a double result.
     *
     * @param query      the SQL query
     * @param uuid       the UUID parameter for the query
     * @param columnName the name of the column to retrieve the result from
     * @return the double result from the specified column
     */
    public double executeQuery(String query, UUID uuid, String columnName) {
        return executeQuery(query, rs -> {
            try {
                return rs.getDouble(columnName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, uuid.toString());
    }

    /**
     * Executes a query and returns a String result.
     *
     * @param query      the SQL query
     * @param email      the email parameter for the query
     * @param columnName the name of the column to retrieve the result from
     * @return the String result from the specified column
     */
    public String executeQuery(String query, String email, String columnName) {
        return executeQuery(query, rs -> {
            try {
                return rs.getString(columnName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }, email);
    }

    /**
     * Executes a query with the specified handler and parameters.
     *
     * @param query   the SQL query
     * @param handler the function to handle the ResultSet
     * @param params  the parameters for the query
     * @param <T>     the type of the result
     * @return the result processed by the handler
     */
    public <T> T executeQuery(String query, Function<ResultSet, T> handler, Object... params) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            int index = 1;
            for (Object param : params) {
                statement.setObject(index++, param);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) return handler.apply(resultSet);
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
