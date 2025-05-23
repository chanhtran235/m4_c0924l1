<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 5/21/2025
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Danh sách sinh viên
<a href="/students/add">Thêm mơi</a>
<p style="color: red">${mess}</p>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Detail-RequestParam</th>
        <th>Detail-PathVariable</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>
                <a href="/students/detail?id=${student.id}">Detail1</a>
            </td>
            <td>
                <a href="/students/${student.id}/detail">Detail2</a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
