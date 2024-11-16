package ua.edu.ucu.decorator;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    @SneakyThrows
    private DBConnection(){
        connection = DriverManager.getConnection("jdbc:sqlite:/Users/mariaonyshchuk/Documents/Prog/J/Lab10");
    }

    @SneakyThrows
    public String getDocument(String gcsPath){
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM document WHERE path=?");
        preparedStatement.setString(1, gcsPath);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getString("parsed");
    }
    public static DBConnection getInstance(){
        if (dbConnection==null){
            DBConnection dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    @SneakyThrows
    public void createDocument(String gcsPath, String parse){
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INFO document(path, parsed) VALUES(?, ?)");
        preparedStatement.setString(1, gcsPath);
        preparedStatement.setString(2, gcsPath);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


}
