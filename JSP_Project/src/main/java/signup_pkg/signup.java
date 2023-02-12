package signup_pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String course=request.getParameter("course");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("ph");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String password=request.getParameter("psw");
		
		String re_password=request.getParameter("re_password");
		
		PrintWriter out=response.getWriter();
		String url = "jdbc:mysql://localhost:3306/formdatabase";
		String user = "root";
		String pass = "root";
		RequestDispatcher dispatcher=null;
		
		if(password.equals(re_password)) {
			try {
			
				  String qur="insert into student(s_fname,s_lname,s_course,s_gender,s_phNumber,s_address,s_email,s_password) values(?,?,?,?,?,?,?,?)";
				  Connection con = DriverManager.getConnection(url,user,pass);
				  PreparedStatement ps = con.prepareStatement(qur);
				   
				  ps.setString(1,fname);
				  ps.setString(2,lname);
				  ps.setString(3,course);
				  ps.setString(4,gender);
				  ps.setString(5,phone);
				  ps.setString(6,address);
				  ps.setString(7,email);
				  ps.setString(8,password);
				  
				  int row_count=ps.executeUpdate();
				  if(row_count>0) {
					  dispatcher = request.getRequestDispatcher("login.jsp");
					  request.setAttribute("status","Success");
				  }
				  else {
					  request.setAttribute("status","Failed");
				  }
				  dispatcher.forward(request, response);
				  ps.close();
				  con.close();
				}
				
			
			catch(Exception e) {
				e.printStackTrace();
			}
				
		
		}
		else {
			out.print("Sorry your password or re_password is not matched :-)");
		} 
	}

}
