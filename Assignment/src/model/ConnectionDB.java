package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
    static Connection connection;
    public void initDB(String qrSQL) throws SQLException{
        if (connection == null || connection.isClosed()){
            connection = DriverManager.getConnection("jdbc:mysql://localhost/assignment?user=root&&password=");
            PreparedStatement preparedStatement = connection.prepareStatement(qrSQL);
        }
    }
}
