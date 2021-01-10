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
<p><strong>Create a new LMS User Account</strong></p>
<form method = "post" >
    <table>
        <tr>
        </tr>
        <tr>
            <td>Name  : <input type = "text" name="user_name" required/></td>
        </tr>
        <tr>
            <td>Username : <input type = "text" name="user_username" required/></td>
        </tr>
        <tr>
            <td>Password : <input type = "password" name="user_pass" required/></td>
        </tr>
        <tr>
            <td>Phone Number (11 digits) : <input type = "text" pattern="[0-9]{11}" name="user_phone" required/></td>
        </tr>
    </table>
    <br>
    <input type="submit" value ="Sign Up" onclick="return confirm('New user account has been created!');">
    <br>
    <p>Already have an account? <a href="/login">Login</a>.</p>
</form>
</body>
</html>
