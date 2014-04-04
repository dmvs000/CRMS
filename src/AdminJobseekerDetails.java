import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class AdminJobseekerDetails extends HttpServlet 
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from jobseekerinformation");
		ResultSet rs=ps.executeQuery();
		out.println("<html><body bgcolor=lightcyan><center>");
		out.println("The Details of the Recruiters are.....<br>");
		out.println("<table boarder height=80% widht=100% >");
		out.println("<tr><td>Email ID</td><td>First Name</td><td>Last Name</td><td>Username</td><td>Phone Nubmer</td><td>Moblie Number</td>");
		out.println("<td>keyskills</td><td>Qualification</td><td>Specialization</td><td></td></tr>");
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getString("emailaddress")+"</td><td>"+rs.getString("firstname")+"</td><td>"+rs.getString("lastname")+"</td><td>"+rs.getString("username")+"</td><td>"+rs.getString("phonenumber")+"</td><td>"+rs.getString("mobilenumber")+"</td>");
			out.println("<td>"+rs.getString("keyskills")+"</td><td>"+rs.getString("highestqualificationheld")+"</td><td>"+rs.getString("major")+"</td><td>Delete</td></tr>");
		}
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at AdminRecrutierDetails Servlet class");
		out.println(e);
	}
}
}
