package org.financesystem.repository;

import com.zaxxer.hikari.HikariDataSource;

import java.util.UUID;

/**
 * Repository class for accessing 'People' data from the database.
 */
public class PeopleRepository extends Repository {

    /**
     * Constructs a PeopleRepository with the specified data source.
     *
     * @param dataSource The data source to be used for database connections.
     */
    public PeopleRepository(HikariDataSource dataSource) {
        super(dataSource);
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
}
