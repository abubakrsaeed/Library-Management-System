<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/9/2021
  Time: 4:02 PM
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
<form action="searchbook">
<input type="text" placeholder="Search title ..." name= "title" size="20"/>
<input type="text" placeholder="Search author ..." name= "author" size="20"/>
<input type="text" placeholder="Search genre ..." name= "genre" size="20"/>
<input type="text" placeholder="Search topic ..." name= "topic" size="20"/>
<input type="number" min="1900" max="2099" step="1" placeholder="search year ..." name="year" size="20"/>
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
        <th>Book ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Topics</th>
        <th>Publisher ID</th>
        <th>Year Published</th>
        <th>Book Stock</th>
        <th>Book Available</th>
    </tr>

<%
    String[][] data = (String[][]) session.getAttribute("searchbook");
    if (data != null)
    {
        for (String[] book : data)
        {
%>
<tr> <td><%= book[0] %></td>  <td><%= book[1] %></td> <td><%= book[2] %></td> <td><%= book[3] %></td> <td><%= book[4] %></td> <td><%= book[5] %></td> <td> <%= book[6] %></td><td> <%= book[7] %></td><td> <%= book[8] %>  </td></tr>
<%
        }
    }
%>
</table>
<br>
<a href="/searchbook">Go back</a>
</body>
</html>
