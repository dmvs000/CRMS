import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;

import javax.sql.*;
public class RecruiterRegistration extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String username=req.getParameter("username");
	String password=req.getParameter("password");
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
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		 PreparedStatement ps=con.prepareStatement("insert into recruiterinformation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 PreparedStatement pst=con.prepareStatement("create table "+username+"questions (questionnumber int,question varchar(140),option1 varchar(45),option2 varchar(45),option3 varchar(45),option4 varchar(45), answer int)");
		 PreparedStatement pstmt=con.prepareStatement("create table "+username+"jobs (referencenumber varchar(45),responsibilities varchar(45),jobname varchar(45),vacancies varchar(45),qualification varchar(45),requiredskills varchar(45),createdby varchar(45),requiredexperience varchar(45),status varchar(45))");
		 pstmt.executeUpdate();
		 ps.setString(1,username);
		 ps.setString(2,password);
		 ps.setString(3,qualification);
		 ps.setString(4,homeno);
		 ps.setString(5,streetname);
		 ps.setString(6,city);
		 ps.setString(7,state);
		 ps.setString(8,country);
		 ps.setString(9,pincode);
		 ps.setString(10,phonenumber);
		 ps.setString(11,mobilenumber);
		 ps.setString(12,emailid);
		 ps.setString(13,passportnumber);
		 ps.setString(14,phomeno);
		 ps.setString(15,pstreetname);
		 ps.setString(16,pcity);
		 ps.setString(17,pstate);
		 ps.setString(18,pcountry);
		 ps.setString(19,ppincode);
		 int count=ps.executeUpdate();
		 pst.executeUpdate();
		 if(count==1)
		 {
			 String type="recruiter";
			 HttpSession hs=req.getSession();
			 hs.setAttribute("username",username);
			 hs.setAttribute("password",password);
			 hs.setAttribute("type",type);
			 RequestDispatcher rd=req.getRequestDispatcher("/redirectuser");
			 rd.forward(req,res);	 
		 }
			 else
			 out.println("There might be some error.Please try again after sometime");	 
	}
	catch(Exception e)
	{
		out.println("Exception caught at Recruiter Registration");
		out.println(e);
	}

}
}
