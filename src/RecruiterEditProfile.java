import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import javax.sql.*;
import java.io.*;
public class RecruiterEditProfile extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String qualification=req.getParameter("qualification");
	String homeno=req.getParameter("homeno");
	String streetname=req.getParameter("streetname");
	String city=req.getParameter("city");
	String state=req.getParameter("state");
	String country=req.getParameter("country");
	String pincode=req.getParameter("pincode");
	String phonenumber=req.getParameter("phonenumber");
	String mobilenumber=req.getParameter("mobilenumber");
	String emailid=req.getParameter("emailid");
	String passportnumber=req.getParameter("passportnumber");
	String phomeno=req.getParameter("phomeno");
	String pstreetname=req.getParameter("pstreetname");
	String pcity=req.getParameter("pcity");
	String pstate=req.getParameter("pstate");
	String pcountry=req.getParameter("pcountry");
	String ppincode=req.getParameter("ppincode");
	HttpSession hs=req.getSession();
	String username=(String)hs.getAttribute("username");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("update recruiterinformation set qualification=?,homeno=?,streetno=?,city=?,state=?,country=?,pincode=?,phonenumber=?,mobilenumber=?,emailid=?,passportno=?,phomeno=?,pstreetname=?,pcity=?,pstate=?,pcountry=?,ppincode=? where username=?");
		 ps.setString(1,qualification);
		 ps.setString(2,homeno);
		 ps.setString(3,streetname);
		 ps.setString(4,city);
		 ps.setString(5,state);
		 ps.setString(6,country);
		 ps.setString(7,pincode);
		 ps.setString(8,phonenumber);
		 ps.setString(9,mobilenumber);
		 ps.setString(10,emailid);
		 ps.setString(11,passportnumber);
		 ps.setString(12,phomeno);
		 ps.setString(13,pstreetname);
		 ps.setString(14,pcity);
		 ps.setString(15,pstate);
		 ps.setString(16,pcountry);
		 ps.setString(17,ppincode);
		 ps.setString(18,username);
		 int count=ps.executeUpdate();
		 if(count==1)
		 {
			 RequestDispatcher rd=req.getRequestDispatcher("RecruiterHome.jsp");
			 rd.include(req,res);
			 out.println("The changes in your profile have been saved");
		 }
		 else
			 out.println("Severe error. Needs Checking of the code");
        }
	catch(Exception e)
	{
		out.println("Exception has been caught at RecriuterEditProfile servlet class");
		out.println(e);
	}
}
}

