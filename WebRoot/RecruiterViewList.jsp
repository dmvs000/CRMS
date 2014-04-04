<%@ page import="java.sql.*" import ="javax.sql.*" import="java.io.*" %>
<html>
<body bgcolor=lightyellow>
<form action=recruiteraction>
<%
String referencenumber=request.getParameter("referencenumber");
session.setAttribute("referencenumber",referencenumber);
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
PreparedStatement ps=con.prepareStatement("select * from "+referencenumber+"appliedlist");
ResultSet rs=ps.executeQuery();
%><center>
<table boarder height=100% width=80% >
<tr><td>Apllied Canditates</td><td>Selection</td><td>Deletetion</td><td>View Details</td></tr>
<%
while(rs.next())
{
String canditate=rs.getString("canditates");
%>
<tr><td><%=rs.getString("canditates")%>
<%
out.println("<input type=hidden value="+canditate+" name=ausername></td><td><input type=submit value=Select name=select></td><td><input type=submit value=Delete name=delete></td><td><input type=submit value=View name=view></td></tr>");%>
<%
%>
<%
}
%>
</table></center>
<%
}
catch(Exception e)
{
out.println("Exception caught at RecruiterViewList.jsp");
out.println(e);
}
 %>
</form>
</body>
</html>