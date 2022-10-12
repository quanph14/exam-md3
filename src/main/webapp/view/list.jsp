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
    <title>Student List</title>
</head>
<body>
<center>
<h1>Student Management</h1>
<h2>
    <a href="StudentServlet?action=create" class="btn btn-info">Add a new Student</a>
</h2>
<h2>Student List</h2>
    <tr>
        <form action="/StudentServlet" method="get">
            <input name="searchByStudentName"  type="text" placeholder="Type Student Name">
            <input type="hidden" name="action" value="searchByStudentName">
            <button type="submit">Search</button>
        </form>
    </tr>
    <tr>
</center>
<div align="center">
    <table border="1" cellpadding="5" class = "table">

        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>PhoneNumber</th>
            <th>Email</th>
            <th>Classroom</th>
        </tr>
        <c:forEach var="student" items="${listStudent}">
            <tr>
                <td><c:out value="${student.getId()}"/></td>
                <td><c:out value="${student.getName()}"/></td>
                <td><c:out value="${student.getDoB()}"/></td>
                <td><c:out value="${student.getAddress()}"/></td>
                <td><c:out value="${student.getPhoneNumber()}"/></td>
                <td><c:out value="${student.getEmail()}"/></td>
                <td><c:out value="${student.getClassRoom()}"/></td>
                <td>
                    <button href="/StudentServlet?action=edit&id=${student.getId()}" class="btn btn-info">Edit</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">Delete</button>
                    <!-- Modal -->

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
