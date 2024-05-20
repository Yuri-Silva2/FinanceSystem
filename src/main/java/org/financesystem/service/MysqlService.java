package org.financesystem.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Service class for managing MySQL database connections using HikariCP.
 */
public class MysqlService {

    private static final HikariConfig hikariConfig = new HikariConfig();
    private static HikariDataSource dataSource;

    /**
     * Constructs a MysqlService and configures the HikariCP data source.
     */
    public MysqlService() {
        configureDataSource();
    }

    /**
     * Configures the HikariCP data source with connection properties.
     */
    private void configureDataSource() {
        String connectionUrl = "jdbc:mysql://localhost:3306/financesystem?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "12345";

        hikariConfig.setJdbcUrl(connectionUrl);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource();
    }

    /**
     * Returns the configured HikariCP data source.
     *
     * @return HikariDataSource the configured data source.
     */
    public HikariDataSource getDataSource() {
        return dataSource;
    }
}
