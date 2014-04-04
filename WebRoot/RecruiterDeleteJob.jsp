<%@ page import="java.util.*" import="java.sql.*" import="javax.sql.*"%>
<html>
<body>
<form action>
<%
String referencenumber=request.getParameter("referencenumber");
out.println(referencenumber);
/*try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
PreparedStatement ps=prepareStatement("")*/
%>
</form>
</body>
</html>