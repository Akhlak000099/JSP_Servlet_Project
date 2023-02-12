package signin_pkg;

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
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		PrintWriter out=response.getWriter();
//		out.print(email+" "+password);
		
		String url = "jdbc:mysql://localhost:3306/formdatabase";
		String user = "root";
		String pass = "root";

		String qur="select * from student where s_email=? and S_password=?";
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=con.prepareStatement(qur);
			ps.setString(1,email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//			out.print("successfully connect");

				if(rs.next()) {
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
					
				}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
					rd.forward(request, response);
					
				}
//			}
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
