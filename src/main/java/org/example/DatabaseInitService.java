package org.example;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    private static final String INIT_DB_FILE = "src/main/java/SQL/init_db.sql";
    public static void main(String[] args) {

        String sql = Utils.readSQL(INIT_DB_FILE);
        try(Statement statement = Database.getInstance().getConnection().createStatement()){
            statement.executeUpdate(sql);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
