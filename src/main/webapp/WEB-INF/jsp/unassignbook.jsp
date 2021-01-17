<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/17/2021
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LMS</title>
</head>
<body>
<h3>Un-Assign Book</h3>

<form method = "post" >
    User ID : <input type = "text" name="user_id" />
    <br><br>
    Book ID : <input type = "text" name="book_id" />
    <br><br>
    <input type="submit" value ="Un-Assign Book"  onclick="return confirm('Book Un-Assigned')"/>
</form>
</body>
</html>
