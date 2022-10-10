<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

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
String dbName = "formDB";
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

</tr>
<tr bgcolor="#008000">
<td><b>Id</b></td>
<td><b>Password</b></td>
</tr>
<%
try {
connection = DriverManager.getConnection(connectionUrl + dbName, userId, password);
statement = connection.createStatement();
String sql = "SELECT * FROM form";

resultSet = statement.executeQuery(sql);
while (resultSet.next()) {
%>
<tr bgcolor="#8FBC8F">

<td><%=resultSet.getString("u_name")%></td>
<td><%=resultSet.getString("u_pass")%></td>


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