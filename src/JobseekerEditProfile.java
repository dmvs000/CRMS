import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import javax.sql.*;
import java.io.*;
public class JobseekerEditProfile extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String emailaddress=req.getParameter("emailaddress");
	String firstname=req.getParameter("firstname");
	String lastname=req.getParameter("lastname");
	HttpSession hs=req.getSession();
	String username=(String)hs.getAttribute("username");
	String totalexperience=req.getParameter("totalexperience");
	String jobcategory=req.getParameter("jobcategory");
	String keyskills=req.getParameter("keyskills");
	String phonenumber=req.getParameter("phonenumber");
	String mobilenumber=req.getParameter("mobilenumber");
	String currentlocation=req.getParameter("currentlocation");
	String prefferedjoblocation=req.getParameter("prefferedjoblocation");
	String highestqualificationheld=req.getParameter("highestqualificationheld");
	String major=req.getParameter("major");
	String institute=req.getParameter("institute");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		 PreparedStatement ps=con.prepareStatement("update jobseekerinformation set emailaddress=?,firstname=?,lastname=?,totalexperience=?,jobcategory=?,keyskills=?,phonenumber=?,mobilenumber=?,currentlocation=?,prefferedjoblocation=?,highestqualificationheld=?,major=?,institute=? where username=?");
		 ps.setString(1,emailaddress);
		 ps.setString(2,firstname);
		 ps.setString(3,lastname);
		 ps.setString(4,totalexperience);
		 ps.setString(5,jobcategory);
		 ps.setString(6,keyskills);
		 ps.setString(7,phonenumber);
		 ps.setString(8,mobilenumber);
		 ps.setString(9,currentlocation);
		 ps.setString(10,prefferedjoblocation);
		 ps.setString(11,highestqualificationheld);
		 ps.setString(12,major);
		 ps.setString(13,institute);
		 ps.setString(14,username);
		 int count=ps.executeUpdate();
		 if(count==1)
		 {
			 RequestDispatcher rd=req.getRequestDispatcher("JobseekerHome.jsp");
			 rd.include(req,res);
			 out.println("Your changes have been saved");
		 }
		 else
			 out.println("There might be some error.Please try again after sometime");	 
	}
	catch(Exception e)
	{
		out.println("Exception caught at JobseekerEditProfile servlet class");
		out.println(e);
	}
}
}
