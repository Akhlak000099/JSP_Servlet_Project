<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   
    
</head>
<body>
      <%
String driverName = "com.mysql.jdbc.Driver";
    
    
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "formDatabase";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<table align="center" cellpadding="2" cellspacing="2">
<tr>
<th>Student_Fname</th><th>Student_Lname</th><th>Student_course</th><th>Student_Gender</th><th>Student_ph.Number</th><th>Student_Address</th><th>Student_Email</th><th>Student_Password</th>
<th>Edit</th><th>Delete</th>
</tr>
<%
try {
connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
statement = connection.createStatement();
String sql = "SELECT * FROM student";

resultSet = statement.executeQuery(sql);
while (resultSet.next()) {
	String id=resultSet.getString("s_id");
%>
<tr>
<td><%=resultSet.getString("s_fname")%></td>
<td><%=resultSet.getString("s_lname")%></td>
<td><%=resultSet.getString("s_course")%></td>
<td><%=resultSet.getString("s_gender")%></td>
<td><%=resultSet.getString("s_phNumber")%></td>
<td><%=resultSet.getString("s_address")%></td>
<td><%=resultSet.getString("s_email")%></td>
<td><%=resultSet.getString("S_password")%></td>
<td><a href="editPage.jsp?id=<%=id%>">Edit</a></td>
<td><a href="delete.jsp?id=<%=id%>">Delete</a></td>

</tr>
<%
}

} catch (Exception e) {

e.printStackTrace();
}
%>
</table>

</body>
</html>