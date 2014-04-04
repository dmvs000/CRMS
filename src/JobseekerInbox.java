import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class JobseekerInbox extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession hs=req.getSession();
	String username=(String)hs.getAttribute("username");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from messenger where tousername=?");
		ps.setString(1,username);
		ResultSet rs=ps.executeQuery();
		out.println("<html><body bgcolor=lightgreen><center>");
		out.println("<h1>INBOX</h1>");
		out.println("<a href='JobseekerHome.jsp'>HOME</a>&nbsp&nbsp&nbsp<a href=JobseekerHome.jsp>GO BACK</a>");
		out.println("<table boarder width=100% height=100% >");
		out.println("<tr><td>From</td><td>Time&Date</td><td>Subject</td><td></td><tr>");
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getString("fromusername")+"</td><td>"+rs.getString("timeanddate")+"</td><td>"+rs.getString("sub")+"</td>");
			hs.setAttribute("timeanddate", rs.getString("timeanddate"));
			out.println("<td><a href='JobseekerViewMessage.jsp'>View</a>");
		}
		out.println("</center></body></html>");
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at JobseekerInbox Servlet class");
		out.println(e);
	}
}
}
