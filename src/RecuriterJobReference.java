import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import javax.sql.*;
public class RecuriterJobReference extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession hs=req.getSession();
	String responsibilities=req.getParameter("responsibilities");
	String jobname=req.getParameter("jobname");
	String vacancies=req.getParameter("vacancies");
	String qualification=req.getParameter("qualification");
	String requiredskills=req.getParameter("requiredskills");
	String createdby=req.getParameter("createdby");
	String requiredexperience=req.getParameter("requiredexperience");
	String status=req.getParameter("status");
	hs.setAttribute("responsibilities",responsibilities);
	hs.setAttribute("jobname",jobname);
	hs.setAttribute("vacancies",vacancies);
	hs.setAttribute("qualification",qualification);
	hs.setAttribute("requiredskills",requiredskills);
	hs.setAttribute("createdby",createdby);
	hs.setAttribute("requiredexperience",requiredexperience);
	hs.setAttribute("status",status);
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from uniquejobreference");
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			String ref=rs.getString("referencenumber");
			hs.setAttribute("referencenumber",ref);
		}
		RequestDispatcher rd=req.getRequestDispatcher("/addjob");
		rd.forward(req, res);
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at RecruiterJobreference Servelt");
		out.println(e);
	}
}
}
