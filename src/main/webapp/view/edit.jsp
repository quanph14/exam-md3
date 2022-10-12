<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/11/2022
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Student Management</h1>
<h2>
    <a href="StudentServlet?action=list" class="btn btn-info btn-lg">List Student</a>
</h2>
<h2>
    Edit Student
</h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5" class = "table-bordered">

            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.id}' />"/>
            </c:if>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${student.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td>
                    <input type="date" name="dob" size="45"
                           value="<c:out value='${student.dob}' />"
                    />
                </td>
            </tr>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${student.address}' />"
                    />
                </td>
            </tr>
            </tr>
            <tr>
                <th>Phone Number:</th>
                <td>
                    <input type="text" name="phonenumber" size="45"
                           value="<c:out value='${student.phonenumber}' />"
                    />
                </td>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${student.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>ClassRoom:</th>
                <td>
                    <input type="text" name="classroom" size="45"
                           value="<c:out value='${student.classroom}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" class="btn btn-primary btn-lg"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
