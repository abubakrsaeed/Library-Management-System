<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/8/2021
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LMS</title>
</head>
<body>
<h3><u>User Sign Up</u></h3>
<p><strong>Create an LMS User Account</strong></p>
<%
    String name = (String) session.getAttribute("user_name");
    if(name == null)
    {
%>
<p style="color: red">${errorMessage}</p>
<form method = "post" >
    <table>
        <tr>
        </tr>
        <tr>
            <td>Name : <input type = "text" name="user_name" /></td>
        </tr>
        <tr>
            <td>Phone Number : <input type = "text" pattern="[0-9]{11}" name="user_phone"/></td>
        </tr>
        <tr>
            <td>Username : <input type = "text" name="user_username" /></td>
        </tr>
        <tr>
            <td>Password : <input type = "password" name="user_pass"/></td>
        </tr>
    </table>
    <br>
    <input type="submit" value ="Sign Up"/>
</form>
<%
}else{
%>
<p>New User Account created successfully!</p>
<%
    }
%>
</body>
</html>
