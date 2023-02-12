<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
 <title>Registeration</title>
 <link rel="stylesheet" href="signup.css">
</head>  
<body>  
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

    <form action="signup" method="post">
  <div class="container">  
  <center>  <h1> Student Registeration Form</h1> </center>  
  <hr>  
  <label><b> Firstname :</b></label>   
<input type="text" name="fname" placeholder= "Firstname" size="15" required />   

<label><b>Lastname :</b></label>    
<input type="text" name="lname" placeholder="Lastname" size="15"required />   
<div>  
<label>   
<b>Course :</b>
</label>   
  
<select name="course">  
<option value="Course">Course</option>  
<option value="BCA">BCA</option>  
<option value="BBA">BBA</option>  
<option value="B.Tech">B.Tech</option>  
<option value="MBA">MBA</option>  
<option value="MCA">MCA</option>  
<option value="M.Tech">M.Tech</option>  
</select>  
</div>  
<div>  
<label>   
<b>Gender :</b>  
</label><br>  
<input type="radio" value="Male" name="gender" checked > Male   
<input type="radio" value="Female" name="gender"> Female   
<input type="radio" value="Other" name="gender"> Other  
  
</div>  
<label> <b>Phone :</b> </label>  
<input type="text" name="ph" placeholder="phone number"  value="+91"/>   
<label for="address"><b>Current Address : </b></label> 
<textarea cols="80" rows="5" placeholder="Current Address" value="address" name="address" required>  
</textarea>  
 <label for="email"><b>Email</b></label>  
 <input type="text" placeholder="Enter Email" name="email" required>  
  
    <label for="psw"><b>Password</b></label>  
    <input type="password" placeholder="Enter Password" name="psw" required>  
  
    <label for="re_password"><b>Re-type Password</b></label>  
    <input type="password" placeholder="Retype Password" name="re_password" required>  
    <input type="submit" value="Register" class="registerbtn">    
</form> 


</script> 
</body>  
</html>  