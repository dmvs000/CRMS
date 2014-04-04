<html>
<body bgcolor=lightpink>
<form><center>
<br>
<%@ page import="java.sql.*" import ="javax.sql.*" import="java.io.*" %><center>
<h3>Applied Jobs</h3><br>
<%
String username=(String)session.getAttribute("username");
try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from "+username+"appliedjobs");
		PreparedStatement pst=con.prepareStatement("select * from job where referencenumber=?");
		ResultSet rs=ps.executeQuery();
		out.println("<table boarder height=80% width=100% >");
		out.println("<tr><td>Reference ID</td><td>Responsibilities</td><td>Job Name</td><td>Vacancies</td><td>");
		out.println("Qualification</td><td>Required Skills</td><td>Created By</td>");
		out.println("<td>Required Experience</td><td>Status</td><td></td></tr><br>");
		while(rs.next())
		{
			String ref=rs.getString("referenceid");
			pst.setString(1,ref);
			ResultSet rst=pst.executeQuery();
			while(rst.next())
			{
			out.println("<tr><td>"+rst.getString("referencenumber")+"<td>"+rst.getString("responsibilities")+"</td><td>"+rst.getString("jobname")+"</td>");
			out.println("<td>"+rst.getString("vacancies")+"</td><td>"+rst.getString("qualification")+"</td><td>"+rst.getString("requiredskills")+"</td>");
			out.println("<td>"+rst.getString("createdby")+"</td><td>"+rst.getString("requiredexperience")+"</td><td>"+rst.getString("status")+"</td><tr>");
		    }
		}
		out.println("</table>");

	}
	catch(Exception e)
	{
		out.println("Exception has been caught at JobseekerViewProfile jsp");
		out.println(e);
	}

 %>
</form></center>
</body>
</html>