package dao.impl;

import dao.AgentDAO;
import db.DBConnection;
import entity.Agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAOImpl implements AgentDAO {

    public  List<Object> getAll(){
        ArrayList<Object> agents = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM agent");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                agents.add(new Agent(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)

                        ));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  agents;
    }
    public  Agent get(Object key){

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM agent WHERE agentId=(?)");
            preparedStatement.setObject(1,key);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
               return  new Agent(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
               );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
        return  null;

    }
    public  boolean save(Object agent){
        Agent agent1 = (Agent)agent;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO agent VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, agent1.getAgentId());
            preparedStatement.setObject(2, agent1.getCompanyId());
            preparedStatement.setObject(3, agent1.getEntryDate());
            preparedStatement.setObject(4, agent1.getPhoneNo());
            preparedStatement.setObject(5, agent1.getEmail());
            preparedStatement.setObject(6, agent1.getName());
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean delete(Object key){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM agent WHERE agentId=(?)");
            preparedStatement.setObject(1, key);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public  boolean update(Object agent){
        Agent agent1 = (Agent)agent;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE agent SET companyId=(?),entryDate=(?),agentPhoneNo=(?),agentEmail=(?),agentName=(?) WHERE agentId=(?)");
            preparedStatement.setObject(6, agent1.getAgentId());
            preparedStatement.setObject(1, agent1.getCompanyId());
            preparedStatement.setObject(2, agent1.getEntryDate());
            preparedStatement.setObject(3, agent1.getPhoneNo());
            preparedStatement.setObject(4, agent1.getEmail());
            preparedStatement.setObject(5, agent1.getName());
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }

    public  String getLastAgentId(){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM agent ORDER BY agentId DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getString(1);

                            }

            return "A001";



        } catch (SQLException e) {
            e.printStackTrace();
            return null;


        }


    }
}
