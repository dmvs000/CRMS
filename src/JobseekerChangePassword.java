import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import javax.sql.*;
import java.io.*;
public class JobseekerChangePassword extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String opassword=req.getParameter("opassword");
		String npassword=req.getParameter("npassword");
		String rpassword=req.getParameter("rpassword");
		HttpSession session=req.getSession();
		session.setAttribute("npassword",npassword);
		String password=(String)session.getAttribute("password");
		out.println("<html><body><center>");
		if(opassword.equals(password))
		 {
		   if(npassword.equals(rpassword))
		   {
		      RequestDispatcher rd=req.getRequestDispatcher("/cpass");
		      rd.forward(req,res);
		   }
		   else
		   {
			 out.println("Your entered new password is incorrect");
		     out.println("Please enter correctly");
		     RequestDispatcher rd=req.getRequestDispatcher("JobseekerChangePassword.jsp");
		     rd.include(req,res);
		   }
		   }
		 else
		 {
		  out.println("<html><body><center>");
		  out.println("Your old password is incorrect");
		  RequestDispatcher rd=req.getRequestDispatcher("JobseekerChangePassword.jsp");
		     rd.include(req,res);
		  out.println("</center></body></html>");
		 }
		out.println("</center></body></html>");
}
}
