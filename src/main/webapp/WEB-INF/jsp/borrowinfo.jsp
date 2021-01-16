<%--
  Created by IntelliJ IDEA.
  User: abubakrsaeed17
  Date: 1/9/2021
  Time: 7:46 PM
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
<h3>Borrowed Book Details</h3>
<table>
    <tr>
        <th>User ID</th>
        <th>Publisher ID</th>
        <th>Borrowed on</th>
        <th>Due Date</th>
        <th>Return Date</th>
        <th>Days Overdue</th>
        <th>Penalty Charged</th>
    </tr>

    <%
        String[][] Data = (String[][]) session.getAttribute("borrowinfo");
        if (Data != null)
        {
            for (String[] info : Data)
            {
    %>
    <tr> <td><%= info[0] %></td>  <td><%= info[1] %></td> <td><%= info[2] %></td> <td><%= info[3] %></td> <td><%= info[4] %></td> <td><%= info[5] %></td> <td> <%= info[6] %></td></tr>
    <%
            }
        }
    %>
</table>
  <br>
  <a href="/managerlogin">Go back</a>
</body>
</html>
