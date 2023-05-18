package org.example;

import SqlRequests.LongestProject;
import SqlRequests.MaxProjectCountClient;
import SqlRequests.MaxSalaryWorker;
import SqlRequests.YoungestEldestWorkers;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String FIND_MAX_SALARY_WORKER = "src/main/java/SQL/find_max_salary_worker.sql";
   private static final String FIND_LONGEST_PROJECT = "src/main/java/SQL/find_longest_project.sql";
    private static final String FIND_MAX_PROJECTS_CLIENT = "src/main/java/SQL/find_max_projects_client.sql";
    private static final String FIND_YOUNGEST_ELDEST_WORKERS = "src/main/java/SQL/find_youngest_eldest_workers.sql";
    public DatabaseQueryService(Database database){ // конструктор приймає Storage як аргумент
        this.database = database;
    }

    private Database database;

    public List<LongestProject> findLongestProject(){
        List<LongestProject> list = new ArrayList<>();
        try(Statement st = database.getConnection().createStatement()){
            String sql = Utils.readSQL(FIND_LONGEST_PROJECT);
            try(ResultSet rs = st.executeQuery(sql)){
                while (rs.next()){
                    LongestProject project = new LongestProject();
                    project.setName(rs.getString("name"));
                    project.setMonthCount(rs.getInt("month_count"));
                    list.add(project);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> list = new ArrayList<>();
        try(Statement st = database.getConnection().createStatement()){
            String sql = Utils.readSQL(FIND_MAX_PROJECTS_CLIENT);
            try(ResultSet rs = st.executeQuery(sql)){
                while (rs.next()){
                    MaxProjectCountClient client = new MaxProjectCountClient();
                    client.setName(rs.getString("name"));
                    client.setProjectCount(rs.getInt("project_count"));
                    list.add(client);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public List<MaxSalaryWorker> maxSalaryWorker()  {
        List<MaxSalaryWorker> list = new ArrayList<>();
        try(Statement st = database.getConnection().createStatement()){
            String sql = Utils.readSQL(FIND_MAX_SALARY_WORKER);
            try(ResultSet rs = st.executeQuery(sql)){
                while (rs.next()){
                    MaxSalaryWorker worker = new MaxSalaryWorker();
                    worker.setName(rs.getString("name"));
                    worker.setSalary(rs.getInt("salary"));
                    list.add(worker);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers()  {
        List<YoungestEldestWorkers> list = new ArrayList<>();
        try(Statement st = database.getConnection().createStatement()){
            String sql = Utils.readSQL(FIND_YOUNGEST_ELDEST_WORKERS);
            try(ResultSet rs = st.executeQuery(sql)){
                while (rs.next()){
                    YoungestEldestWorkers worker = new YoungestEldestWorkers();
                    worker.setType(rs.getString("type"));
                    worker.setName(rs.getString("name"));
                    worker.setBirthday(rs.getString("birthday"));
                    list.add(worker);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public void printResalt(){
        DatabaseQueryService databaseQueryService = new DatabaseQueryService(database);
        List<Object> list = new ArrayList<>();
        list.add(databaseQueryService.findLongestProject());
        list.add(databaseQueryService.findMaxProjectsClient());
        list.add(databaseQueryService.maxSalaryWorker());
        list.add(databaseQueryService.findYoungestEldestWorkers());
        list.forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        Database database1 = Database.getInstance();
        DatabaseQueryService databaseQueryService = new DatabaseQueryService(database1);
        databaseQueryService.printResalt();
    }


}
