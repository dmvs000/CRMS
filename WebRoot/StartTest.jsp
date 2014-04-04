<%@ page import="java.sql.*" import ="javax.sql.*" import="java.io.*" %>
<html>
<body bgcolor=lightcyan>
<form action=myresultplease method=post>
<%
String exam=(String)session.getAttribute("exam");
String qn="1";
try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps1=con.prepareStatement("select * from "+exam+" where qn=?");
		ps1.setString(1,qn);
        ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
%>
Question No.<%=rs1.getString("qn") %>:<br>
Question:<%=rs1.getString("q") %><br><br>
<input type=radio name=1 value=1><%=rs1.getString("o1") %><br>
<input type=radio name=1 value=2><%=rs1.getString("o2") %><br>
<input type=radio name=1 value=3><%=rs1.getString("o3") %><br>
<input type=radio name=1 value=4><%=rs1.getString("o4") %><br><br><br>
--------------------------------------------------------------		<br><br>
<%
		}
		PreparedStatement ps2=con.prepareStatement("select * from "+exam+" where qn=?");
		ps2.setString(1,"2");
		ResultSet rs2=ps2.executeQuery();
		while(rs2.next())
		{
%>
Question No.<%=rs2.getString("qn") %>:<br>
Question:<%=rs2.getString("q") %><br><br>
<input type=radio name=2 value=1><%=rs2.getString("o1") %><br>
<input type=radio name=2 value=2><%=rs2.getString("o2") %><br>
<input type=radio name=2 value=3><%=rs2.getString("o3") %><br>
<input type=radio name=2 value=4><%=rs2.getString("o4") %><br><br><br>
--------------------------------------------------------------		<br><br>
<%
		}
		PreparedStatement ps3=con.prepareStatement("select * from "+exam+" where qn=?");
		ps3.setString(1,"3");
		ResultSet rs3=ps3.executeQuery();
		while(rs3.next())
		{
%>
Question No.<%=rs3.getString("qn") %>:<br>
Question:<%=rs3.getString("q") %><br><br>
<input type=radio name=3 value=1><%=rs3.getString("o1") %><br>
<input type=radio name=3 value=2><%=rs3.getString("o2") %><br>
<input type=radio name=3 value=3><%=rs3.getString("o3") %><br>
<input type=radio name=3 value=4><%=rs3.getString("o4") %><br><br><br>
--------------------------------------------------------------<br><br>
<%
		}
		PreparedStatement ps4=con.prepareStatement("select * from "+exam+" where qn=?");
		ps4.setString(1,"4");
		ResultSet rs4=ps4.executeQuery();
		while(rs4.next())
		{
%>
Question No.<%=rs4.getString("qn") %>:<br>
Question:<%=rs4.getString("q") %><br><br>
<input type=radio name=4 value=1><%=rs4.getString("o1") %><br>
<input type=radio name=4 value=2><%=rs4.getString("o2") %><br>
<input type=radio name=4 value=3><%=rs4.getString("o3") %><br>
<input type=radio name=4 value=4><%=rs4.getString("o4") %><br><br><br>
--------------------------------------------------------------<br><br>
<%
		}
		PreparedStatement ps5=con.prepareStatement("select * from "+exam+" where qn=?");
		ps5.setString(1,"5");
		ResultSet rs5=ps5.executeQuery();
		while(rs5.next())
		{
%>
Question No.<%=rs5.getString("qn") %>:<br>
Question:<%=rs5.getString("q") %><br><br>
<input type=radio name=5 value=1><%=rs5.getString("o1") %><br>
<input type=radio name=5 value=2><%=rs5.getString("o2") %><br>
<input type=radio name=5 value=3><%=rs5.getString("o3") %><br>
<input type=radio name=5 value=4><%=rs5.getString("o4") %><br><br><br>
--------------------------------------------------------------<br><br>

<input type=submit value=SUBMIT>

<%
		}	
	}	
	catch(Exception e)
	{
	 out.println("The exception has been caught at StartTest.jsp");
	 out.println(e);
	}
 %>
</form>
</body>
</html>