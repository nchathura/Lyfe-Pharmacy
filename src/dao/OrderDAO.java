package dao;

import db.DBConnection;
import entity.Employee;
import entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public static List<Order> getAllOrders(){
        ArrayList<Order> orders = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order`");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                orders.add(new Order(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)

                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  orders;

    }
    public static Order getOrder(String orderId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `order` WHERE orderId=(?)");
            preparedStatement.setObject(1,orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Order(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3)

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;

    }
    public static boolean saveOrder(Order order){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?)");
            preparedStatement.setObject(1, order.getOrderId());
            preparedStatement.setObject(2, order.getEmpId());
            preparedStatement.setObject(3, order.getOrderDate());



            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
    public static boolean deleteOrder(String orderId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `order` WHERE orderId=(?)");
            preparedStatement.setObject(1, orderId);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public static boolean updateOrder(Order order){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `order` SET empId=(?),orderDate=(?) WHERE orderId=(?)");
            preparedStatement.setObject(1, order.getEmpId());
            preparedStatement.setObject(2, order.getOrderDate());
            preparedStatement.setObject(3, order.getOrderId());


            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
}
