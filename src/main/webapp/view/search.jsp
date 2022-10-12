<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/12/2022
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
</div>
</nav>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="StudentServlet?action=list">List All Student</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5" class = "table">
        <caption><h2>Student List</h2></caption>
        <tr>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>PhoneNumber</th>
            <th>Email</th>
            <th>ClassRoom</th>
        </tr>
        <c:forEach var="student" items="${searchByStudentName}">
            <tr>
                <td><c:out value="${student.getId()}"/></td>
                <td><c:out value="${student.getName()}"/></td>
                <td><c:out value="${student.getDoB()}"/></td>
                <td><c:out value="${student.getAddress()}"/></td>
                <td><c:out value="${student.getPhoneNumber()}"/></td>
                <td><c:out value="${student.getEmail()}"/></td>
                <td><c:out value="${student.getClassRoom()}"/></td>
                <td>
                    <a href="/StudentServlet?action=edit&id=${student.getId()}">Edit</a>
                    <a href="/StudentServlet?action=delete&id=${student.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
