/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PrintDao;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MarketingAgents;
import model.Locations;

/**
 *
 * @author Yogesh Joshi
 */
public class PrintService {
    public int createMarketingAgents(String firstName, String lastName, String phoneNo, String email, PrintDao printDao){
        int res = 0;
        MarketingAgents agentObj = new MarketingAgents();
        
        if(firstName != null && lastName != null && phoneNo != null && email != null){
            agentObj.setFirstName(firstName);
            agentObj.setLastName(lastName);
            agentObj.setPhoneNo(phoneNo);
            agentObj.setEmail(email);
            res = printDao.createMarketingAgents(agentObj);
        }
        return res;
    }
    
    public ArrayList<MarketingAgents> readMarketingAgents(PrintDao printDao){
        ArrayList<MarketingAgents> agentsList = new ArrayList();
        agentsList = printDao.readMarketingAgents();
        return agentsList;
    }
    
    public MarketingAgents showAgentInfo(int id, PrintDao printDao) throws SQLException{
        MarketingAgents agent = printDao.showAgentInfo(id);    
        return agent;
    }
    
    public boolean updateMarketingAgent(MarketingAgents agent, PrintDao printDao){
        boolean result = printDao.updateMarketingAgent(agent);
        return result;
    }
    
    public boolean deleteMarketingAgent(int id, PrintDao printDao){
        boolean result = printDao.deleteMarketingAgent(id);
        return result;
    }
    
    public int createLocations(String locationName, int distributionCapacity, PrintDao printDao) {
        int res = 0;
        Locations locationObj = new Locations();
     
        if(locationName != null) {
            locationObj.setLocationName(locationName);
            locationObj.setDistributionCapacity(distributionCapacity);
            res = printDao.createLocations(locationObj);
        }
        
        return res;
    }
    
    public ArrayList<Locations> readLocations(PrintDao printDao){
        ArrayList<Locations> locationsList = new ArrayList();
        locationsList = printDao.readLocations();
        return locationsList;
    }
    
    public Locations showLocationInfo(int id, PrintDao printDao) throws SQLException{
        Locations location = printDao.showLocationInfo(id);    
        return location;
    }
    
    public boolean updateLocationInfo(Locations location, PrintDao printDao){
        boolean result = printDao.updateLocationInfo(location);
        return result;
    }
    
    public boolean deleteLocation(int id, PrintDao printDao){
        boolean result = printDao.deleteLocation(id);
        return result;
    }

}
