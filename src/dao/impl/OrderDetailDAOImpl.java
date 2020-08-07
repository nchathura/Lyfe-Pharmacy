package dao.impl;

import db.DBConnection;
import entity.OrderDetail;
import entity.OrderDetailPK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl {
    public  List<OrderDetail> getAllOrderDetails(){
        ArrayList<OrderDetail> ordersDetails = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                ordersDetails.add(new OrderDetail(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getBigDecimal(3),
                        resultSet.getBigDecimal(4)

                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  ordersDetails;


    }
    public  OrderDetail getOrderDetail(OrderDetailPK orderDetailPK){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orderdetail WHERE orderId=(?) AND itemCode=(?)");
            preparedStatement.setObject(1,orderDetailPK.getOrderId());
            preparedStatement.setObject(2,orderDetailPK.getItemCode());

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new OrderDetail(resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getBigDecimal(3),
                                resultSet.getBigDecimal(4)

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;

    }
    public  boolean saveOrderDetail(OrderDetail orderDetail){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orderdetail VALUES (?,?,?,?)");
            preparedStatement.setObject(1, orderDetail.getOrderDetailPK().getOrderId());
            preparedStatement.setObject(2, orderDetail.getOrderDetailPK().getItemCode());
            preparedStatement.setObject(3,orderDetail.getQty());
            preparedStatement.setObject(4,orderDetail.getUnitPrice());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean deleteOrderDetail(OrderDetailPK orderDetailPK){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orderdetail WHERE orderId=(?) AND itemCode=(?)");
            preparedStatement.setObject(1, orderDetailPK.getOrderId());
            preparedStatement.setObject(1, orderDetailPK.getItemCode());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }
    public  boolean updateOrderDetail(OrderDetail orderDetail){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE orderdetail SET qty=(?),unitPrice=(?) WHERE orderId=(?) AND itemCode=(?)");
            preparedStatement.setObject(1, orderDetail.getQty());
            preparedStatement.setObject(2, orderDetail.getUnitPrice());
            preparedStatement.setObject(3, orderDetail.getOrderDetailPK().getOrderId());
            preparedStatement.setObject(3, orderDetail.getOrderDetailPK().getItemCode());


            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }


    }


