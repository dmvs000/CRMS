import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
public class TellResult extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	String ans1=req.getParameter("1");
	String ans2=req.getParameter("2");
	String ans3=req.getParameter("3");
	String ans4=req.getParameter("4");
	String ans5=req.getParameter("5");
	HttpSession hs=req.getSession();
	String exam=(String)hs.getAttribute("exam");
	int score=0;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from "+exam+" where qn=1");
		ResultSet rs1=ps.executeQuery();
		while(rs1.next())
		{
			String answer=rs1.getString("answer");
			if(answer.equals(ans1))
				score++;
		}
		PreparedStatement ps2=con.prepareStatement("select * from "+exam+" where qn=2");
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next())
		{
			String answer=rs2.getString("answer");
			if(answer.equals(ans2))
				score++;
		}
		PreparedStatement ps3=con.prepareStatement("select * from "+exam+" where qn=3");
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next())
		{
			String answer=rs3.getString("answer");
			if(answer.equals(ans3))
				score++;
		}
		PreparedStatement ps4=con.prepareStatement("select * from "+exam+" where qn=4");
		ResultSet rs4=ps4.executeQuery();
		while(rs4.next())
		{
			String answer=rs4.getString("answer");
			if(answer.equals(ans4))
				score++;
		}
		PreparedStatement ps5=con.prepareStatement("select * from "+exam+" where qn=5");
		ResultSet rs5=ps5.executeQuery();
		while(rs5.next())
		{
			String answer=rs5.getString("answer");
			if(answer.equals(ans5))
				score++;
		}
		out.println("<html><body bgcolor=lightblue><center>");
		out.println("We Appreciate you for taking this test<br>");
		out.println("Thank You...........<br>");
		out.println("Your total score for this test is :"+score+"<br>");
		out.println("And The Final Result is......<br><br><br><br>");
		if(score>=3)
		{
			out.println("Pass<br>");
		if(score==5)
			out.println("Excellent<br><br><br><br><br><br><br>");
		else if(score==4)
			out.println("Very Good<br><br><br><br><br><br><br>");
		else
			out.println("Average<br><br><br><br><br><br><br>");
		}
		else
			out.println("Fail<br><br><br><br><br><br>");
            out.println("<a href=TestMenu.jsp>Go Back</a><br>");
	     	out.println("<a href=JobseekerHome.jsp>Home</a><br>");
    		out.println("</center><body><html>");
	}
	catch(Exception e)
	{
		out.println("Exception has been caught at Tell Result servlet class");
		out.println(e);
	}
}
}
