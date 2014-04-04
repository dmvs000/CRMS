import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;

import javax.sql.*;
public class JobseekerChangePasswordReal extends HttpServlet 
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	HttpSession hs=req.getSession();
	String npassword=(String)hs.getAttribute("npassword");
	String username=(String)hs.getAttribute("username");	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("update user set password=? where username=?");
		PreparedStatement pst=con.prepareStatement("update jobseekerinformation set password=? where username=?");
		pst.setString(1,npassword);
		pst.setString(2,username);
		pst.executeUpdate();
		ps.setString(1,npassword);
		ps.setString(2,username);
		int count=ps.executeUpdate();
		out.println("<html><body bgcolor=lightcyan><center>");
		if(count==1)
		{
			out.println("Your password has been changed successfully");
		    out.println("<a href=Login.jsp>");
		    out.println("Go To Login Page");
		    out.println("</a>");
		 }
		else
		{
			out.println("Your password is not changed. Try Again after some time");
		}
		  
	}	
	catch(Exception e)
	{
		out.println("The exception has been caught at JobseekerChangePassword servlet class");
	}
	out.println("</center></body></html>");

}
}
