/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.PrintDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MarketingAgents;
import model.Locations;
import service.PrintService;

/**
 *
 * @author Yogesh Joshi
 */
public class PrintServlet extends HttpServlet {
PrintService printService;
    PrintDao printDao;
    String jdbcUserName;
    String jdbcPassword;
    String jdbcURL;
    
    @Override
    public void init() throws ServletException {
        jdbcURL = getServletContext().getInitParameter("jdbcURL");
        jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
        jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        printDao = new PrintDao(jdbcURL, jdbcUserName, jdbcPassword);
        printService = new PrintService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        
        switch(action){
            case "/addAgent":
                addMarketingAgents(request, response);
                break;
            
            case "/editAgent":
                showMarketingAgent(request, response);
                break;
                
            case "/updateAgent":
                updateMarketingAgent(request,response);
                break;
            
            case "/deleteAgent":
                deleteMarketingAgent(request, response);
                break;    
                
            case "/addLocation":
                addLocations(request, response);
                break;
            
            case "/editLocation":
                showLocation(request, response);
                break;
            
            case "/updateLocation":
                updateLocation(request, response);
                break;
                
            case "/deleteLocation":
                deleteLocation(request, response);
                break;
                
            case "/listLocations":
                readLocations(request, response);
                break;
            
            default:
                readMarketingAgents(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void addMarketingAgents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        
        int res = printService.createMarketingAgents(firstName, lastName, phoneNo, email, printDao);
        
        if(res > 0){
            RequestDispatcher dispatcher = request.getRequestDispatcher("list");
            dispatcher.forward(request, response);
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }
    
    protected void readMarketingAgents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<MarketingAgents> agentsList = new ArrayList();
        agentsList = printService.readMarketingAgents(printDao);
        
        request.setAttribute("agentsList", agentsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayMarketingAgents.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void showMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            MarketingAgents agent = printService.showAgentInfo(id, printDao);
            request.setAttribute("agent", agent);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("editAgents.jsp");
            dispatcher.forward(request,response);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }
    
    protected void updateMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        
        MarketingAgents agent = new MarketingAgents(id, fName, lName, phoneNo, email);
        printService.updateMarketingAgent(agent, printDao);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("list");
        dispatcher.forward(request, response);
    }
    
    protected void deleteMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        printService.deleteMarketingAgent(id, printDao);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("list");
        dispatcher.forward(request,response);
    }
    
    protected void addLocations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String locationName = request.getParameter("locationName");
        int distributionCapacity = Integer.parseInt(request.getParameter("distributionCapacity"));
        
        int res = printService.createLocations(locationName, distributionCapacity, printDao);
        
        if(res > 0){
            RequestDispatcher dispatcher = request.getRequestDispatcher("listLocations");
            dispatcher.forward(request, response);
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }
    
    protected void readLocations(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Locations> locationsList = new ArrayList();
        locationsList = printService.readLocations(printDao);
        
        request.setAttribute("locationsList", locationsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayLocations.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void showLocation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            Locations location = printService.showLocationInfo(id, printDao);
            request.setAttribute("location", location);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("editLocations.jsp");
            dispatcher.forward(request, response);
            
        } catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        }
    }
    
    protected void updateLocation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String locationName = request.getParameter("locationName");
        int distributionCapacity = Integer.parseInt(request.getParameter("distributionCapacity"));
        
        Locations location = new Locations(id, locationName, distributionCapacity);
        printService.updateLocationInfo(location, printDao);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listLocations");
        dispatcher.forward(request, response);
    }
    
    protected void deleteLocation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        printService.deleteLocation(id, printDao);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listLocations");
        dispatcher.forward(request,response);
    }

}
