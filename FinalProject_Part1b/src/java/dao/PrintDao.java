/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.MarketingAgents;

/**
 *
 * @author Yogesh Joshi
 */
public class PrintDao {
    private String url;
    private String userDB;
    private String passDB;
    
    public PrintDao(){
    }
    
    public PrintDao(String url, String userDB, String passDB){
        this.url = url;
        this.userDB = userDB;
        this.passDB = passDB;
    }
    
    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, userDB, passDB);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    
    //method for adding the marketing agents
    public int createMarketingAgents(MarketingAgents agentObj){
        int res = 0;
        String sql = "INSERT INTO marketingagent (firstName,lastName,phoneNo,email) VALUES (?,?,?,?)";
        
        try {
            Connection conn = getConnection();
            if(conn!=null){
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, agentObj.getFirstName());
                stmt.setString(2, agentObj.getLastName());
                stmt.setString(3, agentObj.getPhoneNo());
                stmt.setString(4, agentObj.getEmail());
                res = stmt.executeUpdate();
                conn.close();
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return res;
    }
    
    //method for displaying the marketing agents
    public ArrayList<MarketingAgents> readMarketingAgents(){
        ArrayList<MarketingAgents> agentsList = new ArrayList<>();
        String query = "SELECT * FROM marketingagent";
        
        try{
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            
            while(resultSet.next()){
                MarketingAgents agents = new MarketingAgents();
                agents.setId(resultSet.getInt("id"));
                agents.setFirstName(resultSet.getString("firstName"));
                agents.setLastName(resultSet.getString("lastName"));
                agents.setPhoneNo(resultSet.getString("phoneNo"));
                agents.setEmail(resultSet.getString("email"));
                
                agentsList.add(agents);
            }
            resultSet.close();
            stmt.close();
             
            if(conn!=null && !conn.isClosed()){
                conn.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return agentsList;
    }
    
    public MarketingAgents showAgentInfo(int id){
        MarketingAgents agent = null;
        String query = "SELECT * FROM marketingagent WHERE id = ?";
        
        try{
            Connection conn = getConnection();
            PreparedStatement preStmt = conn.prepareStatement(query);
            preStmt.setInt(1, id);
            ResultSet resultSet = preStmt.executeQuery();
            
            while(resultSet.next()){
                agent = new MarketingAgents();
                agent.setId(resultSet.getInt("id"));
                agent.setFirstName(resultSet.getString("firstName"));
                agent.setLastName(resultSet.getString("lastName"));
                agent.setPhoneNo(resultSet.getString("phoneNo"));
                agent.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            preStmt.close();
            
            if(conn != null || !conn.isClosed()){
                conn.close();
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return agent;
    }
    
    public boolean updateMarketingAgent(MarketingAgents agent) {
        boolean result = false;
        String query = "UPDATE marketingagent SET firstName = ?, lastName = ?, phoneNo = ?, email = ? WHERE id = ?";
        
        try{
            Connection conn = getConnection();
            PreparedStatement preStmt = conn.prepareStatement(query);
            preStmt.setString(1, agent.getFirstName());
            preStmt.setString(2, agent.getLastName());
            preStmt.setString(3, agent.getPhoneNo());
            preStmt.setString(4, agent.getEmail());
            preStmt.setInt(5, agent.getId());
            
            if(preStmt.executeUpdate() > 0){
                result = true;
            }
            else{
                result = false;
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    public boolean deleteMarketingAgent(int id){
        boolean result = false;
        String query = "DELETE FROM marketingagent WHERE id = ?";
        
        try{
            Connection conn = getConnection();
            PreparedStatement preStmt = conn.prepareStatement(query);
            preStmt.setInt(1, id);
            int res = preStmt.executeUpdate();
            
            if(res > 0){
                result = true;
            }
            else{
                result = false;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
