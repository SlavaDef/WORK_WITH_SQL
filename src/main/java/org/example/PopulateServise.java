package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopulateServise {

    private PreparedStatement insertIntoWorker;
    private PreparedStatement insertIntoClient;
    private PreparedStatement insertIntoProject;

    private PreparedStatement insertIntoProjectWorker;

    public PopulateServise(Database database) throws SQLException {
        Connection connection = database.getConnection();

        insertIntoWorker = connection.prepareStatement(
                "INSERT INTO worker\n" +
                        "(name,birthday,level,salary)\n" +
                        "VALUES (?,?,?,?)");
        insertIntoClient = connection.prepareStatement(
                "INSERT INTO client\n" +
                        "(name)\n" +
                        "VALUES (?)");

        insertIntoProject = connection.prepareStatement(
                "INSERT INTO project\n" +
                        "(client_id, start_date,finish_date)\n" +
                        "VALUES (?,?,?)");
        insertIntoProjectWorker = connection.prepareStatement(
                "INSERT INTO project_worker\n" +
                        "(project_id,worker_id)\n" +
                        "VALUES (?,?)");

    }

    public void insertWorkers() throws SQLException {
        String[] sql = Utils.readSQL(
                "src/main/java/SQL/populate_for_worker.sql").split(";");

        for (String temp : sql) {
            String[] colum = temp.trim().replaceAll("\'", "").split(",");

            insertIntoWorker.setString(1, colum[0]);
            insertIntoWorker.setString(2, colum[1]);
            insertIntoWorker.setString(3, colum[2]);
            insertIntoWorker.setInt(4, Integer.parseInt(colum[3]));
            insertIntoWorker.addBatch();
        }
        insertIntoWorker.executeBatch();
    }

    public void insertIntoClient() throws SQLException {
        String[] sql = Utils.readSQL(
                "src/main/java/SQL/populate_for_client.sql").split(",");
        for (String colum : sql) {
            colum.trim().replaceAll("\'", ""); // ?
            insertIntoClient.setString(1, colum);
        }
        insertIntoClient.executeUpdate();
    }

    public void insertIntoProject() throws SQLException {
        String[] sql = Utils.readSQL(
                "src/main/java/SQL/populate_for_project.sql").split(";");
        for (String temp : sql) {
            String[] colum = temp.trim().replaceAll("\'", "").split(",");

            insertIntoProject.setInt(1, Integer.parseInt(colum[0]));
            insertIntoProject.setString(2, colum[1]);
            insertIntoProject.setString(3, colum[2]);
            insertIntoProject.addBatch();
        }
        insertIntoProject.executeBatch();
    }

    public void insertIntoProjectWorker() throws SQLException {
        String[] sql = Utils.readSQL(
                "src/main/java/SQL/populate_for_project_worker.sql").split(";");
        for (String temp : sql) {
            String[] colum = temp.trim().split(",");

            insertIntoProjectWorker.setInt(1,Integer.parseInt(colum[0]));
            insertIntoProjectWorker.setInt(2,Integer.parseInt(colum[1]));
            insertIntoProjectWorker.addBatch();
        }
        insertIntoProjectWorker.executeBatch();
    }

    public static void main(String[] args) throws SQLException {

        PopulateServise populateServise = new PopulateServise(Database.getInstance());
       // populateServise.insertWorkers();
       // populateServise.insertIntoClient();
       // populateServise.insertIntoProject();
        populateServise.insertIntoProjectWorker();

    }
}
