<%-- 
    Document   : createLocation
    Created on : 13-Apr-2018, 4:26:40 PM
    Author     : Kylie Brooks
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <title>Add Location</title>
    </head>
    <body>
        <center>
        <h2 style="margin-top: 50px">Add Location</h2><br/>
        <form action="addLocation" method="post">
            <div class="form-inline col-md-3">
                <label>Location name: </label>&nbsp;
                <input class="form-control" type="text" name="locationName" id="locationName" />
            </div><br/>
            <div class="form-inline col-md-3">
                <label>Max # of flyers this location can have:</label>&nbsp; 
                <input class="form-control" type="text" name="distributionCapacity" id="distributionCapacity" />
            </div><br/>
            <div class="form-group">
                <input class="btn btn-success" type="submit" name="submit" id="submit" value="Add"/>&nbsp;&nbsp;
                <button class="btn btn-success" type="button" name="view" onclick="window.location.href='listLocations'">View Locations</button>
            </div>
        </form>
    </center>
    </body>
</html>
