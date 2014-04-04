<html>
<body bgcolor=lightpink>
<h2>Compose A Message To Applicant.</h2><form action=message method=post>
To:
<%=(String)session.getAttribute("ausername")
 %><br>
 From:
 <%=(String)session.getAttribute("username")
  %><br>
Subject:<input type="text" name=subject><br>Message:<br>
<input type="text" id=player name=message style="width:800px;height=300px;"><br>
<input type=submit value=SEND><br>
</form></body>
</html>