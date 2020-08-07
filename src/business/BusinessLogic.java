package business;

import dao.impl.*;
import db.DBConnection;
import entity.*;
import entity.CompanyItem;
import util.*;
import util.Order;
import util.OrderDetail;

import java.sql.Connection;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessLogic {

    public static List<EmployeeTM> getAllEmployees() {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        ArrayList<EmployeeTM> employees = new ArrayList<>();
        for (Employee employee : employeeDAO.getAllEmployees()) {
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
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        Employee employee = employeeDAO.getEmployee(employeeId);
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
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
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
        return employeeDAO.saveEmployee(employee);


    }

    public static boolean deleteEmployee(String employeeId) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        return employeeDAO.deleteEmployee(employeeId);
    }

    public static boolean updateEmployee(EmployeeTM employeeTM) {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
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

        return employeeDAO.updateEmployee(employee);
    }
    //==============================================================================================

    public static List<AgentTM> getAllAgents() {
        AgentDAOImpl agentDAO = new AgentDAOImpl();

        ArrayList<AgentTM> agents = new ArrayList<>();
        for (Agent agent : agentDAO.getAllAgents()) {
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
        AgentDAOImpl agentDAO = new AgentDAOImpl();

        Agent agent = agentDAO.getAgent(agentId);
        return new AgentTM(agent.getAgentId(),
                agent.getName(),
                agent.getPhoneNo(),
                agent.getEntryDate().toLocalDate(),
                agent.getEmail(),
                agent.getCompanyId());
    }

    public static boolean saveAgent(AgentTM agentTM) {
        AgentDAOImpl agentDAO = new AgentDAOImpl();
        java.sql.Date entryDate = java.sql.Date.valueOf(agentTM.getEntryDate());
        Agent agent = new Agent(
                agentTM.getAgentId(),
                agentTM.getCompanyId(),
                entryDate,
                agentTM.getPhoneNo(),
                agentTM.getEmail(),
                agentTM.getName()
        );

        return agentDAO.saveAgent(agent);

    }

    public static boolean deleteAgent(String agentId) {
        AgentDAOImpl agentDAO = new AgentDAOImpl();
        return agentDAO.deleteAgent(agentId);

    }

    public static boolean updateAgent(AgentTM agentTM) {
        AgentDAOImpl agentDAO = new AgentDAOImpl();
        java.sql.Date entryDate = java.sql.Date.valueOf(agentTM.getEntryDate());


        Agent agent = new Agent(agentTM.getAgentId(),
                agentTM.getCompanyId(),
                entryDate,
                agentTM.getPhoneNo(),
                agentTM.getEmail(),
                agentTM.getName()


        );

        return agentDAO.updateAgent(agent);

    }

    //==============================================================================================


    public static List<CompanyTM> getAllCompanies() {
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();
        ArrayList<CompanyTM> companies = new ArrayList<>();
        for (Company company :companyDAO.getAllCompanies()) {
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
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();

        Company company = companyDAO.getCompany(companyId);
        return new CompanyTM(company.getCompanyId(),
                company.getCompanyName(),
                company.getEntryDate().toLocalDate(),
                company.getCompanyPhoneNo(),
                company.getCompanyEmail());
    }


    public static boolean saveCompany(CompanyTM companyTM, List<ItemTM> itemsOfTheCompany) {
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();
        java.sql.Date entryDate = java.sql.Date.valueOf(companyTM.getEntryDate());
        Company company = new Company(
                companyTM.getCompanyId(),
                companyTM.getCompanyName(),
                entryDate,
                companyTM.getCompanyPhoneNo(),
                companyTM.getCompanyEmail()

        );

        return companyDAO.saveCompany(company);
    }

    public static boolean deleteCompany(String companyId) {
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();

        return companyDAO.deleteCompany(companyId);
    }

    public static boolean updateCompany(CompanyTM companyTM) {
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();

        java.sql.Date entryDate = java.sql.Date.valueOf(companyTM.getEntryDate());


        Company company = new Company(companyTM.getCompanyId(),
                companyTM.getCompanyName(),
                entryDate,
                companyTM.getCompanyPhoneNo(),
                companyTM.getCompanyEmail()


        );

        return companyDAO.updateCompany(company);
    }

    //==============================================================================================

    public static boolean placeOrder(Order order, List<OrderDetail> orderDetailList) {
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
        ItemDAOImpl itemDAO = new ItemDAOImpl();
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
            boolean savedOrder = orderDAO.saveOrder(order1);
            if (savedOrder == false) {
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
                boolean savedOrderDetail = orderDetailDAO.saveOrderDetail(orderDetail1);
                if (savedOrderDetail == false) {
                    connection.rollback();
                    return false;
                }


                Item item = itemDAO.getItem(orderDetail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand().subtract(orderDetail.getQty()));
                boolean updatedQty = itemDAO.updateItem(item);
                if (updatedQty==false) {
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
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        ArrayList<ItemTM> items = new ArrayList<>();
        for (Item item : itemDAO.getAllItems()) {
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
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        Item item = itemDAO.getItem(itemCode);
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
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        CompanyItemDAOImpl companyItemDAO = new CompanyItemDAOImpl();
        Connection connection = DBConnection.getInstance().getConnection();
        int affectedRows = 0;
        try {
            connection.setAutoCommit(false);
            Item item = itemDAO.getItem(companyItemPK.getItemCode());
            boolean saveItem = itemDAO.saveItem(item);
            if (saveItem==false) {
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
            boolean saveCompanyItem = companyItemDAO.saveCompanyItem(companyItem);
            if (saveCompanyItem == false) {
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
        ItemDAOImpl itemDAO = new ItemDAOImpl();
        return itemDAO.deleteItem(itemCode);
    }

    public static boolean updateItem(ItemTM itemTM) {
        ItemDAOImpl itemDAO = new ItemDAOImpl();
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

        return itemDAO.updateItem(item);
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









