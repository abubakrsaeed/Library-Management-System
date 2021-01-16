<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12.01.2021
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LMS</title>
    <style>
        table, th, td {
            border: 2px solid black;
        }
    </style>
</head>
<body>
<h3>Book List</h3>
<form method = "post" >
<table>
    <tr>
        <td>title : <input type = "text" name="book_title"  required/></td>
    </tr>
</table>
<br>
<input type="submit" value ="remove book"/>
<br>
</form>
<table>
    <tr>
        <th>book id</th>
        <th>book title</th>
        <th>book author</th>
        <th>book genre</th>
        <th>book topics</th>
        <th>publisher id</th>
        <th>year published</th>
        <th>book stock</th>
        <th>book available</th>
    </tr>

    <%
        String[][] Data = (String[][]) session.getAttribute("booklist");
        if (Data != null)
        {
            for (String[] info : Data)
            {
    %>
    <tr> <td><%= info[0] %></td>  <td><%= info[1] %></td> <td><%= info[2] %></td> <td><%= info[3] %></td> <td><%= info[4] %></td> <td><%= info[5] %></td> <td> <%= info[6] %></td> <td> <%= info[7] %></td> <td> <%= info[8] %></td></tr>
    <%
            }
        }
    %>
</table>
<br>
<a href="/managerlogin">Go back</a>
</body>
</html>