package business;

import dao.*;
import db.DBConnection;
import entity.*;
import entity.CompanyItem;
import util.*;
import util.Order;
import util.OrderDetail;

import java.sql.Connection;



import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessLogic {

    public static List<EmployeeTM> getAllEmployees() {
        ArrayList<EmployeeTM> employees = new ArrayList<>();
        for (Employee employee : EmployeeDAO.getAllEmployees()) {
            employees.add(new EmployeeTM(employee.getEmpId(),
                    employee.getEmpName(),
                    employee.getEmpAddress(),
                    employee.getEmail(),
                    employee.getContactNo(),
                    employee.getDateOfBirth().toLocalDate(),
                    employee.getJoinedDate().toLocalDate(),
                    employee.getSalary(),
                    employee.getGender()
            ));

        }


        return employees;


    }

    public static EmployeeTM getEmployee(String employeeId) {

        Employee employee = EmployeeDAO.getEmployee(employeeId);
        return new EmployeeTM(employee.getEmpId(),
                employee.getEmpName(),
                employee.getEmpAddress(),
                employee.getEmail(),
                employee.getContactNo(),
                employee.getDateOfBirth().toLocalDate(),
                employee.getJoinedDate().toLocalDate(),
                employee.getSalary(),
                employee.getGender());
    }

    public static boolean saveEmployee(EmployeeTM employeeTM) {
        java.sql.Date dateOfBirth = java.sql.Date.valueOf(employeeTM.getDateOfBirth());
        java.sql.Date joinedDate = java.sql.Date.valueOf(employeeTM.getJoinedDate());

        Employee employee = new Employee(employeeTM.getEmpId(),
                employeeTM.getEmpName(),
                employeeTM.getEmpAddress(),
                employeeTM.getEmail(),
                employeeTM.getContactNo(),
                dateOfBirth,
                joinedDate,
                employeeTM.getSalary(),
                employeeTM.getGender()
        );
        return EmployeeDAO.saveEmployee(employee);


    }

    public static boolean deleteEmployee(String employeeId) {

        return EmployeeDAO.deleteEmployee(employeeId);
    }

    public static boolean updateEmployee(EmployeeTM employeeTM) {
        java.sql.Date dateOfBirth = java.sql.Date.valueOf(employeeTM.getDateOfBirth());
        java.sql.Date joinedDate = java.sql.Date.valueOf(employeeTM.getJoinedDate());

        Employee employee = new Employee(employeeTM.getEmpId(),
                employeeTM.getEmpName(),
                employeeTM.getEmpAddress(),
                employeeTM.getEmail(),
                employeeTM.getContactNo(),
                dateOfBirth,
                joinedDate,
                employeeTM.getSalary(),
                employeeTM.getGender()
        );

        return EmployeeDAO.updateEmployee(employee);
    }
    //==============================================================================================

    public static List<AgentTM> getAllAgents() {
        ArrayList<AgentTM> agents = new ArrayList<>();
        for (Agent agent : AgentDAO.getAllAgents()) {
            agents.add(new AgentTM(agent.getAgentId(),
                    agent.getName(),
                    agent.getPhoneNo(),
                    agent.getEntryDate().toLocalDate(),
                    agent.getEmail(),
                    agent.getCompanyId()

            ));

        }


        return agents;
    }

    public static AgentTM getEAgent(String agentId) {

        Agent agent = AgentDAO.getAgent(agentId);
        return new AgentTM(agent.getAgentId(),
                agent.getName(),
                agent.getPhoneNo(),
                agent.getEntryDate().toLocalDate(),
                agent.getEmail(),
                agent.getCompanyId());
    }

    public static boolean saveAgent(AgentTM agentTM) {
        java.sql.Date entryDate = java.sql.Date.valueOf(agentTM.getEntryDate());
        Agent agent = new Agent(
                agentTM.getAgentId(),
                agentTM.getCompanyId(),
                entryDate,
                agentTM.getPhoneNo(),
                agentTM.getEmail(),
                agentTM.getName()
        );

        return AgentDAO.saveAgent(agent);

    }

    public static boolean deleteAgent(String agentId) {
        return AgentDAO.deleteAgent(agentId);

    }

    public static boolean updateAgent(AgentTM agentTM) {
        java.sql.Date entryDate = java.sql.Date.valueOf(agentTM.getEntryDate());


        Agent agent = new Agent(agentTM.getAgentId(),
                agentTM.getCompanyId(),
                entryDate,
                agentTM.getPhoneNo(),
                agentTM.getEmail(),
                agentTM.getName()


        );

        return AgentDAO.updateAgent(agent);

    }

    //==============================================================================================


    public static List<CompanyTM> getAllCompanies() {
        ArrayList<CompanyTM> companies = new ArrayList<>();
        for (Company company : CompanyDAO.getAllCompanies()) {
            companies.add(new CompanyTM(company.getCompanyId(),
                    company.getCompanyName(),
                    company.getEntryDate().toLocalDate(),
                    company.getCompanyPhoneNo(),
                    company.getCompanyEmail()
            ));
        }
        return companies;
    }

    public static CompanyTM getCompany(String companyId) {

        Company company = CompanyDAO.getCompany(companyId);
        return new CompanyTM(company.getCompanyId(),
                company.getCompanyName(),
                company.getEntryDate().toLocalDate(),
                company.getCompanyPhoneNo(),
                company.getCompanyEmail());
    }


    public static boolean saveCompany(CompanyTM companyTM, List<ItemTM> itemsOfTheCompany) {
        java.sql.Date entryDate = java.sql.Date.valueOf(companyTM.getEntryDate());
        Company company = new Company(
                companyTM.getCompanyId(),
                companyTM.getCompanyName(),
                entryDate,
                companyTM.getCompanyPhoneNo(),
                companyTM.getCompanyEmail()

        );

        return CompanyDAO.saveCompany(company);
    }

    public static boolean deleteCompany(String companyId) {

        return CompanyDAO.deleteCompany(companyId);
    }

    public static boolean updateCompany(CompanyTM companyTM) {

        java.sql.Date entryDate = java.sql.Date.valueOf(companyTM.getEntryDate());


        Company company = new Company(companyTM.getCompanyId(),
                companyTM.getCompanyName(),
                entryDate,
                companyTM.getCompanyPhoneNo(),
                companyTM.getCompanyEmail()


        );

        return CompanyDAO.updateCompany(company);
    }

    //==============================================================================================

    public static boolean placeOrder(Order order, List<OrderDetail> orderDetailList) {
        Connection connection = DBConnection.getInstance().getConnection();
        int affectedRows = 0;
        try {
            connection.setAutoCommit(false);
            java.sql.Date entryDate = java.sql.Date.valueOf(order.getOrderDate());
            entity.Order order1 = new entity.Order(
                    order.getOrderId(),
                    order.getEmpId(),
                    entryDate
            );
            if (OrderDAO.saveOrder(order1)) {
                connection.rollback();
                return false;
            }

            for (OrderDetail orderDetail : orderDetailList) {

                entity.OrderDetail orderDetail1 = new entity.OrderDetail(
                        orderDetail.getOrderId(),
                        orderDetail.getItemCode(),
                        orderDetail.getQty(),
                        orderDetail.getUnitPrice()
                );
                if (OrderDetailDAO.saveOrderDetail(orderDetail1) == false) {
                    connection.rollback();
                    return false;
                }


                Item item = ItemDAO.getItem(orderDetail.getItemCode());
                if (ItemDAO.updateItem(item) == false) {
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
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //==============================================================================================


    public static List<ItemTM> getAllItems() {
        ArrayList<ItemTM> items = new ArrayList<>();
        for (Item item : ItemDAO.getAllItems()) {
            items.add(new ItemTM(
                    item.getItemCode(),
                    item.getDescription(),
                    item.getCategory(),
                    item.getManufacturer(),
                    item.getProductionDate().toLocalDate(),
                    item.getExpiryDate().toLocalDate(),
                    item.getBuyingPrice(),
                    item.getSellingPrice(),
                    item.getMinimumStockLevel(),
                    item.getQtyOnHand(),
                    item.getUnitPrice()
            ));

        }
        return items;


    }

    public static ItemTM getItem(String itemCode) {
        Item item = ItemDAO.getItem(itemCode);
        return new ItemTM(
                item.getItemCode(),
                item.getDescription(),
                item.getCategory(),
                item.getManufacturer(),
                item.getProductionDate().toLocalDate(),
                item.getExpiryDate().toLocalDate(),
                item.getBuyingPrice(),
                item.getSellingPrice(),
                item.getMinimumStockLevel(),
                item.getQtyOnHand(),
                item.getUnitPrice());


    }


    public static boolean saveItem(CompanyItemPK companyItemPK) {
        Connection connection = DBConnection.getInstance().getConnection();
        int affectedRows = 0;
        try {
            connection.setAutoCommit(false);
            Item item = ItemDAO.getItem(companyItemPK.getItemCode());
            if (ItemDAO.saveItem(item) == false) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return false;
            }
            entity.CompanyItem companyItem = new CompanyItem(
                    companyItemPK.getItemCode(),
                    companyItemPK.getCompanyId()
            );
            if (CompanyItemDAO.saveCompanyItem(companyItem) == false) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return false;

            }
            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
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








  /*
        java.sql.Date productionDate = java.sql.Date.valueOf(itemTM.getProductionDate());
        java.sql.Date expiryDate = java.sql.Date.valueOf(itemTM.getExpiryDate());

        Item item = new Item(
                itemTM.getItemCode(),
                itemTM.getDescription(),
                itemTM.getCategory(),
                itemTM.getManufacturer(),
                productionDate,
                expiryDate,
                itemTM.getBuyingPrice(),
                itemTM.getSellingPrice(),
                itemTM.getMinimumStockLevel(),
                itemTM.getQtyOnHand(),
                itemTM.getUnitPrice()


        );*/





    public static boolean deleteItem(String itemCode) {
        return ItemDAO.deleteItem(itemCode);
    }

    public static boolean updateItem(ItemTM itemTM) {
        java.sql.Date productionDate = java.sql.Date.valueOf(itemTM.getProductionDate());
        java.sql.Date expiryDate = java.sql.Date.valueOf(itemTM.getExpiryDate());


        Item item = new Item(
                itemTM.getItemCode(),
                itemTM.getDescription(),
                itemTM.getCategory(),
                itemTM.getManufacturer(),
                productionDate,
                expiryDate,
                itemTM.getBuyingPrice(),
                itemTM.getSellingPrice(),
                itemTM.getMinimumStockLevel(),
                itemTM.getQtyOnHand(),
                itemTM.getUnitPrice()


        );

        return ItemDAO.updateItem(item);
    }


    //==============================================================================================

   /* public static List<CompanyItem> getAllCompanyItems() {
        ArrayList<CompanyItem> companyItems = new ArrayList<>();
        for (entity.CompanyItem companyItem : CompanyItemDAO.getAllCompanyItems()) {
            companyItems.add(new CompanyItem(
                    companyItem.getCompanyItemPK().getItemCode(),
                    companyItem.getCompanyItemPK().getCompanyId()
            ));


        }
        return companyItems;

    }

    public static CompanyItem getCompanyItem(entity.CompanyItemPK companyItemPK) {
        entity.CompanyItem companyItem = CompanyItemDAO.getCompanyItem(companyItemPK);
        CompanyItem companyItem1 = new CompanyItem(
                companyItem.getCompanyItemPK().getItemCode(),
                companyItem.getCompanyItemPK().getCompanyId()
        );

        return   companyItem1;

    }


    public static boolean saveCompanyItem(entity.CompanyItem companyItem) {
        return CompanyItemDAO.saveCompanyItem(companyItem);


    }

    public static boolean deleteItem(entity.CompanyItemPK companyItemPK) {
        return CompanyItemDAO.deleteCompanyItem(companyItemPK);
    }

    public static boolean updateItem(entity.CompanyItem companyItem) {
        return CompanyItemDAO.updateCompanyItem(companyItem);
    }*/
}









