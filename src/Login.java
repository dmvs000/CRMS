import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class Login extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		HttpSession hs=req.getSession();
		hs.setAttribute("username", username);
		hs.setAttribute("password", password);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
			 PreparedStatement ps=con.prepareStatement("select * from user where username=? and password=?");
			 ps.setString(1,username);
			 ps.setString(2,password);
			 ResultSet rs=ps.executeQuery();
			 if(rs.next())
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("/difference");
				 rd.forward(req, res);
			 }
			 else
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				 rd.include(req, res);
			     out.println("The Password or Username You Entered is Incorrect");
			 }
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}