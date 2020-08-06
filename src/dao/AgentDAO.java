package dao;

import db.DBConnection;
import entity.Agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {
    public static List<Agent> getAllAgents(){
        ArrayList<Agent> agents = new ArrayList<>();
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
    public static Agent getAgent(String agentId){

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM agent WHERE agentId=(?)");
            preparedStatement.setObject(1,agentId);
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
    public static boolean saveAgent(Agent agent){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO agent VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, agent.getAgentId());
            preparedStatement.setObject(2, agent.getCompanyId());
            preparedStatement.setObject(3, agent.getEntryDate());
            preparedStatement.setObject(4, agent.getPhoneNo());
            preparedStatement.setObject(5, agent.getEmail());
            preparedStatement.setObject(6, agent.getName());
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public static boolean deleteAgent(String agentId){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM agent WHERE agentId=(?)");
            preparedStatement.setObject(1, agentId);
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    public static boolean updateAgent(Agent agent){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE agent SET companyId=(?),entryDate=(?),agentPhoneNo=(?),agentEmail=(?),agentName=(?) WHERE agentId=(?)");
            preparedStatement.setObject(6, agent.getAgentId());
            preparedStatement.setObject(1, agent.getCompanyId());
            preparedStatement.setObject(2, agent.getEntryDate());
            preparedStatement.setObject(3, agent.getPhoneNo());
            preparedStatement.setObject(4, agent.getEmail());
            preparedStatement.setObject(5, agent.getName());
            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }


    }
}
