package org.example;

import SqlRequests.MaxSalaryWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    /*private String getRequest(String j){
        return new Utils().readSQL(j);
    } */


    private static final String FIND_LONGEST_PROJECT = "src/main/java/SQL/find_longest_project.sql";

    public DatabaseQueryService(Database database){ // конструктор приймає Storage як аргумент
        this.database = database;
    }

    private Database database;

    public List<MaxSalaryWorker> maxSalaryWorker() throws IOException {
        List<MaxSalaryWorker> list = new ArrayList<>();
        try(Statement st = database.getConnection().createStatement()){

                String sql3 = Files.readString(Path.of(FIND_LONGEST_PROJECT)); //// ?????
             // String sql2 = new Utils().readSQL(FIND_LONGEST_PROJECT);  // ????????
            String sql = "SELECT name,salary\n" +
                    "from worker\n" +
                    "GROUP BY name\n" +
                    "HAVING salary = (\n" +
                    "select MAX(salary)\n" +
                    "FROM worker\n" +
                    "); ";
              //database.executeUpdate(sql);
            try(ResultSet rs = st.executeQuery(sql3)){
                while (rs.next()){
                    MaxSalaryWorker worker = new MaxSalaryWorker();
                    worker.setName(rs.getString("name"));
                    worker.setSalary(rs.getLong("salary"));
                    list.add(worker);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws IOException {

        Database database1 = Database.getInstance();


 DatabaseQueryService databaseQueryService = new DatabaseQueryService(database1);
 //databaseQueryService.printWorkerId();
        System.out.println(databaseQueryService.maxSalaryWorker());
    }


}
