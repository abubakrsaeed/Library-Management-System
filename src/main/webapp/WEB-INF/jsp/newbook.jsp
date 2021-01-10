<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/9/2021
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LMS</title>
</head>
<body>
<form method = "post" >
    <table>
        <tr>
            <td>Title : <input type = "text" name="book_title"  required/></td>
        </tr>
        <tr>
            <td>Author : <input type = "text" name="book_author"  required/></td>
        </tr>
        <tr>
            <td>Genre : <input type = "text" name="book_genre" required /></td>
        </tr>
        <tr>
            <td>Topic : <input type="text" name="book_topics" required/></td>
        </tr>
        <tr>
            <td>Publisher ID : <input type = "text" name="publisher_id" required/></td>
        </tr>
        <tr>
            <td>Year Published : <input type="text" name="year_published" required></td>
        </tr>
        <tr>
            <td>Book Stock : <input type="text" name="book_stock" required></td>
        </tr>
        <tr>
            <td>Book Available : <input type="text" name="book_available" required></td>
        </tr>
    </table>
    <br>
    <input type="submit" value ="Add Book" onclick="return confirm('New book is added!');"/>
    <br>
    <br>
    <a href="/managerlogin">Go back</a>
</form>
</body>
</html>
