package org.example;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueryService {

    /*private String getRequest(String j){
        return new Utils().readSQL(j);
    } */


    private static final String FIND_LONGEST_PROJECT = "src/main/java/SQL/find_longest_project.sql";

    public DatabaseQueryService(Database database){ // конструктор приймає Storage як аргумент
        this.database = database;
    }

    private Database database;

  /*  public void printWorkerId() { // метод виводе всі id FROM worker

        try(Statement st = database.getConnection().createStatement()){
            try(ResultSet res = st.executeQuery("SELECT id FROM worker")) {
                while (res.next()){
                    long id = res.getLong("id");
                    System.out.println("ID = " + id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } */

    public String maxSalaryWorker() throws IOException {

        try(Statement st = database.getConnection().createStatement()){

               /* String sql = Files.readString(Path.of("src/main/java/SQL/find_max_salary.sql"));
              String sql2 = new Utils().readSQL(FIND_LONGEST_PROJECT); */ // ????????
            String sql = "SELECT name,salary\n" +
                    "from worker\n" +
                    "GROUP BY name\n" +
                    "HAVING salary = (\n" +
                    "select MAX(salary)\n" +
                    "FROM worker\n" +
                    "); ";
              //database.executeUpdate(sql);
            try(ResultSet rs = st.executeQuery(sql)){
                if(rs.next()){
                    String name = rs.getString("name");
                    long salary = rs.getLong("salary");
                    return name+" "+ salary;
                }else {
                    System.out.println("something wrong");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return " ";
    }

    public static void main(String[] args) throws IOException {

        Database database1 = Database.getInstance();


 DatabaseQueryService databaseQueryService = new DatabaseQueryService(database1);
 //databaseQueryService.printWorkerId();
        System.out.println(databaseQueryService.maxSalaryWorker());
    }


}
