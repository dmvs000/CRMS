import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import javax.sql.*;
public class RecruiterPostedJobs extends HttpServlet
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
		PreparedStatement ps=con.prepareStatement("select * from "+username+"jobs");
		ResultSet rs=ps.executeQuery();
		out.println("<html><body bgcolor=gold><a href='RecruiterHome.jsp'>HOME</a>&nbsp&nbsp&nbsp<a href=RecruiterJobMenu.jsp>GO BACK</a><center>The Jobs That You Have Posted...:");
		out.println("<form action=RecruiterViewList.jsp>");
		out.println("<table boarder height=80% width=100%>");
		out.println("<tr><td>Reference ID</td><td>Responsibilities</td><td>Job Name</td><td>Vacancies</td><td>");
		out.println("Qualification</td><td>Required Skills</td><td>Created By</td>");
		out.println("<td>Required Experience</td><td>Status</td><td>View Applied<br>Canditates</td></tr>");
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getString("referencenumber")+"<td>"+rs.getString("responsibilities")+"</td><td>"+rs.getString("jobname")+"</td>");
			out.println("<td>"+rs.getString("vacancies")+"</td><td>"+rs.getString("qualification")+"</td><td>"+rs.getString("requiredskills")+"</td>");
			out.println("<td>"+rs.getString("createdby")+"</td><td>"+rs.getString("requiredexperience")+"</td><td>"+rs.getString("status")+"</td><td><input type=submit name=referencenumber value="+rs.getString("referencenumber")+"></td></tr>");
		}
		out.println("</table></form></center></body></html>");
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at RecruiterPsotedJobs Servlet class");
		out.println(e);
	}
}
}
