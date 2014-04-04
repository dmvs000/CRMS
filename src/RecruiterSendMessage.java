import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import java.util.Date;
public class RecruiterSendMessage extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession hs=req.getSession();
	String ausername=(String)hs.getAttribute("ausername");
	String referencenumber=(String)hs.getAttribute("referencenumber");
	String username=(String)hs.getAttribute("username");
	String message=req.getParameter("message");
	String subject=req.getParameter("subject");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("insert into messenger values(?,?,?,?,?,?)");
		ps.setString(1,ausername);
		ps.setString(2,username);
		ps.setString(3,message);
		Date date=new Date();
		String time=date.toString();
		ps.setString(4,subject);
		ps.setString(5,time);
		ps.setString(6,referencenumber);
		int count=ps.executeUpdate();
		if(count==1)
			out.println("Message Has been succesfully sent");
		else
			out.println("There might be some error. Please try again after sometime");
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at Recruiter Send Message Servlet class");
		out.println(e);
	}
}
}
