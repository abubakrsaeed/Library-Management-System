<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/8/2021
  Time: 2:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login to LMS</title>
</head>
<body>
<h3><u>Manager Login</u></h3>
<%
    String manager_username = (String) session.getAttribute("manager_username");

    if (manager_username == null)
    {
%>
<p style="color: red">${errorMessage}</p>
<form method = "post" >
    Username : <input type = "text" name="manager_username" />
    <br>
    <br>
    Password : <input type = "password" name="manager_pass"/>
    <br>
    <br>
    <input type="submit" value ="Login"/>
</form>
<%
}else{
%>
<p>You are logged in as: <%= manager_username %> </p>
<a href="/bookInfo">Display Book information</a>
<a href="/logout">Books currently borrowed</a>
<a href="/PublisherSignUp">Create a new Publisher Account</a>
<a href="/logout">Logout</a>
<%
    }
%>
</body>
</html>
