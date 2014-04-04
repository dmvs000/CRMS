import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import javax.sql.*;
public class RedirectUser extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession hs=req.getSession();
	String username=(String)hs.getAttribute("username");
	String password=(String)hs.getAttribute("password");
	String type=(String)hs.getAttribute("type");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?)");
		ps.setString(1,username);
		ps.setString(2,password);
		ps.setString(3,type);
		int count=ps.executeUpdate();
		if(count==1)
		{
			 RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			 rd.include(req,res);
			 out.println("You have been successfully registered");
		}
		else
			out.println("Severe error");
	}
	catch(Exception e)
	{
		out.println(e);
	}
}
}
