package org.example;

public class DatabasePopulateService {

    private static final String POPULATE_DB_FILE = "src/main/java/SQL/populate_db.sql";

    public static void main(String[] args) {

        new Utils().readSQL(POPULATE_DB_FILE);
    }
}
