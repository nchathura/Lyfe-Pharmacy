package dao;

import db.DBConnection;
import util.*;

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

    public static boolean saveCompany(CompanyTM companyTM,List<ItemTM> itemsOfTheCompany){
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO company VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, companyTM.getCompanyId());
            preparedStatement.setObject(2, companyTM.getCompanyName());
            preparedStatement.setObject(3, companyTM.getEntryDate());
            preparedStatement.setObject(6, companyTM.getCompanyPhoneNo());
            preparedStatement.setObject(4, companyTM.getCompanyEmail());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows==0){
                connection.rollback();
                return  false;
            }
            for (ItemTM item:itemsOfTheCompany) {
                preparedStatement = connection.prepareStatement("INSERT INTO companyitem VALUES (?,?)");
                preparedStatement.setObject(1,item.getItemCode());
                preparedStatement.setObject(2,companyTM.getCompanyId());
                affectedRows =  preparedStatement.executeUpdate();
               if(affectedRows == 0){
                   connection.rollback();
                   return false;

               }

            }
            connection.commit();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
        finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


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

    //===================================================================================================================================

    public static boolean placeOrder(Order order,List<OrderDetail> orderDetailList){
        Connection connection = DBConnection.getInstance().getConnection();

      try {
          connection.setAutoCommit(false);
          PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `order` VALUES (?,?,?)");
          preparedStatement.setObject(1, order.getOrderId());
          preparedStatement.setObject(2, order.getEmpId());
          preparedStatement.setObject(3, order.getOrderDate());
          int affectedRows = preparedStatement.executeUpdate();
          if(affectedRows==0){
              connection.rollback();
              return false;
          }

          for (OrderDetail orderDetail:orderDetailList) {
              preparedStatement = connection.prepareStatement("INSERT  INTO orderdetail VALUES (?,?,?,?)");
              preparedStatement.setObject(1, orderDetail.getOrderId());
              preparedStatement.setObject(2, orderDetail.getItemCode());
              preparedStatement.setObject(3, orderDetail.getQty());
              preparedStatement.setObject(4, orderDetail.getUnitPrice());
              affectedRows = preparedStatement.executeUpdate();
              if (affectedRows == 0) {
                  connection.rollback();
                  return false;
              }


              preparedStatement = connection.prepareStatement("UPDATE lyfepharmacy.item SET lyfepharmacy.item.qtyOnHand = lyfepharmacy.item.qtyOnHand-(?) WHERE lyfepharmacy.item.itemCode=(?)");
              preparedStatement.setObject(1, orderDetail.getQty());
              preparedStatement.setObject(2,orderDetail.getItemCode());
              preparedStatement.executeUpdate();
              if(affectedRows == 0){
                  connection.rollback();
                  return  false;
              }

          }
          connection.commit();
          return true;



      } catch (SQLException e) {
          e.printStackTrace();
          try {
              connection.rollback();
          } catch (SQLException ex) {
              ex.printStackTrace();
          }

          return  false;
      }
      finally {
          try {
              connection.setAutoCommit(true);
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }



    }



        //=========================================================================================================================

    public static List<ItemTM> getAllItems(){
        ArrayList<ItemTM> items = new ArrayList<>();
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                items.add(new ItemTM(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getDate(6).toLocalDate(),
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
    public static ItemTM getItem(String itemCode) {
        try {

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *  FROM lyfepharmacy.item WHERE itemCode=(?)");
            preparedStatement.setObject(1, itemCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new ItemTM(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getDate(6).toLocalDate(),
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

    public static boolean saveItem(ItemTM itemTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO lyfepharmacy.item VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setObject(1,itemTM.getItemCode());
            preparedStatement.setObject(2,itemTM.getDescription());
            preparedStatement.setObject(3,itemTM.getCategory());
            preparedStatement.setObject(4,itemTM.getManufacturer());
            preparedStatement.setObject(5,itemTM.getProductionDate());
            preparedStatement.setObject(6,itemTM.getExpiryDate());
            preparedStatement.setObject(7,itemTM.getBuyingPrice());
            preparedStatement.setObject(8,itemTM.getSellingPrice());
            preparedStatement.setObject(9,itemTM.getMinimumStockLevel());
            preparedStatement.setObject(9,itemTM.getQtyOnHand());
            preparedStatement.setObject(9,itemTM.getUnitPrice());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean deleteItem(String itemCode){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM lyfepharmacy.item WHERE lyfepharmacy.item.itemCode=(?)");
            preparedStatement.setObject(1, itemCode);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }
    public static boolean updateItem(ItemTM itemTM){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET description=(?),category=(?),manufacturer=(?),productionDate=(?),expiryDate=(?),buyingPrice=(?),sellingPrice=(?),minimumStockLevel=(?),qtyOnHand=(?),unitPrice=(?) WHERE itemCode=(?)");
            preparedStatement.setObject(11,itemTM.getItemCode());
            preparedStatement.setObject(1,itemTM.getDescription());
            preparedStatement.setObject(2,itemTM.getCategory());
            preparedStatement.setObject(3,itemTM.getManufacturer());
            preparedStatement.setObject(4,itemTM.getProductionDate());
            preparedStatement.setObject(5,itemTM.getExpiryDate());
            preparedStatement.setObject(6,itemTM.getBuyingPrice());
            preparedStatement.setObject(7,itemTM.getSellingPrice());
            preparedStatement.setObject(8,itemTM.getMinimumStockLevel());
            preparedStatement.setObject(9,itemTM.getQtyOnHand());
            preparedStatement.setObject(10,itemTM.getUnitPrice());

            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    //===================================================================================================================================







}
