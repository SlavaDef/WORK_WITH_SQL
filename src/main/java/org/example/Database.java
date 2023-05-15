package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    private static final String url = "jdbc:h2:./test";

    private Connection connection;

    private static final Database INSTANCE = new Database();

   private Database() {

       try{
           connection = DriverManager.getConnection(url);
       }catch (Exception e){
           e.printStackTrace();
       }

    }
    public static Database getInstance(){
        return INSTANCE;
    }

    public Connection getConnection(){
        return connection;
    }

    public int executeUpdate(String sql) { // метод для виконання запиту
        try (Statement st = connection.createStatement() ){
            return st.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();

            return -1;
        }
    }
}
