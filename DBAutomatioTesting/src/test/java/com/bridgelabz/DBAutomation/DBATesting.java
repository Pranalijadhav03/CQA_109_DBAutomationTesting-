package com.bridgelabz.DBAutomation;
import org.testng.annotations.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import static com.bridgelabz.DBAutomation.BaseClass.setUp;

public class DBATesting {
    private Connection connection;

    @Test
    public void dbTest_ExecuteSelectData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        System.out.println("Connection established");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from upload");

        while (resultset.next()) {
            int userID = resultset.getInt(1);
            String userName = resultset.getString(2);
            String userType = resultset.getString(3);
            System.out.println(userID + " " + userName + " " + userType);
        }
        System.out.println("Getting all upload data table");
    }
    @Test
    public void dbTest_InsertData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into upload values(?,?,?)");
        preparedStatement.setInt(1, 11143);
        preparedStatement.setString(2, "Rajesh");
        preparedStatement.setString(3, "admin");
        System.out.println("Successfully inserted");
    }
    @Test
    public void dbTest_UpdateData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        PreparedStatement preparedStatement = connection.prepareStatement("update upload set userName=(?) where userType=(?)");
        preparedStatement.setString(2, "dipti");
        preparedStatement.setString(1, "client");
        preparedStatement.executeUpdate();
        System.out.println("Updated successfully !!");
    }
    @Test
    public void dbTest_DeleteData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        System.out.println("Connection established");
        PreparedStatement preparedStatement = connection.prepareStatement("delete from upload where userName=(?)");
        preparedStatement.setString(1, "rachit");
        System.out.println("Getting all deleted data successfully");
    }
}
