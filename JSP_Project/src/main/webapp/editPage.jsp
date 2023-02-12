<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
    <%@page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="signup.css">
</head>
<body>
<form action="update" method="post">


  <div class="container">  
  <center>  <h1> Student Registeration Form</h1> </center>  
  <hr>  
  <label><b> Firstname :</b></label>   
<input type="text" name="fname" placeholder= "Firstname" size="15" required />   

<label><b>Lastname :</b></label>    
<input type="text" name="lname" placeholder="Lastname" size="15"required />   

  
<label> <b>Phone :</b> </label>  
<input type="text" name="ph" placeholder="phone number"  value="+91"/>   
<label for="address"><b>Current Address : </b></label> 
<textarea cols="80" rows="5" placeholder="Current Address" value="address" name="address" required>  
</textarea>  
 
  
    <input type="submit" value="Register" class="registerbtn" name="submit">    
    
  
</form>
</body>
</html>
