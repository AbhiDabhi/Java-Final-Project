<%-- 
    Document   : displayLocations
    Created on : 13-Apr-2018, 4:32:14 PM
    Author     : Kyle Brooks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Locations"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <title>View Locations Page</title>
    </head>
    <body>
        <center>
            <h1 style="margin-top: 50px">List Of Locations</h1><br/>
            <a href="createLocation.jsp">Add Location</a><br/><br/>
            <table class="table-striped" cellpadding="5" border="1">
                <thead>
                    <th>id</th>
                    <th>Location name</th>
                    <th>Max # of flyers this location can have</th>
                </thead>
                <tbody>                
                <c:forEach var="location" items="${locationsList}">
                    <tr>
                        <td><c:out value="${location.id}"/></td>
                        <td><c:out value="${location.locationName}"/></td>
                        <td><c:out value="${location.distributionCapacity}"/></td>
                        <td><a href="editLocation?id=<c:out value='${location.id}'/>">
                                Edit
                            </a>
                                &nbsp;&nbsp;&nbsp;
                            <a href="deleteLocation?id=<c:out value='${location.id}'/>">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </center>
    </body>
</html>
