import javax.servlet.*;
import java.util.*;
import java.util.Date;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import javax.sql.*;
public class RecruiterAction extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String delete=req.getParameter("delete");
	String view=req.getParameter("view");
	String select=req.getParameter("select");
	String ausername=req.getParameter("ausername");
	String del="Delete";
	String v="View";
	String sel="Select";
	HttpSession hs=req.getSession();
	String referencenumber=(String)hs.getAttribute("referencenumber");
	hs.setAttribute("ausername",ausername);
	String username=(String)hs.getAttribute("username");
	Date time=new Date();
	String timeanddate=time.toString();
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("delete from "+referencenumber+"appliedlist where canditates=?");
		ps.setString(1,ausername);
		PreparedStatement pst=con.prepareStatement("select * from jobseekerinformation where username=?");
		pst.setString(1,ausername);
		PreparedStatement pstmt=con.prepareStatement("update "+referencenumber+"appliedlist set status=? where canditates=?");
		pstmt.setString(1,"Selected");
		pstmt.setString(2, ausername);
		out.println("<html><body><form action><center>");
		if(del.equals(delete))
		{
			ps.executeUpdate();
			PreparedStatement ps2=con.prepareStatement("insert into messenger values(?,?,?,?,?,?)");
			ps2.setString(1, ausername);
			ps2.setString(2, username);
			ps2.setString(3, "This is an automated message. Please dont send any reply..We are very sorry to tell you that You have been rejected for this job. If you have any queries Directly contact your Employer directly");
			ps2.setString(4, "Sorry");
			ps2.setString(5, timeanddate);
			ps2.setString(6, referencenumber);
			int count=ps2.executeUpdate();
			if(count==1)
			{
				out.println("Canditate Rejected. An Automated message has been sent to him.");
				out.println("<a href=postedjobs>GO Back</a>");
			}
			else 
				out.println("There is a severe error. Needs recorrection");
	    
		}
		else if(v.equals(view))
		{
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				out.println("The Canditates Details are..........<br>");
				out.println("Job Experience :"+rs.getString("totalexperience")+"<br>");
				out.println("Job Category :"+rs.getString("jobcategory")+"<br>");
				out.println("keyskills :"+rs.getString("keyskills")+"<br>");
				out.println("phone number :"+rs.getString("phonenumber")+"<br>");
				out.println("Mobile Number :"+rs.getString("mobilenumber")+"<br>");
				out.println("Current Location :"+rs.getString("currentlocation")+"<br>");
				out.println("Preferred Job Location :"+rs.getString("prefferedjoblocation")+"<br>");
				out.println("Highest Qualification Held :"+rs.getString("highestqualificationheld")+"<br>");
				out.println("Specialization/Major :"+rs.getString("major")+"<br>");
				out.println("Institute :"+rs.getString("institute")+"<br><br>");
				out.println("<a href=RecruiterMessage.jsp>Offer a Job And Send Him A Message</a><br><br>");
				out.println("<a href=>Reject Applicant's Request and Delete Application</a><br><br><br><br>");
				out.println("<a href=RecruiterHome.jsp>GO HOME</a><br>");
			    out.println("<a href=postedjobs>GO TO JOBS PAGE</a>");
			}
		}
		else
		{
			pstmt.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("insert into messenger values(?,?,?,?,?,?)");
			ps1.setString(1, ausername);
			ps1.setString(2, username);
			ps1.setString(3, "This is an automated message. Please dont send any reply..Congratulations You have been selected for this job. If you have any queries Directly contact your Employer directly. Reference Number of this job is "+referencenumber);
			ps1.setString(4, "Congratulation");
			ps1.setString(5, timeanddate);
			ps1.setString(6, referencenumber);
			int count=ps1.executeUpdate();
			PreparedStatement ps3=con.prepareStatement("insert into adminlist values(?,?)");
			ps3.setString(1,referencenumber);
			ps3.setString(2,ausername);
			ps3.executeUpdate();
			if(count==1)
			{
				out.println("Canditate selected. An Automated message has been sent to him.");
			    out.println("<a href=postedjobs>Go BAck</a>");
			}
			else 
				out.println("There is a severe error. Needs recorrection");
	    
		}
		out.println("</center></form></body></html>");
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at RecruiterAction");
		out.println(e);
	}
}
}