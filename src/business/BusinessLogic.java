package business;

import dao.DaoLayer;
import util.*;

import java.util.List;

public class BusinessLogic {

    public static List<EmployeeTM> getAllEmployees(){
        return DaoLayer.getAllEmployees();
    }

    public static EmployeeTM getEmployee(String employeeId) {
        return  DaoLayer.getEmployee(employeeId);
    }

    public static boolean saveEmployee(EmployeeTM employeeTM){
        return DaoLayer.saveEmployee(employeeTM);
    }

    public static boolean deleteEmployee(String employeeId){
        return  DaoLayer.deleteEmployee(employeeId);
    }

    public static boolean updateEmployee(EmployeeTM employeeTM){
        return DaoLayer.updateEmployee(employeeTM);
    }

    public static List<AgentTM> getAllAgents(){
        return DaoLayer.getAllAgents();
    }

    public static AgentTM getEAgent(String agentId) {
        return DaoLayer.getEAgent(agentId);
    }

    public static boolean saveAgent(AgentTM agentTM){
        return  DaoLayer.saveAgent(agentTM);
    }

    public static boolean deleteAgent(String agentId){
        return DaoLayer.deleteAgent(agentId);
    }

    public static boolean updateAgent(AgentTM agentTM){
        return DaoLayer.updateAgent(agentTM);
    }

    public static List<CompanyTM> getAllCompanies(){
        return DaoLayer.getAllCompanies();
    }

    public static boolean saveCompany(CompanyTM companyTM,List<ItemTM> itemsOfTheCompany){
        return  DaoLayer.saveCompany(companyTM,itemsOfTheCompany);
    }

    public static boolean deleteCompany(String companyId){
        return  DaoLayer.deleteCompany(companyId);
    }

    public static boolean updateCompany(CompanyTM companyTM){
        return DaoLayer.updateCompany(companyTM);
    }

    public static boolean placeOrder(Order order, List<OrderDetail> orderDetailList){
        return  DaoLayer.placeOrder(order,orderDetailList);
    }

    public static List<ItemTM> getAllItems(){
        return  DaoLayer.getAllItems();
    }

    public static ItemTM getItem(String itemCode) {
        return DaoLayer.getItem(itemCode);
    }

    public static boolean saveItem(ItemTM itemTM){
        return  DaoLayer.saveItem(itemTM);
    }

    public static boolean deleteItem(String itemCode){
        return DaoLayer.deleteItem(itemCode);
    }

    public static boolean updateItem(ItemTM itemTM){
        return DaoLayer.updateItem(itemTM);
    }





}
