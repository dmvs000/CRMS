import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;
import javax.sql.*;
public class Difference extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		HttpSession hs=req.getSession();
		String username=(String)hs.getAttribute("username");
		String recruiter="recruiter";
		String jobseeker="jobseeker";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
			 PreparedStatement ps=con.prepareStatement("select * from user where username=?");
			 ps.setString(1,username);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 String type=rs.getString("type");
				 if(type.equals(recruiter))
				 {
					 RequestDispatcher rd=req.getRequestDispatcher("RecruiterHome.jsp");
					 rd.forward(req, res);
				 }
				 else if(type.equals(jobseeker))
				 {
					 RequestDispatcher rd=req.getRequestDispatcher("JobseekerHome.jsp");
					 rd.forward(req, res);
				 }
				 else
				 {
					 RequestDispatcher rd=req.getRequestDispatcher("AdminHome.jsp");
					 rd.forward(req, res);
				 }
			 }
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}