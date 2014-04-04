<html>
<body bgcolor=lightyellow>
<%@ page import="java.sql.*" import ="javax.sql.*" import="java.io.*" %>
<h1>EDIT PROFILE</h1><br><br>
<%
String username=(String)session.getAttribute("username");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shankar","root","root");
		PreparedStatement ps=con.prepareStatement("select * from jobseekerinformation where username=?");
		ps.setString(1,username);
	    ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
%>
<center>
<form action=jobseekerchangeprofile method=post>
Email Address:<input type=text name=emailaddress value="<%=rs.getString("emailaddress") %>"><br>
First Name:<input type=text name=firstname value="<%=rs.getString("firstname") %>"><br>
Last Name:<input type=text name=lastname value="<%=rs.getString("lastname") %>"><br>
Username:"<%=rs.getString("username") %>"<br>
Username will not changed.
Professional Details:<br>
Total Experience:<input type=text name=totalexperience value="<%=rs.getString("totalexperience") %>"><br>
Job Category:<input type=text name=jobcategory value="<%=rs.getString("jobcategory") %>"><br>
KeySkills:<input type=text name=keyskills value="<%=rs.getString("keyskills") %>"><br><br><br>
Personal Details:<br><br>
Phone Number:<input type=text name=phonenumber value="<%=rs.getString("phonenumber") %>"><br>
Mobile Number:<input type=text name=mobilenumber value="<%=rs.getString("mobilenumber") %>"><br>
Current Location:<input type=text name=currentlocation value="<%=rs.getString("currentlocation") %>"><br>
Preffered Job Location:<input type=text name=prefferedjoblocation value="<%=rs.getString("prefferedjoblocation") %>"><br>
Education Qualification:<br>
Highest Qualification Held:<input type=text name=highestqualificationheld value="<%=rs.getString("highestqualificationheld") %>"><br>
Specialization/Major:<input type=major name=major value="<%=rs.getString("major") %>"><br>
Institute:<input type=institute name=institute value="<%=rs.getString("institute") %>"><br><br>
<input type=submit value="Save Changes"><br>
</form></center>		
	<%
	}
}	
	catch(Exception e)
	{
	 out.println("The exception has been caught at JobseekerEditProfile.jsp");
	 out.println(e);
	}
 %>
</body>
</html>