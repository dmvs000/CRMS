import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import javax.sql.*;
public class JobseekerApplyJob extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String referencenumber=req.getParameter("apply");
	HttpSession hs=req.getSession();
	String username=(String)hs.getAttribute("username");
   	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("insert into "+username+"appliedjobs values(?)");
		PreparedStatement pst=con.prepareStatement("insert into "+referencenumber+"appliedlist values(?,?)");
		pst.setString(1, username);
		pst.setString(2, "pending");
		int count1=pst.executeUpdate();
		ps.setString(1,referencenumber);
		int count2=ps.executeUpdate();
		if((count1==1)&&(count2==1))
		{
			RequestDispatcher rd=req.getRequestDispatcher("JobseekerSearchJobs.jsp");
			rd.include(req, res);
			out.println("You have successfully applied for this job");
		}
		else
			out.println("There might be some error");
	}
	catch(Exception e)
	{
	out.println("Exception caught at JobseekerApplyJob Servlet class");
	out.println(e);
	}
}
}
