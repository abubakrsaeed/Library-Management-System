<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/17/2021
  Time: 2:01 AM
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
<form action="searchpublishers">
    <input type="text" placeholder="Search publisher ..." name= "publishers" size="20"/>
    <input type="text" placeholder="Search genre ..." name= "genre" size="20"/>
    <label for="isAvailable">Select Availability:</label>
    <select name="isAvailable" id="isAvailable">
        <option value="none">none</option>
        <option value="true">yes</option>
        <option value="false">no</option>
    </select>
    <input type="submit" value="Search">
</form>
<table>
    <tr>
        <th>Publisher ID</th>
        <th>Publisher Name</th>
        <th>Book ID</th>
        <th>Genre</th>
        <th>Book Available</th>
    </tr>

    <%
        String[][] data = (String[][]) session.getAttribute("searchpublishers");
        if (data != null)
        {
            for (String[] book : data)
            {
    %>
    <tr> <td><%= book[0] %></td>  <td><%= book[1] %></td> <td><%= book[2] %></td> <td><%= book[3] %></td> <td><%= book[4] %></td></tr>
    <%
            }
        }
    %>
</table>
<br>
<a href="/searchpublishers">Go back</a>
</body>
</html>
