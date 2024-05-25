package org.financesystem.repository;

import com.zaxxer.hikari.HikariDataSource;

import java.util.UUID;

/**
 * Repository class for accessing 'Account' data from the database.
 */
public class AccountRepository extends Repository {

    /**
     * Constructs a AccountRepository with the specified data source.
     *
     * @param dataSource The data source to be used for database connections.
     */
    public AccountRepository(HikariDataSource dataSource) {
        super(dataSource);
    }

    /**
     * Gets the bill amount by uuid.
     *
     * @param uuid the uuid to check.
     * @return the value found of this account.
     */
    public double getCurrentBalanceByUUID(UUID uuid) {
        String query = "SELECT value FROM accounts WHERE id_text = ?";
        return executeQuery(query, uuid, "value");
    }
}
