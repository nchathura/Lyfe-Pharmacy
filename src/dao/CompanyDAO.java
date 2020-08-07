package dao;

import db.DBConnection;
import entity.Agent;
import entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    public  List<Company> getAllCompanies(){
        ArrayList<Company> companies = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                companies.add(new Company(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  companies;

    }
    public  Company getCompany(String companyId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1,companyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Company(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;

    }
    public  boolean saveCompany(Company company){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO company VALUES (?,?,?,?,?)");
            preparedStatement.setObject(1, company.getCompanyId());
            preparedStatement.setObject(2, company.getCompanyName());
            preparedStatement.setObject(3, company.getEntryDate());
            preparedStatement.setObject(4, company.getCompanyPhoneNo());
            preparedStatement.setObject(5, company.getCompanyEmail());

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }
    public  boolean deleteCompany(String companyId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1, companyId);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean updateCompany(Company company){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE company SET companyName=(?),entryDate=(?),companyPhoneNo=(?),companyEmail=(?) WHERE companyId=(?)");

            preparedStatement.setObject(1, company.getCompanyName());
            preparedStatement.setObject(2, company.getEntryDate());
            preparedStatement.setObject(3, company.getCompanyPhoneNo());
            preparedStatement.setObject(4, company.getCompanyEmail());
            preparedStatement.setObject(5, company.getCompanyId());
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }

    public  String getLastCompanyId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company ORDER BY companyId DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "C001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }
}
