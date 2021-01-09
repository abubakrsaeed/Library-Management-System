<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/8/2021
  Time: 3:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LMS Publisher Account</title>
</head>
<body>
<h3><u>Publisher Account</u></h3>
<%
    String publisher_username = (String) session.getAttribute("publisher_username");
    if(publisher_username == null)
    {
%>
<p style="color: red">${errorMessage}</p>
<form method = "post" >
    Username : <input type = "text" name="publisher_username"/>
    <br>
    <br>
    Password : <input type = "password" name="publisher_pass"/>
    <br>
    <br>
    <input type="submit" value ="Login"/>
    <br>
    <br>
    <a href="/login">Go back</a>
</form>
<%
}else{
%>
<p>You are logged in as: <%= publisher_username %> </p>
<a href="/bookInfo">Display Book Information</a>
<a href="/logout">Logout</a>
<%
    }
%>
</body>
</html>
