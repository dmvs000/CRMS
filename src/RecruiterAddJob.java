import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import javax.sql.*;
public class RecruiterAddJob extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession hs=req.getSession();
	String username=(String)hs.getAttribute("username");
	String referencenumber=(String)hs.getAttribute("referencenumber");
	String responsibilities=(String)hs.getAttribute("responsibilities");
	String jobname=(String)hs.getAttribute("jobname");
	String vacancies=(String)hs.getAttribute("vacancies");
	String qualification=(String)hs.getAttribute("qualification");
	String requiredskills=(String)hs.getAttribute("requiredskills");
	String createdby=(String)hs.getAttribute("createdby");
	String requiredexperience=(String)hs.getAttribute("requiredexperience");
	String status=(String)hs.getAttribute("status");
	int ref=Integer.parseInt(referencenumber);
	int nref=ref+1;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("insert into job values(?,?,?,?,?,?,?,?,?)");
		PreparedStatement pstmt=con.prepareStatement("insert into "+username+"jobs values(?,?,?,?,?,?,?,?,?)");
		PreparedStatement psad=con.prepareStatement("create table "+referencenumber+"appliedlist (canditates varchar(45),status varchar(45))");
		ps.setString(1,referencenumber);
		ps.setString(2,responsibilities);
		ps.setString(3,jobname);
		ps.setString(4,vacancies);
		ps.setString(5,qualification);
		ps.setString(6,requiredskills);
		ps.setString(7,createdby);
		ps.setString(8,requiredexperience);
		ps.setString(9,status);
		pstmt.setString(1,referencenumber);
		pstmt.setString(2,responsibilities);
		pstmt.setString(3,jobname);
		pstmt.setString(4,vacancies);
		pstmt.setString(5,qualification);
		pstmt.setString(6,requiredskills);
		pstmt.setString(7,createdby);
		pstmt.setString(8,requiredexperience);
		pstmt.setString(9,status);
		pstmt.executeUpdate();
		int count=ps.executeUpdate();
		if(count==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("RecruiterHome.jsp");
			rd.include(req, res);
			psad.executeUpdate();
			out.println("Job Has Been Created Successfully");
		}
		else
			out.println("There might be some severe error");
		PreparedStatement psd=con.prepareStatement("update uniquejobreference set referencenumber=?");
		psd.setInt(1,nref);
		psd.executeUpdate();
	}
	catch(Exception e)
	{
		out.println("Exception caught at RecruiterAddjob servlet class");
		out.println(e);
	}
}
}
