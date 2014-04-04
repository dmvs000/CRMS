import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;

import javax.sql.*;

public class AdminSelectedCanditates extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
	   	try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
			PreparedStatement ps=con.prepareStatement("select * from adminlist");
			ResultSet rs=ps.executeQuery();
			PreparedStatement ps2=con.prepareStatement("select * from job where referencenumber=?");
			out.println("<html><body bgcolor=lightgreen><center>");
			out.println("<a href=AdminHome.jsp>Home</a>");
			out.println("<table boarder height=100% width=100% >");
			out.println("<tr><td>Reference Number</td><td>Canditates</td>");
			while(rs.next())
			{
				String username=rs.getString("canditates");
				String referencenumber=rs.getString("referencenumber");
				ps2.setString(1,referencenumber);
				out.println("<tr><td>"+username+"</td><td>"+referencenumber+"</td>");
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next())
				{
					out.println("kev keka");
					out.println("<td>"+rs2.getString("qualification")+"</td><td>"+rs2.getString("requiredskills")+"</td><td>"+rs2.getString("responsibilities")+"</td>");
					out.println("<td>"+rs2.getString("vacancies")+"</td><td>"+rs2.getString("qualification")+"</td><td>"+rs2.getString("qualification")+"</td></tr>");
				}
			}
			out.println("</table></center></body></html>");
		}
		catch(Exception e)
		{
		out.println("Exception caught at AdminSelectedCanditates Servlet class");
		out.println(e);
		}
	}

}
