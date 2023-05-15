package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    public void readSQL(String sql){

        Database database = Database.getInstance();

        try {
            sql = Files.readString(Path.of(sql));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        database.executeUpdate(sql);
    }
}
