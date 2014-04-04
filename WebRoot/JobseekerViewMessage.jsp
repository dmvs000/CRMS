<%@ page import="java.sql.*" import="javax.sql.*"%>
<html><a href='JobseekerHome.jsp'>HOME</a>&nbsp&nbsp&nbsp<a href=inbox>GO BACK</a><br><body bgcolor=lightcyan>
<h1>Message</h1><br><br>
<%
String timeanddate=(String)session.getAttribute("timeanddate");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
PreparedStatement ps=con.prepareStatement("select * from messenger where timeanddate=?");
ps.setString(1,timeanddate);
ResultSet rs=ps.executeQuery();
out.println("<br>");
while(rs.next())
{
out.println(rs.getString("message"));
}
}
catch(Exception e)
{
out.println("Exception has been caught at jobseekerviewmessage.jsp file");
out.println(e);
}
 %></body>
</html>