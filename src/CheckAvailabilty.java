import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
public class CheckAvailabilty extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String username=req.getParameter("username");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
			 PreparedStatement ps=con.prepareStatement("select * from user");
			 ResultSet rs=ps.executeQuery();
			 out.println("<html><body><center>");
			 int count=0;
			 while(rs.next())
			 {
				 String uname=rs.getString("username");
				 if(uname.equals(username))
				 {
					 RequestDispatcher rd=req.getRequestDispatcher("JobseekerRegistration.jsp");
					 rd.include(req,res);
					 out.println("Sorry, this username is unvailable.Please give another username");
					 count=1;
					 break;
				 }
			 }
			 if(count!=1)
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("InsertJobseeker");
				 rd.forward(req, res);
			 }
			 out.println("</center></body><html>");
			 
		}
		catch(Exception e)
		{
			out.println(e);
		}

	}

}
