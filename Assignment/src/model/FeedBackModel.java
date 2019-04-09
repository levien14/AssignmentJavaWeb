package model;

import entity.Feedback;
import entity.User;

import java.sql.*;

public class FeedBackModel {
    static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/assignment?user=root&&password=");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Lưu feedback người gửi lên
    public boolean insert(Feedback feedback){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into feedback (email,description) values (?,?)" );

            preparedStatement.setString(1,feedback.getEmail());
            preparedStatement.setString(2,feedback.getDescription());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // đọc những feedback đã được duyệt
    public Feedback getAllActive(){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from feedback where status = 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String email = resultSet.getString(2);
                String des = resultSet.getString(3);
                String status = resultSet.getString(4);
                Feedback feedback = new Feedback(email,des);
                return feedback;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
