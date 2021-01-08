<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/8/2021
  Time: 2:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login to LMS</title>
</head>
<body>
<h3><u>User Login</u></h3>
<%
    String user_username = (String) session.getAttribute("user_username");
    if(user_username == null)
    {
%>
<p style="color: red" >${errorMessage}</p>
<form method="post">
    Username : <input type="text" name="user_username" />
    <br>
    <br>
    Password : <input type="password" name="user_pass" />
    <br>
    <br>
    <input type="submit" value="Login" />
</form>
<%
    } else{
%>
<p>You are logged in as : <%= user_username %> </p>
<br>
<a href="/logout">Logout</a>
<%
    }
%>
</body>
</html>
