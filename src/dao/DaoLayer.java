package dao;

import db.DBConnection;
import util.AgentTM;
import util.CompanyTM;
import util.EmployeeTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoLayer {
    public static List<EmployeeTM> getAllEmployees(){
        ArrayList<EmployeeTM> employees = new ArrayList<>();
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(new EmployeeTM(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6).toLocalDate(),
                        resultSet.getDate(7).toLocalDate(),
                        resultSet.getBigDecimal(8),
                        resultSet.getString(9)

                ));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;

    }
    public static EmployeeTM getEmployee(String employeeId) {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new EmployeeTM(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getDate(6).toLocalDate(),
                        resultSet.getDate(7).toLocalDate(),
                        resultSet.getBigDecimal(8),
                        resultSet.getString(9)
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean saveEmployee(EmployeeTM employeeTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1, employeeTM.getEmpId());
            preparedStatement.setObject(2, employeeTM.getEmpName());
            preparedStatement.setObject(3, employeeTM.getEmpAddress());
            preparedStatement.setObject(4, employeeTM.getEmail());
            preparedStatement.setObject(5, employeeTM.getContactNo());
            preparedStatement.setObject(6, employeeTM.getDateOfBirth());
            preparedStatement.setObject(7, employeeTM.getJoinedDate());
            preparedStatement.setObject(8, employeeTM.getSalary());
            preparedStatement.setObject(9, employeeTM.getGender());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean deleteEmployee(String employeeId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE empId=(?)");
            preparedStatement.setObject(1, employeeId);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean updateEmployee(EmployeeTM employeeTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET empName=(?),empAddress=(?),email=(?),contactNo=(?),dateOfBirth=(?),joinedDate=(?),salary=(?),gender=(?) WHERE empId=(?)");
            preparedStatement.setObject(9, employeeTM.getEmpId());
            preparedStatement.setObject(1, employeeTM.getEmpName());
            preparedStatement.setObject(2, employeeTM.getEmpAddress());
            preparedStatement.setObject(3, employeeTM.getEmail());
            preparedStatement.setObject(4, employeeTM.getContactNo());
            preparedStatement.setObject(5, employeeTM.getDateOfBirth());
            preparedStatement.setObject(6, employeeTM.getJoinedDate());
            preparedStatement.setObject(7, employeeTM.getSalary());
            preparedStatement.setObject(8, employeeTM.getGender());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    //===================================================================================================================================

    public static List<AgentTM> getAllAgents(){
        ArrayList<AgentTM> agents = new ArrayList<>();
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM agent");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                agents.add(new AgentTM(resultSet.getString(1),
                        resultSet.getString(6),
                        resultSet.getString(4),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(5),
                        resultSet.getString(2)

                ));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agents;

    }
    public static AgentTM getEAgent(String agentId) {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM agent WHERE agentId=(?)");
            preparedStatement.setObject(1, agentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AgentTM(resultSet.getString(1),
                        resultSet.getString(6),
                        resultSet.getString(4),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(5),
                        resultSet.getString(2)
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean saveAgent(AgentTM agentTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO agent VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, agentTM.getAgentId());
            preparedStatement.setObject(2, agentTM.getCompanyId());
            preparedStatement.setObject(3, agentTM.getEntryDate());
            preparedStatement.setObject(6, agentTM.getPhoneNo());
            preparedStatement.setObject(4, agentTM.getEmail());
            preparedStatement.setObject(5, agentTM.getName());



            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean deleteAgent(String agentId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM agent WHERE agentId=(?)");
            preparedStatement.setObject(1, agentId);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean updateAgent(AgentTM agentTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE agent SET companyId=(?),entryDate=(?),agentPhoneNo=(?),agentEmail=(?),agentName=(?) WHERE agentId=(?)");

            preparedStatement.setObject(1, agentTM.getCompanyId());
            preparedStatement.setObject(2, agentTM.getEntryDate());
            preparedStatement.setObject(3, agentTM.getPhoneNo());
            preparedStatement.setObject(4, agentTM.getEmail());
            preparedStatement.setObject(5, agentTM.getName());
            preparedStatement.setObject(6, agentTM.getAgentId());


            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    //===================================================================================================================================

    public static List<CompanyTM> getAllCompanies(){
        ArrayList<CompanyTM> companies = new ArrayList<>();
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                companies.add(new CompanyTM(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getString(5)

                ));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companies;

    }
    public static CompanyTM getCompany(String companyId) {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1, companyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new CompanyTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getString(5)

                );


            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean saveCompany(CompanyTM companyTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO agent VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, companyTM.getCompanyId());
            preparedStatement.setObject(2, companyTM.getCompanyName());
            preparedStatement.setObject(3, companyTM.getEntryDate());
            preparedStatement.setObject(6, companyTM.getCompanyPhoneNo());
            preparedStatement.setObject(4, companyTM.getCompanyEmail());




            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean deleteCompany(String companyId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM company WHERE companyId=(?)");
            preparedStatement.setObject(1, companyId);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean updateCompany(CompanyTM companyTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE company SET companyName=(?),entryDate=(?),companyPhoneNo=(?),companyEmail=(?) WHERE companyId=(?)");

            preparedStatement.setObject(1, companyTM.getCompanyName());
            preparedStatement.setObject(2, companyTM.getEntryDate());
            preparedStatement.setObject(3, companyTM.getCompanyPhoneNo());
            preparedStatement.setObject(4, companyTM.getCompanyEmail());
            preparedStatement.setObject(5, companyTM.getCompanyId());



            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }



}
