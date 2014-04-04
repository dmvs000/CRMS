import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class AddQuestion extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String questionnumber=req.getParameter("questionnumber");
	String question=req.getParameter("question");
	String option1=req.getParameter("option1");
	String option2=req.getParameter("option2");
	String option3=req.getParameter("option3");
	String option4=req.getParameter("option4");
	String answer=req.getParameter("answer");
	HttpSession hs=req.getSession();
	String username=(String)hs.getAttribute("username");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("insert into "+username+"questions values(?,?,?,?,?,?,?)");
		ps.setString(1,questionnumber);
		ps.setString(2,question);
		ps.setString(3,option1);
		ps.setString(4,option2);
		ps.setString(5,option3);
		ps.setString(6,option4);
		ps.setString(7,answer);
		int count=ps.executeUpdate();
		if(count==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("RecruiterHome.jsp");
			rd.include(req, res);
			out.println("Question Has Been Added Successfully");
		}
		else
			out.println("There might be some severe error");
	}
	catch(Exception e)
	{
		out.println("Exception caught at AddQuestion servlet class");
		out.println(e);
	}
}
}
