package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static final String INIT_DB_FILE = "src/main/java/SQL/init_db.sql";
    public static void main(String[] args)  {



        Database database = Database.getInstance();
      //  Connection con = Database.getInstance().getConnection();
        String sql = null;
        try {
            sql = Files.readString(Path.of(INIT_DB_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        database.executeUpdate(sql);

    }
}