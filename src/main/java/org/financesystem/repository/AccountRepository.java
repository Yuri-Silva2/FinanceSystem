package org.financesystem.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.financesystem.model.Color;
import org.financesystem.model.Institution;
import org.financesystem.model.account.AccountDTO;
import org.financesystem.model.account.AccountType;

import java.util.List;
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
     * Creates a new record in the 'accounts' table.
     *
     * @param uuid          the uuid of the account.
     * @param institution   the institution of the account.
     * @param accountType   the type of the account
     * @param quick         the condition of the account.
     * @param home_screen   the condition of the account.
     * @param description   the description of the account.
     * @param color         the color of the account.
     */
    public void createAccount(UUID uuid, Institution institution, AccountType accountType, boolean quick, boolean home_screen, String description, Color color) {
        String query = "insert into accounts (id_bin, institution, type, quick, home_screen, description, color) values (?, ?, ?, ?, ?, ?, ?)";
        executeUpdate(query, uuid, institution, accountType, quick, home_screen, description, color.getHexCode());
    }

    /**
     * Get wallet balance.
     *
     * @param uuid the uuid to check.
     * @return the value found of this account.
     */
    public double getWalletBalanceByUUID(UUID uuid) {
        String query = "select value from accounts WHERE id_text = ? and type = ?";
        return executeQuery(query, uuid, AccountType.WALLET, "value");
    }

    public List<AccountDTO> getAllAccounts(UUID uuid) {
        String query = "select * from accounts WHERE id_text = ?";
        return executeQuery(query, uuid);
    }
}
