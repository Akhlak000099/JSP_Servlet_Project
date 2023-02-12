<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"%>
    
   <%
   String driverName = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/";
   String dbName = "formdatabase";
   String userId = "root";
   String password = "root";
   
   try{
   int id=Integer.parseInt(request.getParameter("id").trim());
   String query="delete from student where s_id=?";
   Connection con;
   PreparedStatement pst;
   RequestDispatcher dispatcher=null;
   con=DriverManager.getConnection(url+dbName,userId,password);
   pst=con.prepareStatement(query);
   pst.setInt(1, id);
   
   int rs=pst.executeUpdate();
   if(rs>0){
	      
		  dispatcher = request.getRequestDispatcher("index.jsp");
		  dispatcher.forward(request, response);
		
   }
   else{
		  dispatcher = request.getRequestDispatcher("index.jsp");
		  dispatcher.forward(request, response);
   }
   
 

  
   
	  pst.close();
	  con.close();
  
   }
   catch(Exception e){
	   System.out.println(e);
   }
   %>
   