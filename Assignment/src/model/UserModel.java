package model;

import entity.User;

import java.sql.*;

public class UserModel {
    static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/assignment?user=root&&password=");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean insert(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into account(username,email,password) values (?,?,?)" );

            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public User getByEmailAndPassword(String email, String password){
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from account where email = ? and password = ?;");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String username = rs.getString(2);
                String useremail = rs.getString(3);
                String userpas  =rs.getString(4);
                String userRole = rs.getString(5);

                System.out.println("username : " + username);
                System.out.println("useremai : " + useremail);
                System.out.println("pass : " + userpas);
                System.out.println("role : " + userRole);
                User user = new User(username,useremail,userpas,userRole);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}