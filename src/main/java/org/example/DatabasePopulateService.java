package org.example;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    private static final String POPULATE_DB_FILE = "src/main/java/SQL/populate_db.sql";

    public static void main(String[] args) {

        String sql = Utils.readSQL(POPULATE_DB_FILE);
        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
