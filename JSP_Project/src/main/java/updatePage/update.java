package updatePage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String ph=request.getParameter("ph");
		String address=request.getParameter("address");
		PrintWriter pw=response.getWriter();
		//out.println(fname+" "+lname+" "+ph+" "+address);
		//if(request.getParameter("submit") !=null){

		try{


		int id=Integer.parseInt(request.getParameter("id"));

		String driverName = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/";
		String dbName = "formdatabase";
		String userId = "root";
		String password = "root";
		Connection con;
		PreparedStatement pst;
		//ResultSet rs;
		RequestDispatcher dispatcher=null;
		String query="update student set s_fname=?,s_lname=?,s_phNumber=?,s_address=? where s_id=?";
		con = DriverManager.getConnection(connectionUrl + dbName, userId, password);
		pst = con.prepareStatement(query);
		pst.setString(1,fname);
		pst.setString(2,lname);
		pst.setString(3,ph);
		pst.setString(4,address);
		pst.setInt(5,id);
		int rs=pst.executeUpdate();
		if(rs>0) {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}
		else {
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}



		}
		catch (Exception e) {
		  e.printStackTrace();
		}
	}
		
	
	}

//}sf
