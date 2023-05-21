package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                        "VALUES(?,?,?,?");
        insertIntoClient = connection.prepareStatement(
                "INSERT INTO client\n" +
                        "(name)\n" +
                        "VALUES (?)");

        insertIntoProject = connection.prepareStatement(
                "INSERT INTO project\n" +
                        "(client_id, start_date,finish_date)\n" +
                        "VALUES (?,?,?");
        insertIntoProjectWorker = connection.prepareStatement(
                "INSERT INTO project_worker\n" +
                        "(project_id,worker_id)\n" +
                        "VALUES (?,?");

    }

    public  void   insertWorkers() throws SQLException {
        String[] sql =  Utils.readSQL("src/main/java/SQL/populate_for_worker.sql").split(";");

        for(String temp : sql) {
            String[] colum = temp.trim().replaceAll("\'", "").split(",");

            insertIntoWorker.setString(1, colum[1]);
            insertIntoWorker.setString(2, colum[2]);
            insertIntoWorker.setString(3, colum[3]);
            insertIntoWorker.setInt(4, Integer.parseInt(colum[4]));
            insertIntoWorker.addBatch();
        }
            insertIntoWorker.executeBatch();

      //  return false;
    }

    public static void main(String[] args) throws SQLException {
      /*  String[] sql =  Utils.readSQL("src/main/java/SQL/populate_for_worker.sql").trim().split(";");
        for(String b : sql){
            String[]colum = b.trim().replaceAll("\'", "").split(",");
            for(String a : colum){
                System.out.println(colum[0] + " "+ colum[1] + " " + colum[2] + " "+ colum[3]);
            }
           // System.out.println(b);


        } */
        Connection connection;
        PopulateServise populateServise = new PopulateServise(Database.getInstance());
        populateServise.insertWorkers();






    }


}
