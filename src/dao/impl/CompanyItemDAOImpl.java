package dao.impl;

import dao.CompanyItemDAO;
import db.DBConnection;
import entity.CompanyItem;
import entity.CompanyItemPK;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyItemDAOImpl implements CompanyItemDAO {
    public  List<Object> getAll(){
        ArrayList<Object> companyItems = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM companyitem");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                companyItems.add(new CompanyItem(resultSet.getString(1),
                        resultSet.getString(2)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  companyItems;



    }
    public  CompanyItem get(Object companyItemPK){
        CompanyItemPK companyItemPK1 = (CompanyItemPK) companyItemPK;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM companyitem WHERE companyId=(?) AND ItemCode=(?)");
            preparedStatement.setObject(1,companyItemPK1.getCompanyId());
            preparedStatement.setObject(1,companyItemPK1.getItemCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new CompanyItem(resultSet.getString(1),
                        resultSet.getString(2)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;

    }
    public  boolean save(Object companyItem){
        CompanyItem companyItem1 = (CompanyItem) companyItem;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO companyitem VALUES (?,?)");
            preparedStatement.setObject(1, companyItem1.getCompanyItemPK().getItemCode());
            preparedStatement.setObject(2, companyItem1.getCompanyItemPK().getCompanyId());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean delete(Object companyItemPK){
        CompanyItemPK companyItemPK1 = (CompanyItemPK) companyItemPK;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM companyitem WHERE companyId=(?) AND ItemCode=(?)");
            preparedStatement.setObject(1, companyItemPK1.getItemCode());
            preparedStatement.setObject(2, companyItemPK1.getCompanyId());
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean update(Object companyItem){
        return false;

    }
}
