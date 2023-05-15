package org.example;

import java.sql.Connection;

public class DatabaseInitService {

    public static void main(String[] args) {

        Database db = Database.getInstance();
        db.executeUpdate("SQL/init_db.sql");

    }
}
