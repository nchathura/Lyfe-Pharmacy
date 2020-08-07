package dao.impl;

import dao.EmployeeDAO;
import db.DBConnection;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    public  List<Employee> getAllEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employees.add(new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getString(8)
                ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  employees;


    }
    public  Employee getEmployee(String empId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1,empId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Employee(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6),
                        resultSet.getDate(6),
                        resultSet.getBigDecimal(7),
                        resultSet.getString(8)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;


    }
    public  boolean saveEmployee(Employee employee){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1, employee.getEmpId());
            preparedStatement.setObject(2, employee.getEmpName());
            preparedStatement.setObject(3, employee.getEmpAddress());
            preparedStatement.setObject(4, employee.getEmail());
            preparedStatement.setObject(5, employee.getContactNo());
            preparedStatement.setObject(4, employee.getDateOfBirth());
            preparedStatement.setObject(4, employee.getJoinedDate());
            preparedStatement.setObject(4, employee.getSalary());
            preparedStatement.setObject(4, employee.getGender());


            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean deleteEmployee(String employeeId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1, employeeId);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean updateEmployee(Employee employee){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET empName=(?),empAddress=(?),email=(?),contactNo=(?),dateOfBirth=(?),joinedDate=(?),salary=(?),gender=(?) WHERE empId=(?)");
            preparedStatement.setObject(9, employee.getEmpId());
            preparedStatement.setObject(1, employee.getEmpName());
            preparedStatement.setObject(2, employee.getEmpAddress());
            preparedStatement.setObject(3, employee.getEmail());
            preparedStatement.setObject(4, employee.getContactNo());
            preparedStatement.setObject(5, employee.getDateOfBirth());
            preparedStatement.setObject(6, employee.getJoinedDate());
            preparedStatement.setObject(7, employee.getSalary());
            preparedStatement.setObject(8, employee.getGender());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    public  String getLastEmployeeId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee ORDER BY empId DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);

            }

            return "E001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }
}
