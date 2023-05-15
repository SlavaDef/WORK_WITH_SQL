package org.example;

public class DatabaseInitService {

    private static final String INIT_DB_FILE = "src/main/java/SQL/init_db.sql";

    public static void main(String[] args) {

        new Utils().readSQL(INIT_DB_FILE);

    }
}
