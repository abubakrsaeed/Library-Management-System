<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/9/2021
  Time: 2:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LMS</title>
</head>
<body>
<p><strong>Create a new LMS Publisher Account</strong></p>
<form method = "post" >
    <table>
        <tr>
        </tr>
        <tr>
            <td>Name  : <input type = "text" name="publisher_name" required/></td>
        </tr>
        <tr>
            <td>Username : <input type = "text" name="publisher_username" required/></td>
        </tr>
        <tr>
            <td>Password : <input type = "password" name="publisher_pass" required/></td>
        </tr>
        <tr>
            <td>Phone Number (11 digits) : <input type = "text" pattern="[0-9]{11}" name="publisher_phone" required/></td>
        </tr>
    </table>
    <br>
    <input type="submit" value ="Create Account" onclick="return confirm('New publisher account has been created!');">
    <br>
    <br>
    <a href="/managerlogin">Go back</a>
</form>
</body>
</html>
