<%-- 
    Document   : createAgent
    Created on : 12-Apr-2018, 4:25:37 PM
    Author     : Yogesh Joshi
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
        
        <title>Add Agent Page</title>
    </head>
    <body>
        <center>
        <h2 style="margin-top: 50px">Add Marketing Agent</h2><br/>
        <form action="addAgent" method="post">
            <div class="form-inline col-md-3">
                <label>First Name: </label>&nbsp;
                <input class="form-control" type="text" name="firstName" id="firstName" />
            </div><br/>
            <div class="form-inline col-md-3">
                <label>Last Name: </label>&nbsp; 
                <input class="form-control" type="text" name="lastName" id="lastName" />
            </div><br/>
            <div class="form-inline col-md-3">
                <label>Phone No: </label>&nbsp;&nbsp;
                <input class="form-control" type="text" name="phoneNo" id="phoneNo" />
            </div><br/>
            <div class="form-inline col-md-3">
                <label>Email: </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="form-control" type="text" name="email" id="email" />
            </div><br/>
            <div class="form-group">
                <input class="btn btn-success" type="submit" name="submit" id="submit" value="Register"/>&nbsp;&nbsp;
                <button class="btn btn-success" type="button" name="view" onclick="window.location.href='list'">View Agents</button>
            </div>
        </form>
    </center>
    </body>
</html>
