<html>
<body bgcolor=lightyellow>
<form>
<%@ page import="java.sql.*" import ="javax.sql.*" import="java.io.*" %>
<h1>EDIT PROFILE</h1><br><br>
<%
String username=(String)session.getAttribute("username");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from recruiterinformation where username=?");
		ps.setString(1,username);
	    ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
%>
<center>
Personal Information:<br><br>
username=<%=rs.getString("username") %><br>
Username will not be changed.<br><br>
Qualification:<input type=text name=qualification value=<%=rs.getString("qualification") %>><br><br>
Contact Address:<br>
Home No:<input type=text name=homeno value=<%=rs.getString("homeno") %>><br>
Street Name:<input type=text name=streetname value=<%=rs.getString("streetno") %>><br>
City:<input type=text name=city value=<%=rs.getString("city") %>><br>
State:<input type=text name=state value=<%=rs.getString("state") %>><br>
Country:<input type=text name=country value=<%=rs.getString("country") %>><br>
Pin Code:<input type=text name=pincode value=<%=rs.getString("pincode") %>><br><br>
Contact Information:<br><br>
Phone Number:<input type=text name=phonenumber value=<%=rs.getString("phonenumber") %>><br>
Mobile Number:<input type=text name=mobilenumber value=<%=rs.getString("mobilenumber") %>><br>
Emain Id:<input type=text name=emailid value=<%=rs.getString("emailid") %>><br>
Passport No:<input type=text name=passportnumber value=<%=rs.getString("passportno") %>><br><br>
Permanamt Address:<br><br>
Home No:<input type=text name=phomeno value=<%=rs.getString("phomeno") %>><br>
Street Name:<input type=text name=pstreetname value=<%=rs.getString("pstreetname") %>><br>
City:<input type=text name=pcity value=<%=rs.getString("pcity") %>><br>
State:<input type=text name=pstate value=<%=rs.getString("pstate") %>><br>
Country:<input type=text name=pcountry value=<%=rs.getString("pcountry") %>><br>
Pin Code:<input type=text name=ppincode value=<%=rs.getString("ppincode") %>><br><br>
<input type=submit value="Save Changes"><br>
</center>		
	<%
	}
}	
	catch(Exception e)
	{
	 out.println("The exception has been caught at EditProfile.jsp");
	}
 %>
</form>
</body>
</html>