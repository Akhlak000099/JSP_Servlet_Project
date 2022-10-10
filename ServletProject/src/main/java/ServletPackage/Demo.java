package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Demo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("Connected");
	try {
		String url = "jdbc:mysql://localhost:3306/formDB";
		String user = "root";
		String pass = "root";
	  	String q = "select * from form where u_name=? and u_pass=?";
	  	String u_name = request.getParameter("name");
	  	String u_pass = request.getParameter("pass");
	  	//out.print("name="+u_name+"And pass="+u_pass);
		Connection con = DriverManager.getConnection(url,user,pass);
		//out.println("After CON");
		PreparedStatement ps =  con.prepareStatement(q);
		ps.setString(1, u_name);
		ps.setString(2, u_pass);
		ResultSet rs = ps.executeQuery();
	//	out.println("After QUE");
		
		if(rs.next())
		{
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Incorrect.jsp");
			rd.forward(request, response);
		
		}
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	
		
	}

}


