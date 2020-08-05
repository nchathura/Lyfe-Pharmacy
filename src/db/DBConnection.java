package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private  static Connection connection;
    private DBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lyfepharmacy", "root", "ijse");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static DBConnection getInstance(){
        return (dbConnection==null)?(dbConnection=new DBConnection()):dbConnection;
    }
    public static  Connection getConnection(){
        return  connection;
    }


}
