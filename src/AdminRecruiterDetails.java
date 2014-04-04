import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class AdminRecruiterDetails extends HttpServlet 
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from recruiterinformation");
		ResultSet rs=ps.executeQuery();
		out.println("<html><body bgcolor=lightgreen><center>");
		out.println("The Details of the Recruiters are.....<br>");
		out.println("<table boarder height=80% widht=100% >");
		out.println("<tr><td>Username</td><td>Hone No:</td><td>Moblie Number</td><td>Email ID</td></tr>");
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getString("username")+"</td><td>"+rs.getString("homeno")+"</td><td>"+rs.getString("mobilenumber")+"</td><td>"+rs.getString("emailid")+"</td></tr>");
		}
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at AdminRecrutierDetails Servlet class");
		out.println(e);
	}
}
}
