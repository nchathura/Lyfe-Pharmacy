package dao;

import db.DBConnection;
import entity.Item;
import util.ItemTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public  List<Item> getAllItems(){
        ArrayList<Item> items = new ArrayList<>();
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                items.add(new Item(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getBigDecimal(8),
                        resultSet.getBigDecimal(9),
                        resultSet.getBigDecimal(10),
                        resultSet.getBigDecimal(11)


                ));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;


    }
    public  Item getItem(String itemCode){
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM lyfepharmacy.item WHERE itemCode=(?)");
            preparedStatement.setObject(1, itemCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Item(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getBigDecimal(8),
                        resultSet.getBigDecimal(9),
                        resultSet.getBigDecimal(10),
                        resultSet.getBigDecimal(11)
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public  boolean saveItem(Item item){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO lyfepharmacy.item VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1,item.getItemCode());
            preparedStatement.setObject(2,item.getDescription());
            preparedStatement.setObject(3,item.getCategory());
            preparedStatement.setObject(4,item.getManufacturer());
            preparedStatement.setObject(5,item.getProductionDate());
            preparedStatement.setObject(6,item.getExpiryDate());
            preparedStatement.setObject(7,item.getBuyingPrice());
            preparedStatement.setObject(8,item.getSellingPrice());
            preparedStatement.setObject(9,item.getMinimumStockLevel());
            preparedStatement.setObject(9,item.getQtyOnHand());
            preparedStatement.setObject(9,item.getUnitPrice());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public  boolean deleteItem(String itemId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lyfepharmacy.item WHERE lyfepharmacy.item.itemCode=(?)");
            preparedStatement.setObject(1, itemId);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public  boolean updateItem(Item item){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET description=(?),category=(?),manufacturer=(?),productionDate=(?),expiryDate=(?),buyingPrice=(?),sellingPrice=(?),minimumStockLevel=(?),qtyOnHand=(?),unitPrice=(?) WHERE itemCode=(?)");
            preparedStatement.setObject(11,item.getItemCode());
            preparedStatement.setObject(1,item.getDescription());
            preparedStatement.setObject(2,item.getCategory());
            preparedStatement.setObject(3,item.getManufacturer());
            preparedStatement.setObject(4,item.getProductionDate());
            preparedStatement.setObject(5,item.getExpiryDate());
            preparedStatement.setObject(6,item.getBuyingPrice());
            preparedStatement.setObject(7,item.getSellingPrice());
            preparedStatement.setObject(8,item.getMinimumStockLevel());
            preparedStatement.setObject(9,item.getQtyOnHand());
            preparedStatement.setObject(10,item.getUnitPrice());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    public  String getLastItemCode(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM lyfepharmacy.item ORDER BY itemCode DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "I001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }
}
