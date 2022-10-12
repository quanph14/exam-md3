<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/11/2022
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
<center>
<h1>Student Management</h1>
<h2>
    <a href="StudentServlet?action=list">Student List</a>
</h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5" class = "table">
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td>
                    <input type="date" name="doB" id="doB" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>PhoneNumber:</th>
                <td>
                    <input type="text" name="phonenumber" id="phonenumber" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>ClassRoom:</th>
                <td>
                    <input type="text" name="classroom" id="classroom" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
